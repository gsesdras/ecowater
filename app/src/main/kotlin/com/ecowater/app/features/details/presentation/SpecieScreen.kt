package com.ecowater.app.features.details.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ecowater.app.model.EndangeredSpecie
import com.ecowater.app.ui.BarlowFamily
import com.ecowater.app.ui.RobotoFamily
import com.ecowater.app.ui.components.AsyncImageWithShimmer
import com.ecowater.app.ui.components.AutoSizeText

@Composable
fun SpecieScreen(specie: EndangeredSpecie) {

    Card(colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)) {
        AsyncImageWithShimmer(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1.5f),
            imageUrl = specie.imageUrl,
            shape = RectangleShape,
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            AutoSizeText(
                text = specie.name.uppercase(),
                textStyle = TextStyle(
                    fontFamily = BarlowFamily,
                    fontSize = 56.sp,
                    fontWeight = FontWeight.Medium
                )
            )
            Text(
                text = specie.scientificName.uppercase(),
                fontFamily = RobotoFamily,
                fontSize = 18.sp,
                fontWeight = FontWeight.Thin
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                AlertLevelCard(level = specie.alertLevel)
                Spacer(modifier = Modifier.width(4.dp))
                Card {
                    Column(
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.inversePrimary)
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    ) {
                        Text(
                            text = specie.system.capitalize(),
                            style = MaterialTheme.typography.labelLarge,
                            fontSize = 10.sp
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            TitleCard(
                title = "Principal Threats",
                contentTopPadding = 4.dp,
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                LazyColumn {
                    items(specie.principalThreats) { threat ->
                        Text(
                            text = "• " + threat.capitalize(),
                            style = MaterialTheme.typography.labelMedium,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Thin
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            TitleCard(
                title = "Protective Measures",
                contentTopPadding = 4.dp,
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                LazyColumn {
                    items(specie.protectiveMeasures) { protectiveMeasure ->
                        Text(
                            text = "• " + protectiveMeasure.capitalize(),
                            style = MaterialTheme.typography.labelMedium,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Thin
                        )
                    }
                }
            }
        }
    }
}