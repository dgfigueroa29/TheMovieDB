package com.example.boa.data.datasource.local

import com.example.boa.data.datasource.TopRatedDataSource
import com.example.boa.data.datasource.local.db.TheMovieDBDatabase
import com.example.boa.data.mapper.ResultEntityToModel
import com.example.boa.domain.model.Result

class LocalTopRatedDataSource(
    private val database: TheMovieDBDatabase,
    private val resultEntityToModel: ResultEntityToModel
) : TopRatedDataSource {
    override suspend fun getMovies(): List<Result> =
        resultEntityToModel.mapAll(database.resultDao().getTopRatedMovies())

    override suspend fun getTv(): List<Result> =
        resultEntityToModel.mapAll(database.resultDao().getTopRatedTv())
}