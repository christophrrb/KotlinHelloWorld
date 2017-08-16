package com.example.christophrrb.kotlinhelloworld

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by christophrrb on 8/16/17.
 */
class fragmentB : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var rootView = inflater!!.inflate(R.layout.fragmentb, container, false);

        return rootView;
    }
}