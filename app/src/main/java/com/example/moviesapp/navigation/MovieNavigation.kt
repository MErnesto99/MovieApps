package com.example.moviesapp.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.moviesapp.model.Movie
import com.example.moviesapp.screens.Details.DetailsScreen
import com.example.moviesapp.screens.home.HomeScreen
import com.example.moviesapp.screens.imageViewer.ImageViewScreen

@Composable
fun MovieNavigation(mList:List<Movie>) {

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MovieScreens.HomeScreen.name
    ) {
        composable(MovieScreens.HomeScreen.name) {
            //Here we pass where this should lead us
            HomeScreen(navController = navController,mList)
            Log.d("Nav", "MovieNavigation: ${MovieScreens.HomeScreen.name}")
        }
        composable(MovieScreens.DetailsScreen.name + "/{arg}",
            arguments = listOf(navArgument(name = "arg") { type = NavType.StringType })
        ) { backStackEntry ->
            DetailsScreen(
                navController = navController,
                backStackEntry.arguments?.getString("arg"),mList
            )
        }

        composable(MovieScreens.ImageViewerScreen.name+"/{arg}",
            arguments = listOf(navArgument(name="arg"){
                type= NavType.StringType
            })
        ){navBackStackEntry ->
            ImageViewScreen(
                navController = navController,
                mList = mList,
                movieId = navBackStackEntry.arguments?.getString("arg"))
        }
    }

}