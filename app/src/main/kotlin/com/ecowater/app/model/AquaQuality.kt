package com.ecowater.app.model

data class AquaQuality(
    val ph: Float,
    val temperature: Float,
    val turbidity: Float,
    val salinity: Float,
    val drinkable: Boolean
)
