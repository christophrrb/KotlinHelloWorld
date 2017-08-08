package com.example.christophrrb.kotlinhelloworld

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.app.Activity
import android.content.Intent
import android.widget.RadioGroup
import com.example.christophrrb.kotlinhelloworld.R
import kotlinx.android.synthetic.main.activity_second.*
import org.jetbrains.anko.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val intent: Intent = getIntent();
        var bundle: Bundle = intent.getExtras();

        textView2.text = bundle.get("dato").toString() ?: "Couldn't receive text from previous activity.";

//        radioGroup.setOnCheckedChangeListener(object: RadioGroup.OnCheckedChangeListener() {
//          fun onCheckedChange(group: RadioGroup, checkedId: Int) {
//              if (checkedId == 1) {
//                toast("Bananas!");
//              } else if (checkedId == 2){
//                    toast("Pears!");
//              } else {
//                    toast("Mangoes!");
//              }
//          }
//        })

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            button5.setEnabled(true);
            if (checkedId == R.id.bananas)  {
                toast("Bananas!");
            } else if (checkedId == R.id.pears){
                toast("Pears!");
            } else {
                toast("Mangoes!")
            }
        }

        button5.setOnClickListener {
            toast("I don't do anything yet. \uD83D\uDE42");
        }
    }
}