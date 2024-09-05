package com.dm.berxley.electronicsstore.data.sharedprefs

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.dm.berxley.electronicsstore.Constants.LOCAL_USER_DB
import com.dm.berxley.electronicsstore.Constants.USER_IS_LOGGED_IN
import com.dm.berxley.electronicsstore.domain.sharedprefs.LocalUserManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalUserManagerImpl(private val context: Context) : LocalUserManager {
    override suspend fun saveIsLoggedIn(isLoggedIn: Boolean) {
        context.dataStore.edit { prefs ->
            prefs[SharedPrefsKeys.IS_LOGGED_IN] = isLoggedIn
        }
    }

    override fun readIsLoggedIn(): Flow<Boolean> {
        return context.dataStore.data.map { prefs ->
            prefs[SharedPrefsKeys.IS_LOGGED_IN] ?: false
        }
    }

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(LOCAL_USER_DB)

    private object SharedPrefsKeys {
        val IS_LOGGED_IN = booleanPreferencesKey(USER_IS_LOGGED_IN)
    }
}