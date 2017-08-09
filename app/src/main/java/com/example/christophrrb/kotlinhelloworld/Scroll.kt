package com.example.christophrrb.kotlinhelloworld

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_scroll.*
import org.jetbrains.anko.toast
import android.widget.Toast



class Scroll : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll)

        val listItems = ArrayList<String>()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        listView.setAdapter(adapter)

        fun addToList() {
            if (editText.text.toString() != "") {
                listItems.add(editText.text.toString());
                adapter.notifyDataSetChanged();
                editText.setText("");
                listView.setSelection(adapter.getCount() - 1);
            } else {
                toast("Please enter text");
            }
        }


        button8.setOnClickListener {
            addToList();
        }

        //TODO have text enter on enter
        editText.isFocusableInTouchMode = true;
        editText.requestFocus();
        editText.setOnKeyListener { view, i, keyEvent ->
            if ((keyEvent.action == KeyEvent.ACTION_DOWN) && (keyEvent.action == KeyEvent.KEYCODE_ENTER)) {
                addToList();
                return@setOnKeyListener true
            }
            return@setOnKeyListener false
        }
    }
}