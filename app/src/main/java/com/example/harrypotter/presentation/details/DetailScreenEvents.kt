package com.example.harrypotter.presentation.details

sealed class DetailScreenEvents {
    data class OnImageClicked(val clickedImage: String): DetailScreenEvents()
}