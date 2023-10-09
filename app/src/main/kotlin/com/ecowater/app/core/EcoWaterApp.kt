package com.ecowater.app.core

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
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

        val notificationChannel = NotificationChannel(
            "near_water_notification",
            "Near Water",
            NotificationManager.IMPORTANCE_HIGH
        )
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(notificationChannel)
    }
}