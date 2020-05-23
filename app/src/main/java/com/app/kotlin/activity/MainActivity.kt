package com.app.kotlin.activity

import android.os.Bundle
import android.util.Log
import com.app.kotlin.R
import com.app.kotlin.adapter.Adapter
import com.app.kotlin.controller.Controller
import com.app.kotlin.pojo.Model
import com.app.kotlin.retrofit.ApiClient
import com.app.kotlin.retrofit.ApiInterface
import com.app.kotlin.retrofit.CallbackMethods
import com.app.kotlin.utils.BaseActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.collections.ArrayList

class MainActivity : BaseActivity(), CallbackMethods {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hitApi()
    }

    private fun hitApi() {
        val controller=Controller(this,this)
    }

    override fun onFetchStart() {
        TODO("Not yet implemented")
    }

    override fun onFetchProgress(model: Model) {
        TODO("Not yet implemented")
    }

    override fun onFetchComplete(i: Int) {
        TODO("Not yet implemented")
    }

    override fun onFetchFailed() {
        TODO("Not yet implemented")
    }
}
