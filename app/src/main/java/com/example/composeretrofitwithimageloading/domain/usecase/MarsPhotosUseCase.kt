package com.example.composeretrofitwithimageloading.domain.usecase

import com.example.composeretrofitwithimageloading.data.datasource.MarsPhotosRepositoryImpl
import com.example.composeretrofitwithimageloading.data.model.MarsItem
import javax.inject.Inject

class MarsPhotosUseCase @Inject constructor(
    private val marsPhotosRepositoryImpl: MarsPhotosRepositoryImpl
) {
    suspend fun execute(): List<MarsItem>{
        return marsPhotosRepositoryImpl.getMarsPhotos()
    }
}