package com.example.boa.domain.repository

import com.example.boa.domain.model.Result

interface SearchRepository {
    suspend fun searchByTerm(term: String): List<Result>
    suspend fun filterByTerm(term: String, isMovie: Boolean, isPopular: Boolean): List<Result>
}