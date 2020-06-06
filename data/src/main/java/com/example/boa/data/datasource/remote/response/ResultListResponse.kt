package com.example.boa.data.datasource.remote.response

data class ResultListResponse(
    val page: Int = 1,
    val total_results: Int = 0,
    val total_pages: Int = 1,
    val results: List<ResultResponse>
)