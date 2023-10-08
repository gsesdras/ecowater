package com.ecowater.app.di

import com.ecowater.app.features.details.di.detailsModule
import com.ecowater.app.features.map.di.mapModule

val appModule = listOf(
    mapModule,
    detailsModule
)