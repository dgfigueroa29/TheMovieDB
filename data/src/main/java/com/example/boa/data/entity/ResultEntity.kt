package com.example.boa.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.boa.data.core.BaseEntity

@Entity
data class ResultEntity(
    @PrimaryKey(autoGenerate = true)
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
    var isPopular: Boolean = false,
    var isTopRated: Boolean = false
) : BaseEntity()