package com.dm.berxley.electronicsstore.presentation.home

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.outlined.CardGiftcard
import androidx.compose.material.icons.outlined.PeopleAlt
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dm.berxley.electronicsstore.R
import com.dm.berxley.electronicsstore.presentation.home.components.BannerItemComp
import com.dm.berxley.electronicsstore.presentation.home.components.MenuItemComp
import com.dm.berxley.electronicsstore.presentation.home.components.SaleItemComp
import com.dm.berxley.electronicsstore.presentation.onboarding.intro.components.OffersIndicator
import com.dm.berxley.electronicsstore.presentation.onboarding.intro.components.PageIndicator
import com.dm.berxley.electronicsstore.ui.theme.primaryContainerDark

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Home", fontWeight = FontWeight.Bold) })
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(
                    top = it.calculateTopPadding(),
                    bottom = it.calculateBottomPadding(),
                    start = 12.dp,
                    end = 12.dp
                )
        ) {

            //show scrollable banner items here
            BannerItemComp()


            //banner items indicators
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                OffersIndicator(pageSize = 4, selectedPage = 1)
            }

            val menuItems = listOf(
                MenuItem(Icons.AutoMirrored.Filled.List, "Categories"),
                MenuItem(Icons.Outlined.StarBorder, "Favorites"),
                MenuItem(Icons.Outlined.CardGiftcard, "Gifts"),
                MenuItem(Icons.Outlined.PeopleAlt, "Best Selling"),
            )

            //titles for categories
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                itemsIndexed(menuItems) { index, menuItem ->
                    MenuItemComp(menuItem = menuItem) {
                        when (index) {
                            0 -> {
                                //navController.navigate("")
                            }

                            1 -> {
                                //navController.navigate("")
                            }

                            2 -> {
                                //navController.navigate("")
                            }

                            3 -> {
                                //navController.navigate("")
                            }
                        }

                    }
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp), horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Sales", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }



            //lazyrow for sales items
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),

            ) {
                items(6){
                    SaleItemComp()
                }
            }

        }
    }

}


data class MenuItem(val imageVector: ImageVector, val title: String)

@Preview(showBackground = true)
@Composable
fun Preview() {
    HomeScreen(rememberNavController())
}