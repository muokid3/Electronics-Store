package com.dm.berxley.electronicsstore.di

import android.app.Application
import com.dm.berxley.electronicsstore.data.remote.ShopApi
import com.dm.berxley.electronicsstore.data.sharedprefs.LocalUserManagerImpl
import com.dm.berxley.electronicsstore.domain.sharedprefs.LocalUserManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    private val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

    @Provides
    @Singleton
    fun provideLocalUserManager(application: Application): LocalUserManager = LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun provideShopApi(): ShopApi{
        return Retrofit.Builder()
            .baseUrl(ShopApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(ShopApi::class.java)
    }

}