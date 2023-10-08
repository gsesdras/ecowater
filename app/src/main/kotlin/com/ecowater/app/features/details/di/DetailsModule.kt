package com.ecowater.app.features.details.di

import com.ecowater.app.features.details.presentation.DetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val detailsModule = module {
    viewModel {
        DetailsViewModel()
    }
}