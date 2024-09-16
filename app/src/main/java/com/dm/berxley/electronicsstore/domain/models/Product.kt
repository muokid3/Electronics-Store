package com.dm.berxley.electronicsstore.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product(
    @PrimaryKey val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val currency: String,
    val imageUrl: String,
    val images: List<String>,
)