package com.example.boa.domain.repository

import com.example.boa.domain.model.Result

interface DetailRepository {
    suspend fun getById(id: Long, isMovie: Boolean): Result
}