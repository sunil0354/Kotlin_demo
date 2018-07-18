package com.app.kotlin.retrofit

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

 class ApiClient {
    private var BASE_URL: String = "https://jsonplaceholder.typicode.com/"
    private var retrofit: Retrofit?=null
    private val gson = GsonBuilder().setLenient().create()
    fun getClient(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
        }
        return retrofit
    }
}