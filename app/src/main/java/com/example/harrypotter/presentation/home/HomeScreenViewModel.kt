package com.example.harrypotter.presentation.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.harrypotter.common.Resource
import com.example.harrypotter.domain.model.SingleCharacterModel
import com.example.harrypotter.domain.use_case.GetAllCharactersUseCase
import com.example.harrypotter.domain.use_case.GetCharacterByHouseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getAllCharactersUseCase: GetAllCharactersUseCase,
    private val getCharacterByHouseUseCase: GetCharacterByHouseUseCase
):ViewModel(){
    var messageDialogState by mutableStateOf(false)
    var filterDialogState by mutableStateOf(false)
    val allCharacters: MutableState<List<SingleCharacterModel>> = mutableStateOf(ArrayList())
    var searchValue by mutableStateOf("")
    var isSearchingByCharacterName by mutableStateOf(false)

    private val _state = mutableStateOf(HomeScreenState())
    val state: State<HomeScreenState> = _state

    init {
        getCharacters()
    }

    fun getCharacters(){
        getAllCharactersUseCase().onEach { result ->
            when(result){
                is Resource.Success -> {
                    this.allCharacters.value = result.data?: emptyList()
                    _state.value = HomeScreenState(isLoading = false)
                }
                is Resource.Loading -> {
                    _state.value = HomeScreenState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value = HomeScreenState(message = result.message ?:"")
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getCharactersByHouseName(){
        getCharacterByHouseUseCase(searchValue).onEach { result ->
            when(result){
                is Resource.Success -> {
                    this.allCharacters.value = result.data?: emptyList()
                    _state.value = HomeScreenState(isLoading = false)
                }
                is Resource.Loading -> {
                    _state.value = HomeScreenState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value = HomeScreenState(message = result.message ?:"")
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun searchCharacterByCharacterName(){
        this.allCharacters.value = this.allCharacters.value.filter { it.name.contains(searchValue, ignoreCase = true) }
    }

    fun onEvent(homeScreenEvents: HomeScreenEvents){
        when(homeScreenEvents){
            is HomeScreenEvents.OnSearchValueChanged -> {
                searchValue = homeScreenEvents.searchValue
            }
            is HomeScreenEvents.OnSearchByCharacterName -> {
                searchCharacterByCharacterName()
            }
            is HomeScreenEvents.OnSearchByHouseName -> {
                getCharactersByHouseName()
            }
            is HomeScreenEvents.OnIsSearchingByCharacterNameChecked -> {
                isSearchingByCharacterName = homeScreenEvents.isSearchingByCharacterName
            }
            is HomeScreenEvents.OnReset -> { getCharacters() }
        }
    }
}