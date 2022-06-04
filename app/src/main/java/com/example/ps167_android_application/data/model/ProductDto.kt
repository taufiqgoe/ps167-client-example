package com.example.ps167_android_application.data.model

import java.io.Serializable

data class ProductDto(
    val id: String? = null,
    val name: String? = null,
    val createdAt: Long? = null,
    val updatedAt: Long? = null,
    val nutritionFact: NutritionFactDto? = null
) : Serializable {
    data class NutritionFactDto(
        val calories: Int? = null,
        val totalFat: Int? = null,
        val saturatedFat: Int? = null,
        val protein: Int? = null,
        val totalCarbohydrate: Int? = null,
        val sugar: Int? = null,
        val sodium: Int? = null,
        val servingSize: Int? = null
    ) : Serializable
}