package com.example.harrypotter.data.remote.api

import com.example.harrypotter.data.remote.dto.SingleCharacter
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface HarryPotterApi {

    @GET("characters")
    suspend fun getAllCharacters(): Response<List<SingleCharacter>>

    @GET("characters/house/{houseName}")
    suspend fun getCharacterByHouseName(
        @Path("houseName") houseName: String
    ): Response<List<SingleCharacter>>
}