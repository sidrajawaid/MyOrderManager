package com.example.myordermanager.presentation.screens.loginScreen


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun LoginScreen() {
    Scaffold{
        paddingValues ->
        Box(modifier = Modifier.padding(paddingValues))
        {
            LoginBody()
        }
    }

}

@Preview
@Composable
fun prevHomeScreen(){
LoginScreen()

}