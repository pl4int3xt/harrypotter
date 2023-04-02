package com.example.harrypotter.presentation.home.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.harrypotter.presentation.details.components.NavigationButton
import com.example.harrypotter.presentation.home.HomeScreenViewModel
import com.example.harrypotter.presentation.screens.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onScreenLoaded: () -> Unit,
    navHostController: NavHostController,
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val characters = viewModel.allCharacters.value
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    LaunchedEffect(key1 = true){
        onScreenLoaded()
    }
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                scrollBehavior = scrollBehavior,
                modifier = Modifier.padding(5.dp),
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.Transparent ),
                actions = {
                    NavigationButton(
                        onClick = { navHostController.navigate(Screens.SearchScreen.route) },
                        icon = Icons.Rounded.Search)
                },
                title = {
                    Text(
                        text = "Harry Potter",
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp
                    )
                }
            )
        }
    ) {
        Box(modifier = Modifier.fillMaxSize()){
            LazyColumn(){
                item {
                    Spacer(modifier = Modifier.height(it.calculateTopPadding()))
                }
                items(characters){
                    SingleCard(name = it.name, image = it.image) {
                        navHostController.currentBackStackEntry?.savedStateHandle?.set(
                            key = "details",
                            value = it
                        )
                        navHostController.navigate(Screens.DetailsScreen.route)
                    }
                }
                item {
                    Spacer(modifier = Modifier.height(it.calculateBottomPadding()))
                }
            }

            if (state.isLoading){
                CircularProgressIndicator( modifier = Modifier.align(Alignment.Center))
            }

            if (viewModel.filterDialogState){ FilterDialog(viewModel = viewModel) }

            if (state.message.isNotEmpty()){
                MessageDialog(viewModel = viewModel, message = state.message)
            }
        }
    }
}