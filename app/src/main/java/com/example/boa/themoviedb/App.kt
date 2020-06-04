package com.example.boa.themoviedb

import android.app.Application
import com.example.boa.data.di.dataModule
import com.example.boa.domain.di.domainModule
import com.example.boa.themoviedb.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

@Suppress("unused")
class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }
}