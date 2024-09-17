package com.dm.berxley.electronicsstore.presentation.categoryItems

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dm.berxley.electronicsstore.domain.repositories.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryItemsViewModel @Inject constructor(
    private val productsRepository: ProductsRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val categoryId: Int = savedStateHandle.get("categoryId") ?: 0
    private val _categoryItemsState = MutableStateFlow(CategoryItemsState())
    val categoryItemsState = _categoryItemsState.asStateFlow()

    init {
        _categoryItemsState.update {
            it.copy(isLoadingProducts = true)
        }


        loadCategoryProductsFromApi(categoryId)

    }

    fun getCategory(){
        viewModelScope.launch(Dispatchers.IO) {
            val cat = productsRepository.getCategoryById(categoryId)
            _categoryItemsState.update {
                it.copy(selectedCategory = cat)
            }
        }
    }

    fun getProducts(){
        viewModelScope.launch(Dispatchers.IO) {
            productsRepository.roomGetProductsInCategory(categoryId).collectLatest { productsList ->
                _categoryItemsState.update {
                    it.copy(isLoadingProducts = false, selectedCategoryProducts = productsList)
                }
            }
        }
    }


    private fun loadCategoryProductsFromApi(categoryId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            productsRepository.getProductsInCategory(categoryId).collectLatest { response ->

                if (response.isSuccessful) {
                    if (response.body()?.success == true) {
                        val products = response.body()?.products

                        for (product in products!!) {
                            productsRepository.upsertProduct(product)
                        }

                        _categoryItemsState.update {
                            it.copy(productsErrorMessage = null)
                        }
                    } else {
                        //api returned error
                        val errorMessage = response.body()?.message ?: "Unknown API error"

                        _categoryItemsState.update {
                            it.copy(productsErrorMessage = errorMessage)
                        }
                    }


                } else {
                    val httpErrorCode = response.code()
                    val httpErrorMessage = response.message()
                    val errorMessage = "Error $httpErrorCode: $httpErrorMessage"

                    _categoryItemsState.update {
                        it.copy(productsErrorMessage = errorMessage)
                    }
                }

            }
        }
    }
}