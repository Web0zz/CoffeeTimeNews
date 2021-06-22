package com.web0z.coffeetimenews.ui.home

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import com.web0z.coffeetimenews.ui.theme.CoffeeTimeNewsTheme
import com.web0z.coffeetimenews.ui.theme.CoffeeTimeNewsTypography
import com.web0z.coffeetimenews.ui.theme.lightBrown2
import com.web0z.coffeetimenews.ui.theme.lightDark
import com.web0z.coffeetimenews.ui.util.ArticleList

@ExperimentalPagerApi
@Composable
fun NewsListBody(
    modifier: Modifier,
    sectionList: List<String>
) {
    val pagerState = rememberPagerState(pageCount = 1)

    ScrollableTabRow(
        selectedTabIndex = pagerState.currentPage,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
            )
        },
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.primary,
        edgePadding = 15.dp
    ) {
        // TODO function will taken from viewmodel later
        sectionList.forEachIndexed { index, title ->
            Tab(
                text = {
                    Text(
                        text = title,
                        style = CoffeeTimeNewsTypography.subtitle1,
                        color = MaterialTheme.colors.onPrimary
                    )
                },
                selected = pagerState.currentPage == index,
                onClick = { /*TODO*/ },
                selectedContentColor = lightDark.copy(alpha = 0.95f),
                unselectedContentColor = lightDark.copy(alpha = 0.6f)
            )
        }
    }

    // TODO will change with lazyColumn
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding( top = 428.dp )
    ) {
        ArticleList.forEach{ article ->
            ArticleListContent(
                modifier = Modifier
                    .padding(top = 17.dp)
                    .width(375.dp)
                    .height(97.dp)
                    .shadow(4.dp)
                    .align(Alignment.CenterHorizontally),
                article = article)
        }
    }
}

@Composable
fun ArticleListContent(
    modifier: Modifier,
    article: Article
) {
    Box(
        modifier = modifier
    ) {
        Card(
            shape = RoundedCornerShape(4.dp),
            backgroundColor = MaterialTheme.colors.primaryVariant,
            border = BorderStroke(0.5.dp, lightBrown2),
            modifier = Modifier
                .fillMaxSize()
        ) {
            Row {
                Image(
                    painter = painterResource(id = article.poster),
                    contentDescription = null,
                    modifier = Modifier
                        .width(140.dp)
                        .height(97.dp),
                    contentScale = ContentScale.FillHeight
                )
                Column(
                    modifier = Modifier
                        .padding(start = 12.dp)
                ) {
                    Text(
                        text = article.section,
                        style = CoffeeTimeNewsTypography.caption,
                        color = MaterialTheme.colors.onPrimary.copy(alpha = 0.6f),
                        modifier = Modifier.padding(top = 12.dp)
                    )
                    Text(
                        text = article.title,
                        style = CoffeeTimeNewsTypography.body2,
                        color = MaterialTheme.colors.onPrimary,
                        modifier = Modifier.height(42.dp)
                    )
                    Text(
                        text = "${article.author}  |  ${article.date}",
                        style = CoffeeTimeNewsTypography.overline,
                        color = MaterialTheme.colors.onPrimary.copy(alpha = 0.75f),
                        modifier = Modifier.padding(top = 3.dp)
                    )
                }
            }
        }
    }
}

@ExperimentalPagerApi
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DarkThemePreview() {
    CoffeeTimeNewsTheme {
        ArticleListContent(
            modifier = Modifier
                .width(375.dp)
                .height(97.dp),
            article = ArticleList[0]
        )
    }
}

@ExperimentalPagerApi
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun LightThemePreview() {
    CoffeeTimeNewsTheme {
        ArticleListContent(
            modifier = Modifier
                .width(375.dp)
                .height(97.dp),
            article = ArticleList[0]
        )
    }
}