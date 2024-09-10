package com.dm.berxley.electronicsstore.data.remote

import com.dm.berxley.electronicsstore.data.remote.dto.CategoriesDto
import com.dm.berxley.electronicsstore.data.remote.dto.LoginDto
import com.dm.berxley.electronicsstore.data.remote.dto.ProductsDto
import com.dm.berxley.electronicsstore.domain.models.payloads.LoginPayload
import com.dm.berxley.electronicsstore.domain.models.payloads.RegisterPayload
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface ShopApi {

    @Headers("Content-Type: application/json")
    @GET("categories")
    suspend fun getCategories(@Header("Authorization") accessToken: String): CategoriesDto

    @Headers("Content-Type: application/json")
    @GET("products")
    suspend fun getProducts(@Header("Authorization") accessToken: String): ProductsDto

    @POST("login")
    suspend fun login(
        @Body loginPayload: LoginPayload
    ): LoginDto


    @POST("register")
    suspend fun register(
        @Body registerPayload: RegisterPayload
    ): LoginDto


    companion object {
        const val BASE_URL = "https://latech.free.beeceptor.com/"
    }
}