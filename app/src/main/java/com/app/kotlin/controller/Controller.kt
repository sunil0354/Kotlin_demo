package com.app.kotlin.controller

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.app.kotlin.adapter.Adapter
import com.app.kotlin.retrofit.ApiClient
import com.app.kotlin.retrofit.ApiInterface
import com.app.kotlin.retrofit.CallbackMethods
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * Created by MY PC on 01-Sep-17.
 */

class Controller(private val mCallbackMethods: CallbackMethods, private val mContext: Context) {

    fun get_sponosors(start: Int, count: Int) {
        mCallbackMethods.onFetchStart()
        val call = ApiClient().getClient()!!.create(ApiInterface::class.java)
        call.getHospitalsList().enqueue(
                object : Callback<Any> {
                    override fun onResponse(call: Call<Any>, response: Response<Any>) {
                        mCallbackMethods.onFetchComplete(1)
                    }
                    override fun onFailure(call: Call<Any>, t: Throwable) {
                        call.cancel()
                        Log.e("TAG", "Failure>>>\n: $t")
                        mCallbackMethods.onFetchFailed()
                    }
                })
    }
}
