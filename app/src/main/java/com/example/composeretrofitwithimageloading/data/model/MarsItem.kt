package com.example.composeretrofitwithimageloading.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MarsItem(
    val id: String,
    @SerialName("img_src")
    val image: String
)