package com.example.moviesapp.screens.imageViewer

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.material.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.moviesapp.model.Movie
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageViewScreen(navController: NavController,mList:List<Movie>,movieId:String?){

    var movieList=mList.filter {movie->
        movie.id==movieId
    }.first()

    val scope = rememberCoroutineScope()
    val pagerState= rememberPagerState()
    Surface(color = MaterialTheme.colors.background) {
        Column() {

            Box(modifier = Modifier.fillMaxSize()) {
                HorizontalPager(
                    pageCount = movieList.images.size,
                    state = pagerState,
                    pageSize = PageSize.Fill,
//                    pageSize = PageSize.Fixed(300.dp),//Show only 300 dp of the image horizontally
                    key = {
                        movieList.images[it]
                    },
                ) { index ->

                    AsyncImage(
                        model = movieList.images[index],
                        contentDescription = "",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )

                }

                Box(
                    modifier = Modifier
                        .offset(y = -16.dp)
                        .fillMaxWidth(0.5f)
                        .clip(CircleShape.copy(all = CornerSize(100)))
                        .background(MaterialTheme.colors.background)
                        .padding(8.dp)
                        .align(Alignment.BottomCenter)


                ) {

                    IconButton(onClick = {

                        scope.launch {
                            pagerState.animateScrollToPage(
                                pagerState.currentPage-1
                            )
                        }

                    }, modifier = Modifier.align(Alignment.BottomStart)) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = "goBack"
                        )
                    }

                    IconButton(onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(
                                pagerState.currentPage+1
                            )
                        }
                    }, modifier = Modifier.align(Alignment.BottomEnd)) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = "goBack"
                        )
                    }
                }
            }


        }

    }
}