package com.example.harrypotter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import com.example.harrypotter.presentation.home.components.HomeScreen
import com.example.harrypotter.presentation.navigation.MainNavGraph
import com.example.harrypotter.presentation.theme.HarrypotterTheme
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HarrypotterTheme {
                MainNavGraph(navHostController = rememberAnimatedNavController())
            }
        }
    }
}