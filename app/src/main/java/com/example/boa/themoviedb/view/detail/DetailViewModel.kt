package com.example.boa.themoviedb.view.detail

import com.example.boa.themoviedb.core.BaseViewModel

class DetailViewModel : BaseViewModel<DetailViewStatus>() {
    override fun getInitialViewState(): DetailViewStatus = DetailViewStatus()

    fun load(url: String) {
        resourceViewState.value = DetailViewStatus(url)
    }
}