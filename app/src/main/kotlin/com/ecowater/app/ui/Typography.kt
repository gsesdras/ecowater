package com.ecowater.app.ui

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ecowater.app.R

val BarlowFamily = FontFamily(
    Font(
        resId = R.font.barlow,
        weight = FontWeight.Normal
    ),
    Font(
        resId = R.font.barlow_medium,
        weight = FontWeight.Medium
    ),
    Font(
        resId = R.font.barlow_bold,
        weight = FontWeight.Bold
    ),
    Font(
        resId = R.font.barlow_extrabold,
        weight = FontWeight.ExtraBold
    )
)

val RobotoFamily = FontFamily(
    Font(
        resId = R.font.roboto,
        weight = FontWeight.Normal
    ),
    Font(
        resId = R.font.roboto_thin,
        weight = FontWeight.Thin
    ),
    Font(
        resId = R.font.roboto_light,
        weight = FontWeight.Light
    ),
    Font(
        resId = R.font.roboto_medium,
        weight = FontWeight.Medium
    )
)

val Typography = Typography(
    headlineSmall = TextStyle(
        fontFamily = BarlowFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 23.sp,
        lineHeight = 32.sp
    ),
    titleLarge = TextStyle(
        fontFamily = BarlowFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 19.sp,
        lineHeight = 28.sp
    ),
    titleMedium = TextStyle(
        fontFamily = BarlowFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    titleSmall = TextStyle(
        fontFamily = BarlowFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = RobotoFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = RobotoFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),
    bodySmall = TextStyle(
        fontFamily = RobotoFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 14.sp
    ),
    labelLarge = TextStyle(
        fontFamily = RobotoFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),
    labelMedium = TextStyle(
        fontFamily = RobotoFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp
    ),
    labelSmall = TextStyle(
        fontFamily = RobotoFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        lineHeight = 12.sp
    )
)