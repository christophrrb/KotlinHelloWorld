package com.example.christophrrb.kotlinhelloworld

 import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.app.Activity
 import android.view.View
 import com.example.christophrrb.kotlinhelloworld.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun cambiarTexto(v: View) {
        if (miTexto.text != resources.getString(R.string.button1_text)) {
            miTexto.text = resources.getString(R.string.button1_text);
        } else {
            miTexto.text = resources.getString(R.string.hello_world);
        }
    }
}
