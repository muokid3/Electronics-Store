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
import com.dm.berxley.electronicsstore.presentation.onboarding.intro.IntroScreen
import com.dm.berxley.electronicsstore.presentation.onboarding.login.LoginScreen
import com.dm.berxley.electronicsstore.presentation.onboarding.register.RegisterScreen

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
            composable(Screen.IntroScreen.route) { navBackStackEntry ->
                IntroScreen(navController)
            }

            composable(Screen.LoginScreen.route) { navBackStackEntry ->
                LoginScreen()
            }

            composable(Screen.RegisterScreen.route) { navBackStackEntry ->
                RegisterScreen()
            }

        }


        //core app
        navigation(
            startDestination = Screen.HomeScreen.route,
            route = Screen.CoreAppNavigator.route
        ) {
            composable(Screen.HomeScreen.route) { navBackStackEntry ->

            }

            composable(Screen.SearchScreen.route) { navBackStackEntry ->

            }

            composable(Screen.CheckoutScreen.route) { navBackStackEntry ->

            }

            composable(Screen.AccountScreen.route) { navBackStackEntry ->

            }

        }

    }
}