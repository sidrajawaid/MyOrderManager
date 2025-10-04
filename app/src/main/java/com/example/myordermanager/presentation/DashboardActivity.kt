package com.example.myordermanager.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.myordermanager.presentation.screens.loginScreen.LoginScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
GoogleCloudConsoleSetupDebug.checkCurrentSetup(this)
          //  GoogleCloudConsoleSetupDebug.openGoogleCloudConsole(this)
            LoginScreen()
        }
    }
}
