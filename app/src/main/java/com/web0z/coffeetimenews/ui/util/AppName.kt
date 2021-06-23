package com.web0z.coffeetimenews.ui.util

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun BoxScope.AppNameText(
    smalltextStyle: TextStyle,
    bigtextStyle: TextStyle,
    topPadding: Float,
    color: Color = MaterialTheme.colors.onPrimary
) {
    Text(
        text = "Coffee",
        style = smalltextStyle.merge(
            TextStyle(
                shadow = Shadow(color = MaterialTheme.colors.onPrimary.copy(alpha = 0.25f), Offset(0f, 4f), 15f)
            )
        ),
        color = color,
        modifier = Modifier
            .align(Alignment.TopCenter)
    )
    Text(
        text = "TimeNews",
        textAlign = TextAlign.Center,
        style = bigtextStyle.merge(
            TextStyle(
                shadow = Shadow(color = MaterialTheme.colors.onPrimary.copy(alpha = 0.25f), Offset(0f, 4f), 15f)
            )
        ),
        color = color,
        modifier = Modifier
            .padding(top = topPadding.dp)
    )
}