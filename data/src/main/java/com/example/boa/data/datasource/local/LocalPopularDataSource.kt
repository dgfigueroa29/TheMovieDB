package com.example.boa.data.datasource.local

import com.example.boa.data.datasource.PopularDataSource
import com.example.boa.data.datasource.local.db.TheMovieDBDatabase
import com.example.boa.data.mapper.ResultEntityToModel
import com.example.boa.domain.model.Result

class LocalPopularDataSource(
    private val database: TheMovieDBDatabase,
    private val resultEntityToModel: ResultEntityToModel
) : PopularDataSource {
    override suspend fun getMovies(): List<Result> =
        resultEntityToModel.mapAll(database.resultDao().getPopularMovies())

    override suspend fun getTv(): List<Result> =
        resultEntityToModel.mapAll(database.resultDao().getPopularTv())
}