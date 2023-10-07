package com.ecowater.app.core

import android.app.Application
import com.ecowater.app.di.appModule
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