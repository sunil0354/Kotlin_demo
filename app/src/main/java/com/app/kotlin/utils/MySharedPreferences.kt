package com.app.kotlin.utils

import android.app.Application
import android.arch.core.BuildConfig
import android.content.Context
import android.content.SharedPreferences

class MySharedPreferences : Application {

    val uuid: String
        get() {
            if (mSharedPreferences != null) {
                mSharedPreferences!!.getString("1", "")
            }
            return ""
        }

    val name: String
        get() {
            if (mSharedPreferences != null) {
                mSharedPreferences!!.getString("1", "")
            }
            return ""
        }

    val email: String
        get() {
            if (mSharedPreferences != null) {
                mSharedPreferences!!.getString("1", "")
            }
            return ""
        }

    override fun onCreate() {
        super.onCreate()
        mySharedPreferences = MySharedPreferences(applicationContext)
    }

    constructor() {}

    constructor(context: Context) {
        mSharedPreferences = context.getSharedPreferences(mySharedPrefrences, Context.MODE_PRIVATE)
    }

    fun saveUserId(uuid: String, name: String, email: String) {
        mEditor = mSharedPreferences!!.edit()
        mEditor!!.putString("", uuid)
        mEditor!!.apply()
    }

    fun clearAllData(context: Context) {
        mEditor = mSharedPreferences!!.edit()
        mEditor!!.clear().apply()
    }

    fun removeData(context: Context) {
        mEditor = mSharedPreferences!!.edit()
        //        mEditor.remove(ConstantsKey.UUID);
        mEditor!!.apply()
    }

    companion object {
        private val mySharedPrefrences = BuildConfig.APPLICATION_ID
        private var mSharedPreferences: SharedPreferences? = null
        private var mEditor: SharedPreferences.Editor? = null
        var mySharedPreferences: MySharedPreferences? = null
    }
}

