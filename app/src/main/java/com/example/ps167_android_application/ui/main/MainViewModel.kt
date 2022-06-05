package com.example.ps167_android_application.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.example.ps167_android_application.data.model.GeneralResponse
import com.example.ps167_android_application.data.model.ProductDto
import com.example.ps167_android_application.data.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    fun getProductById(id: String): LiveData<GeneralResponse<ProductDto>> {
        return LiveDataReactiveStreams.fromPublisher(productRepository.getProduct(id))
    }

    fun getProductByName(name: String, page: Int, size: Int): LiveData<GeneralResponse<List<ProductDto>>> {
        return LiveDataReactiveStreams.fromPublisher(productRepository.getProductByName(name, page, size))
    }
}