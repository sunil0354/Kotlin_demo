package com.app.kotlin.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.app.kotlin.R

class DemoFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_, container, false)
        initView(view)
        return view
    }

    private fun initView(view: View) {
        val textView=view.findViewById(R.id.textView)!! as TextView
    }
}
