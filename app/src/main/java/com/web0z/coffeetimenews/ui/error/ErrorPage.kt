package com.web0z.coffeetimenews.ui.error

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import com.web0z.coffeetimenews.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.stringResource
import com.web0z.coffeetimenews.ui.theme.CoffeeTimeNewsTheme
import com.web0z.coffeetimenews.ui.theme.CoffeeTimeNewsTypography
import com.web0z.coffeetimenews.ui.theme.lightRed
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow

@Composable
fun ErrorPage(
    // TODO will come data class
    errorMessage: String
) {
    Scaffold() {
        Content(errorMessage)
    }
}

@Composable
private fun Content(errorMessage: String) {
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
                // TODO Error message from data class
                text = errorMessage,
                modifier = Modifier
                    .padding(top = 5.dp)
            )
            Button(
                onClick = { /*TODO*/ },
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


@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DarkThemePreviewHome() {
    CoffeeTimeNewsTheme {
        ErrorPage(
            errorMessage = "Something's missing"
        )
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun LightThemePreviewHome() {
    CoffeeTimeNewsTheme {
        ErrorPage(
            errorMessage = "Something's missing"
        )
    }
}