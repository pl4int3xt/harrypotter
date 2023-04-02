package com.example.harrypotter.presentation.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.harrypotter.domain.model.SingleCharacterModel
import com.example.harrypotter.presentation.details.components.DetailsScreen
import com.example.harrypotter.presentation.home.components.HomeScreen
import com.example.harrypotter.presentation.screens.Screens
import com.example.harrypotter.presentation.search.components.SearchScreen
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
        composable(
            route = Screens.HomeScreen.route,
            enterTransition = {
                when (targetState.destination.route) {
                    navHostController.currentDestination?.route ->
                        slideIntoContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(300))
                    else -> null
                }
            },
            popExitTransition = {
                when (targetState.destination.route) {
                    navHostController.currentDestination?.route ->
                        slideOutOfContainer(AnimatedContentScope.SlideDirection.Right, animationSpec = tween(1000))
                    else -> null
                }
            }
        ){ HomeScreen(navHostController = navHostController) }

        composable(
            route = Screens.DetailsScreen.route,
            enterTransition = {
                when (targetState.destination.route) {
                    navHostController.currentDestination?.route ->
                        slideIntoContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(300))
                    else -> null
                }
            },
            popExitTransition = {
                when (targetState.destination.route) {
                    navHostController.currentDestination?.route ->
                        slideOutOfContainer(AnimatedContentScope.SlideDirection.Right, animationSpec = tween(1000))
                    else -> null
                }
            }
        ){
            val characterDetails = navHostController.previousBackStackEntry?.savedStateHandle?.get<SingleCharacterModel>("details")
            if (characterDetails != null) {
                DetailsScreen( singleCharacterModel =  characterDetails ,navHostController = navHostController)
            }
        }

        composable(
            route = Screens.SearchScreen.route,
            enterTransition = {
                when (targetState.destination.route) {
                    navHostController.currentDestination?.route ->
                        slideIntoContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(300))
                    else -> null
                }
            },
            popExitTransition = {
                when (targetState.destination.route) {
                    navHostController.currentDestination?.route ->
                        slideOutOfContainer(AnimatedContentScope.SlideDirection.Right, animationSpec = tween(1000))
                    else -> null
                }
            }
        ){ SearchScreen(navHostController = navHostController) }
    }
}