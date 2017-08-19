package com.example.christophrrb.kotlinhelloworld

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragmenta.*
import kotlinx.android.synthetic.main.fragmentb.*

/**
 * Created by christophrrb on 8/16/17.
 */
class fragmentA : Fragment() {
    lateinit var sm: SendMessage;

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var rootView = inflater!!.inflate(R.layout.fragmenta, container, false);

        inputButton.setOnClickListener {
            var data = input.text.toString();
            sm.sendMessage(data);
        }

        //Default: return super.onCreateView(inflater, container, savedInstanceState)
        return rootView;
    }
}