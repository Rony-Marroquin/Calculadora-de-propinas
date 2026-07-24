package com.example.calculadora_de_propina.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.FontFamily

// Base de Material 3
val baseline = Typography()

val defaultFont = FontFamily.Default

val AppTypography = Typography(
    displayLarge = baseline.displayLarge.copy(fontFamily = defaultFont),
    displayMedium = baseline.displayMedium.copy(fontFamily = defaultFont),
    displaySmall = baseline.displaySmall.copy(fontFamily = defaultFont),

    headlineLarge = baseline.headlineLarge.copy(fontFamily = defaultFont),
    headlineMedium = baseline.headlineMedium.copy(fontFamily = defaultFont),
    headlineSmall = baseline.headlineSmall.copy(fontFamily = defaultFont),

    titleLarge = baseline.titleLarge.copy(fontFamily = defaultFont),
    titleMedium = baseline.titleMedium.copy(fontFamily = defaultFont),
    titleSmall = baseline.titleSmall.copy(fontFamily = defaultFont),

    bodyLarge = baseline.bodyLarge.copy(fontFamily = defaultFont),
    bodyMedium = baseline.bodyMedium.copy(fontFamily = defaultFont),
    bodySmall = baseline.bodySmall.copy(fontFamily = defaultFont),

    labelLarge = baseline.labelLarge.copy(fontFamily = defaultFont),
    labelMedium = baseline.labelMedium.copy(fontFamily = defaultFont),
    labelSmall = baseline.labelSmall.copy(fontFamily = defaultFont),
)