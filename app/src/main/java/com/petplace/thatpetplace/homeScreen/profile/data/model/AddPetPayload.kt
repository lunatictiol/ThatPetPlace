package com.petplace.thatpetplace.homeScreen.profile.data.model

data class AddPetPayload(
    val name: String,
    val gender: String,
    val user_id: String,
    val age: Int,
    val breed: String,
    val neutered: Boolean,
    val species: String,
    val vaccinated: Boolean,
)