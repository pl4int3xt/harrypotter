package com.example.harrypotter.presentation.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.harrypotter.presentation.home.HomeScreenEvents
import com.example.harrypotter.presentation.home.HomeScreenViewModel
import com.example.harrypotter.presentation.screens.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navHostController: NavHostController,
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val characters = viewModel.allCharacters.value
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection)
            .fillMaxSize()
        ,
        topBar = {
            TopAppBar(
                navigationIcon = { Button(onClick = { viewModel.filterDialogState = true }) {

                }},
                title = {
                    SearchBar(
                        onSearch = {
                            if (viewModel.isSearchingByCharacterName)
                                viewModel.onEvent(HomeScreenEvents.OnSearchByCharacterName)
                            else
                                viewModel.onEvent(HomeScreenEvents.OnSearchByHouseName) },
                        value = viewModel.searchValue,
                        onValueChange = { viewModel.onEvent(HomeScreenEvents.OnSearchValueChanged(it))},
                        onReset = { viewModel.onEvent(HomeScreenEvents.OnReset)}
                    )
                },
                scrollBehavior = scrollBehavior
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
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            if (viewModel.filterDialogState){
                FilterDialog(viewModel = viewModel)
            }
            if (state.message.isNotEmpty()){
                Column(
                    modifier = Modifier.fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = state.message)
                    Text(
                        modifier = Modifier.clickable { viewModel.getCharacters() },
                        text = "Refresh",
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 25.sp
                    )
                }
            }
        }
    }
}