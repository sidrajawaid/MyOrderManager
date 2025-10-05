package com.example.myordermanager.NavigationRoute

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myordermanager.presentation.screens.mainScreen.MainScreen
import kotlinx.serialization.Serializable



@Serializable
object Dashboard

@Serializable
object Login


@Serializable
object Splash

@Serializable
object Main


@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
@Composable
fun Route() {

    val navController = rememberNavController()
    // val viewmodel : AuthenticationViewmodel = viewModel()

    NavHost(navController = navController, startDestination = Dashboard) {
        composable<Dashboard> { /*DashboardScreen()*/
        }
        composable<Login> { }
        composable<Main> {
            MainScreen()
        }

    }
}


