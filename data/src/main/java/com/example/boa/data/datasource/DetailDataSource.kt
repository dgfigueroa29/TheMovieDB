package com.example.boa.data.datasource

import com.example.boa.domain.model.Result

interface DetailDataSource {
    suspend fun getById(id: Long, isMovie: Boolean): Result
}