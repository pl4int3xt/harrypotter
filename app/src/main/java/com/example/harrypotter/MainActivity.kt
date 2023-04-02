package com.example.harrypotter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.example.harrypotter.presentation.navigation.MainNavGraph
import com.example.harrypotter.presentation.theme.HarrypotterTheme
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    var keepSplashOpened = true
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().setKeepOnScreenCondition{
            keepSplashOpened
        }
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            HarrypotterTheme {
                MainNavGraph(
                    onScreenLoaded = { keepSplashOpened = false },
                    navHostController = rememberAnimatedNavController()
                )
            }
        }
    }
}