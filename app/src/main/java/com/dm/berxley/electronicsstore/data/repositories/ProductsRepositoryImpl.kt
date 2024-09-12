package com.dm.berxley.electronicsstore.data.repositories

import com.dm.berxley.electronicsstore.data.remote.ShopApi
import com.dm.berxley.electronicsstore.data.remote.dto.CategoriesDto
import com.dm.berxley.electronicsstore.data.remote.dto.ProductsDto
import com.dm.berxley.electronicsstore.domain.repositories.ProductsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private val shopApi: ShopApi
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
}