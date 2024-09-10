package com.dm.berxley.electronicsstore.presentation.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.dm.berxley.electronicsstore.R
import com.dm.berxley.electronicsstore.domain.models.Product

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navController: NavController) {

    val searchViewModel: SearchViewModel = hiltViewModel()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Search", fontWeight = FontWeight.Bold) })
        }
    ) {

        var searchText by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = it.calculateTopPadding(),
                    bottom = it.calculateBottomPadding(),
                    start = 12.dp,
                    end = 12.dp
                )
        ) {

            Row(modifier = Modifier.fillMaxWidth()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .clip(RoundedCornerShape(200.dp))
                        .background(MaterialTheme.colorScheme.secondaryContainer)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 18.dp, end = 18.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
                        Spacer(modifier = Modifier.width(12.dp))
                        Divider(
                            modifier = Modifier
                                .fillMaxHeight()
                                .padding(top = 8.dp, bottom = 8.dp)
                                .width(2.dp)
                        )

                        TextField(
                            modifier = Modifier.fillMaxSize(),
                            value = searchText,
                            singleLine = true,
                            onValueChange = {
                                searchText = it
                            },
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color.Transparent,
                                unfocusedContainerColor = Color.Transparent,
                                disabledContainerColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                            ),
                            placeholder = {
                                Text(text = "What are you looking for?")
                            }
                        )
                    }
                }
            }

            //show search results here
            LazyColumn(
                modifier = Modifier.padding(top = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(searchViewModel.searchState.searchResults) { product ->
                    SearchResultItem(product = product)
                }

            }

        }
    }
}


@Composable
fun SearchResultItem(product: Product) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.onPrimary).height(80.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()){
            Image(
                modifier = Modifier.align(Alignment.CenterStart),
                painter = rememberAsyncImagePainter(
                    model = product.imageUrl,
                    placeholder = painterResource(id = R.drawable.placeholder)
                ),
                contentDescription = product.name
            )
            Column(modifier = Modifier.align(Alignment.CenterStart).padding(start = 110.dp), verticalArrangement = Arrangement.Center) {
                Text(text = product.name, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text(
                    text = "${product.currency} ${product.price}",
                    color = MaterialTheme.colorScheme.primary
                )

            }
        }



    }

}

@Preview
@Composable
fun Preview() {
    SearchScreen(rememberNavController())
}

