package com.example.boa.data.datasource.remote

import com.example.boa.data.datasource.remote.response.ResultListResponse
import com.example.boa.data.datasource.remote.response.ResultResponse
import com.example.boa.data.util.*
import retrofit2.http.GET
import retrofit2.http.Query

interface AppApi {
    @GET(SEARCH_ENDPOINT)
    suspend fun search(@Query("query") query: String): ResultListResponse

    @Suppress("unused")
    @GET(MOVIE_DETAIL_ENDPOINT)
    suspend fun getMovie(@Query("movie_id") query: String): ResultResponse

    @Suppress("unused")
    @GET(TV_DETAIL_ENDPOINT)
    suspend fun getTv(@Query("tv_id") query: String): ResultResponse

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