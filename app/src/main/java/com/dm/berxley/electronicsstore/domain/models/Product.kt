package com.dm.berxley.electronicsstore.domain.models

data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val currency: String,
    val imageUrl: String,
    val images: List<String>,
)