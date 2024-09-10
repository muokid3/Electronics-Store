package com.dm.berxley.electronicsstore.domain.repositories

import com.dm.berxley.electronicsstore.data.remote.dto.LoginDto
import com.dm.berxley.electronicsstore.data.remote.dto.RegisterDto
import com.dm.berxley.electronicsstore.domain.models.User
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface AuthRepository {

    suspend fun login(email: String, password: String): Flow<Response<LoginDto>>
    suspend fun register(email: String, name: String, phone_no: String, password: String,): Flow<Response<RegisterDto>>
}