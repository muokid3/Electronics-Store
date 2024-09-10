package com.dm.berxley.electronicsstore.data.repositories

import com.dm.berxley.electronicsstore.data.remote.ShopApi
import com.dm.berxley.electronicsstore.data.remote.dto.LoginDto
import com.dm.berxley.electronicsstore.data.remote.dto.RegisterDto
import com.dm.berxley.electronicsstore.domain.models.payloads.LoginPayload
import com.dm.berxley.electronicsstore.domain.repositories.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val shopApi: ShopApi
): AuthRepository {
    override suspend fun login(email: String, password: String): Flow<Response<LoginDto>> {
        return flow {
            val loginPayload = LoginPayload(
                email = email,
                password = password
            )
            val responseFromApi = shopApi.login(loginPayload)

            emit(responseFromApi)
            return@flow
        }
    }

    override suspend fun register(
        email: String,
        name: String,
        phone_no: String,
        password: String
    ): Flow<Response<RegisterDto>> {
        TODO("Not yet implemented")
    }
}