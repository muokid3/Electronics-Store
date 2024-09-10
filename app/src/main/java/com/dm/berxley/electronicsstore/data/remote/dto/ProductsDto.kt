package com.dm.berxley.electronicsstore.data.remote.dto

import com.dm.berxley.electronicsstore.domain.models.Product

data class ProductsDto(
    val currentPage: Int,
    val itemsPerPage: Int,
    val products: List<Product>,
    val success: Boolean,
    val totalItems: Int,
    val totalPages: Int
)