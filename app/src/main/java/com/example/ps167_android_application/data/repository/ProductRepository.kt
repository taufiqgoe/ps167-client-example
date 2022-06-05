package com.example.ps167_android_application.data.repository

import com.example.ps167_android_application.data.model.GeneralResponse
import com.example.ps167_android_application.data.model.ProductDto
import io.reactivex.Flowable

interface ProductRepository {

    fun getProduct(
        id: String
    ): Flowable<GeneralResponse<ProductDto>>

    fun getProductByName(
        name: String,
        page: Int? = 1,
        size: Int? = 10
    ): Flowable<GeneralResponse<List<ProductDto>>>

}