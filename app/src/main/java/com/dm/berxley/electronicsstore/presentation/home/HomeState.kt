package com.dm.berxley.electronicsstore.presentation.home

import com.dm.berxley.electronicsstore.domain.models.Category

data class HomeState(
    var isLoadingCategories: Boolean = false,
    var categoriesErrorMessage: String? = null,
    var categoriesList: List<Category> = emptyList()


)
