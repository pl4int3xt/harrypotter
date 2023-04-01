package com.example.harrypotter.presentation.screens

sealed class Screens(val route: String){
    object HomeScreen: Screens("home_screen")
    object DetailsScreen: Screens("details_screen")
}
