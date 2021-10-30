package com.ashaluwalakazeem.loubankuidesign.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Accent,
    primaryVariant = Mint,
    secondary = Purple
)

private val LightColorPalette = lightColors(
    primary = Accent,
    primaryVariant = Mint,
    secondary = Purple

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun LouBankUIDesignTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = LightColorPalette

    MaterialTheme(
        colors = colors,
        typography = nunitoTypography,
        shapes = Shapes,
        content = content
    )
}