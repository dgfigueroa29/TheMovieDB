package com.example.boa.data.datasource.remote

import com.example.boa.data.datasource.SearchDataSource
import com.example.boa.domain.model.Result

class RemoteSearchDataSource(private val api: AppApi) : SearchDataSource {
    override suspend fun searchByTerm(term: String): List<Result> = api.getResults(term).results
}