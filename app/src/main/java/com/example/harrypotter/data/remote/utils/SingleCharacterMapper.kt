package com.example.harrypotter.data.remote.utils

import com.example.harrypotter.data.remote.dto.SingleCharacter
import com.example.harrypotter.domain.model.SingleCharacterModel

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