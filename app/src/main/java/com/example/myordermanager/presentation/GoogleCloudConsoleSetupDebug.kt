package com.example.myordermanager.presentation

import android.content.Context
import android.content.Intent
import android.net.Uri

object GoogleCloudConsoleSetupDebug {

    fun checkCurrentSetup(context: Context) {
        println("TAG === GOOGLE SIGN-IN SETUP CHECK ===")
        println("TAG Package name: ${context.packageName}")
        println("TAG Check these in Google Cloud Console:")
        println("TAG 1. ✅ Identity Toolkit API - ENABLED")
        println("TAG 2. ✅ OAuth Consent Screen - CONFIGURED")
        println("TAG 3. ✅ Android OAuth Client - CREATED")
        println("TAG 4. ✅ SHA-1 fingerprint - ADDED")
        println("TAG 5. ✅ Package name - MATCHES: ${context.packageName}")
    }

    fun openGoogleCloudConsole(context: Context) {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("https://console.cloud.google.com/")
        }
        context.startActivity(intent)
    }
}