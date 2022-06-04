package com.example.ps167_android_application.data.model

data class WebResponse<T>(
    val code: Int,
    val status: String,
    val data: T
)