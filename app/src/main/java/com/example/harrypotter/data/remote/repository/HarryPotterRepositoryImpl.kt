package com.example.harrypotter.data.remote.repository

import com.example.harrypotter.data.remote.api.HarryPotterApi
import com.example.harrypotter.data.remote.dto.SingleCharacter
import com.example.harrypotter.domain.repository.HarryPotterRepository
import retrofit2.Response

class HarryPotterRepositoryImpl(
    private val api: HarryPotterApi
) : HarryPotterRepository {
    override suspend fun getAllCharacters(): Response<List<SingleCharacter>> {
        return api.getAllCharacters()
    }

    override suspend fun getCharacterByHouse(houseName: String): Response<List<SingleCharacter>> {
        return api.getCharacterByHouseName(houseName)
    }
}