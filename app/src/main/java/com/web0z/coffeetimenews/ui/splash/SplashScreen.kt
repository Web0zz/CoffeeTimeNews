package com.web0z.coffeetimenews.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.web0z.coffeetimenews.R
import com.web0z.coffeetimenews.ui.theme.CoffeeTimeNewsTypography
import com.web0z.coffeetimenews.ui.util.appNameText

@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.primary)
    ) {
        Image(
            painterResource(id = R.drawable.applogo),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 245.dp)
                .width(250.dp)
                .height(250.dp)
                .align(Alignment.TopCenter)
        )
        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 550.dp)
        ) {
            appNameText(
                smalltextStyle = CoffeeTimeNewsTypography.h2,
                bigtextStyle = CoffeeTimeNewsTypography.h1,
                topPadding = 40f
            )
        }
    }
}