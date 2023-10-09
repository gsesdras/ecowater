package com.ecowater.app.features.map.presentation

import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.Manifest.permission.POST_NOTIFICATIONS
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.ecowater.app.R
import com.ecowater.app.core.WaterNotificationService
import com.ecowater.app.model.Location
import com.ecowater.app.ui.bitmapDescriptorFromVector
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapScreen(
    onLocationClicked: (Location) -> Unit
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    var locationGranted by remember { mutableStateOf(false) }

    val waterNotificationService = WaterNotificationService(context)

    val launcher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        locationGranted = isGranted
    }

    var infoBottomSheetEnabled by remember {
        mutableStateOf(true)
    }

    LaunchedEffect(Unit) {
        when (PackageManager.PERMISSION_GRANTED) {
            ContextCompat.checkSelfPermission(
                context,
                ACCESS_COARSE_LOCATION
            ) -> {
                when (PackageManager.PERMISSION_GRANTED) {
                    ContextCompat.checkSelfPermission(
                        context,
                        ACCESS_FINE_LOCATION
                    ) -> {
                        locationGranted = true
                    }
                    else -> {
                        launcher.launch(ACCESS_COARSE_LOCATION)
                    }
                }
            }
            else -> {
                launcher.launch(ACCESS_COARSE_LOCATION)
            }
        }

        when(PackageManager.PERMISSION_GRANTED) {
            ContextCompat.checkSelfPermission(
                context,
                POST_NOTIFICATIONS
            ) -> {}

            else -> {
                launcher.launch(POST_NOTIFICATIONS)
            }
        }
    }

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(
            LatLng(
                -10.9512646,
                -37.0579337
            ),
            13f
        )
    }

    val locations = Location.sample
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                infoBottomSheetEnabled = true
            }) {
                Icon(imageVector = Icons.Filled.KeyboardArrowUp, contentDescription = null)
            }
        }
    ) {
        if (locationGranted) {
            GoogleMap(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                cameraPositionState = cameraPositionState,
                properties = MapProperties(
                    isMyLocationEnabled = true,
                    mapType = MapType.TERRAIN
                ),
                uiSettings = MapUiSettings(
                    zoomControlsEnabled = false
                )
            ) {
                locations.forEach { location ->
                    Marker(
                        state = MarkerState(position = location.coordinates),
                        title = location.name,
                        snippet = location.description,
                        icon = bitmapDescriptorFromVector(
                            context = context,
                            vectorResId = location.markerResId
                        ),
                        onClick = {
                            onLocationClicked(location)
                            true
                        }
                    )
                }
            }
        }

        if (infoBottomSheetEnabled) {
            ModalBottomSheet(
                onDismissRequest = {
                    infoBottomSheetEnabled = false
                },
                sheetState = sheetState
            ) {
                Column(
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        modifier = Modifier
                            .padding(horizontal = 64.dp)
                            .padding(vertical = 32.dp),
                        painter = painterResource(R.drawable.destination_art),
                        contentDescription = null
                    )
                    Text(
                        text = "EcoWater",
                        style = MaterialTheme.typography.headlineSmall,
                        fontSize = 28.sp,
                        letterSpacing = 0.75.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        text = "EcoWater is an app that helps you find beaches, check water quality, and learn about protecting aquatic species for sustainable water experiences.",
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Light,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Text(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        text = "In order to see the location details, you can click on the marker on the map. For example, you can click on the Atalaia Beach marker below:",
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Light,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Box(modifier = Modifier.clip(RoundedCornerShape(25))) {
                        Image(
                            modifier = Modifier
                                .clip(CircleShape)
                                .border(1.dp, MaterialTheme.colorScheme.primary, CircleShape)
                                .clickable {
                                    coroutineScope.launch {
                                        sheetState.hide()
                                        onLocationClicked(locations[2])
                                        infoBottomSheetEnabled = false
                                    }
                                }
                            ,
                            painter = painterResource(id = R.drawable.location_example),
                            contentDescription = null
                        )
                    }
                    Spacer(modifier = Modifier.height(32.dp))
                }
            }
        }
    }
}