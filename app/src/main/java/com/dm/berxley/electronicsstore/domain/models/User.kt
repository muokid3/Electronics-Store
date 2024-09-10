package com.dm.berxley.electronicsstore.domain.models

data class User(
    val id: Int,
    val email: String,
    val name: String,
    val phone_no: String,
    val role: String
)