package com.ecowater.app.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ecowater.app.ui.RobotoFamily

@Composable
fun Tag(label: String) {
    OutlinedCard(
        shape = RoundedCornerShape(100),
        border = BorderStroke(0.5.dp, MaterialTheme.colorScheme.outline)
    ) {
        Box(modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)) {
            Text(
                text = label,
                fontSize = 10.sp,
                fontFamily = RobotoFamily,
                fontWeight = FontWeight.Thin
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TagPreview() {
    Tag(label = "Controlled Fishing")
}