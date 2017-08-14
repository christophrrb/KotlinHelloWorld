package com.example.christophrrb.kotlinhelloworld;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by christophrrb on 8/9/17.
 */

public class FrutasVerdurasAdapter extends ArrayAdapter<String> {
    Context myContext;
    int myLayoutResourceID;
    FrutasVerduras mydata[] = null;

    public FrutasVerdurasAdapter(Context context, String[] data) {
        super(context, R.layout.listview_item_row, data);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater customLayoutInflater = LayoutInflater.from(getContext());
        View customView = customLayoutInflater.inflate(R.layout.listview_item_row, parent, false);

        String singleFoodItem = getItem(position);
        TextView itemText = (TextView) customView.findViewById(R.id.textViewPersonalized);
        ImageView buckysImage = (ImageView) customView.findViewById(R.id.imageViewPersonalized);

        itemText.setText(singleFoodItem);
        buckysImage.setImageResource(R.mipmap.ic_launcher_round);

        return customView;
    }

    static class FrutasVerdurasHolder{
        ImageView imagen;
        TextView textView;
    }
}