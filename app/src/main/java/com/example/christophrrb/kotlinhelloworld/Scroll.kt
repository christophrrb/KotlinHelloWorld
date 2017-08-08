package com.example.christophrrb.kotlinhelloworld

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_scroll.*

class Scroll : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll)

        val listItems = ArrayList<String>()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        listView.setAdapter(adapter)

//        var text = ArrayList<String>();
//
//        var arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, text);
//        listView.adapter = arrayAdapter;


        fun addToList() {
            listItems.add(editText.text.toString());
            adapter.notifyDataSetChanged();
        }

        button8.setOnClickListener {
            addToList();
        }

        editText.setOnClickListener {
            addToList();
        }
        }
}
