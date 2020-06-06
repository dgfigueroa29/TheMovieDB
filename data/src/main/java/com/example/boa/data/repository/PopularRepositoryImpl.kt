package com.example.boa.data.repository

import com.example.boa.data.datasource.PopularDataSource
import com.example.boa.data.datasource.ResultDataSource
import com.example.boa.domain.model.Result
import com.example.boa.domain.repository.PopularRepository

class PopularRepositoryImpl(
    private val popularDataSource: PopularDataSource,
    private val resultDataSource: ResultDataSource
) : PopularRepository {
    override suspend fun getMovies(): List<Result> = popularDataSource.getMovies()

    override suspend fun getTv(): List<Result> = popularDataSource.getTv()
}