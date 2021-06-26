package com.web0z.coffeetimenews.ui.view.home

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.web0z.coffeetimenews.R
import com.web0z.coffeetimenews.ui.theme.CoffeeTimeNewsTheme
import com.web0z.coffeetimenews.ui.theme.CoffeeTimeNewsTypography
import com.web0z.coffeetimenews.ui.util.AppNameText
import com.web0z.coffeetimenews.ui.util.ArticleList2
import com.web0z.coffeetimenews.ui.util.CategoryList

@ExperimentalPagerApi
@Composable
fun HomeScreen(
    navController: NavController,
    // scaffoldState: ScaffoldState = rememberScaffoldState()
) {
    Scaffold(
        // scaffoldState = scaffoldState,
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopBar()
        },
        content = {
            BodyContent(navController)
        },
        backgroundColor = MaterialTheme.colors.primary,
    )
}

@Composable
private fun TopBar() {
    Box(
        Modifier
            .padding(
                start = 14.dp,
                top = 25.dp
            )
            .width(361.dp)
            .height(46.dp)
            .background(MaterialTheme.colors.primary)
    ) {
        Box {
            AppNameText(
                smalltextStyle = CoffeeTimeNewsTypography.h6,
                bigtextStyle = CoffeeTimeNewsTypography.h5,
                topPadding = 15.73f
            )
        }
        IconButton(
            onClick = {
                /* TODO create main util fail and make light/dark mode changer */
            },
            modifier = Modifier
                .align(Alignment.CenterEnd)
        ) {
            Icon(
                painter = painterResource(id = if (isSystemInDarkTheme()) R.drawable.ic_dark_icon else R.drawable.ic_light_icon),
                contentDescription = null
            )
        }
    }
}

@ExperimentalPagerApi
@Composable
private fun BodyContent(navController: NavController) {
    Box(
        modifier = Modifier
            .padding(top = 25.dp)
            .fillMaxSize()
            .background(MaterialTheme.colors.primary),
        contentAlignment = Alignment.TopCenter,
    ) {
        NewsPager(
            // TODO data list will taken from ViewModel later
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
            sectionList = CategoryList,
            navController = navController,
            selectedCategory = CategoryList.first(),
            onCategorySelected = {
                //TODO will set viewState
            }
        )
    }
}


@ExperimentalPagerApi
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DarkThemePreviewHome() {
    CoffeeTimeNewsTheme {
        HomeScreen(
            navController = NavController(LocalContext.current)
        )
    }
}

@ExperimentalPagerApi
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun LightThemePreviewHome() {
    CoffeeTimeNewsTheme {
        HomeScreen(
            navController = NavController(LocalContext.current)
        )
    }
}
