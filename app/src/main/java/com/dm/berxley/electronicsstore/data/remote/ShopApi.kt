package com.dm.berxley.electronicsstore.data.remote

import com.dm.berxley.electronicsstore.data.remote.dto.CategoriesDto
import com.dm.berxley.electronicsstore.data.remote.dto.LoginDto
import com.dm.berxley.electronicsstore.data.remote.dto.ProductsDto
import com.dm.berxley.electronicsstore.data.remote.dto.RegisterDto
import com.dm.berxley.electronicsstore.domain.models.payloads.LoginPayload
import com.dm.berxley.electronicsstore.domain.models.payloads.RegisterPayload
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface ShopApi {

    @Headers("Content-Type: application/json")
    @GET("fbd089f5-3f2b-4798-b792-27a23130a32c")
    suspend fun getCategories(@Header("Authorization") accessToken: String): Response<CategoriesDto>

    @Headers("Content-Type: application/json")
    //@GET("products/{id}") //in a real api, retrofit will override this id
    @GET("12098de9-a0ce-4815-a551-454f61f7b959") //this calls a dummy api that can not take dynamic paths
    suspend fun getProducts(
        @Header("Authorization") accessToken: String,
        //@Path("id") categoryId: Int // in a real api, we will get the passed ID here
    ): Response<ProductsDto>

    @Headers("Content-Type: application/json")
    @POST("9c0aed70-f84c-4b1e-8e11-4fff5d1057cc")
    suspend fun login(@Body loginPayload: LoginPayload): Response<LoginDto>

    @Headers("Content-Type: application/json")
    @POST("a5760c85-d342-4c17-abdd-a56e6532bb57")
    suspend fun register(@Body registerPayload: RegisterPayload): Response<RegisterDto>

    companion object {
        const val BASE_URL = "https://run.mocky.io/v3/"
    }
}