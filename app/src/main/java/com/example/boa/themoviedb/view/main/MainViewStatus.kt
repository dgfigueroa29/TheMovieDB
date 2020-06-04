package com.example.boa.themoviedb.view.main

import com.example.boa.domain.model.Result
import com.example.boa.themoviedb.core.BaseViewStatus

class MainViewStatus(
    var resultList: List<Result> = listOf(),
    var termList: List<String> = listOf()
) : BaseViewStatus()