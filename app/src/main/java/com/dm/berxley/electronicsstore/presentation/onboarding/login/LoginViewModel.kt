package com.dm.berxley.electronicsstore.presentation.onboarding.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dm.berxley.electronicsstore.domain.repositories.AuthRepository
import com.dm.berxley.electronicsstore.domain.sharedprefs.LocalUserManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val localUserManager: LocalUserManager,
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _loginState = MutableStateFlow(LoginState())
    val loginState = _loginState.asStateFlow()

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _loginState.update {
                it.copy(isLoading = true)
            }

            //perform login via api
            authRepository.login(email = email, password = password).collectLatest { response ->

                if (response.isSuccessful) {
                    //http success. HTTP code is 200
                    if (response.body()?.success == true){
                        val user = response.body()?.user
                        val token = response.body()?.token

                        //TODO persist user and token locally

                        localUserManager.saveIsLoggedIn(true)
                        _loginState.update {
                            it.copy(isLoading = false, loginSuccessful = true)
                        }
                    }else{
                        //api returned error
                        val errorMessage = response.body()?.message ?: "Unknown API error"

                        _loginState.update {
                            it.copy(isLoading = false, loginSuccessful = false, loginFailed = true, errorMessage = errorMessage)
                        }
                    }

                } else {
                    //http failed. HTTP code not 200
                    val httpErrorCode = response.code()
                    val httpErrorMessage = response.message()
                    val errorMessage = "Error $httpErrorCode: $httpErrorMessage"


                    _loginState.update {
                        it.copy(isLoading = false, loginSuccessful = false, loginFailed = true, errorMessage = errorMessage)
                    }

                }
            }
        }
    }

    fun resetError() {
        _loginState.update {
            it.copy(isLoading = false, loginSuccessful = false, loginFailed = false, errorMessage = "")
        }
    }

}