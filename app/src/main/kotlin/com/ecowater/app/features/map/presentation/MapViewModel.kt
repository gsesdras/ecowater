package com.ecowater.app.features.map.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import com.ecowater.app.features.map.domain.Compass
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MapViewModel : ViewModel() {

    private val _compassData = MutableStateFlow(0f)
    val compassData = _compassData.asStateFlow()

    private lateinit var compass: Compass

    fun setupCompass(context: Context) {
        compass = Compass(context)
        compass.setListener(
            object : Compass.CompassListener {
                override fun onNewAzimuth(azimuth: Float) {
                    _compassData.update { azimuth }
                }
            }
        )
    }

    fun startListener() {
        compass.start()
    }

    private fun stopCompassObservation() {
        compass.stop()
    }

    override fun onCleared() {
        super.onCleared()
        stopCompassObservation()
    }
}