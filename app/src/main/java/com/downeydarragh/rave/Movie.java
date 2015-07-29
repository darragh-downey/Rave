package com.downeydarragh.rave;

/**
 * Created by Darragh on 29/07/2015.
 */
public class Movie {
    private String mTitle;
    private int mPosterId;
    private String mDescription;

    public Movie(String title, int posterid, String description){
        mTitle = title;
        mPosterId = posterid;
        mDescription = description;
    }

    public String getTitle(){
        return mTitle;
    }

    public int getPosterId(){
        return mPosterId;
    }

    public String getDescription(){
        return mDescription;
    }
}
