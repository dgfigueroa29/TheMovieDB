package com.example.boa.data.mapper

import com.example.boa.data.datasource.remote.response.ResultResponse
import com.example.boa.data.util.toStringLabel
import com.example.boa.domain.core.BaseMapper
import com.example.boa.domain.model.Result
import com.example.boa.domain.util.hasValue
import com.example.boa.domain.util.parseAverage

class ResultResponseToModel : BaseMapper<ResultResponse, Result>() {
    override fun map(input: ResultResponse): Result = Result(
        input.id,
        "",
        if (input.original_name.hasValue()) {
            input.original_name
        } else {
            input.original_title
        },
        input.overview,
        input.poster_path,
        input.backdrop_path,
        input.media_type,
        if (input.first_air_date.hasValue()) {
            input.first_air_date
        } else {
            input.release_date
        },
        input.genres.toStringLabel(),
        if (!input.created_by.isNullOrEmpty()) {
            input.created_by.toStringLabel()
        } else {
            input.production_companies.toStringLabel()
        },
        input.number_of_seasons,
        input.vote_average.parseAverage(),
        input.homepage,
        if (!input.video.results.isNullOrEmpty()) {
            input.video.results[0].key
        } else {
            ""
        }
    )
}