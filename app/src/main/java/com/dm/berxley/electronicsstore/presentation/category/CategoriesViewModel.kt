package com.dm.berxley.electronicsstore.presentation.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dm.berxley.electronicsstore.domain.models.Category
import com.dm.berxley.electronicsstore.domain.repositories.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(
    private val productsRepository: ProductsRepository
) : ViewModel() {
    private val _categoriesState = MutableStateFlow(CategoryState())
    val categoriesState = _categoriesState.asStateFlow()

    init {
        _categoriesState.update {
            it.copy(isLoadingCategories = true)
        }

        viewModelScope.launch {
            productsRepository.getCategories().collectLatest { categoryList ->

                _categoriesState.update {
                    it.copy(
                        isLoadingCategories = false,
                        categoriesList = categoryList
                    )
                }
            }
        }

        loadCategoriesFromApi()
    }

    private fun loadCategoriesFromApi() {
        viewModelScope.launch {
            productsRepository.getProductCategories().collectLatest { response ->
                if (response.isSuccessful) {

                    if (response.body()?.success == true) {
                        val categories = response.body()?.categories

                        for (category in categories!!) {
                            productsRepository.upsertCategory(category)
                        }

                        _categoriesState.update {
                            it.copy(isLoadingCategories = false, categoriesErrorMessage = null)
                        }
                    } else {
                        //api returned error
                        val errorMessage = response.body()?.message ?: "Unknown API error"

                        _categoriesState.update {
                            it.copy(
                                isLoadingCategories = false,
                                categoriesErrorMessage = errorMessage
                            )
                        }
                    }

                } else {
                    val httpErrorCode = response.code()
                    val httpErrorMessage = response.message()
                    val errorMessage = "Error $httpErrorCode: $httpErrorMessage"

                    _categoriesState.update {
                        it.copy(isLoadingCategories = false, categoriesErrorMessage = errorMessage)
                    }
                }

            }
        }
    }
}