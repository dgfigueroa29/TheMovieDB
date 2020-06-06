package com.example.boa.data.datasource.remote

import com.example.boa.data.datasource.remote.response.ResultListResponse
import com.example.boa.data.datasource.remote.response.ResultResponse
import com.example.boa.data.util.MOVIES_POPULAR_ENDPOINT
import com.example.boa.data.util.MOVIES_TOP_RATED_ENDPOINT
import com.example.boa.data.util.TV_POPULAR_ENDPOINT
import com.example.boa.data.util.TV_TOP_RATED_ENDPOINT
import retrofit2.http.GET
import retrofit2.http.Url

interface AppApi {
    suspend fun search(@Url url: String): ResultListResponse

    suspend fun getMovie(@Url url: String): ResultResponse

    suspend fun getTv(@Url url: String): ResultResponse

    @Suppress("unused")
    @GET(MOVIES_POPULAR_ENDPOINT)
    suspend fun getPopularMovies(): ResultListResponse

    @Suppress("unused")
    @GET(MOVIES_TOP_RATED_ENDPOINT)
    suspend fun getTopRatedMovies(): ResultListResponse

    @Suppress("unused")
    @GET(TV_POPULAR_ENDPOINT)
    suspend fun getPopularTv(): ResultListResponse

    @Suppress("unused")
    @GET(TV_TOP_RATED_ENDPOINT)
    suspend fun getTopRatedTv(): ResultListResponse
}