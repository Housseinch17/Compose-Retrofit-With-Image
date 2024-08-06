package com.example.composeretrofitwithimageloading.data.di

import com.example.composeretrofitwithimageloading.data.api.MarsApiService
import com.example.composeretrofitwithimageloading.data.datasource.repository.datasource.NetworkMarsPhotosDataSource
import com.example.composeretrofitwithimageloading.data.datasource.repository.datasourceimpl.NetworkMarsPhotosDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkMarsPhotosDependency {

    @Singleton
    @Provides
    fun provideNetworkMarsPhotosDependency(marsApiService: MarsApiService): NetworkMarsPhotosDataSource{
        return NetworkMarsPhotosDataSourceImpl(marsApiService)
    }
}