package com.web0z.coffeetimenews.ui.view.error

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import com.web0z.coffeetimenews.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.stringResource
import com.web0z.coffeetimenews.ui.theme.CoffeeTimeNewsTypography
import com.web0z.coffeetimenews.ui.theme.lightRed
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.navigation.NavController

@Composable
fun ErrorPage(
    errorMessage: String,
    navController: NavController
) {
    Scaffold {
        Content(errorMessage, navController)
    }
}

@Composable
private fun Content(
    errorMessage: String,
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.primary)
    ) {
        Image(
            painter = painterResource(
                id = if (isSystemInDarkTheme()) R.drawable.error_coffee_dark_img else R.drawable.error_coffee_light_img
            ),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 267.dp)
                .width(168.dp)
                .height(179.dp)
        )
        Column(
            modifier = Modifier
                .padding(top = 499.dp)
                .align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.oops),
                style = CoffeeTimeNewsTypography.h2,
                color = lightRed
            )
            Text(
                text = errorMessage,
                modifier = Modifier
                    .padding(top = 5.dp)
            )
            Button(
                onClick = {
                    navController.navigateUp()
                },
                colors = ButtonDefaults.textButtonColors(
                    backgroundColor = MaterialTheme.colors.onPrimary
                ),
                modifier = Modifier
                    .padding(top = 100.dp)
                    .shadow(elevation = 4.dp),
            ) {
                Text(
                    text = stringResource(id = R.string.try_again),
                    style = CoffeeTimeNewsTypography.button,
                    color = MaterialTheme.colors.primaryVariant
                )
            }
        }
    }
}
