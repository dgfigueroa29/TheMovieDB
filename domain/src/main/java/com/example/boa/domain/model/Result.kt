package com.example.boa.domain.model

data class Result(
    val id: Long = 0L,
    var term: String = "",
    val name: String = "",
    val overview: String = "",
    val posterPath: String = "",
    val backdropPath: String = "",
    val type: String = "",
    val releaseDate: String = "",
    val genres: String = "",
    val createdBy: String = "",
    val seasons: Int = 0,
    val average: String = "",
    val homepage: String = "",
    val video: String = "",
    val isPopular: Boolean = false,
    val isTopRated: Boolean = false
)