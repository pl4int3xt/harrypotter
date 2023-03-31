package com.example.harrypotter.domain.repository

import com.example.harrypotter.data.remote.dto.SingleCharacter

interface Repository {
    suspend fun getAllCharacters(): List<SingleCharacter>
    suspend fun
}