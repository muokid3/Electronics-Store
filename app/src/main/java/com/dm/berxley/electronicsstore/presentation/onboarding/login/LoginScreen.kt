package com.dm.berxley.electronicsstore.presentation.onboarding.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dm.berxley.electronicsstore.R
import com.dm.berxley.electronicsstore.presentation.navgraph.Screen
import com.dm.berxley.electronicsstore.ui.theme.primaryContainerDark
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(navController: NavController) {
    val viewModel = hiltViewModel<LoginViewModel>()
    val loginState = viewModel.loginState.collectAsState().value

//    val snackbarHostState = remember {
//        SnackbarHostState()
//    }
//    SnackbarHost(hostState = snackbarHostState)

//    if (loginState.loginFailed) {
//        LaunchedEffect(key1 = loginState.errorMessage) {
//            snackbarHostState.showSnackbar(message = loginState.errorMessage, duration = SnackbarDuration.Long)
//            viewModel.resetError()
//        }
//    }

    if (loginState.loginSuccessful){
        navController.navigate(Screen.CoreAppNavigator.route)
    }

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }
    var showPassword by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(primaryContainerDark)
            .padding(12.dp)
            .imePadding()
            .verticalScroll(rememberScrollState())
    ) {


        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp),
            text = "Login",
            color = Color.White,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineLarge
        )

        Image(
            modifier = Modifier
                .size(250.dp)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo"
        )

        OutlinedTextField(modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
            value = email,
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.White,
                focusedContainerColor = primaryContainerDark,
                focusedLabelColor = Color.White,
                focusedIndicatorColor = Color.White,
                unfocusedTextColor = Color.White,
                unfocusedContainerColor = primaryContainerDark,
                unfocusedLabelColor = Color.White,
                unfocusedIndicatorColor = Color.White,
                cursorColor = Color.White
            ),
            onValueChange = {
                email = it
            },
            label = {
                Text(color = Color.White, text = "E-Mail")
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next, keyboardType = KeyboardType.Email
            )
        )

        OutlinedTextField(modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
            value = password,
            onValueChange = {
                password = it
            },
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.White,
                focusedContainerColor = primaryContainerDark,
                focusedLabelColor = Color.White,
                focusedIndicatorColor = Color.White,
                unfocusedTextColor = Color.White,
                unfocusedContainerColor = primaryContainerDark,
                unfocusedLabelColor = Color.White,
                unfocusedIndicatorColor = Color.White,
                cursorColor = Color.White
            ),
            label = {
                Text(text = "Password")
            },
            singleLine = true,
            visualTransformation = if (showPassword) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password, imeAction = ImeAction.Done
            ),
            trailingIcon = {
                if (showPassword) {
                    IconButton(onClick = { showPassword = false }) {
                        Icon(
                            imageVector = Icons.Default.Visibility,
                            contentDescription = "Hide Password",
                            tint = Color.White
                        )
                    }
                } else {
                    IconButton(onClick = { showPassword = true }) {
                        Icon(
                            imageVector = Icons.Default.VisibilityOff,
                            contentDescription = "Show Password",
                            tint = Color.White
                        )
                    }
                }
            })

        if (loginState.isLoading) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                CircularProgressIndicator(color = Color.White)
            }
        } else {
            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White, contentColor = primaryContainerDark
                ),
                shape = RoundedCornerShape(5.dp),
                onClick = { viewModel.login(email, password) }) {
                Text(text = "Log In")
            }


            TextButton(modifier = Modifier.fillMaxWidth(), onClick = {
                navController.navigate(Screen.RegisterScreen.route)
            }) {
                Text(color = Color.White, text = "Don't have an account? Sign up!")
            }
        }
    }
}