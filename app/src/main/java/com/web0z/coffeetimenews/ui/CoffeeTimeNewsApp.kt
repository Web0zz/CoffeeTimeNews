package com.web0z.coffeetimenews.ui

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.web0z.coffeetimenews.ui.splash.SplashScreen
import com.web0z.coffeetimenews.ui.theme.CoffeeTimeNewsTheme

@Composable
fun CoffeeTimeNewsApp(
    /*appContainer: AppContainer*/
) {
    CoffeeTimeNewsTheme {
        SplashScreen()
    }
}
