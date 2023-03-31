package com.example.harrypotter.data.remote.repository

import com.example.harrypotter.data.remote.api.Api
import com.example.harrypotter.data.remote.dto.SingleCharacter
import com.example.harrypotter.domain.repository.Repository

class RepositoryImpl(
    val api: Api
) : Repository {
    override suspend fun getAllCharacters(): List<SingleCharacter> {
        return api.getAllCharacters()
    }

    override suspend fun getCharacterByHouse(houseName: String): List<SingleCharacter> {
        return api.getCharacterByHouseName(houseName)
    }
}