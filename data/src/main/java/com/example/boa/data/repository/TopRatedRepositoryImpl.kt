package com.example.boa.data.repository

import com.example.boa.data.datasource.ResultDataSource
import com.example.boa.data.datasource.TopRatedDataSource
import com.example.boa.domain.model.Result
import com.example.boa.domain.repository.TopRatedRepository

class TopRatedRepositoryImpl(
    private val topRatedDataSource: TopRatedDataSource,
    private val resultDataSource: ResultDataSource
) : TopRatedRepository {
    override suspend fun getMovies(): List<Result> = topRatedDataSource.getMovies()

    override suspend fun getTv(): List<Result> = topRatedDataSource.getTv()
}