package com.app.kotlin.retrofit

import retrofit2.Call
import retrofit2.http.*
import java.util.*

/**
 * Created by MY PC on 22-Jun-18.
 */
interface ApiInterface {
    @GET("posts")
    fun getHospitalsList(): Call<Any>
}