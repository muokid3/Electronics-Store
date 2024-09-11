package com.dm.berxley.electronicsstore.presentation.category

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dm.berxley.electronicsstore.domain.models.Category
import com.dm.berxley.electronicsstore.presentation.navgraph.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoriesScreen(navController: NavController) {

    val viewModel = hiltViewModel<CategoriesViewModel>()
    val categoriesState = viewModel.categoriesState.collectAsState().value

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Categories",
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = "Navigate Back"
                        )
                    }
                }
            )
        }
    ) {

        if (categoriesState.isLoadingCategories) {
            // TODO: show shimmer layout here

        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = it.calculateTopPadding(),
                        bottom = it.calculateBottomPadding() + 5.dp,
                        start = 12.dp,
                        end = 12.dp
                    ),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(categoriesState.categoriesList) { category ->
                    CategoryItem(category = category) {
                        //navigate to the category
                        navController.navigate(
                            Screen.CategoryDetailsScreen.route.replace(
                                "{catName}",
                                category.name
                            )
                        )
                    }
                }

            }

        }

    }

}


@Composable
fun CategoryItem(category: Category, onclick: () -> Unit) {


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .clickable { onclick() },
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 18.dp, end = 18.dp)
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = category.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                    contentDescription = "View"
                )
            }
        }

    }


}

@Preview(showBackground = true)
@Composable
fun Preview() {
    CategoriesScreen(rememberNavController())
}