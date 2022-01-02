package com.web0z.coffeetimenews.ui.view.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.LocalImageLoader
import coil.compose.rememberImagePainter
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.web0z.coffeetimenews.ui.theme.CoffeeTimeNewsTypography
import com.web0z.coffeetimenews.ui.theme.darkTextColor
import com.web0z.coffeetimenews.ui.theme.lightBrown2
import com.web0z.coffeetimenews.ui.theme.lightDark
import com.web0z.coffeetimenews.ui.view.Screen
import com.web0z.core.model.Article

@ExperimentalPagerApi
@ExperimentalCoilApi
@Composable
fun NewsPager(
    viewModel: HomeViewModel,
    modifier: Modifier = Modifier,
    onItemSelect: (Article) -> Unit = {},
    navController: NavController
) {
    val pagerNews by viewModel.pagerNews.collectAsState()

    var isGetError by rememberSaveable(key = "getErrorAlready") { mutableStateOf(false) }

    when {
        pagerNews.initialLoad || pagerNews.loading -> {
            // TODO loading state will come
        }
        !isGetError && pagerNews.hasError -> {
            isGetError = true
            navigateToError(navController, pagerNews.error)
        }
        pagerNews.data != null -> {
            Box(
                modifier = modifier
            ) {
                val pagerState = rememberPagerState(
                    pageCount = pagerNews.data!!.size
                )

                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier
                        .fillMaxSize()
                ) { page ->
                    ArticleContent(
                        article = pagerNews.data!![page],
                        modifier = Modifier
                            .clickable { onItemSelect(pagerNews.data!![page]) }
                    )
                }
                HorizontalPagerIndicator(
                    pagerState = pagerState,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 13.dp),
                    activeColor = lightBrown2.copy(alpha = 0.85f),
                    inactiveColor = lightDark.copy(alpha = 0.5f),
                )
            }
        }
    }
}

@ExperimentalCoilApi
@Composable
private fun ArticleContent(
    article: Article,
    modifier: Modifier
) {
    Box(
        modifier = modifier
    ) {
        Card(
            shape = RoundedCornerShape(5.dp)
        ) {
            Image(
                painter = rememberImagePainter(
                    data = article.article_image,
                    imageLoader = LocalImageLoader.current,
                    builder = {
                        crossfade(true)
                        placeholder(0)
                    }
                ),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .padding(
                        start = 14.dp,
                        top = 152.dp
                    )
            ) {
                Text(
                    text = article.title,
                    style = CoffeeTimeNewsTypography.h6,
                    color = darkTextColor
                )
                Text(
                    text = article.writer,
                    style = CoffeeTimeNewsTypography.caption,
                    color = darkTextColor
                )
            }
        }
    }
}

private fun navigateToError(navController: NavController, errorMessage: String?) {
    navController.navigate(Screen.Error.route(errorMessage ?: "Something weird happened!")) {
        popUpTo(Screen.Home.route) {
            inclusive = true
        }
    }
}