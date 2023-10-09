package com.ecowater.app.model

data class EndangeredSpecie(
    val name: String,
    val description: String,
    val scientificName: String,
    val imageUrl: String,
    val alertLevel: AlertLevel,
    val system: String,
    val principalThreats: List<String>,
    val protectiveMeasures: List<String>
)

