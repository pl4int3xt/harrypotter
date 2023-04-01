package com.example.harrypotter.presentation.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.harrypotter.domain.model.SingleCharacterModel
import com.example.harrypotter.presentation.details.components.DetailsScreen
import com.example.harrypotter.presentation.home.components.HomeScreen
import com.example.harrypotter.presentation.screens.Screens
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainNavGraph(
    navHostController: NavHostController
) {
    AnimatedNavHost(
        navController = navHostController,
        startDestination = Screens.HomeScreen.route
    ){
        composable(route = Screens.HomeScreen.route){ HomeScreen(navHostController = navHostController)}
        composable(route = Screens.DetailsScreen.route){
            val characterDetails = navHostController.previousBackStackEntry?.savedStateHandle?.get<SingleCharacterModel>("details")
            if (characterDetails != null) {
                DetailsScreen(characterDetails, navHostController)
            }
        }
    }
}