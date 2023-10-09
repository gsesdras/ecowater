package com.ecowater.app.features.details.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.ecowater.app.model.AlertLevel
import com.ecowater.app.model.EndangeredSpecie
import com.ecowater.app.model.Location
import com.ecowater.app.ui.BarlowFamily
import com.ecowater.app.ui.RobotoFamily
import com.ecowater.app.ui.components.AsyncImageWithShimmer
import com.ecowater.app.ui.components.AutoSizeText
import com.ecowater.app.ui.components.Tag
import java.util.Locale

@Composable
fun DetailsScreen(location: Location) {
    var isDialogOpen by remember { mutableStateOf(false) }
    var selectedSpecie by remember { mutableStateOf<EndangeredSpecie?>(null) }

    LazyColumn(
        modifier = Modifier
            .systemBarsPadding()
            .fillMaxWidth()
            .fillMaxHeight(0.9f)
            .padding(horizontal = 16.dp)
            .padding(bottom = 16.dp)
    ) {
        item {
            Header(location = location)
        }
        item {
            TitleCard(title = "Description", contentTopPadding = 4.dp) {
                Text(
                    text = location.description,
                    fontFamily = RobotoFamily,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
        item {
            Row {
                Box(Modifier.weight(0.43f)) {
                    TitleCard(title = "Water pH Level", contentTopPadding = 4.dp) {
                        Text(
                            text = location.aquaQuality.ph.toString(),
                            fontFamily = RobotoFamily,
                            fontSize = 54.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
                Spacer(modifier = Modifier.weight(0.03f))
                Box(Modifier.weight(0.46f)) {
                    TitleCard(title = "Water turbidity", contentTopPadding = 4.dp) {
                        Text(
                            text = location.aquaQuality.turbidity.toString(),
                            fontFamily = RobotoFamily,
                            fontSize = 54.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            TitleCard(title = "Endangered Species", contentTopPadding = 8.dp) {
                location.endangeredSpecies.forEachIndexed { index, endangeredSpecie ->
                    EndangeredSpeciesItem(specie = endangeredSpecie) {
                        isDialogOpen = true
                        selectedSpecie = endangeredSpecie
                    }
                    if (index != location.endangeredSpecies.size - 1) {
                        Divider(color = DividerDefaults.color.copy(alpha = 0.5f))
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            TitleCard(title = "How to preserve our bodies of water", contentTopPadding = 4.dp) {
                listOf(
                    "Not leaving trash on the beach to protect the sea.",
                    "Reducing plastic usage and recycling to prevent ocean pollution.",
                    "Choosing environmentally friendly products, such as coral-safe sunscreens."
                ).forEach {
                    Text(
                        text = "• " + it.capitalize(),
                        style = MaterialTheme.typography.labelMedium,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Thin
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                }
            }
        }
    }

    if (isDialogOpen && selectedSpecie != null) {
        Dialog(onDismissRequest = {
            isDialogOpen = false
            selectedSpecie = null
        }) {
            SpecieScreen(specie = selectedSpecie!!)
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Header(location: Location) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 16.dp,
                end = 16.dp,
                bottom = 16.dp
            )
    ) {
        AutoSizeText(
            text = location.firstNamePart.uppercase(),
            textStyle = TextStyle(
                fontFamily = BarlowFamily,
                fontSize = 56.sp,
                fontWeight = FontWeight.Medium
            )
        )
        Text(
            text = location.lastNamePart.uppercase(),
            fontFamily = RobotoFamily,
            fontSize = 24.sp,
            fontWeight = FontWeight.Thin
        )

        Spacer(Modifier.height(8.dp))
        Divider()
        Spacer(Modifier.height(8.dp))

        Text(
            text = "${location.city} - ${location.state}".uppercase(),
            fontFamily = RobotoFamily,
            fontSize = 18.sp,
            fontWeight = FontWeight.Thin
        )

        Spacer(modifier = Modifier.height(8.dp))

        FlowRow(
            verticalArrangement = Arrangement.spacedBy(2.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            repeat(location.tags.size) {
                Tag(label = location.tags[it])
            }
        }
    }
}

@Composable
fun TitleCard(
    title: String,
    contentTopPadding: Dp,
    colors: CardColors = CardDefaults.cardColors(),
    content: @Composable () -> Unit
) {
    Card(modifier = Modifier.fillMaxWidth(), colors = colors) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp,
                    top = 8.dp
                )
        ) {
            Text(
                text = title.uppercase(),
                style = MaterialTheme.typography.labelMedium,
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.height(contentTopPadding))
            content()
        }
    }
}

@Composable
fun EndangeredSpeciesItem(specie: EndangeredSpecie, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .clickable { onClick() }
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImageWithShimmer(
            modifier = Modifier.size(48.dp),
            imageUrl = specie.imageUrl,
            shape = RoundedCornerShape(100),
            contentScale = ContentScale.Crop
        )
        Spacer(Modifier.width(8.dp))
        Column {
            Text(
                text = specie.name,
                style = MaterialTheme.typography.labelLarge,
                fontSize = 16.sp
            )
            Text(
                text = specie.scientificName,
                style = MaterialTheme.typography.labelMedium,
                fontSize = 14.sp,
                fontWeight = FontWeight.Thin
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Column(
            horizontalAlignment = Alignment.End
        ) {
            AlertLevelCard(level = specie.alertLevel)
            Spacer(modifier = Modifier.height(4.dp))
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
    }
}

@Composable
fun AlertLevelCard(level: AlertLevel) {
    Card {
        Column(
            modifier = Modifier
                .background(level.color)
                .padding(horizontal = 8.dp, vertical = 4.dp)
        ) {
            Text(
                text = level.value.capitalize(),
                style = MaterialTheme.typography.labelLarge,
                fontSize = 10.sp,
                color = level.textColor
            )
        }
    }
}

fun String.capitalize() =
    replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }