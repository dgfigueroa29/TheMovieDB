package com.example.boa.data.mapper

import com.example.boa.data.entity.ResultEntity
import com.example.boa.domain.core.BaseMapper
import com.example.boa.domain.model.Result

class ResultEntityToModel : BaseMapper<ResultEntity, Result>() {
    override fun map(input: ResultEntity): Result = Result(
        input.id,
        input.term,
        input.name,
        input.overview,
        input.posterPath,
        input.backdropPath,
        input.type,
        input.releaseDate,
        input.genres,
        input.createdBy,
        input.seasons,
        input.average,
        input.homepage,
        input.video
    )
}