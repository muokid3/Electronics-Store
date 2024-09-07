package com.dm.berxley.electronicsstore.presentation.navgraph

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.dm.berxley.electronicsstore.presentation.account.AccountScreen
import com.dm.berxley.electronicsstore.presentation.checkout.CheckoutScreen
import com.dm.berxley.electronicsstore.presentation.home.HomeScreen
import com.dm.berxley.electronicsstore.presentation.onboarding.intro.IntroScreen
import com.dm.berxley.electronicsstore.presentation.onboarding.login.LoginScreen
import com.dm.berxley.electronicsstore.presentation.onboarding.register.RegisterScreen
import com.dm.berxley.electronicsstore.presentation.search.SearchScreen

@Composable
fun NavGraph(
    navController: NavController,
    startDestination: String,
    paddingValues: PaddingValues
) {
    NavHost(
        navController = navController as NavHostController,
        startDestination = startDestination,
        modifier = Modifier.padding(paddingValues)
    ) {

        //app intro
        navigation(
            startDestination = Screen.IntroScreen.route,
            route = Screen.AppIntroNavigator.route
        ) {
            composable(route = Screen.IntroScreen.route) { navBackStackEntry ->
                IntroScreen(navController)
            }

            composable(route = Screen.LoginScreen.route) { navBackStackEntry ->
                LoginScreen(navController)
            }

            composable(route = Screen.RegisterScreen.route) { navBackStackEntry ->
                RegisterScreen(navController)
            }

        }


        //core app
        navigation(
            startDestination = Screen.HomeScreen.route,
            route = Screen.CoreAppNavigator.route
        ) {
            composable(route = Screen.HomeScreen.route) { navBackStackEntry ->
                HomeScreen(navController)
            }

            composable(route = Screen.SearchScreen.route) { navBackStackEntry ->
                SearchScreen()
            }

            composable(route = Screen.CheckoutScreen.route) { navBackStackEntry ->
                CheckoutScreen()
            }

            composable(route = Screen.AccountScreen.route) { navBackStackEntry ->
                AccountScreen()
            }

        }

    }
}