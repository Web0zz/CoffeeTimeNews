package com.web0z.coffeetimenews.ui.home

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.web0z.coffeetimenews.ui.theme.CoffeeTimeNewsTheme
import com.web0z.coffeetimenews.ui.util.ArticleList2
import com.web0z.coffeetimenews.ui.util.SectionList

@ExperimentalPagerApi
@Composable
fun HomeScreen(
    // repository,
    // navigateToArticle: (String) -> Unit,
    // drawer,
    // scaffoldState: ScaffoldState = rememberScaffoldState()
) {
    HomeScreenContent(
        // scaffoldState = scaffoldState
    )
}

@ExperimentalPagerApi
@Composable
private fun HomeScreenContent(
    // Article lists
    // Top news for pager
    // onRefreshPosts: () -> Unit,
    // onErrorDismiss: () -> Unit,
    // navigateToArticle: (String) -> Unit,
    // drawer,
    // scaffoldState: ScaffoldState
) {

    // Error handler will setup

    Scaffold(
        // scaffoldState = scaffoldState,
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopBar()
        },
        content = {
            BodyContent()
        },
        backgroundColor = MaterialTheme.colors.primary,
    )
}

@ExperimentalPagerApi
@Composable
private fun BodyContent() {
    Box(
        modifier = Modifier
            .padding(top = 25.dp)
            .fillMaxSize()
            .background(MaterialTheme.colors.primary),
        contentAlignment = Alignment.TopCenter,
    ) {
        NewsPager(
            // TODO data list will taken from viewmodel later
            items = ArticleList2,
            modifier = Modifier
                .width(375.dp)
                .height(220.dp)
                .shadow(
                    elevation = 4.dp
                ),
            onItemSelect = { }
        )
        NewsListBody(
            modifier = Modifier
                .padding(
                    top = 248.dp,
                ),
            sectionList = SectionList,
            navigateToArticle = { },
        )
    }
}


@ExperimentalPagerApi
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DarkThemePreviewHome() {
    CoffeeTimeNewsTheme {
        HomeScreen()
    }
}

@ExperimentalPagerApi
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun LightThemePreviewHome() {
    CoffeeTimeNewsTheme {
        HomeScreen()
    }
}