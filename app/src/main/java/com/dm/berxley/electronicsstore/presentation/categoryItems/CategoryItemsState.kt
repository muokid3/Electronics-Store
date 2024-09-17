package com.dm.berxley.electronicsstore.presentation.categoryItems

import com.dm.berxley.electronicsstore.domain.models.Category
import com.dm.berxley.electronicsstore.domain.models.Product

data class CategoryItemsState(
    var selectedCategory: Category? = null,
    var isLoadingProducts: Boolean = false,
    var productsErrorMessage: String? = null,
    var selectedCategoryProducts: List<Product> = emptyList(),
)