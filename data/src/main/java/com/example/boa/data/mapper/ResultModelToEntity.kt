package com.example.boa.data.mapper

import com.example.boa.data.entity.ResultEntity
import com.example.boa.domain.core.BaseMapper
import com.example.boa.domain.model.Result

class ResultModelToEntity : BaseMapper<Result, ResultEntity>() {
    override fun map(input: Result): ResultEntity = ResultEntity(
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