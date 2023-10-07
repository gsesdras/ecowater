package com.ecowater.app.features.map.presentation

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import com.ecowater.app.features.map.presentation.model.LocationDot
import org.koin.androidx.compose.koinViewModel
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun MapScreen(
    mapViewModel: MapViewModel = koinViewModel(),
    onLocationClicked: (String) -> Unit
) {
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        mapViewModel.setupCompass(context = context)
        mapViewModel.startListener()
    }

    val compassData by mapViewModel.compassData.collectAsState()
    var canvasWidth by remember { mutableFloatStateOf(0f) }
    var canvasHeight by remember { mutableFloatStateOf(0f) }
    val canvasCenterX = canvasWidth / 2
    val canvasCenterY = canvasHeight / 2
    val radius = canvasWidth / 2

    val locationsAngles = listOf(
        Pair(0f, "1"),
        Pair(45f, "2"),
        Pair(300f, "3")
    )

    val locationDots by rememberUpdatedState(
        locationsAngles.map { angle ->
            val adjustedAngle = (compassData + angle.first) % 360f
            val isInUpperSide = adjustedAngle in 300f..360f || adjustedAngle in 0f..60f

            val sizeDivider by animateFloatAsState(
                targetValue = canvasWidth / if (isInUpperSide) 10f else 20f, label = ""
            )

            LocationDot(
                locationId = angle.second,
                x = canvasCenterX + radius * cos(
                    Math.toRadians(
                        adjustedAngle.toDouble() - 90f
                    )
                ).toFloat(),
                y = canvasCenterY + radius * sin(
                    Math.toRadians(
                        adjustedAngle.toDouble() - 90f
                    )
                ).toFloat(),
                size = sizeDivider
            )
        }
    )

    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        val tappedLocationDot = locationDots.firstOrNull { locationDot ->
                            it.x in locationDot.x - 50f..locationDot.x + 50f &&
                                    it.y in locationDot.y - 50f..locationDot.y + 50f
                        }

                        println("Tapped location dot: $tappedLocationDot")

                        if (tappedLocationDot != null) {
                            onLocationClicked(tappedLocationDot.locationId)
                        }
                    }
                )
            }
            .onGloballyPositioned {
                canvasWidth = it.size.width.toFloat()
                canvasHeight = it.size.height.toFloat()
            }
    ) {
        locationDots.forEach { locationDot ->
            drawCircle(
                color = Red,
                radius = locationDot.size,
                center = Offset(locationDot.x, locationDot.y)
            )
        }
    }
}