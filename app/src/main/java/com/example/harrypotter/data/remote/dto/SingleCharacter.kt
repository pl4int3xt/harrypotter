package com.example.harrypotter.data.remote.dto

import com.example.harrypotter.domain.model.SingleCharacterModel

data class SingleCharacter(
    val actor: String,
    val alive: Boolean,
    val alternate_actors: List<String>,
    val alternate_names: List<String>,
    val ancestry: String,
    val dateOfBirth: String,
    val eyeColour: String,
    val gender: String,
    val hairColour: String,
    val hogwartsStaff: Boolean,
    val hogwartsStudent: Boolean,
    val house: String,
    val id: String,
    val image: String,
    val name: String,
    val patronus: String,
    val species: String,
    val wand: Wand,
    val wizard: Boolean,
    val yearOfBirth: Int
)

fun SingleCharacter.toSingleCharacterModel(): SingleCharacterModel {
    return SingleCharacterModel(
        actor = actor,
        alive = alive,
        alternateActors = alternate_actors,
        alternateNames = alternate_names,
        ancestry = ancestry,
        dateOfBirth = dateOfBirth,
        eyeColour = eyeColour,
        gender = gender,
        hairColour = hairColour,
        hogwartsStaff = hogwartsStaff,
        hogwartsStudent = hogwartsStudent,
        house = house,
        image = image,
        name = name,
        patronus = patronus,
        species = species,
        wand = wand,
        wizard = wizard,
        yearOfBirth = yearOfBirth
    )
}