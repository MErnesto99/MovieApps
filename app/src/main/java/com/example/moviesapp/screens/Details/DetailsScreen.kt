package com.example.moviesapp.screens.Details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.moviesapp.Utils.AppBar1
import com.example.moviesapp.model.getMovies
import com.example.moviesapp.widgets.MovieRow


//@Preview
@Composable
fun DetailsScreen(navController: NavController, movieData: String?) {
    Scaffold(topBar = {
        AppBar1(title = "Details Screen", Icons.Default.ArrowBack) {
            navController.popBackStack()
        }
    }) {

        MainContent(navController = navController, movieData)
    }
}

@Composable
fun MainContent(navController: NavController, movieId: String?) {
    val newMovieList = getMovies().filter { movie ->
        movie.id == movieId
    } //This will return a movie when the condition matches.
    Surface(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            //  .first metgod gets the
            MovieRow(newMovieList.first())
            Spacer(modifier = Modifier.height(8.dp))
            Divider()
            Text(text = "Movie Images")
            LazyRow() {

                items(newMovieList.first().images) { image ->
                    Card(
                        modifier = Modifier
                            .padding(12.dp)
                            .size(240.dp),
                        elevation = 5.dp
                    ) {

                        val painter = rememberAsyncImagePainter(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(image)
                                .size(Size.ORIGINAL)
                                .crossfade(enable = true)
                                .build()
                        )

                        Image(
                            modifier = Modifier,
                            painter = painter,
                            contentDescription = "movie poster",
                        )
                    }
                }
            }
        }
    }

}

