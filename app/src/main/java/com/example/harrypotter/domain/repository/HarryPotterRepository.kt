package com.example.harrypotter.domain.repository

import com.example.harrypotter.data.remote.dto.SingleCharacter

interface HarryPotterRepository {
    suspend fun getAllCharacters(): List<SingleCharacter>
    suspend fun getCharacterByHouse(houseName: String): List<SingleCharacter>
}