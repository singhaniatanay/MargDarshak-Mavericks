package com.example.android.rajhackathon;

public class Guide_Item {

    private String mName;
    private String mSex;
    private String mPh;
    private String mEmail;
    private String mCiti;


    public Guide_Item(String name, String sex,String ph,String email,String citi) {
        mName = name;
        mSex = sex;
        mPh = ph;
        mEmail = email;
        mCiti = citi;

    }

    public String getmName() {
        return mName;
    }
    public String getmSex() {
        return mSex;
    }

    public String getmPh() {
        return mPh;
    }
    public String getmEmail(){
        return mEmail;
    }
    public String getmCiti(){
        return mCiti;
    }


}
