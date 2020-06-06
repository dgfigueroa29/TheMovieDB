package com.example.boa.data.datasource.remote

import com.example.boa.data.datasource.TopRatedDataSource
import com.example.boa.data.mapper.ResultResponseToModel
import com.example.boa.domain.model.Result

class RemoteTopRatedDataSource(
    private val api: AppApi,
    private val resultResponseToModel: ResultResponseToModel
) : TopRatedDataSource {
    override suspend fun getMovies(): List<Result> =
        resultResponseToModel.mapAll(api.getTopRatedMovies().results)

    override suspend fun getTv(): List<Result> =
        resultResponseToModel.mapAll(api.getTopRatedTv().results)
}