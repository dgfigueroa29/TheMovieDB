package com.example.boa.data.datasource.remote

import com.example.boa.data.util.POPULAR_ENDPOINT
import com.example.boa.data.util.TOP_RATED_ENDPOINT
import com.example.boa.data.util.UPCOMING_ENDPOINT
import retrofit2.http.GET
import retrofit2.http.Query

interface AppApi {
    @GET(" ")
    suspend fun getResults(@Query("term") term: String): ResultResponseDto

    @GET(POPULAR_ENDPOINT)
    suspend fun getPopular()

    @GET(TOP_RATED_ENDPOINT)
    suspend fun getTop()

    @GET(UPCOMING_ENDPOINT)
    suspend fun getUpcoming()
}