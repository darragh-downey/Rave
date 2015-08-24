package com.downeydarragh.rave;

import android.net.Uri;

/**
 * Created by Darragh on 29/07/2015.
 */
public class Movie {
    private double averageVote;
    private String posterPath;
    private String releaseDate;
    private String title;
    private String synopsis;
    private String posterURI;
    private int id;
    private double popularity;
    private String screenWidth;

    public Movie() {

    }

    public void setAverageVote(double averageVote) {
        this.averageVote = averageVote;
    }

    public double getAverageVote() {
        return averageVote;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public double getPopularity() {
        return popularity;
    }


    public String getPosterURI() {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("http")
                .authority("image.tmdb.org")
                .appendPath("t").appendPath("p")
                .appendPath("w185").appendEncodedPath(getPosterPath());
        return builder.build().toString();
    }

    public void setScreenWidth(String screenWidth) {
        this.screenWidth = screenWidth;
    }

    public String getScreenWidth(){
        return screenWidth;
    }


}