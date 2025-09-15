package com.example.myordermanager.presentation.screens.loginScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.myordermanager.presentation.components.OutlinedTextFieldComponent


@Composable
fun LoginScreen() {

    Scaffold( modifier = Modifier.fillMaxSize())
    { paddingValue ->
        Box(
            modifier = Modifier
                .padding(paddingValue)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            OutlinedTextFieldComponent(
                true, false, false,
                true, 1, "username",
                KeyboardActions.Default
            )
        }
    }
}