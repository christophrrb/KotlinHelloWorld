package com.example.christophrrb.kotlinhelloworld

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListAdapter
import kotlinx.android.synthetic.main.activity_personalized_list_view.*
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.list_header_row.view.*
import android.widget.Toast
import org.jetbrains.anko.*


class PersonalizedListView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personalized_list_view)

        var foods: Array<String> = arrayOf("Pizza", "Chicken", "Smoked Salmon", "Brie Tart", "Pumpkin", "Spascketti");

        var header = R.layout.list_header_row;
        var customListAdapter = FrutasVerdurasAdapter(this, foods);
        listViewPersonalized.adapter = customListAdapter;

        listViewPersonalized.setOnItemClickListener { adapterView, view, i, l ->
            var listItem = listViewPersonalized.getItemAtPosition(i).toString();
            toast(listItem);
        }
    }
}
