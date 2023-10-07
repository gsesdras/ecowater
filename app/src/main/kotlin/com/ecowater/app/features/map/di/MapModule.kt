package com.ecowater.app.features.map.di

import com.ecowater.app.features.map.presentation.MapViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mapModule = module {
    viewModel {
        MapViewModel()
    }
}