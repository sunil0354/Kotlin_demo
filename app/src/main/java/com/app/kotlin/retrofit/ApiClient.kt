package com.app.kotlin.retrofit

import com.app.kotlin.utils.Constants
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

 class ApiClient {
    private var retrofit: Retrofit?=null
    private val gson = GsonBuilder().setLenient().create()
    fun getClient(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
        }
        return retrofit
    }
}