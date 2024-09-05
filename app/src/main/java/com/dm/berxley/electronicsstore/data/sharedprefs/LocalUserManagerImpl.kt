package com.dm.berxley.electronicsstore.data.sharedprefs

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.dm.berxley.electronicsstore.Constants.LOCAL_USER_DB
import com.dm.berxley.electronicsstore.Constants.WELCOME_SCREEN_VIEWED
import com.dm.berxley.electronicsstore.domain.sharedprefs.LocalUserManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalUserManagerImpl(private val context: Context) : LocalUserManager {
    override suspend fun saveWelcomeScreenDone() {
        context.dataStore.edit { prefs ->
            prefs[SharedPrefsKeys.WELCOME_SCREEN_SHOWN] = true
        }
    }

    override fun readWelcomeScreenDone(): Flow<Boolean> {
        return context.dataStore.data.map { prefs ->
            prefs[SharedPrefsKeys.WELCOME_SCREEN_SHOWN] ?: false
        }
    }

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(LOCAL_USER_DB)

    private object SharedPrefsKeys {
        val WELCOME_SCREEN_SHOWN = booleanPreferencesKey(WELCOME_SCREEN_VIEWED)
    }
}