package com.example.myordermanager.presentation.navigation

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myordermanager.NavigationRoute.Dashboard
import com.example.myordermanager.NavigationRoute.Login
import com.example.myordermanager.NavigationRoute.Splash
import com.example.myordermanager.NavigationRoute.SplashScreen

@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
@Composable
fun Route() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Dashboard) {
        composable<Dashboard> { /*DashboardScreen()*/
        }
        composable<Login> { /*LoginScreen("",hiltViewModel<AuthenticationViewmodel>())*/
        }
        composable<Splash> { SplashScreen( /* ... */) }
    }
}

@Composable
fun SplashScreen() {
}

/*
fun AppNavController() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = ScreenName.HOME_SCREEN) {

        composable(route = ScreenName.HOME_SCREEN){
            HomeScreen{ id ->
                navController.navigate(ScreenName.DETAIL_SCREEN + "/$id")
            }
        }

        composable(route = ScreenName.DETAIL_SCREEN + "/{id}", arguments = listOf(
            navArgument(name = "id"){
                type = NavType.StringType
            }
        )){
            DetailScreen{
                navController.popBackStack()
            }
        }

    }
}*/
