package com.dm.berxley.electronicsstore.presentation.categoryItems

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.dm.berxley.electronicsstore.R
import com.dm.berxley.electronicsstore.domain.models.Product

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryItemsScreen(
    navController: NavController,
) {

    val viewModel = hiltViewModel<CategoryItemsViewModel>()
    val categoryState = viewModel.categoryItemsState.collectAsState().value

    LaunchedEffect(key1 = Unit){
        viewModel.getCategory()
        viewModel.getProducts()
    }



    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    categoryState.selectedCategory?.name?.let {
                        Text(
                            text = it,
                            fontWeight = FontWeight.Bold
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = "Navigate Back"
                        )
                    }
                })
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = it.calculateTopPadding() + 5.dp,
                    bottom = it.calculateBottomPadding() + 5.dp,
                    start = 12.dp,
                    end = 12.dp
                )
        ) {

            //filter here

            if (categoryState.isLoadingProducts) {
                //show is loading (shimmer layout) here or show data from Room
//                CircularProgressIndicator()
            } else {
                //gridlayout or two items with products here
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(150.dp),
                    verticalArrangement = Arrangement.spacedBy(14.dp),
                    horizontalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    items(categoryState.selectedCategoryProducts) { product ->
                        ProductComp(product) {
                            //navigate tp product details page
                        }
                    }
                }
            }

        }

    }

}


@Composable
fun ProductComp(product: Product, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .clickable { onClick() }
            .size(300.dp),
        shape = RoundedCornerShape(
            topStart = 0.dp,
            topEnd = 0.dp,
            bottomStart = 16.dp,
            bottomEnd = 16.dp
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),

        ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                modifier = Modifier
                    .fillMaxWidth(),
                painter = rememberAsyncImagePainter(
                    model = product.imageUrl,
                    placeholder = painterResource(id = R.drawable.placeholder)
                ),
                contentDescription = product.name
            )

            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(12.dp)
            ) {
                Text(text = product.name, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text(text = "${product.currency} ${product.price}")
            }


        }
    }

}