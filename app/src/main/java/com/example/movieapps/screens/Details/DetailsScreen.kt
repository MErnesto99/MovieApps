package com.example.movieapps.screens.Details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapps.Utils.AppBar


//@Preview
@Composable
fun DetailsScreen(navController: NavController, movieData: String?=""){
    Scaffold(topBar = { AppBar(title = "Details Screen", Icons.Default.ArrowBack){
         navController.navigateUp()
    } }) {

        MainContent(navController = navController,movieData)
    }
}

@Composable
fun MainContent(navController: NavController,movieData:String?){
   Surface(modifier = Modifier.padding(5.dp).fillMaxSize()) {
        Column(modifier = Modifier.padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
           ) {


               Text(text = movieData.toString())


        }
    }

}

