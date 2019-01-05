package com.example.android.rajhackathon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.android.rajhackathon.R;

import java.util.ArrayList;

public class Citi_Adapter extends ArrayAdapter<Citi_Item> {

    public Citi_Adapter(Context context, ArrayList<Citi_Item> items) {
        super(context, 0, items);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.citi_item, parent, false);
        }
        Citi_Item currentItem;
        currentItem = getItem(position);
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.titleName);
        titleTextView.setText(currentItem.getTitle());
        TextView detailsTextView = (TextView) listItemView.findViewById(R.id.details);
        detailsTextView.setText(currentItem.getDetails());
        RelativeLayout imageView = (RelativeLayout) listItemView.findViewById(R.id.img);
        imageView.setBackgroundResource(currentItem.getImageResourceId());
        imageView.setVisibility(View.VISIBLE);

        return listItemView;
    }

}
