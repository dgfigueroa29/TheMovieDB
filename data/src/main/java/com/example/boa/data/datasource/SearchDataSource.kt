package com.example.boa.data.datasource

import com.example.boa.domain.model.Result

interface SearchDataSource {
    suspend fun searchByTerm(term: String): List<Result>
}