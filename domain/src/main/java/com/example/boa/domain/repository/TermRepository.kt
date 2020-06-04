package com.example.boa.domain.repository

interface TermRepository {
    suspend fun getTerms(): List<String>
}