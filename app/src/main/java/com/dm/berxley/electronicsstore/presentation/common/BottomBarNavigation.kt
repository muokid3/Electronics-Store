package com.dm.berxley.electronicsstore.presentation.common

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddShoppingCart
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PersonOutline
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.dm.berxley.electronicsstore.MainViewModel
import com.dm.berxley.electronicsstore.presentation.navgraph.Screen

@Composable
fun BottomBarNavigation(navController: NavController, mainViewModel: MainViewModel) {

    val context = LocalContext.current
    val navItems = listOf<BottomNavItem>(
        BottomNavItem(title = "Home", Icons.Outlined.Home, Icons.Filled.Home),
        BottomNavItem(title = "Search", Icons.Outlined.Search, Icons.Filled.Search),
        BottomNavItem(title = "Checkout", Icons.Outlined.ShoppingCart, Icons.Filled.ShoppingCart),
        BottomNavItem(title = "Account", Icons.Outlined.Person, Icons.Filled.Person)
    )

    NavigationBar(modifier = Modifier.fillMaxWidth()) {

        navItems.forEachIndexed { index, bottomNavItem ->
            NavigationBarItem(
                selected = mainViewModel.selectedBottomIndex == index,
                onClick = {
                    when (index) {
                        0 -> {
                            mainViewModel.setBottomIndex(0)
                            navController.navigate(Screen.HomeScreen.route)
                        }
                        1 -> {
                            mainViewModel.setBottomIndex(1)
                            navController.navigate(Screen.SearchScreen.route)
                        }
                        2 -> {
                            mainViewModel.setBottomIndex(2)
                            navController.navigate(Screen.CheckoutScreen.route)
                        }
                        3 -> {
                            mainViewModel.setBottomIndex(3)
                            navController.navigate(Screen.AccountScreen.route)
                        }
                    }
                },
                icon = {
                    Icon(
                        imageVector = if (mainViewModel.selectedBottomIndex == index) bottomNavItem.selectedIcon else bottomNavItem.unselectedIcon,
                        contentDescription = bottomNavItem.title
                    )
                },
                label = {
                    Text(text = bottomNavItem.title)
                })

        }
    }

}

data class BottomNavItem(
    val title: String,
    val unselectedIcon: ImageVector,
    val selectedIcon: ImageVector
)