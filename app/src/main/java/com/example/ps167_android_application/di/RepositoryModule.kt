package com.example.ps167_android_application.di

import com.example.ps167_android_application.api.ProductService
import com.example.ps167_android_application.data.repository.ProductRepository
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
    fun provideProductRepository(api: ProductService): ProductRepository = ProductRepository(api)

}
