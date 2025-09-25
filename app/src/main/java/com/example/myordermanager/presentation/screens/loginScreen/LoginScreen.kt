package com.example.myordermanager.presentation.screens.loginScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myordermanager.presentation.components.LargeFilledButton
import com.example.myordermanager.presentation.components.OutlinedTextFieldComponent
import com.example.myordermanager.presentation.components.LargeTitleHeading
import com.example.myordermanager.presentation.components.MediumTitleHeading


@Composable
fun LoginScreen() {

    Scaffold( modifier = Modifier.fillMaxSize())
    { paddingValue ->
        Box(
            modifier = Modifier
                .padding(paddingValue)
                .padding(16.dp)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column( modifier = Modifier.fillMaxWidth()) {

                LargeTitleHeading("Login")

                MediumTitleHeading("Please enter your credentials to login")

                OutlinedTextFieldComponent(
                    true, false, false,
                    true, 1, "Enter user name", "Username",
                    KeyboardOptions(keyboardType = KeyboardType.Text)
                )

                OutlinedTextFieldComponent(
                    true, false, false,
                    true, 1, "Enter password", "Password",
                    KeyboardOptions(keyboardType = KeyboardType.Password)
                )
                LargeFilledButton("Login!")
            }
        }
    }
}

@Preview
@Composable
fun prevHomeScreen(){

    LoginScreen()
}