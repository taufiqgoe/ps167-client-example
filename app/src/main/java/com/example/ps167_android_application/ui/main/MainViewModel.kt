package com.example.ps167_android_application.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ps167_android_application.data.model.ProductDto
import com.example.ps167_android_application.data.model.WebResponse
import com.example.ps167_android_application.data.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    fun getProductById(id: String): MutableLiveData<WebResponse<ProductDto>> {
        val result = MutableLiveData<WebResponse<ProductDto>>()
        viewModelScope.launch {
            result.postValue(productRepository.getProduct(id))
        }
        return result
    }

}