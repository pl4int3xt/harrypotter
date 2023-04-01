package com.example.harrypotter.data.repository

import com.example.harrypotter.data.remote.dto.SingleCharacter
import com.example.harrypotter.domain.repository.HarryPotterRepository

class FakeHarryPotterRepository: HarryPotterRepository {

    private val characters = mutableListOf<SingleCharacter>()

    override suspend fun getAllCharacters(): List<SingleCharacter> {
        return characters
    }

    override suspend fun getCharacterByHouse(houseName: String): List<SingleCharacter> {
        return characters
    }
}