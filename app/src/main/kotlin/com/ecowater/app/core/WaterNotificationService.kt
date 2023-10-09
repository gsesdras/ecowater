package com.ecowater.app.core

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import com.ecowater.app.R
import kotlin.random.Random

class WaterNotificationService(
    private val context: Context
) {

    private val notificationManager = context.getSystemService(NotificationManager::class.java)

    fun showBasicNotification() {
        val notification = NotificationCompat.Builder(context, "near_water_notification")
            .setContentTitle("EcoWater")
            .setContentText("Seems that you are near a water source! Check it out, and learn more about it!")
            .setSmallIcon(R.drawable.rounded_logo)
            .setPriority(NotificationManager.IMPORTANCE_HIGH)
            .setAutoCancel(true)
            .build()

        notificationManager.notify(
            Random.nextInt(),
            notification
        )
    }
}