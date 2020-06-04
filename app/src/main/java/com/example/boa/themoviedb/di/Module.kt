package com.example.boa.themoviedb.di

import com.example.boa.themoviedb.view.detail.DetailViewModel
import com.example.boa.themoviedb.view.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { MainViewModel(get(), get()) }
    viewModel { DetailViewModel() }
}