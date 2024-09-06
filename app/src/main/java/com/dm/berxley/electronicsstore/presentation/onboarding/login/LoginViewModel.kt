package com.dm.berxley.electronicsstore.presentation.onboarding.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dm.berxley.electronicsstore.domain.sharedprefs.LocalUserManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val localUserManager: LocalUserManager
) : ViewModel() {

    private val _loginState = MutableStateFlow(LoginState())
    val loginState = _loginState.asStateFlow()

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _loginState.update {
                it.copy(isLoading = true)
            }
            delay(3000)
            localUserManager.saveIsLoggedIn(true)
            _loginState.update {
                it.copy(isLoading = false, loginSuccessful = true)
            }
        }
    }

    fun resetError(){
        _loginState.update {
            it.copy(loginFailed = false, errorMessage = "")
        }
    }

}