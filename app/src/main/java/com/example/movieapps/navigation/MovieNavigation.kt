package com.example.movieapps.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movieapps.screens.Details.DetailsScreen
import com.example.movieapps.screens.home.HomeScreen

@Composable
fun MovieNavigation(){

    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination =MovieScreens.HomeScreen.name){
        composable(MovieScreens.HomeScreen.name){
            //Here we pass where this should lead us
            HomeScreen(navController=navController)
            Log.d("Nav", "MovieNavigation: ${MovieScreens.HomeScreen.name}")
        }
        composable(MovieScreens.DetailsScreen.name){
            DetailsScreen(navController=navController)
        }
    }

}