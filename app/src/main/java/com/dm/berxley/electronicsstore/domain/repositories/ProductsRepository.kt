package com.dm.berxley.electronicsstore.domain.repositories

import com.dm.berxley.electronicsstore.data.remote.dto.CategoriesDto
import com.dm.berxley.electronicsstore.data.remote.dto.ProductsDto
import com.dm.berxley.electronicsstore.domain.models.Category
import com.dm.berxley.electronicsstore.domain.models.Product
import com.dm.berxley.electronicsstore.domain.models.User
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface ProductsRepository {
    //Remote API
    suspend fun getProductCategories(): Flow<Response<CategoriesDto>>
    suspend fun getProductsInCategory(categoryId: Int): Flow<Response<ProductsDto>>



    //Local Room DB
    suspend fun upsertCategory(category: Category)
    suspend fun deleteCategory(category: Category)
    fun getCategories(): Flow<List<Category>>
    suspend fun upsertProduct(product: Product)
    suspend fun deleteProduct(product: Product)
    fun roomGetProductsInCategory(categoryId: Int): Flow<List<Product>>

    suspend fun upsertUser(user: User)
    suspend fun deleteUser(user: User)
    fun getUser(): Flow<User>


}