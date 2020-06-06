package com.example.boa.data.datasource.remote.response

data class ResultResponse(
    val id: Long = 0L,
    var original_name: String = "",
    val original_title: String = "",
    val overview: String = "",
    val poster_path: String = "",
    val backdrop_path: String = "",
    val media_type: String = "",
    val first_air_date: String = "",
    val release_date: String = "",
    val genres: List<ItemResponse> = listOf(),
    val created_by: List<ItemResponse> = listOf(),
    val production_companies: List<ItemResponse> = listOf(),
    val number_of_seasons: Int = 0,
    val vote_average: String = "",
    val homepage: String = "",
    val video: VideoResponse
)