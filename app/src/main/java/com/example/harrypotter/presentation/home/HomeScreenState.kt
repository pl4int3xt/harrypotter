package com.example.harrypotter.presentation.home

import com.example.harrypotter.domain.model.SingleCharacterModel

data class HomeScreenState(
    val isLoading: Boolean = false,
    val message: String = "",
    val characters: List<SingleCharacterModel> = emptyList()
)