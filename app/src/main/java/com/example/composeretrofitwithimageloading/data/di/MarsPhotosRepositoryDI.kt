package com.example.composeretrofitwithimageloading.data.di
import com.example.composeretrofitwithimageloading.data.datasource.MarsPhotosRepositoryImpl
import com.example.composeretrofitwithimageloading.data.datasource.repository.datasourceimpl.NetworkMarsPhotosDataSourceImpl
import com.example.composeretrofitwithimageloading.domain.repository.MarsPhotosRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MarsPhotosRepositoryDI {

    @Singleton
    @Provides
    fun provideMarsPhotosRepository(networkMarsPhotosDataSourceImpl: NetworkMarsPhotosDataSourceImpl
    ): MarsPhotosRepository{
        return MarsPhotosRepositoryImpl(networkMarsPhotosDataSourceImpl)
    }

}