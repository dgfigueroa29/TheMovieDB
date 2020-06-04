package com.example.boa.data.datasource

import com.example.boa.data.entity.TermEntity

interface TermDataSource {
    suspend fun saveTerm(term: String): TermEntity
    suspend fun getTerms(): List<TermEntity>
}