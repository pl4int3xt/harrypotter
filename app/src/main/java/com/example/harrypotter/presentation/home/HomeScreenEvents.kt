package com.example.harrypotter.presentation.home

sealed class HomeScreenEvents {
    data class OnSearchValueChanged(val searchValue: String): HomeScreenEvents()
    object OnSearchByCharacterName: HomeScreenEvents()
    object OnSearchByHouseName: HomeScreenEvents()
    data class OnIsSearchingByCharacterNameChecked(val isSearchingByCharacterName: Boolean): HomeScreenEvents()
}