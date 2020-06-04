package com.example.boa.domain.di

import com.example.boa.domain.usecase.SearchUseCase
import com.example.boa.domain.usecase.SuggestTermsUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val domainModule = module {
    factory { SuggestTermsUseCase(get(), get()) }
    factory { SearchUseCase(get(), get()) }

    single { CoroutineScope(Dispatchers.IO) }
}