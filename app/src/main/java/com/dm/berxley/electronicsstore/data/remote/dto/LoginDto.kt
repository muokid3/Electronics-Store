package com.dm.berxley.electronicsstore.data.remote.dto

import com.dm.berxley.electronicsstore.domain.models.User

data class LoginDto(
    val success: Boolean,
    val token: String,
    val user: User,
    val message: String?
)