package com.example.boa.data.datasource.remote

import com.example.boa.data.datasource.SearchDataSource
import com.example.boa.data.mapper.ResultResponseToModel
import com.example.boa.domain.model.Result

class RemoteSearchDataSource(
    private val api: AppApi,
    private val resultResponseToModel: ResultResponseToModel
) : SearchDataSource {
    override suspend fun searchByTerm(term: String): List<Result> =
        resultResponseToModel.mapAll(api.search(term).results)
}