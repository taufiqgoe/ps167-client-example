package com.example.ps167_android_application.data.repository

import com.example.ps167_android_application.api.ProductService
import com.example.ps167_android_application.data.model.ProductDto
import com.example.ps167_android_application.data.model.WebResponse
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val api: ProductService,
) {

    suspend fun getProduct(id: String): WebResponse<ProductDto> {
        return api.getProduct(id)
    }

    suspend fun listByName(
        name: String,
        page: Int? = null,
        size: Int? = null
    ): WebResponse<List<ProductDto>> {
        return api.listByName(name, page, size)
    }

}