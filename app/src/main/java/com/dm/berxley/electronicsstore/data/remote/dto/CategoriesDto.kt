package com.dm.berxley.electronicsstore.data.remote.dto

import com.dm.berxley.electronicsstore.domain.models.Category

data class CategoriesDto(
    val categories: List<Category>,
    val success: Boolean
)