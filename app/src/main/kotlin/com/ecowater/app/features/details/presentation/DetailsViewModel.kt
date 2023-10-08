package com.ecowater.app.features.details.presentation

import androidx.lifecycle.ViewModel
import com.ecowater.app.model.Location
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DetailsViewModel : ViewModel() {

    private val _location = MutableStateFlow<Location?>(null)
    val location = _location.asStateFlow()

    fun fetchLocation(id: String) {
        _location.update {
            Location.sample
        }
    }

}