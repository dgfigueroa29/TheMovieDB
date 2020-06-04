package com.example.boa.data.repository

import android.content.Context
import com.example.boa.data.datasource.ResultDataSource
import com.example.boa.data.datasource.SearchDataSource
import com.example.boa.data.datasource.TermDataSource
import com.example.boa.data.mapper.ResultEntityToModel
import com.example.boa.data.mapper.ResultModelToEntity
import com.example.boa.data.util.isOnline
import com.example.boa.domain.model.Result
import com.example.boa.domain.repository.SearchRepository

class SearchRepositoryImpl(
    private val searchDataSource: SearchDataSource,
    private val termDataSource: TermDataSource,
    private val resultDataSource: ResultDataSource,
    private val resultEntityToModel: ResultEntityToModel,
    private val resultModelToEntity: ResultModelToEntity,
    private val context: Context
) : SearchRepository {
    override suspend fun searchByTerm(term: String): List<Result> {
        var results = if (isOnline(context)) {
            searchDataSource.searchByTerm(term.replace(" ", "+"))
        } else {
            listOf()
        }

        termDataSource.saveTerm(term)

        if (results.isNotEmpty()) {
            val entities = resultModelToEntity.mapAll(results)
            entities.forEach {
                it.term = term
                resultDataSource.saveResult(it)
            }
        } else {
            val entities = resultDataSource.getResultsByTerm(term)
            results = resultEntityToModel.mapAll(entities)
        }

        return results
    }
}