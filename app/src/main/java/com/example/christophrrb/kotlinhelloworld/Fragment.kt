package com.example.christophrrb.kotlinhelloworld

import android.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class Fragment : AppCompatActivity(), SendMessage {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
    }

    override fun sendMessage(message: String) {

    }

//    override fun onAttachFragment(fragment: Fragment?) {
//        super.onAttachFragment(fragment)
//    }()
}
