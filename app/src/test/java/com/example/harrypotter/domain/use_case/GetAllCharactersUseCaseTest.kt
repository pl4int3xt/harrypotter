package com.example.harrypotter.domain.use_case

import com.example.harrypotter.data.remote.api.HarryPotterApi
import com.example.harrypotter.data.remote.dto.SingleCharacter
import com.example.harrypotter.data.remote.dto.Wand
import com.example.harrypotter.data.remote.repository.HarryPotterRepositoryImpl
import com.example.harrypotter.data.repository.FakeHarryPotterRepository
import com.example.harrypotter.domain.model.SingleCharacterModel
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class GetAllCharactersUseCaseTest{

    private lateinit var getAllCharactersUseCase: GetAllCharactersUseCase
    private lateinit var fakeHarryPotterRepository: FakeHarryPotterRepository

    @Before
    fun setUp(){
        fakeHarryPotterRepository = FakeHarryPotterRepository()
        getAllCharactersUseCase = GetAllCharactersUseCase(fakeHarryPotterRepository)
        val charactersToAdd = mutableListOf<SingleCharacterModel>()
        ('a'..'z').forEachIndexed { index, c ->
            charactersToAdd.add(
                SingleCharacterModel(
                    actor = c.toString(),
                    alive = false,
                    alternateActors = listOf(c.toString()),
                    alternateNames = listOf(c.toString()),
                    ancestry = c.toString(),
                    dateOfBirth = c.toString(),
                    eyeColour = c.toString(),
                    gender = c.toString(),
                    hairColour = c.toString(),
                    hogwartsStaff = false,
                    hogwartsStudent = true,
                    house = c.toString(),
                    image = c.toString(),
                    name = c.toString(),
                    patronus = c.toString(),
                    species = c.toString(),
                    wand = Wand(
                        core = c.toString(),
                        length = index.toDouble(),
                        wood = c.toString()
                    ),
                    wizard = false,
                    yearOfBirth = index
                )
            )
        }

        charactersToAdd.shuffle()
        runBlocking {
            charactersToAdd.forEach { fakeHarryPotterRepository.getAllCharacters() }
        }
    }

}