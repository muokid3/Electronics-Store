package com.dm.berxley.electronicsstore.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dm.berxley.electronicsstore.domain.repositories.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val productsRepository: ProductsRepository
) : ViewModel() {

    private val _homeState = MutableStateFlow(HomeState())
    val homeState = _homeState.asStateFlow()

    init {
        _homeState.update {
            it.copy(isLoadingCategories = true)
        }
        loadCategories()
    }

    private fun loadCategories() {
        viewModelScope.launch {
            productsRepository.getProductCategories().collectLatest { response ->
                if (response.isSuccessful){

                    if (response.body()?.success == true){
                        val categories = response.body()?.categories

                        //TODO persist categories to Room DB

                        _homeState.update {
                            it.copy(isLoadingCategories = false, categoriesErrorMessage = null, categoriesList = categories!!)
                        }
                    }else{
                        //api returned error
                        val errorMessage = response.body()?.message ?: "Unknown API error"

                        _homeState.update {
                            it.copy(isLoadingCategories = false, categoriesErrorMessage = errorMessage)
                        }
                    }

                }else{
                    val httpErrorCode = response.code()
                    val httpErrorMessage = response.message()
                    val errorMessage = "Error $httpErrorCode: $httpErrorMessage"

                    _homeState.update {
                        it.copy(isLoadingCategories = false, categoriesErrorMessage = errorMessage)
                    }
                }
            }
        }
    }

}