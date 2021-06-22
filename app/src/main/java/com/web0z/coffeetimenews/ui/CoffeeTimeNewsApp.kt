package com.web0z.coffeetimenews.ui

import androidx.compose.runtime.Composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.web0z.coffeetimenews.ui.splash.SplashScreen
import com.web0z.coffeetimenews.ui.theme.CoffeeTimeNewsTheme

@ExperimentalPagerApi
@Composable
fun CoffeeTimeNewsApp(
    /*appContainer: AppContainer*/
) {
    CoffeeTimeNewsTheme {
        SplashScreen()
    }
}
