package com.example.harrypotter.domain.repository

import com.example.harrypotter.data.remote.dto.SingleCharacter
import retrofit2.Response

interface HarryPotterRepository {
    suspend fun getAllCharacters(): Response<List<SingleCharacter>>
    suspend fun getCharacterByHouse(houseName: String): Response<List<SingleCharacter>>
}