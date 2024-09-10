package com.dm.berxley.electronicsstore.domain.models.payloads

data class RegisterPayload(
    val email: String,
    val name: String,
    val phone_no: String,
    val password: String,
)
