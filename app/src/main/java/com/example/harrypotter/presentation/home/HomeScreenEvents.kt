package com.example.harrypotter.presentation.home

sealed class HomeScreenEvents {
    data class OnCharacterNameChanged(val characterName: String): HomeScreenEvents()
    data class OnHouseNameChanged(val houseName: String): HomeScreenEvents()
    object OnSearchByCharacterName: HomeScreenEvents()
    object OnSearchByHouseName: HomeScreenEvents()
}