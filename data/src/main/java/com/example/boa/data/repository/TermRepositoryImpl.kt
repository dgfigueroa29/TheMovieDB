package com.example.boa.data.repository

import com.example.boa.data.datasource.TermDataSource
import com.example.boa.data.mapper.TermEntityToString
import com.example.boa.domain.repository.TermRepository

class TermRepositoryImpl(
    private val termDataSource: TermDataSource,
    private val termEntityToString: TermEntityToString
) : TermRepository {
    override suspend fun getTerms(): List<String> =
        termEntityToString.mapAll(termDataSource.getTerms())
}