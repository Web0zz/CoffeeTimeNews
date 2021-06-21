package com.web0z.coffeetimenews.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.web0z.coffeetimenews.ui.theme.*
import com.web0z.coffeetimenews.ui.util.ArticleList

// TODO Data class will replace with real data model after
data class Article(
    val poster: Int,
    val title: String,
    val author: String
)

@ExperimentalPagerApi
@Composable
fun NewsPager(
    items: List<Article>,
    modifier: Modifier = Modifier,
    // TODO State remember will be added here,,,
    onItemSelect: (Article) -> Unit = {},
) {
    Box(
        modifier = modifier
    ) {
        val pagerState = rememberPagerState(
            pageCount = items.size
        )

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
        ) { page ->
            ArticleContent(
                article = items[page],
                modifier = Modifier
                    .clickable { onItemSelect(items[page]) }
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

@Composable
private fun ArticleContent(
    article: Article,
    modifier: Modifier
) {
    // TODO Hardcoded values will change later on
    Box(
        modifier = modifier
    ) {
        Card (
            shape = RoundedCornerShape(5.dp)
        ) {
            Image(
                painter = painterResource(id = article.poster),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color(0x45000000),
                                Color(0x00000000)
                            ),
                            0f,
                            500f
                        )
                    )
                    .alpha(0.8f)

            ) {}
            Column(
                modifier = Modifier
                    .padding(
                        start = 14.dp,
                        top = 157.dp
                    )
            ) {
                Text(
                    text = article.title,
                    style = CoffeeTimeNewsTypography.h6,
                    color = darkTextColor
                )
                Text(
                    text = article.author,
                    style = CoffeeTimeNewsTypography.caption,
                    color = darkTextColor
                )
            }
        }
    }
}

@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
private fun DarkThemePreview() {
    CoffeeTimeNewsTheme {
        NewsPager(
            items = ArticleList,
            modifier = Modifier
                .width(375.dp)
                .height(220.dp),
            onItemSelect = {}
        )
    }
}