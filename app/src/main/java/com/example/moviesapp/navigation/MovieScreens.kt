package com.example.moviesapp.navigation

enum class MovieScreens {
    HomeScreen,
    ImageViewerScreen,
    DetailsScreen;

    companion object {
        fun fromRoute(route: String?): MovieScreens
            = when (route?.substringBefore("/")) {
                HomeScreen.name -> HomeScreen
            ImageViewerScreen.name -> ImageViewerScreen
                DetailsScreen.name -> DetailsScreen
              null -> HomeScreen
              else -> throw IllegalArgumentException("Route $route is not recon")
            }

    }


}