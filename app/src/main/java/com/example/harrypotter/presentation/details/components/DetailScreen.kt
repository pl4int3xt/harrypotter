package com.example.harrypotter.presentation.details.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.rounded.Cancel
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.harrypotter.R
import com.example.harrypotter.domain.model.SingleCharacterModel
import com.example.harrypotter.presentation.details.DetailScreenEvents
import com.example.harrypotter.presentation.details.DetailScreenViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(
    viewModel: DetailScreenViewModel = hiltViewModel(),
    singleCharacterModel: SingleCharacterModel,
    navHostController: NavHostController
) {
    val scrollState = rememberScrollState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                scrollBehavior = scrollBehavior,
                modifier = Modifier.padding(5.dp),
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.Transparent ),
                navigationIcon = {
                    if (viewModel.isImageClicked){
                        NavigationButton(onClick = { viewModel.isImageClicked = false },
                            icon = Icons.Rounded.Cancel)
                    } else {
                        NavigationButton(onClick = { navHostController.popBackStack() },
                            icon = Icons.Default.ArrowBack)
                    }
                },
                title = {}
            )
        }
    ) {
        if (viewModel.isImageClicked){
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                AsyncImage(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentScale = ContentScale.Fit,
                    model = singleCharacterModel.image,
                    contentDescription = "image",
                    placeholder = painterResource(id = R.drawable.placeholder)
                )
            }
        } else {
            Box {
                Column(
                    modifier = Modifier.verticalScroll(scrollState)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(350.dp)
                            .graphicsLayer {
                                translationY = 0.4f * scrollState.value
                            }
                    ) {
                        AsyncImage(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    viewModel.onEvent(
                                        DetailScreenEvents.OnImageClicked(
                                            singleCharacterModel.image
                                        )
                                    )
                                },
                            contentScale = ContentScale.Crop,
                            model = singleCharacterModel.image,
                            contentDescription = "image",
                            placeholder = painterResource(id = R.drawable.placeholder)
                        )
                    }
                    Column(
                        modifier = Modifier.background(color = MaterialTheme.colorScheme.background)
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(10.dp)
                        ) {
                            Text(
                                text = singleCharacterModel.name,
                                fontWeight = FontWeight.Bold,
                                fontSize = 35.sp
                            )
                            Text(
                                text = singleCharacterModel.actor,
                                fontWeight = FontWeight.Bold,
                                fontSize = 35.sp
                            )
                            Text(
                                text = "Details",
                                fontWeight = FontWeight.Bold,
                                fontSize = 35.sp
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            DetailsRow(title = "Species", value = singleCharacterModel.species)
                            DetailsRow(title = "Gender", value = singleCharacterModel.gender)
                            DetailsRow(title = "House", value = singleCharacterModel.house)
                            DetailsRow(title = "Date of birth", value = singleCharacterModel.dateOfBirth)
                            DetailsRow(title = "Year of birth", value = singleCharacterModel.yearOfBirth)
                            DetailsRow(title = "Wizard", value = singleCharacterModel.wizard)
                            DetailsRow(title = "Ancestry", value = singleCharacterModel.ancestry)
                            DetailsRow(title = "Eye colour", value = singleCharacterModel.eyeColour)
                            DetailsRow(title = "Hair colour", value = singleCharacterModel.hairColour)
                            DetailsRow(title = "Wand wood", value = singleCharacterModel.wand.wood)
                            DetailsRow(title = "Wand core", value = singleCharacterModel.wand.core)
                            DetailsRow(title = "Wand length", value = singleCharacterModel.wand.length)
                            DetailsRow(title = "Patronus", value =singleCharacterModel.patronus)
                            DetailsRow(title = "Hogwarts student", value = singleCharacterModel.hogwartsStudent)
                            DetailsRow(title = "Hogwarts staff", value = singleCharacterModel.hogwartsStaff)
                            DetailsRow(isList = true ,title = "Alternative actors", value = singleCharacterModel.alternateActors)
                            DetailsRow(title = "Alive", value = singleCharacterModel.alive)
                        }
                    }
                }
            }
        }
    }
}