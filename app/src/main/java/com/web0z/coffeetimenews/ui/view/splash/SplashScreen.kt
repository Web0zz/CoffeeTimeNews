package com.web0z.coffeetimenews.ui.view.splash

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.web0z.coffeetimenews.R
import com.web0z.coffeetimenews.ui.theme.CoffeeTimeNewsTheme
import com.web0z.coffeetimenews.ui.theme.CoffeeTimeNewsTypography
import com.web0z.coffeetimenews.ui.util.AppNameText

@Composable
fun SplashScreen(
    navController: NavController
) {
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
            AppNameText(
                smalltextStyle = CoffeeTimeNewsTypography.h2,
                bigtextStyle = CoffeeTimeNewsTypography.h1,
                topPadding = 40f
            )
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DarkThemePreviewHome() {
    CoffeeTimeNewsTheme {
        SplashScreen(
            navController = NavController(LocalContext.current)
        )
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun LightThemePreviewHome() {
    CoffeeTimeNewsTheme {
        SplashScreen(
            navController = NavController(LocalContext.current)
        )
    }
}