package com.example.composeretrofitwithimageloading.data.datasource.repository.datasource

import com.example.composeretrofitwithimageloading.data.model.MarsItem

interface NetworkMarsPhotosDataSource {
    suspend fun getPhotos() : List<MarsItem>
}