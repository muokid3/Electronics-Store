package com.dm.berxley.electronicsstore.domain.models.payloads

data class LoginPayload(
    val email: String,
    val password: String
)
