package com.example.harrypotter.presentation.details.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.harrypotter.domain.model.SingleCharacterModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(
    singleCharacterModel: SingleCharacterModel,
    navHostController: NavHostController
) {
    val scrollState = rememberScrollState()
    Scaffold() {
        Box {
            Column(
                modifier = Modifier.verticalScroll(scrollState)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .graphicsLayer {
                            translationY = 0.4f * scrollState.value
                        }
                ) {
                    AsyncImage(
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.FillBounds,
                        model = singleCharacterModel.image,
                        contentDescription = "image"
                    )
                }
                Column(
                    modifier = Modifier
                        .background(
                            color = if (isSystemInDarkTheme()) Color.Black else Color.White
                        )
                ) {
                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                            .background(
                                color = if (isSystemInDarkTheme()) Color.Black else Color.White
                            )
                    ) {
                        Text(
                            text = singleCharacterModel.name,
                            fontWeight = FontWeight.Bold,
                            fontSize = 35.sp
                        )
                    }
                }
            }
        }
    }
}