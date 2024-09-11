package com.dm.berxley.electronicsstore.domain.repositories

import com.dm.berxley.electronicsstore.data.remote.dto.CategoriesDto
import com.dm.berxley.electronicsstore.data.remote.dto.ProductsDto
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface ProductsRepository {
    suspend fun getProductCategories(): Flow<Response<CategoriesDto>>
    suspend fun getProductsInCategory(categoryId: Int): Flow<Response<ProductsDto>>
}