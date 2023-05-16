package com.example.movieapps.screens.home

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapps.Utils.AppBar
import com.example.movieapps.navigation.MovieScreens

@Composable
fun HomeScreen(navController: NavController){
    Scaffold(topBar = { AppBar(title = "Movies",Icons.Default.Home){

    } }) {
        MainContent(navController=navController)
    }
}


@Composable
fun MainContent(
    navController: NavController,
    movieList:List<String> = listOf("Life",
    "Devil May Cry",
    "Gabrielle",
    "Die Hard",
    "John Wick",
    "Die Heart",
    "The Pops Exorcist",
    "Stimulant")){
    Surface(color = MaterialTheme.colors.background) {
        Column(modifier = Modifier.padding(12.dp)) {
            LazyColumn(){
                items(items=movieList){
                    MovieRow(movie = it){movie ->
                       //NavController allows us to click and go somewhere else
                        navController.navigate(route = MovieScreens.DetailsScreen.name)
                    }
                }

            }
        }
    }
}

@Composable
fun MovieRow(movie:String,onItemClick: (String)-> Unit={}){
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(130.dp)
        .clickable {
            onItemClick(movie)
        }
        .padding(6.dp),
        shape= CircleShape.copy(all= CornerSize(13.dp)),
        elevation = 6.dp) {
        Row(modifier = Modifier.padding(5.dp), verticalAlignment = Alignment.CenterVertically) {
            Surface(modifier = Modifier
                .padding(12.dp)
                .size(100.dp),
                shape = RectangleShape,
                elevation = 4.dp) {
                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "movie image")
            }

            Text(text = movie)

        }
    }
}