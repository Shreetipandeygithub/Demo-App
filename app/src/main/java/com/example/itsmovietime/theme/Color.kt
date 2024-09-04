package com.example.itsmovietime.theme

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

// Define your custom colors here
//val Purple200 = Color(0xFFBB86FC)
//val Purple500 = Color(0xFF6200EE)
//val Purple700 = Color(0xFF3700B3)
//val Teal200 = Color(0xFF03DAC5)
val Black=Color(0xFF000000)
val White=Color(0xFFFFFEFE)

// Dark theme colors
val DarkPrimary = Color(0xFF1F1F1F)
val DarkSecondary = Color(0xFF37474F)

// Light theme colors
val LightPrimary = Color(0xFFFFFFFF)
val LightSecondary = Color(0xFFB0BEC5)

// Update your color palettes in your DarkColorPalette and LightColorPalette
private val DarkColorPalette = darkColors(
    primary = DarkPrimary,
    secondary = DarkSecondary,
    // Add more color parameters as needed
)

private val LightColorPalette = lightColors(
    primary = LightPrimary,
    secondary = LightSecondary,
    // Add more color parameters as needed
)
