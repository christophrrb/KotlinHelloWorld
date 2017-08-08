package com.example.christophrrb.kotlinhelloworld

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.app.Activity
import android.content.Intent
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
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

        //RadioGroup Code
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

        //Spinner Code
        val list = ArrayList<String>();
        list.add("Ford");
        list.add("Chevrolet");
        list.add("Dodge");
        list.add("Range Rover");
        list.add("Lexus");
        list.add("Tesla");
        list.add("BMW");
        list.add("Honda");
        list.add("Toyota");

        var showSelectedItem: Boolean = false;

        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.adapter = arrayAdapter;

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
                if (showSelectedItem) {
                    toast(spinner.selectedItem.toString());
                } else {
                    showSelectedItem = true;
                }
            }

            override fun onNothingSelected(parent: AdapterView<out Adapter>?) {

            }

        }

        //Switch Button
        switch1.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                switch1.text = resources.getString(R.string.grinning_face_with_smiling_eyes);
            } else {
                switch1.text = resources.getString(R.string.crying_face);
            }
        }

        button6.setOnClickListener {
            startActivity<Scroll>();
        }

        }
    }
