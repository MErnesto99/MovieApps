package com.example.moviesapp.model

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import com.example.moviesapp.data.MovieDataSource

class MovieViewModel: ViewModel(){

    private val movies = mutableStateListOf<Movie>()

    init {
        movies.addAll(MovieDataSource().loadMovies())
    }

    fun loadAllMovies(): List<Movie>{
        return movies
    }
}