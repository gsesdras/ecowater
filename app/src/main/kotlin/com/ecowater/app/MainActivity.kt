package com.ecowater.app

import android.Manifest.permission.POST_NOTIFICATIONS
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.ecowater.app.core.WaterNotificationService
import com.ecowater.app.features.details.presentation.DetailsScreen
import com.ecowater.app.features.map.presentation.MapScreen
import com.ecowater.app.model.Location
import com.ecowater.app.ui.EcoWaterTheme
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class, ExperimentalPermissionsApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContent {
            EcoWaterTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
                    val scope = rememberCoroutineScope()
                    var showBottomSheet by remember { mutableStateOf(false) }
                    var selectedLocation by remember { mutableStateOf<Location?>(null) }

                    MapScreen {
                        selectedLocation = it
                        scope.launch {
                            showBottomSheet = true
                        }
                    }

                    if (showBottomSheet && selectedLocation != null) {
                        ModalBottomSheet(
                            onDismissRequest = {
                                selectedLocation = null
                                showBottomSheet = false
                            },
                            sheetState = sheetState
                        ) {
                            DetailsScreen(location = selectedLocation!!)
                        }
                    }
                }
            }
        }
    }
}