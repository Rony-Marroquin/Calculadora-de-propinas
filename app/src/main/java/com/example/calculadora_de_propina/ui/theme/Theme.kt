package com.example.compose
import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import com.example.calculadora_de_propina.ui.theme.AppTypography
import com.example.calculadora_de_propina.ui.theme.backgroundLight
import com.example.calculadora_de_propina.ui.theme.errorContainerLight
import com.example.calculadora_de_propina.ui.theme.errorDark
import com.example.calculadora_de_propina.ui.theme.errorLight
import com.example.calculadora_de_propina.ui.theme.inverseOnSurfaceDark
import com.example.calculadora_de_propina.ui.theme.inverseOnSurfaceLight
import com.example.calculadora_de_propina.ui.theme.inversePrimaryLight
import com.example.calculadora_de_propina.ui.theme.inverseSurfaceLight
import com.example.calculadora_de_propina.ui.theme.onBackgroundLight
import com.example.calculadora_de_propina.ui.theme.onErrorContainerLight
import com.example.calculadora_de_propina.ui.theme.onErrorDark
import com.example.calculadora_de_propina.ui.theme.onErrorLight
import com.example.calculadora_de_propina.ui.theme.onPrimaryContainerDark
import com.example.calculadora_de_propina.ui.theme.onPrimaryContainerLight
import com.example.calculadora_de_propina.ui.theme.onPrimaryContainerLightMediumContrast
import com.example.calculadora_de_propina.ui.theme.onPrimaryDark
import com.example.calculadora_de_propina.ui.theme.onPrimaryLight
import com.example.calculadora_de_propina.ui.theme.onPrimaryLightMediumContrast
import com.example.calculadora_de_propina.ui.theme.onSecondaryContainerDark
import com.example.calculadora_de_propina.ui.theme.onSecondaryContainerLight
import com.example.calculadora_de_propina.ui.theme.onSecondaryDark
import com.example.calculadora_de_propina.ui.theme.onSecondaryLight
import com.example.calculadora_de_propina.ui.theme.onSecondaryLightMediumContrast
import com.example.calculadora_de_propina.ui.theme.onSurfaceLight
import com.example.calculadora_de_propina.ui.theme.onSurfaceVariantLight
import com.example.calculadora_de_propina.ui.theme.onTertiaryContainerDark
import com.example.calculadora_de_propina.ui.theme.onTertiaryContainerLight
import com.example.calculadora_de_propina.ui.theme.onTertiaryDark
import com.example.calculadora_de_propina.ui.theme.onTertiaryLight
import com.example.calculadora_de_propina.ui.theme.onTertiaryLightMediumContrast
import com.example.calculadora_de_propina.ui.theme.outlineLight
import com.example.calculadora_de_propina.ui.theme.outlineVariantLight
import com.example.calculadora_de_propina.ui.theme.primaryContainerDark
import com.example.calculadora_de_propina.ui.theme.primaryContainerLight
import com.example.calculadora_de_propina.ui.theme.primaryContainerLightMediumContrast
import com.example.calculadora_de_propina.ui.theme.primaryDark
import com.example.calculadora_de_propina.ui.theme.primaryLight
import com.example.calculadora_de_propina.ui.theme.primaryLightMediumContrast
import com.example.calculadora_de_propina.ui.theme.scrimLight
import com.example.calculadora_de_propina.ui.theme.secondaryContainerDark
import com.example.calculadora_de_propina.ui.theme.secondaryContainerLight
import com.example.calculadora_de_propina.ui.theme.secondaryContainerLightMediumContrast
import com.example.calculadora_de_propina.ui.theme.secondaryDark
import com.example.calculadora_de_propina.ui.theme.secondaryLight
import com.example.calculadora_de_propina.ui.theme.secondaryLightMediumContrast
import com.example.calculadora_de_propina.ui.theme.surfaceBrightLight
import com.example.calculadora_de_propina.ui.theme.surfaceContainerHighLight
import com.example.calculadora_de_propina.ui.theme.surfaceContainerLight
import com.example.calculadora_de_propina.ui.theme.surfaceContainerLowLight
import com.example.calculadora_de_propina.ui.theme.surfaceContainerLowestLight
import com.example.calculadora_de_propina.ui.theme.surfaceDimLight
import com.example.calculadora_de_propina.ui.theme.surfaceLight
import com.example.calculadora_de_propina.ui.theme.surfaceVariantLight
import com.example.calculadora_de_propina.ui.theme.tertiaryContainerDark
import com.example.calculadora_de_propina.ui.theme.tertiaryContainerLight
import com.example.calculadora_de_propina.ui.theme.tertiaryDark
import com.example.calculadora_de_propina.ui.theme.tertiaryLight



private val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,

)

private val darkScheme: ColorScheme
    get() = darkColorScheme(
        primary = primaryDark,
        onPrimary = onPrimaryDark,
        primaryContainer = primaryContainerDark,
        onPrimaryContainer = onPrimaryContainerDark,
        secondary = secondaryDark,
        onSecondary = onSecondaryDark,
        secondaryContainer = secondaryContainerDark,
        onSecondaryContainer = onSecondaryContainerDark,
        tertiary = tertiaryDark,
        onTertiary = onTertiaryDark,
        tertiaryContainer = tertiaryContainerDark,
        onTertiaryContainer = onTertiaryContainerDark,
        error = errorDark,
        onError = onErrorDark
    )







@Immutable
data class ColorFamily(
    val color: Color,
    val onColor: Color,
    val colorContainer: Color,
    val onColorContainer: Color
)

val unspecified_scheme = ColorFamily(
    Color.Unspecified, Color.Unspecified, Color.Unspecified, Color.Unspecified
)

@Composable
fun  Calculadora_De_PropinaTheme (
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable() () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> darkScheme
        else -> lightScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        content = content
    )
}

