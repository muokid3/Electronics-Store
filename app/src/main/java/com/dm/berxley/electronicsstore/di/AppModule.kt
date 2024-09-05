package com.dm.berxley.electronicsstore.di

import android.app.Application
import com.dm.berxley.electronicsstore.data.sharedprefs.LocalUserManagerImpl
import com.dm.berxley.electronicsstore.domain.sharedprefs.LocalUserManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(application: Application): LocalUserManager =
        LocalUserManagerImpl(application)

}