package com.ecowater.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest

@Composable
fun AsyncImageWithShimmer(
    modifier: Modifier = Modifier,
    imageUrl: String,
    shape: Shape,
    contentScale: ContentScale
) {
    SubcomposeAsyncImage(
        modifier = modifier.clip(shape),
        model = ImageRequest.Builder(LocalContext.current).data(imageUrl).crossfade(true).build(),
        contentDescription = null,
        contentScale = contentScale,
        loading = {
            Box(modifier = Modifier.background(shimmerBrush()))
        }
    )
}