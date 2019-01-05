package com.example.android.rajhackathon;

public class Citi_Item {
    private int mImgRid = -1;
    private String mDetails;
    private String mTitle;


    public Citi_Item(String details, String title, int imageResourceId) {
        mDetails = details;
        mTitle = title;
        mImgRid = imageResourceId;

    }

    public String getDetails() {
        return mDetails;
    }
    public String getTitle() {
        return mTitle;
    }
    public int getImageResourceId() {
        return mImgRid;
    }


}
