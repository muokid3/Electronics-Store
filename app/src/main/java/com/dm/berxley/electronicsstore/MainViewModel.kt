package com.dm.berxley.electronicsstore

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dm.berxley.electronicsstore.domain.sharedprefs.LocalUserManager
import com.dm.berxley.electronicsstore.presentation.navgraph.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    localUserManager: LocalUserManager
) : ViewModel() {

    var splashCondition by mutableStateOf(true)
        private set
    var startDestination by mutableStateOf(Screen.AppIntroNavigator.route)
        private set

    var selectedBottomIndex by mutableStateOf(0)
        private set

    init {
        viewModelScope.launch {
            localUserManager.readIsLoggedIn().onEach { isLoggedIn ->
                if (isLoggedIn) {
                    //set navigator start screen of home
                    startDestination = Screen.CoreAppNavigator.route
                } else {
                    //set navigator start screen of auth and welcome screens
                    startDestination = Screen.AppIntroNavigator.route
                }
                delay(300)
                splashCondition = false
            }.collect()
        }
    }

    fun setBottomIndex(index: Int){
        selectedBottomIndex = index
    }
}