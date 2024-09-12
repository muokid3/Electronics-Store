package com.dm.berxley.electronicsstore.presentation.account

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dm.berxley.electronicsstore.R

@Composable
fun AccountScreen() {

    Scaffold {
        Column(
            modifier = Modifier
                .padding(
                    top = it.calculateTopPadding(),
                    bottom = it.calculateBottomPadding(),
                    start = 12.dp,
                    end = 12.dp
                )
                .verticalScroll(rememberScrollState()),
        ) {

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 5.dp
                ),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp)
                            .clip(CircleShape),
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = "profile pic"
                    )

                    Column(
                        modifier = Modifier
                            .weight(2f)
                            .padding(start = 12.dp)
                            .fillMaxHeight(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "John Doe",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        Text(
                            text = "Premium Member",
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )

                    }

                }

            }

            Spacer(modifier = Modifier.height(24.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(top = 12.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 5.dp
                ),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Orders")
                }

            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(top = 12.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 5.dp
                ),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Returns and Refunds")
                }

            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(top = 12.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 5.dp
                ),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Account Information")
                }

            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(top = 12.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 5.dp
                ),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Security and Settings")
                }

            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(top = 12.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 5.dp
                ),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Help")
                }

            }


        }
    }
}

@Preview(showBackground = true)
@Composable
fun Previeew() {
    AccountScreen()
}