package com.web0z.coffeetimenews.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.web0z.coffeetimenews.R

private val Andada = FontFamily(
    Font(R.font.andada_regular)
)

private val AndadaSC = FontFamily(
    Font(R.font.andada_sc_regular)
)


// Set of Material typography styles to start with
val CoffeeTimeNewsTypography = Typography(
    defaultFontFamily = Andada,
    h1 = TextStyle(
        fontFamily = AndadaSC,
        fontWeight = FontWeight.Normal,
        fontSize = 58.sp,
        letterSpacing = 3.sp
    ),
    h2 = TextStyle(
        fontFamily = AndadaSC,
        fontWeight = FontWeight.Normal,
        fontSize = 48.sp,
        letterSpacing = 4.sp
    ),
    h4 = TextStyle(
        fontFamily = AndadaSC,
        fontWeight = FontWeight.Normal,
        fontSize = 30.sp
    ),
    h5 = TextStyle(
        fontFamily = AndadaSC,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp
    ),
    h6 = TextStyle(
        fontFamily = Andada,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = AndadaSC,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        letterSpacing = 0.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = Andada,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
    ),
    body1 = TextStyle(
        fontFamily = Andada,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        letterSpacing = 3.5.sp
    ),
    body2 = TextStyle(
        fontFamily = Andada,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),
    button = TextStyle(
        fontFamily = Andada,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
        letterSpacing = 6.5.sp
    ),
    caption = TextStyle(
        fontFamily = Andada,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp
    ),
    overline = TextStyle(
        fontFamily = Andada,
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp
    )
)
