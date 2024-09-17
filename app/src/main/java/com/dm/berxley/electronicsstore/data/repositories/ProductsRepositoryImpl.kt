package com.dm.berxley.electronicsstore.data.repositories

import com.dm.berxley.electronicsstore.data.local.StoreDao
import com.dm.berxley.electronicsstore.data.remote.ShopApi
import com.dm.berxley.electronicsstore.data.remote.dto.CategoriesDto
import com.dm.berxley.electronicsstore.data.remote.dto.ProductsDto
import com.dm.berxley.electronicsstore.domain.models.Category
import com.dm.berxley.electronicsstore.domain.models.Product
import com.dm.berxley.electronicsstore.domain.models.User
import com.dm.berxley.electronicsstore.domain.repositories.ProductsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private val shopApi: ShopApi,
    private val storeDao: StoreDao
) : ProductsRepository {
    override suspend fun getProductCategories(): Flow<Response<CategoriesDto>> {
        return flow {
            val categoriesResponse = shopApi.getCategories(accessToken = "Random access token here")
            emit(categoriesResponse)
            return@flow
        }
    }

    override suspend fun getProductsInCategory(categoryId: Int): Flow<Response<ProductsDto>> {
        return flow {
            val products = shopApi.getProducts(
                accessToken = "Random access token here",
                //categoryId = categoryId //we won't pass the ID because we are using a dummy API that does not accept dynamic paths
            )
            emit(products)
            return@flow
        }
    }

    override suspend fun upsertCategory(category: Category) {
        storeDao.upsertCategory(category)
    }

    override suspend fun deleteCategory(category: Category) {
        storeDao.deleteCategory(category)
    }

    override fun getCategories(): Flow<List<Category>> {
        return storeDao.getCategories()
    }

    override suspend fun getCategoryById(id: Int): Category {
        return storeDao.getCategoryById(id)
    }

    override suspend fun upsertProduct(product: Product) {
        storeDao.upsertProduct(product)
    }

    override suspend fun deleteProduct(product: Product) {
       storeDao.deleteProduct(product)
    }

    override suspend fun roomGetProductsInCategory(categoryId: Int): Flow<List<Product>> {
        return storeDao.getProducts(categoryId)
    }

    override suspend fun upsertUser(user: User) {
        storeDao.upsertUser(user)
    }

    override suspend fun deleteUser(user: User) {
        storeDao.deleteUser(user)
    }

    override fun getUser(): Flow<User> {
        return storeDao.getUser()
    }
}