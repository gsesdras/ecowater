package com.ecowater.app.model

import androidx.compose.ui.graphics.Color

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

sealed class AlertLevel(
    val value: String,
    val color: Color,
    val textColor: Color
) {
    data object Vulnerable : AlertLevel("Vulnerable", Color(0xFFF9D976), Color(0xFF000000))
    data object InDanger : AlertLevel("In Danger", Color(0xFFDD8041), Color(0xFFFFFFFF))
    data object CriticalDanger : AlertLevel("Critical Danger", Color(0xFFE94B4B), Color(0xFFFFFFFF))
}
