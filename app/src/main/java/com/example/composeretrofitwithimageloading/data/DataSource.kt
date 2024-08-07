package com.example.composeretrofitwithimageloading.data

object DataSource {
<<<<<<< HEAD
    const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"
=======
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

>>>>>>> parent of 1409df9 (Fixing Dependency Injection using Hilt)
}