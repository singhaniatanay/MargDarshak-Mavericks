package com.example.android.rajhackathon;

public class Review_Item {

    private String mDetails;
    private String mTitle;
    private float mRating;


    public Review_Item(String details, String title,float rating) {
        mDetails = details;
        mTitle = title;

        mRating = rating;

    }

    public String getDetails() {
        return mDetails;
    }
    public String getTitle() {
        return mTitle;
    }

    public float getRating() {
        return mRating;
    }


}
