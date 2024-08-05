package com.example.composeretrofitwithimageloading.domain.repository

import com.example.composeretrofitwithimageloading.data.model.MarsItem

interface MarsPhotosRepository {
    suspend fun getMarsPhotos(): List<MarsItem>
}