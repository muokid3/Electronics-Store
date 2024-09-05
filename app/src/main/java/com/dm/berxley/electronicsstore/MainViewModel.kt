package com.dm.berxley.electronicsstore

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dm.berxley.electronicsstore.domain.sharedprefs.LocalUserManager
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

    var splashCondition by mutableStateOf(false)
        private set

    init {
        viewModelScope.launch {
            localUserManager.readWelcomeScreenDone().onEach { shouldStartFromHome ->
                if (shouldStartFromHome) {
                    //set navigator start screen of auth
                } else {
                    //set navoigator start screen of wellcome screens
                }
                delay(300)
                splashCondition = true
            }.collect()
        }

    }
}