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
import java.sql.ResultSet

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val intent: Intent? = getIntent();
        if (intent!!.extras != null) {
            var bundle: Bundle = intent.extras;
            textView2.text = bundle.get("dato").toString() ?: "Couldn't receive text from previous activity.";
        } else {
            textView.text = resources.getString(R.string.no_bundle_text);
        }



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

        //Dialog Box Code
        button5.setOnClickListener {
            alert("Thank God I finally figured out how to use these things.", "Yay!") {
                positiveButton("Cool Bro") {  }
                negativeButton("Interesting") {  }
            }.show()
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

        //Checkbox Code
        val drivingString:String = resources.getString(R.string.driving);
        val busString:String = resources.getString(R.string.bus);
        val walkingString:String = resources.getString(R.string.walking);
        
        booleanChecked.setOnClickListener {
            var booleanResult: StringBuffer = StringBuffer();
            booleanResult.append("$drivingString: ").append(driving.isChecked).append("\n");
            booleanResult.append("$busString: ").append(bus.isChecked).append("\n");
            booleanResult.append("$walkingString: ").append(walking.isChecked);
            toast(booleanResult);
        }
        
        textChecked.setOnClickListener {
            var textResult: StringBuffer = StringBuffer();

            if (driving.isChecked) {
                textResult.append(drivingString);
            }

            if (bus.isChecked) {
                textResult.append("\n $busString");
            }

            if (walking.isChecked) {
                textResult.append("\n $walkingString");
            }

            toast(textResult);
        }

        //Autocomplete Code
        val states:Array<String> = arrayOf("Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachussetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Mexico", "New Jersey", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming");

        val arrayAdapter2 = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, states);
        autoCompleteTextView.setAdapter(arrayAdapter2); //No property access syntax for this.
        // autoCompleteTextView.threshold = 3; This would limit the suggestions to only appear after three characters have been typed.

        //To CameraActivity
        toCameraActivity.setOnClickListener {
            startActivity<CameraActivity>();
        }
    }
}
