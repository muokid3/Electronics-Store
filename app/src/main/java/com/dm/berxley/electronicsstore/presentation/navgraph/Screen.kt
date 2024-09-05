package com.dm.berxley.electronicsstore.presentation.navgraph

sealed class Screen(val route: String) {
    object AppIntroNavigator: Screen(route = "appIntro")
    object CoreAppNavigator: Screen(route = "coreAppNavigator")

    object IntroScreen: Screen(route = "introScreen")
    object LoginScreen: Screen(route = "loginScreen")
    object RegisterScreen: Screen(route = "registerScreen")



    object HomeScreen: Screen(route = "homeScreen")
    object SearchScreen: Screen(route = "searchScreen")
    object CheckoutScreen: Screen(route = "checkoutScreen")
    object AccountScreen: Screen(route = "accountScreen")


}