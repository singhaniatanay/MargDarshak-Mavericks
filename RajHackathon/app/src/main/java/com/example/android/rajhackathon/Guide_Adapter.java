package com.example.android.rajhackathon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class Guide_Adapter extends ArrayAdapter<Guide_Item> {

    public Guide_Adapter(Context context, ArrayList<Guide_Item> items) {
        super(context, 0, items);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.guide_item, parent, false);
        }
        Guide_Item currentItem;
        currentItem = getItem(position);
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.titleName);
        titleTextView.setText(currentItem.getmName());
        TextView detailsTextView = (TextView) listItemView.findViewById(R.id.details);
        detailsTextView.setText(currentItem.getmEmail());
        TextView phTextView = (TextView) listItemView.findViewById(R.id.ph);
        phTextView.setText(currentItem.getmPh());
        TextView sexTextView = (TextView) listItemView.findViewById(R.id.sex);
        sexTextView.setText(currentItem.getmSex());
        String citi = currentItem.getmCiti();
        String cities ="";
        if(citi.charAt(0)=='1')
            cities +="Jasalmer ,";
        if(citi.charAt(1)=='1')
            cities +="Jaipur ,";

        if(citi.charAt(2)=='1')
            cities +="Ajmer ,";

        if(citi.charAt(3)=='1')
            cities +="Udaipur ,";

        TextView citiTextView = (TextView) listItemView.findViewById(R.id.citi);
        citiTextView.setText(cities);
        return listItemView;
    }

}
