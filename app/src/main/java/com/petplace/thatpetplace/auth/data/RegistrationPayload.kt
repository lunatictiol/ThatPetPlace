package com.petplace.thatpetplace.auth.data

data class RegistrationPayload(
    val email: String,
    val first_name: String,
    val last_name: String,
    val password: String,
    val phone_number: String
)