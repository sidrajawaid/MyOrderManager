package com.example.myordermanager.common

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext

fun Context.findActivity(): Activity? = when (this) {
    is Activity -> this
    is ContextWrapper -> baseContext.findActivity()
    else -> null
}

fun Context.requireActivity(): Activity =
    findActivity() ?: throw IllegalStateException("Context is not an Activity context")


//fun rememberActivity(): Activity? {
//    val context = LocalContext.current
//    return remember(context) { context.findActivity() }
//}
//
//
//fun requireActivity(): Activity {
//    return rememberActivity() ?: throw IllegalStateException("No Activity found")
//}