package com.example.christophrrb.kotlinhelloworld

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.app.Activity
import android.content.Intent
import com.example.christophrrb.kotlinhelloworld.R
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val intent: Intent = getIntent();
        var bundle: Bundle = intent.getExtras();

        textView2.text = bundle.get("dato").toString() ?: "Couldn't receive text from previous activity."
    }
}
