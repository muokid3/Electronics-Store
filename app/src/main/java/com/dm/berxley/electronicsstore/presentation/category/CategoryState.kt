package com.dm.berxley.electronicsstore.presentation.category

import com.dm.berxley.electronicsstore.domain.models.Category

data class CategoryState (
    var isLoadingCategories: Boolean = false,
    var categoriesErrorMessage: String? = null,
    var categoriesList: List<Category> = emptyList()
)