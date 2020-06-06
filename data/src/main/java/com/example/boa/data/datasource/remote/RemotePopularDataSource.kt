package com.example.boa.data.datasource.remote

import com.example.boa.data.datasource.PopularDataSource
import com.example.boa.data.mapper.ResultResponseToModel
import com.example.boa.domain.model.Result

class RemotePopularDataSource(
    private val api: AppApi,
    private val resultResponseToModel: ResultResponseToModel
) : PopularDataSource {
    override suspend fun getMovies(): List<Result> =
        resultResponseToModel.mapAll(api.getPopularMovies().results)

    override suspend fun getTv(): List<Result> =
        resultResponseToModel.mapAll(api.getPopularTv().results)
}