package com.example.ps167_android_application.di

import com.example.ps167_android_application.api.ProductService
import com.example.ps167_android_application.util.ApiUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providerRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(ApiUtil.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideProductApi(retrofit: Retrofit): ProductService = retrofit.create(ProductService::class.java)

}
