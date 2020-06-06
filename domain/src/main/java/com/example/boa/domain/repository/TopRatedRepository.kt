package com.example.boa.domain.repository

import com.example.boa.domain.model.Result

interface TopRatedRepository {
    suspend fun getMovies(): List<Result>
    suspend fun getTv(): List<Result>
}