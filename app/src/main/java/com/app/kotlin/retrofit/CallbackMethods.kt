package com.app.kotlin.retrofit

import com.app.kotlin.pojo.Model

/**
 * Created by MY PC on 28-Aug-17.
 */

interface CallbackMethods {
    fun onFetchStart()
    fun onFetchProgress(model: Model)
    fun onFetchComplete(i: Int)
    fun onFetchFailed()
}
