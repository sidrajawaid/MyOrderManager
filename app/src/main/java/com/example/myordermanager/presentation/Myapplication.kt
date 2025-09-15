package com.example.myordermanager.presentation

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class Myapplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}