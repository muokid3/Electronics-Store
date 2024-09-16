package com.dm.berxley.electronicsstore.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey val id: Int,
    val email: String,
    val name: String,
    val phone_no: String,
    val role: String
)