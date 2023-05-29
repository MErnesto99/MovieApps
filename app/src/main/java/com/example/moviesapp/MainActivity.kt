package com.example.moviesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.moviesapp.model.MovieViewModel
import com.example.moviesapp.navigation.MovieNavigation
import com.example.moviesapp.ui.theme.MovieAppsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                val viewModel: MovieViewModel by viewModels()
                MovieApp(viewModel = viewModel)
            }
        }
    }
}

@Composable
fun MovieApp(viewModel: MovieViewModel){

    MovieNavigation(mList = viewModel.loadAllMovies())
}
@Composable
fun MyApp(content: @Composable () -> Unit){

    MovieAppsTheme {
        // A surface container using the 'background' color from the theme
        content()
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
//        MovieNavigation()
    }
   }