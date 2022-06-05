package com.example.ps167_android_application.data.model

data class GeneralResponse<T>(
    val status: String?,
    val data: T?
)