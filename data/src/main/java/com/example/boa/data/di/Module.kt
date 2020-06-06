package com.example.boa.data.di

import com.example.boa.data.datasource.*
import com.example.boa.data.datasource.local.*
import com.example.boa.data.datasource.local.db.TheMovieDBDatabase
import com.example.boa.data.datasource.remote.*
import com.example.boa.data.mapper.ResultEntityToModel
import com.example.boa.data.mapper.ResultModelToEntity
import com.example.boa.data.mapper.ResultResponseToModel
import com.example.boa.data.mapper.TermEntityToString
import com.example.boa.data.repository.*
import com.example.boa.domain.repository.*
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single<ResultDataSource> { LocalResultDataSource(get()) }
    single<TermDataSource> { LocalTermDataSource(get()) }
    single<PopularDataSource> { LocalPopularDataSource(get(), get()) }
    single<TopRatedDataSource> { LocalTopRatedDataSource(get(), get()) }
    single<DetailDataSource> { LocalDetailDataSource(get(), get()) }

    single<SearchDataSource> { RemoteSearchDataSource(get(), get()) }
    single<PopularDataSource> { RemotePopularDataSource(get(), get()) }
    single<TopRatedDataSource> { RemoteTopRatedDataSource(get(), get()) }
    single<DetailDataSource> { RemoteDetailDataSource(get(), get()) }

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
    single<PopularRepository> { PopularRepositoryImpl(get(), get()) }
    single<TopRatedRepository> { TopRatedRepositoryImpl(get(), get()) }
    single<DetailRepository> { DetailRepositoryImpl(get(), get()) }

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