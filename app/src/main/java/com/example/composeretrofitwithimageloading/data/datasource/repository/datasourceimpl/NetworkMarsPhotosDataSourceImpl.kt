package com.example.composeretrofitwithimageloading.data.datasource.repository.datasourceimpl

import com.example.composeretrofitwithimageloading.data.DataSource
import com.example.composeretrofitwithimageloading.data.api.MarsApiService
import com.example.composeretrofitwithimageloading.data.datasource.repository.datasource.NetworkMarsPhotosDataSource
import com.example.composeretrofitwithimageloading.data.model.MarsItem
import javax.inject.Inject

class NetworkMarsPhotosDataSourceImpl @Inject constructor(
    private val marsApiService: MarsApiService
): NetworkMarsPhotosDataSource {
    override suspend fun getPhotos(): List<MarsItem> {
        return marsApiService.getPhotos()
    }
}