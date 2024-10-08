package com.dm.berxley.electronicsstore.domain.sharedprefs

import kotlinx.coroutines.flow.Flow


interface LocalUserManager {
    suspend fun saveIsLoggedIn(isLoggedIn: Boolean)
    fun readIsLoggedIn(): Flow<Boolean>
}