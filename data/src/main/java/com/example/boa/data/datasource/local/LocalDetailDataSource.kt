package com.example.boa.data.datasource.local

import com.example.boa.data.datasource.DetailDataSource
import com.example.boa.data.datasource.local.db.TheMovieDBDatabase
import com.example.boa.data.mapper.ResultEntityToModel
import com.example.boa.domain.model.Result

class LocalDetailDataSource(
    private val database: TheMovieDBDatabase,
    private val resultEntityToModel: ResultEntityToModel
) : DetailDataSource {
    override suspend fun getById(id: Long, isMovie: Boolean): Result =
        resultEntityToModel.map(database.resultDao().getById(id))
}