package com.example.jetpack_compose_weather_ui.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpack_compose_weather_ui.R
import com.example.jetpack_compose_weather_ui.screen.customShadow
import com.example.jetpack_compose_weather_ui.ui.theme.ColorGradient1
import com.example.jetpack_compose_weather_ui.ui.theme.ColorGradient2
import com.example.jetpack_compose_weather_ui.ui.theme.ColorGradient3
import com.example.jetpack_compose_weather_ui.ui.theme.ColorImageShadow
import com.example.jetpack_compose_weather_ui.ui.theme.ColorSurface
import com.example.jetpack_compose_weather_ui.ui.theme.ColorTextPrimary

@Preview(showBackground = true)
@Composable
fun ActionBar(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ControlButton()
        LocationInfo(modifier = Modifier.padding(top = 20.dp), location = "Rome")
        ProfileButton()
    }
}


@Composable
fun ControlButton(modifier: Modifier = Modifier) {
    Surface(
        color = ColorSurface,
        shape = CircleShape,
        modifier = modifier
            .size(48.dp)
            .customShadow(
                color = Color.Black,
                alpha = 0.5f,
                shadowRadius = 16.dp,
                borderRadius = 48.dp,
                offsetY = 4.dp
            )
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.ic_control),
                modifier = Modifier.size(20.dp),
                contentDescription = null
            )
        }
    }
}

@Composable
fun LocationInfo(
    modifier: Modifier = Modifier,
    location: String
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.ic_location_pin),
                contentDescription = "Location",
                modifier = Modifier.height(18.dp),
                contentScale = ContentScale.FillHeight
            )
            Text(
                text = location,
                style = MaterialTheme.typography.titleLarge,
                color = ColorTextPrimary,
                fontWeight = FontWeight.Bold
            )
        }
        Box(
            modifier = Modifier
                .background(
                    brush = Brush.linearGradient(
                        0f to ColorGradient1,
                        0.25f to ColorGradient2,
                        1f to ColorGradient3
                    ),
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(vertical = 2.dp, horizontal = 10.dp)
        ) {
            Text(text = "Updating")
        }
    }
}

@Preview
@Composable
fun ProfileButton(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(48.dp)
            .border(
                width = 1.5.dp,
                color = ColorSurface,
                shape = CircleShape
            ).customShadow(
                color = ColorImageShadow,
                alpha = 0.7f,
                shadowRadius = 12.dp,
                borderRadius = 48.dp,
                offsetY = 6.dp
            )
    ) {
        Image(
            painter = painterResource(R.drawable.img_profile),
            modifier = Modifier
                .fillMaxSize()
                .clip(
                    CircleShape
                ),
            contentDescription = null
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun locationInfoPreview() {
    LocationInfo(location = "Roma")

}