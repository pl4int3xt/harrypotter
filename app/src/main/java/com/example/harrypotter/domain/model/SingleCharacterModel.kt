package com.example.harrypotter.domain.model

import android.os.Parcelable
import com.example.harrypotter.data.remote.dto.Wand
import kotlinx.parcelize.Parcelize

@Parcelize
data class SingleCharacterModel(
    val actor: String,
    val alive: Boolean,
    val alternateActors: List<String>,
    val alternateNames: List<String>,
    val ancestry: String,
    val dateOfBirth: String,
    val eyeColour: String,
    val gender: String,
    val hairColour: String,
    val hogwartsStaff: Boolean,
    val hogwartsStudent: Boolean,
    val house: String,
    val image: String,
    val name: String,
    val patronus: String,
    val species: String,
    val wand: Wand,
    val wizard: Boolean,
    val yearOfBirth: Int
) : Parcelable
