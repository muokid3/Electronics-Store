package com.dm.berxley.electronicsstore.presentation.onboarding.login

data class LoginState(
    var isLoading: Boolean = false,
    var loginSuccessful: Boolean = false,
    var loginFailed: Boolean = false,
    var errorMessage: String = "",
)
