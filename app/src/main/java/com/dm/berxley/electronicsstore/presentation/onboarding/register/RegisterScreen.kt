package com.dm.berxley.electronicsstore.presentation.onboarding.register

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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dm.berxley.electronicsstore.R
import com.dm.berxley.electronicsstore.presentation.navgraph.Screen
import com.dm.berxley.electronicsstore.ui.theme.primaryContainerDark

@Composable
fun RegisterScreen(navController: NavController) {
    var fullName by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var passwordIsVisible by remember {
        mutableStateOf(false)
    }
    var passwordConfirmation by remember {
        mutableStateOf("")
    }
    var passwordConfirmationIsVisible by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(primaryContainerDark)
            .verticalScroll(
                rememberScrollState()
            )
            .imePadding(),
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp),
            text = "Create and Account",
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center,
            color = Color.White
        )

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .size(250.dp)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        )

        OutlinedTextField(modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
            value = fullName,
            onValueChange = {
                fullName = it
            },
            label = { Text(text = "Full Name") },
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.White,
                focusedIndicatorColor = Color.White,
                focusedLabelColor = Color.White,
                focusedContainerColor = primaryContainerDark,
                unfocusedLabelColor = Color.White,
                unfocusedContainerColor = primaryContainerDark,
                unfocusedIndicatorColor = Color.White,
                cursorColor = Color.White
            ),
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
        )

        OutlinedTextField(modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
            value = email,
            onValueChange = {
                email = it
            },
            label = { Text(text = "E-mail") },
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.White,
                focusedIndicatorColor = Color.White,
                focusedLabelColor = Color.White,
                focusedContainerColor = primaryContainerDark,
                unfocusedLabelColor = Color.White,
                unfocusedContainerColor = primaryContainerDark,
                unfocusedIndicatorColor = Color.White,
                cursorColor = Color.White
            ),
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
            label = { Text(text = "Password") },
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.White,
                focusedIndicatorColor = Color.White,
                focusedLabelColor = Color.White,
                focusedContainerColor = primaryContainerDark,
                unfocusedLabelColor = Color.White,
                unfocusedContainerColor = primaryContainerDark,
                unfocusedIndicatorColor = Color.White,
                cursorColor = Color.White
            ),
            trailingIcon = {
                if (passwordIsVisible) {
                    IconButton(onClick = { passwordIsVisible = false }) {
                        Icon(
                            tint = Color.White,
                            imageVector = Icons.Default.Visibility,
                            contentDescription = "Hide Password"
                        )
                    }
                } else {
                    IconButton(onClick = { passwordIsVisible = true }) {
                        Icon(
                            tint = Color.White,
                            imageVector = Icons.Default.VisibilityOff,
                            contentDescription = "Show Password"
                        )
                    }
                }
            },
            visualTransformation = if (passwordIsVisible) VisualTransformation.None else PasswordVisualTransformation(),
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next, keyboardType = KeyboardType.Password
            )
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            value = passwordConfirmation,
            onValueChange = {
                passwordConfirmation = it
            },
            label = { Text(text = "Confirm Password") },
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.White,
                focusedIndicatorColor = Color.White,
                focusedLabelColor = Color.White,
                focusedContainerColor = primaryContainerDark,
                unfocusedLabelColor = Color.White,
                unfocusedContainerColor = primaryContainerDark,
                unfocusedIndicatorColor = Color.White,
                cursorColor = Color.White
            ),
            singleLine = true,
            trailingIcon = {
                if (passwordConfirmationIsVisible) {
                    IconButton(onClick = { passwordConfirmationIsVisible = false }) {
                        Icon(
                            tint = Color.White,
                            imageVector = Icons.Default.Visibility,
                            contentDescription = "Hide Password"
                        )
                    }
                } else {
                   IconButton(onClick = { passwordConfirmationIsVisible = true }) {
                       Icon(
                           tint = Color.White,
                           imageVector = Icons.Default.VisibilityOff,
                           contentDescription = "Show Password"
                       )
                   }
                }
            },
            visualTransformation = if (passwordConfirmationIsVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done, keyboardType = KeyboardType.Password
            )
        )

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            CircularProgressIndicator(color = Color.White)
        }

        Button(modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = primaryContainerDark, containerColor = Color.White
            ),
            onClick = { /*TODO*/ }) {
            Text(text = "Sign Up!")
        }

        TextButton(modifier = Modifier.fillMaxWidth(), onClick = {
            navController.navigate(Screen.LoginScreen.route)
        }) {
            Text(color = Color.White, text = "Already have an account? Sign In")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    RegisterScreen(rememberNavController())
}