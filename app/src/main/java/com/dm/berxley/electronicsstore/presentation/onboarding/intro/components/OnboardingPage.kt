package com.dm.berxley.electronicsstore.presentation.onboarding.intro.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dm.berxley.electronicsstore.R

@Composable
fun OnboardingPage(page: Page) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.6f),
            painter = painterResource(id = page.image),
            contentDescription = null,
            contentScale = ContentScale.FillHeight
        )
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = page.description,
            color = Color.White,
            modifier = Modifier.padding(30.dp),
            style = MaterialTheme.typography.headlineMedium
        )


    }

}

@Preview(showBackground = true)
@Composable
fun Preview() {
    OnboardingPage(page = Page(R.drawable.world_illustration, "The best tech market"))
}