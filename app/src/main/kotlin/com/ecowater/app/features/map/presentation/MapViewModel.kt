package com.ecowater.app.features.map.presentation

import androidx.lifecycle.ViewModel
import com.ecowater.app.model.Location
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MapViewModel : ViewModel() {

    private val _locations = MutableStateFlow<List<Location>>(emptyList())
    val locations = _locations.asStateFlow()

    val initialLatLong get() = LatLng(
        -10.9512646,
        -37.0579337
    )

    init {
        fetchLocations()
    }

    private fun fetchLocations() {
        _locations.update {
            listOf(
                Location.sample
            )
        }
    }
}