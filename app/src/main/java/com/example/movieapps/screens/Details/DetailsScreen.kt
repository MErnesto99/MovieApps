package com.example.movieapps.screens.Details

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.movieapps.Utils.AppBar

@Composable
fun DetailsScreen(navController: NavController){
    Scaffold(topBar = { AppBar(title = "Details Screen", Icons.Default.ArrowBack){
         navController.navigateUp()
    } }) {
        MainContent(navController = navController)
    }
}

@Composable
fun MainContent(navController: NavController){
    Text(text = "Details Screen")

}

