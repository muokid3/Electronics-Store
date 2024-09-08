package com.dm.berxley.electronicsstore.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dm.berxley.electronicsstore.R

@Composable
fun SaleItemComp() {

    Card(
        modifier = Modifier
            .width(180.dp)
            .height(300.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {

        Box(
            modifier = Modifier
                .width(60.dp)
                .height(40.dp)
                .padding(8.dp)
                .background(MaterialTheme.colorScheme.inversePrimary),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "-50%", modifier = Modifier.padding(2.dp))
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.smartphone),
                contentDescription = null
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
                .weight(1f),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Smartphones", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        }

    }

}