package com.dm.berxley.electronicsstore.domain.sharedprefs

import kotlinx.coroutines.flow.Flow


interface LocalUserManager {
    suspend fun saveWelcomeScreenDone()
    fun readWelcomeScreenDone(): Flow<Boolean>
}