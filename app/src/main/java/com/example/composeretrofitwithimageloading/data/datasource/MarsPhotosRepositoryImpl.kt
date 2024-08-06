package com.example.composeretrofitwithimageloading.data.datasource

import com.example.composeretrofitwithimageloading.data.datasource.repository.datasourceimpl.NetworkMarsPhotosDataSourceImpl
import com.example.composeretrofitwithimageloading.data.model.MarsItem
import com.example.composeretrofitwithimageloading.domain.repository.MarsPhotosRepository
import javax.inject.Inject

class MarsPhotosRepositoryImpl @Inject constructor(
    private val networkMarsPhotosDataSourceImpl: NetworkMarsPhotosDataSourceImpl
): MarsPhotosRepository {
    override suspend fun getMarsPhotos(): List<MarsItem> {
        return networkMarsPhotosDataSourceImpl.getPhotos()
    }
}