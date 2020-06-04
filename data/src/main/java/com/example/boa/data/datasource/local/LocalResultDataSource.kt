package com.example.boa.data.datasource.local

import com.example.boa.data.datasource.ResultDataSource
import com.example.boa.data.datasource.local.db.TheMovieDBDatabase
import com.example.boa.data.entity.ResultEntity

class LocalResultDataSource(private val database: TheMovieDBDatabase) : ResultDataSource {
    override suspend fun saveResult(resultEntity: ResultEntity) {
        database.resultDao().insert(resultEntity)
    }

    override suspend fun getResultsByTerm(term: String): List<ResultEntity> =
        database.resultDao().getAll()
}