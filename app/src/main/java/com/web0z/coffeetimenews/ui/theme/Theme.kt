package com.web0z.coffeetimenews.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = lightDark2,
    primaryVariant = lightDark,
    secondary = lightBrown,
    onPrimary = darkTextColor
)

private val LightColorPalette = lightColors(
    primary = lightBrown,
    primaryVariant = white,
    secondary = lightDark2,
    onPrimary = lightTextColor
)

@Composable
fun CoffeeTimeNewsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    MaterialTheme(
        colors = if (darkTheme) DarkColorPalette else LightColorPalette,
        typography = CoffeeTimeNewsTypography,
        shapes = CoffeeTimeNewsShapes,
        content = content
    )
}