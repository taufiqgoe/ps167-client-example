package com.example.ps167_android_application.api

import com.example.ps167_android_application.BuildConfig
import com.example.ps167_android_application.data.model.GeneralResponse
import com.example.ps167_android_application.data.model.ProductDto
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductApiService {

    @GET("/api/p/{id}")
    @Headers("Content-Type: application/json", BuildConfig.PRODUCT_HTTP_SECRET_HEADER)
    fun getProduct(
        @Path("id") id: String
    ): Flowable<GeneralResponse<ProductDto>>

    @GET("/api/p")
    @Headers("Content-Type: application/json", BuildConfig.PRODUCT_HTTP_SECRET_HEADER)
    fun listByName(
        @Query(value = "name") name: String,
        @Query(value = "page") page: Int? = 0,
        @Query(value = "size") size: Int? = 10
    ): Flowable<GeneralResponse<List<ProductDto>>>

}