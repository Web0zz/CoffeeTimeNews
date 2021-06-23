package com.web0z.coffeetimenews.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.web0z.coffeetimenews.R
import com.web0z.coffeetimenews.ui.theme.CoffeeTimeNewsTypography
import com.web0z.coffeetimenews.ui.util.AppNameText

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