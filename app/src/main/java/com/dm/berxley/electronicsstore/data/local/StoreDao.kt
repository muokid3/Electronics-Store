package com.dm.berxley.electronicsstore.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.dm.berxley.electronicsstore.domain.models.Category
import com.dm.berxley.electronicsstore.domain.models.Product
import com.dm.berxley.electronicsstore.domain.models.User
import kotlinx.coroutines.flow.Flow

@Dao
interface StoreDao {

    @Upsert
    suspend fun upsertCategory(category: Category)
    @Delete
    suspend fun deleteCategory(category: Category)
    @Query("SELECT * FROM Category")
    fun getCategories(): Flow<List<Category>>

    @Upsert
    suspend fun upsertProduct(product: Product)
    @Delete
    suspend fun deleteProduct(product: Product)
    @Query("SELECT * FROM Product")
    fun getProducts(): Flow<List<Product>>

    @Upsert
    suspend fun upsertUser(user: User)
    @Delete
    suspend fun deleteUser(user: User)
    @Query("SELECT * FROM User LIMIT 1")
    fun getUser(): Flow<User>




}