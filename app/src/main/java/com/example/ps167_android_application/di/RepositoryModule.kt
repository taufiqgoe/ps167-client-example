package com.example.ps167_android_application.di

import com.example.ps167_android_application.api.ProductApiService
import com.example.ps167_android_application.data.repository.ProductRepository
import com.example.ps167_android_application.data.repository.impl.ProductRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideProductRepository(api: ProductApiService): ProductRepository = ProductRepositoryImpl(api)

}
