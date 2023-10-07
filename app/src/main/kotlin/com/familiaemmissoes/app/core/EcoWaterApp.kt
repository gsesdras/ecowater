package com.familiaemmissoes.app.core

import android.app.Application
import com.familiaemmissoes.app.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class EcoWaterApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@EcoWaterApp)
            modules(appModule)
        }
    }
}