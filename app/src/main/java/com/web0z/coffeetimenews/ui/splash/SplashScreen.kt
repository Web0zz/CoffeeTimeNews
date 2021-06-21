package com.web0z.coffeetimenews.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.web0z.coffeetimenews.R
import com.web0z.coffeetimenews.ui.theme.CoffeeTimeNewsTypography
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.primary)
    ) {
        Image(
            painterResource(id = R.drawable.applogo),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 245.dp)
                .width(250.dp)
                .height(250.dp)
                .align(Alignment.TopCenter)
        )
        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 550.dp)
        ) {
            Text(
                text = "Coffee",
                style = CoffeeTimeNewsTypography.h2.merge(
                    TextStyle(
                        shadow = Shadow(color = MaterialTheme.colors.onPrimary, Offset(0f, 4f), 8f)
                    )
                ),
                color = MaterialTheme.colors.onPrimary,
                modifier = Modifier
                    .align(Alignment.TopCenter)
            )
            Text(
                text = "TimeNews",
                textAlign = TextAlign.Center,
                style = CoffeeTimeNewsTypography.h1.merge(
                    TextStyle(
                        shadow = Shadow(color = MaterialTheme.colors.onPrimary, Offset(0f, 4f), 8f)
                    )
                ),
                color = MaterialTheme.colors.onPrimary,
                modifier = Modifier
                    .padding(top = 40.dp)
            )
        }
    }
}