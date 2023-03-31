package com.example.harrypotter.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.harrypotter.common.Resource
import com.example.harrypotter.domain.use_case.GetAllCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getAllCharactersUseCase: GetAllCharactersUseCase
):ViewModel(){

    private val _state = mutableStateOf(HomeScreenState())
    val state: State<HomeScreenState> = _state

    fun getCharacters(){
        getAllCharactersUseCase().onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = HomeScreenState(characters = result.data ?: emptyList())
                }
                is Resource.Loading -> {
                    _state.value = HomeScreenState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value = HomeScreenState(message = result.message ?:"")
                }
            }
        }
    }
}