package com.example.boa.data.datasource

import com.example.boa.domain.model.Result

interface PopularDataSource {
    suspend fun getMovies(): List<Result>
    suspend fun getTv(): List<Result>
}