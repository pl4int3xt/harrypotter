package com.example.harrypotter.data.remote.api

import com.example.harrypotter.data.remote.dto.SingleCharacter
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("characters")
    suspend fun getAllCharacters(): List<SingleCharacter>

    @GET("characters/house/{houseName}")
    suspend fun getCharacterByHouseName(
        @Path("houseName") houseName: String
    ): List<SingleCharacter>
}