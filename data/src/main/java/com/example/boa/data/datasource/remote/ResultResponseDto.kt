package com.example.boa.data.datasource.remote

import com.example.boa.domain.model.Result

data class ResultResponseDto(val resultCount: Int = 20, val results: List<Result>)