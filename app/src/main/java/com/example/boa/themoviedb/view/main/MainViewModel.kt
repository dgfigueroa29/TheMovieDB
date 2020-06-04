package com.example.boa.themoviedb.view.main

import com.example.boa.domain.core.BaseException
import com.example.boa.domain.core.BaseStatusObserver
import com.example.boa.domain.model.Result
import com.example.boa.domain.usecase.SearchUseCase
import com.example.boa.domain.usecase.SuggestTermsUseCase
import com.example.boa.themoviedb.core.BaseViewModel

class MainViewModel(
    private val suggestTermsUseCase: SuggestTermsUseCase,
    private val searchUseCase: SearchUseCase
) : BaseViewModel<MainViewStatus>() {
    private var resultList: List<Result> = listOf()
    private var termList: List<String> = listOf()

    override fun getInitialViewState(): MainViewStatus = MainViewStatus()

    fun suggest(term: String = "") {
        val mainViewStatus = getInitialViewState()
        BaseStatusObserver(resourceViewState, suggestTermsUseCase.execute(null), {
            termList = it ?: termList
            mainViewStatus.isReady = true
            mainViewStatus.termList = termList
            resourceViewState.value = mainViewStatus
        }, this::onError, this::onLoading)

        if (term.isNotEmpty()) {
            termList = listOf(term)
        }
    }

    fun search(term: String, isTest: Boolean = false) {
        val mainViewStatus = getInitialViewState()
        BaseStatusObserver(resourceViewState, searchUseCase.execute(term), {
            resultList = it ?: resultList
            mainViewStatus.isComplete = true
            mainViewStatus.resultList = resultList
            resourceViewState.value = mainViewStatus
        }, this::onError, this::onLoading)

        if (isTest) {
            val result = Result()
            result.term = term
            resultList = listOf(result)
        }
    }

    private fun onError(exception: BaseException?) {
        exception?.let {
            val mainViewStatus = getInitialViewState()
            mainViewStatus.isError = true
            mainViewStatus.errorMessage = it.message ?: ""
            resourceViewState.value = mainViewStatus
        }
    }

    private fun onLoading(progress: Int) {
        val mainViewStatus = getInitialViewState()
        mainViewStatus.isLoading = progress > 100
        resourceViewState.value = mainViewStatus
    }
}