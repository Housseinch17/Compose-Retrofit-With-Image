package com.example.composeretrofitwithimageloading.data

import com.example.composeretrofitwithimageloading.data.api.MarsApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

object DataSource {
    private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"

    /*//without serialization
    val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()
    */

    //with serialization
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

    val marsApiRetrofit: MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }

}