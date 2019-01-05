package com.example.android.rajhackathon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Review_Adapter extends ArrayAdapter<Review_Item> {

    public Review_Adapter(Context context, ArrayList<Review_Item> items) {
        super(context, 0, items);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.review_item, parent, false);
        }
        Review_Item currentItem;
        currentItem = getItem(position);
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.titleName);
        titleTextView.setText(currentItem.getTitle());
        TextView detailsTextView = (TextView) listItemView.findViewById(R.id.details);
        detailsTextView.setText(currentItem.getDetails());
        RatingBar rating = (RatingBar) listItemView.findViewById(R.id.rating);
        rating.setRating(currentItem.getRating());
        return listItemView;
    }

}
