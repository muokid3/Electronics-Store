package com.dm.berxley.electronicsstore.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.dm.berxley.electronicsstore.domain.models.MenuItem

@Composable
fun MenuItemComp(menuItem: MenuItem, onClick: () -> Unit) {
    Box(modifier = Modifier.clickable { onClick() }) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.secondaryContainer)

            ) {
                Icon(
                    tint = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier
                        .size(60.dp)
                        .padding(10.dp),
                    imageVector = menuItem.imageVector,
                    contentDescription = null
                )
            }
            Text(text = menuItem.title, color = MaterialTheme.colorScheme.onPrimaryContainer)
        }
    }
}