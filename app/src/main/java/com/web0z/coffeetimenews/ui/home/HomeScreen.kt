package com.web0z.coffeetimenews.ui.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.web0z.coffeetimenews.ui.theme.CoffeeTimeNewsTheme
import com.web0z.coffeetimenews.ui.util.ArticleList

@ExperimentalPagerApi
@Composable
fun HomeScreen() {
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .padding(top = 25.dp),
        ) {
            TopBar()
            NewsPager(
                // TODO data list will taken from viewmodel later
                items = ArticleList,
                modifier = Modifier
                    .padding(
                        top = 106.dp
                    )
                    .width(375.dp)
                    .height(220.dp)
                    .align(Alignment.TopCenter)
                    .shadow(
                        elevation = 4.dp
                    ),
                onItemSelect = {  /* TODO function will taken from viewmodel later */ }
            )
        }
    }
}

@ExperimentalPagerApi
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DarkThemePreview() {
    CoffeeTimeNewsTheme {
        HomeScreen()
    }
}

@ExperimentalPagerApi
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun LightThemePreview() {
    CoffeeTimeNewsTheme {
        HomeScreen()
    }
}