package com.dm.berxley.electronicsstore.presentation.category

import com.dm.berxley.electronicsstore.domain.models.Category
import com.dm.berxley.electronicsstore.domain.models.Product

data class CategoryState(
    var isLoadingCategories: Boolean = false,
    var categoriesErrorMessage: String? = null,
    var categoriesList: List<Category> = emptyList(),


    var isLoadingProducts: Boolean = false,
    var productsErrorMessage: String? = null,
    var selectedCategory: Category? = null,
    var selectedCategoryProducts: List<Product> = emptyList(),
)