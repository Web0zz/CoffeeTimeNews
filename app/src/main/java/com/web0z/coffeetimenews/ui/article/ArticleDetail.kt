package com.web0z.coffeetimenews.ui.article

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.web0z.coffeetimenews.R
import com.web0z.coffeetimenews.ui.theme.CoffeeTimeNewsTheme
import com.web0z.coffeetimenews.ui.theme.CoffeeTimeNewsTypography
import com.web0z.coffeetimenews.ui.util.appNameText

@Composable
fun ArticleDetail(

) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopBar()
        },
        content = {

        },
        backgroundColor = MaterialTheme.colors.primary
    )
}

@Composable
fun TopBar() {
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
        Icon(
            painter = painterResource(id = R.drawable.ic_back_button),
            contentDescription = null,
            modifier = Modifier
                .clickable {  }
                .align(Alignment.CenterStart)
                .fillMaxHeight()
                .padding(start = 4.dp),
            tint = MaterialTheme.colors.onPrimary
        )
        Box(
            modifier = Modifier
                .align(Alignment.CenterEnd)
        ) {
            appNameText(
                smalltextStyle = CoffeeTimeNewsTypography.h6,
                bigtextStyle = CoffeeTimeNewsTypography.h5,
                topPadding = 15.73f,
            )
        }
    }
}

@Composable
fun ArticleContent() {

}

@ExperimentalPagerApi
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DarkThemePreviewHome() {
    CoffeeTimeNewsTheme {
        ArticleDetail()
    }
}

@ExperimentalPagerApi
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun LightThemePreviewHome() {
    CoffeeTimeNewsTheme {
        ArticleDetail()
    }
}