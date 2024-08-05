package com.example.composeretrofitwithimageloading.data.api

import com.example.composeretrofitwithimageloading.data.model.MarsItem
import retrofit2.http.GET

interface MarsApiService {
    @GET("photos")
    suspend fun getPhotos(): List<MarsItem>
}