package com.web0z.coffeetimenews.ui.view.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.web0z.coffeetimenews.ui.theme.*
import com.web0z.core.model.Article

@ExperimentalPagerApi
@Composable
fun NewsPager(
    items: List<Article>,
    modifier: Modifier = Modifier,
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
    Box(
        modifier = modifier
    ) {
        Card (
            shape = RoundedCornerShape(5.dp)
        ) {
            Image(
                painter = rememberCoilPainter(article.article_image),
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
