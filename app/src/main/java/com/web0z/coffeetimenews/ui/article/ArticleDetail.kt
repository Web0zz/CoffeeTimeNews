package com.web0z.coffeetimenews.ui.article

import android.content.res.Configuration
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.web0z.coffeetimenews.R
import com.web0z.coffeetimenews.ui.home.Article
import com.web0z.coffeetimenews.ui.theme.*
import com.web0z.coffeetimenews.ui.util.ArticleList
import com.web0z.coffeetimenews.ui.util.AppNameText

@ExperimentalFoundationApi
@Composable
fun ArticleDetail(
    article: Article
) {
    LazyColumn(
        modifier = Modifier
            .background(MaterialTheme.colors.primary)
    ) {
        stickyHeader {
            TopBar()
        }
        item {
            ArticleHead(article)
        }
        item {
            BodyText(article)
        }
    }
}

@Composable
private fun BodyText(article: Article) {
    Box(
        modifier = Modifier
            .background(
                MaterialTheme.colors.primary,
                RoundedCornerShape(
                    topStart = 22.dp,
                    topEnd = 22.dp
                )
            )
    ) {
        Text(
            text = article.articleDetail,
            style = CoffeeTimeNewsTypography.body1,
            color = MaterialTheme.colors.onPrimary,
            modifier = Modifier
                .padding(
                    top = 29.dp,
                    start = 12.dp,
                    end = 12.dp
                )
        )
    }
}

@Composable
private fun ArticleHead(article: Article) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primary)
    ) {
        Box(
            modifier = Modifier
                .width(411.dp)
                .height(400.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Image(
                painter = painterResource(id = R.drawable.elon2),
                contentDescription = null,
                modifier = Modifier
                    .width(411.dp)
                    .height(400.dp),
                contentScale = ContentScale.Crop,
            )
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .fillMaxWidth()
                    .height(150.dp)
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.Black),
                            startY = 0f,
                            endY = 400 * 1f
                        )
                    )
            ) {
                Text(
                    text = "${article.section} | ${article.date}",
                    style = CoffeeTimeNewsTypography.subtitle2,
                    color = darkTextColor.copy(alpha = 0.8f),
                    modifier = Modifier
                        .padding(
                            start = 25.dp,
                            top = 10.dp
                        )
                )
                Text(
                    text = article.title,
                    style = TextStyle(
                        fontFamily = Andada,
                        fontWeight = FontWeight.Normal,
                        fontSize = 22.sp,
                    ),
                    color = darkTextColor,
                    modifier = Modifier
                        .padding(start = 25.dp)
                )
                Row(
                    modifier = Modifier
                        .padding(
                            top = 33.dp,
                            bottom = 10.dp,
                            start = 25.dp
                        )
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.elon2),
                        contentDescription = null,
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(15.dp))
                            .width(42.dp)
                            .height(42.dp),
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = article.author,
                        style = CoffeeTimeNewsTypography.subtitle2,
                        color = darkTextColor,
                        modifier = Modifier
                            .padding(
                                top = 8.dp,
                                start = 15.dp
                            )
                    )
                }
            }
        }
    }
}

@Composable
fun TopBar() {
    Box(
        Modifier
            .fillMaxWidth()
            .height(71.dp)
            .background(MaterialTheme.colors.primary.copy(alpha = 0.95f))
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_back_button),
            contentDescription = null,
            modifier = Modifier
                .clickable { }
                .align(Alignment.CenterStart)
                .padding(start = 12.dp)
                .width(32.08.dp)
                .height(32.08.dp),
            tint = MaterialTheme.colors.onPrimary
        )
        Box(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 10.dp)
        ) {
            AppNameText(
                smalltextStyle = CoffeeTimeNewsTypography.h6,
                bigtextStyle = CoffeeTimeNewsTypography.h5,
                topPadding = 15.73f,
                color = MaterialTheme.colors.onPrimary
            )
        }
    }
}

@ExperimentalFoundationApi
@ExperimentalPagerApi
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DarkThemePreviewHome() {
    CoffeeTimeNewsTheme {
        ArticleDetail(
            ArticleList.first()
        )
    }
}

@ExperimentalFoundationApi
@ExperimentalPagerApi
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun LightThemePreviewHome() {
    CoffeeTimeNewsTheme {
        ArticleDetail(
            ArticleList.first()
        )
    }
}