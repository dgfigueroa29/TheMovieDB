package com.example.boa.data.datasource.remote

import android.content.Context
import com.example.boa.data.util.BASE_URL
import com.example.boa.data.util.TOKEN
import com.example.boa.data.util.isOnline
import com.example.boa.domain.core.BaseError
import com.example.boa.domain.core.BaseException
import com.example.boa.domain.util.OFFLINE_ERROR_TEXT
import com.google.gson.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Type
import java.util.*
import javax.net.ssl.HttpsURLConnection

class ApiProvider(context: Context) {
    val api: AppApi

    init {
        val builder = GsonBuilder()
        builder.registerTypeAdapter(Calendar::class.java, object : JsonDeserializer<Calendar> {
            override fun deserialize(
                json: JsonElement,
                typeOf: Type,
                context: JsonDeserializationContext
            ): Calendar {
                val calendar = Calendar.getInstance()
                calendar.timeInMillis = json.asJsonPrimitive.asLong * 1000
                return calendar
            }
        })

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(getOkHttpClient(context))
            .addConverterFactory(GsonConverterFactory.create(builder.create()))
            .build()
        api = retrofitBuilder.create(AppApi::class.java)
    }

    private fun getOkHttpClient(context: Context): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.addInterceptor {
            var error = BaseError(OFFLINE_ERROR_TEXT)

            if (!isOnline(context)) {
                throw BaseException(error)
            }

            val request = it.request()
            val requestBuilder = request.newBuilder()
            requestBuilder.addHeader("Accept", "application/json")
            requestBuilder.addHeader("Content-type", "application/json;charset=utf-8")
            requestBuilder.addHeader("Authorization", TOKEN)
            val response = it.proceed(requestBuilder.build())

            if (response.code != HttpsURLConnection.HTTP_OK) {
                val parser = Gson()

                response.body?.let { body ->
                    error = try {
                        parser.fromJson(body.charStream(), BaseError::class.java)
                    } catch (ex: Exception) {
                        BaseError(ex.message ?: "")
                    }

                    throw BaseException(error)
                }
            }

            response
        }

        //Only for debug for checking the api connection
        @Suppress("ConstantConditionIf")
        if (BuildConfig.BUILD_TYPE == "debug") {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.HEADERS
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(interceptor)
        }

        return builder.build()
    }
}