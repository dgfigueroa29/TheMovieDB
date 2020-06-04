package com.example.boa.domain.usecase

import com.example.boa.domain.core.BaseUseCase
import com.example.boa.domain.model.Result
import com.example.boa.domain.repository.SearchRepository
import kotlinx.coroutines.CoroutineScope

class SearchUseCase(scope: CoroutineScope, private val searchRepository: SearchRepository) :
    BaseUseCase<List<Result>, String>(scope) {
    override suspend fun getData(param: String): List<Result> = searchRepository.searchByTerm(param)
}