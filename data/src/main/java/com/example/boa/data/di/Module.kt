package com.example.boa.data.di

import com.example.boa.data.datasource.ResultDataSource
import com.example.boa.data.datasource.SearchDataSource
import com.example.boa.data.datasource.TermDataSource
import com.example.boa.data.datasource.local.LocalResultDataSource
import com.example.boa.data.datasource.local.LocalTermDataSource
import com.example.boa.data.datasource.local.db.TheMovieDBDatabase
import com.example.boa.data.datasource.remote.ApiProvider
import com.example.boa.data.datasource.remote.RemoteSearchDataSource
import com.example.boa.data.mapper.ResultEntityToModel
import com.example.boa.data.mapper.ResultModelToEntity
import com.example.boa.data.mapper.ResultResponseToModel
import com.example.boa.data.mapper.TermEntityToString
import com.example.boa.data.repository.SearchRepositoryImpl
import com.example.boa.data.repository.TermRepositoryImpl
import com.example.boa.domain.repository.SearchRepository
import com.example.boa.domain.repository.TermRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single<ResultDataSource> { LocalResultDataSource(get()) }
    single<TermDataSource> { LocalTermDataSource(get()) }

    single<SearchDataSource> { RemoteSearchDataSource(get(), get()) }

    single<SearchRepository> {
        SearchRepositoryImpl(
            get(),
            get(),
            get(),
            get(),
            get(),
            androidContext()
        )
    }
    single<TermRepository> { TermRepositoryImpl(get(), get()) }

    single { ResultEntityToModel() }
    single { ResultModelToEntity() }
    single { ResultResponseToModel() }
    single { TermEntityToString() }

    single { ApiProvider(androidContext()) }
    single {
        val apiProvider: ApiProvider = get()
        apiProvider.api
    }
    single { TheMovieDBDatabase.getAppDatabase(androidContext()) }
}