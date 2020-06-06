package com.example.boa.data.datasource.remote

import com.example.boa.data.datasource.DetailDataSource
import com.example.boa.data.mapper.ResultResponseToModel
import com.example.boa.data.util.BASE_PARAMS
import com.example.boa.data.util.BASE_URL
import com.example.boa.data.util.MOVIES_PREFIX
import com.example.boa.data.util.TV_PREFIX
import com.example.boa.domain.model.MediaType
import com.example.boa.domain.model.Result

class RemoteDetailDataSource(
    private val api: AppApi,
    private val resultResponseToModel: ResultResponseToModel
) : DetailDataSource {
    override suspend fun getById(id: Long, isMovie: Boolean): Result =
        if (isMovie) {
            val movie = api.getMovie("${BASE_URL}${MOVIES_PREFIX}${id}${BASE_PARAMS}")
            movie.media_type = MediaType.MOVIE.text
            resultResponseToModel.map(movie)
        } else {
            val tv = api.getTv("${BASE_URL}${TV_PREFIX}${id}${BASE_PARAMS}")
            tv.media_type = MediaType.TV.text
            resultResponseToModel.map(tv)
        }
}