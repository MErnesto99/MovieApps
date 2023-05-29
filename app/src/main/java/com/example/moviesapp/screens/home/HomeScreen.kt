package com.example.moviesapp.screens.home

import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.moviesapp.Utils.AppBar
import com.example.moviesapp.model.Movie
import com.example.moviesapp.navigation.MovieScreens
import com.example.moviesapp.widgets.MovieRow

@Composable
fun HomeScreen(navController: NavController, movieList:List<Movie>){
    Scaffold(topBar = { AppBar(title = "Movies",Icons.Default.Home){

    } }) {
        MainContent(navController=navController,movieList)
    }
}


@Composable
fun MainContent(
    navController: NavController,
    movieList:List<Movie>){
    Surface(color = MaterialTheme.colors.background) {
        Column(modifier = Modifier.padding(12.dp)) {
            LazyColumn(){
                items(items=movieList){
                    MovieRow(movie = it){movie->
                       //NavController allows us to click and go somewhere else
                        navController.navigate(route = MovieScreens.DetailsScreen.name+"/$movie")
                    }
                }

            }
        }
    }
}

