package com.app.kotlin.activity

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.app.kotlin.R
import com.app.kotlin.adapter.Adapter
import com.app.kotlin.retrofit.ApiClient
import com.app.kotlin.retrofit.ApiInterface
import com.app.kotlin.utils.BaseActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.collections.ArrayList

class MainActivity : BaseActivity(){
    private var listCommnet = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        printlog(isInternetConnected().toString())
    }

    private fun hitApi() {
        val call = ApiClient().getClient()!!.create(ApiInterface::class.java)
        call.getHospitalsList().enqueue(
                object : Callback<Any> {
                    override fun onResponse(call: Call<Any>, response: Response<Any>) {
                        try {
                            val value=Gson().toJson(response.body())
                            Log.e("Tag","onResponse\n:${value}")
                            val jsonArray=JSONArray(value)
                            for (i in 0..(jsonArray.length()-1)){
                                val jsonObject=jsonArray.getJSONObject(i)
                                listCommnet.add(jsonObject.getString("title"))
                            }
                            rv_recycler.layoutManager = LinearLayoutManager(applicationContext)
                            rv_recycler.adapter = Adapter(listCommnet)
                        }catch (e:Exception){
                            call.cancel()
                            Log.e("TAG", "Exception>>>\n: ${e.toString()}")
                        }
                    }
                    override fun onFailure(call: Call<Any>, t: Throwable) {
                        call.cancel()
                        Log.e("TAG", "Failure>>>\n: $t")
                    }
                })
    }
}
