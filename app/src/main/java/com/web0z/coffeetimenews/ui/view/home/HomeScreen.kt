package com.web0z.coffeetimenews.ui.view.home

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.web0z.coffeetimenews.R
import com.web0z.coffeetimenews.ui.theme.CoffeeTimeNewsTypography
import com.web0z.coffeetimenews.ui.util.AppNameText
import com.web0z.coffeetimenews.ui.view.Screen
import com.web0z.coffeetimenews.ui.viewmodel.HomeViewModel
import com.web0z.core.model.Article

@ExperimentalPagerApi
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel,
    toggleTheme: () -> Unit
) {
    Scaffold(
        // scaffoldState = scaffoldState,
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopBar(toggleTheme)
        },
        content = {
            BodyContent(
                navController,
                viewModel
            )
        },
        backgroundColor = MaterialTheme.colors.primary,
    )
}

@Composable
private fun TopBar(toggleTheme: () -> Unit) {
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
                toggleTheme()
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
private fun BodyContent(
    navController: NavController,
    viewModel: HomeViewModel
) {
    val onArticleClicked: (Article) -> Unit = {
        println("Article Clicked")
        navController.navigate(Screen.Detail.route(it.id))
    }

    Box(
        modifier = Modifier
            .padding(top = 25.dp)
            .fillMaxSize()
            .background(MaterialTheme.colors.primary),
        contentAlignment = Alignment.TopCenter,
    ) {
        NewsPager(
            modifier = Modifier
                .width(375.dp)
                .height(220.dp)
                .shadow(
                    elevation = 4.dp
                ),
            viewModel = viewModel,
            onItemSelect = {
                onArticleClicked(it)
            },
            navController = navController
        )
        NewsListBody(
            modifier = Modifier
                .padding(
                    top = 248.dp,
                ),
            viewModel = viewModel,
            onCategorySelected = {
                viewModel.onHomeCategorySelected(it)
            },
            navController = navController,
        )
    }
}