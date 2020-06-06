package com.example.boa.data.repository

import com.example.boa.data.datasource.DetailDataSource
import com.example.boa.data.datasource.ResultDataSource
import com.example.boa.domain.model.Result
import com.example.boa.domain.repository.DetailRepository

class DetailRepositoryImpl(
    private val detailDataSource: DetailDataSource,
    private val resultDataSource: ResultDataSource
) : DetailRepository {
    override suspend fun getById(id: Long, isMovie: Boolean): Result =
        detailDataSource.getById(id, isMovie)
}