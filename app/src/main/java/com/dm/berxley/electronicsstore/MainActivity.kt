package com.dm.berxley.electronicsstore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.dm.berxley.electronicsstore.presentation.common.BottomBarNavigation
import com.dm.berxley.electronicsstore.presentation.navgraph.NavGraph
import com.dm.berxley.electronicsstore.presentation.navgraph.Screen
import com.dm.berxley.electronicsstore.ui.theme.ElectronicsStoreTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        installSplashScreen().apply {
            setKeepOnScreenCondition {
                mainViewModel.splashCondition
            }
        }
        setContent {
            val navController = rememberNavController()

            ElectronicsStoreTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        bottomBar = {
                            if (mainViewModel.startDestination == Screen.CoreAppNavigator.route) {
                                BottomBarNavigation(navController, mainViewModel)
                            }
                        }
                    ) { paddingValues ->
                        NavGraph(
                            navController = navController,
                            startDestination = mainViewModel.startDestination,
                            paddingValues = paddingValues
                        )
                    }
                }
            }
        }
    }
}