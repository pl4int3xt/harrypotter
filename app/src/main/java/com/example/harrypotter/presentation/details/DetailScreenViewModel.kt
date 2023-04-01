package com.example.harrypotter.presentation.details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class DetailScreenViewModel: ViewModel() {
    var isImageClicked by mutableStateOf(false)
    var clickedImage by mutableStateOf("")
    fun onEvent(detailScreenEvents: DetailScreenEvents){
        when(detailScreenEvents){
            is DetailScreenEvents.OnImageClicked -> {
                isImageClicked = true
                clickedImage = detailScreenEvents.clickedImage
            }
        }
    }
}