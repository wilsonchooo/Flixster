package com.example.flixster3.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Movie {
    String backdropPath;
    String posterPath;
    String title;
    String overview;
    double rating;
    String release_date;
    boolean adult;
    int movieId;

    //empty constructor for parcel
    public Movie()
    { }
    public Movie(JSONObject jsonObject) throws JSONException {
        posterPath = jsonObject.getString("poster_path");
        backdropPath=jsonObject.getString("backdrop_path");
        title=jsonObject.getString("title");
        overview = jsonObject.getString("overview");
        rating = jsonObject.getDouble("vote_average");
        release_date=jsonObject.getString("release_date");
        adult = jsonObject.getBoolean("adult");
        movieId=jsonObject.getInt("id");
    }

    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for(int i=0;i<movieJsonArray.length(); i++){
            movies.add(new Movie((movieJsonArray.getJSONObject(i))));
        }
        return movies;
    }


    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s",backdropPath);
    }

    public String getPosterPath() {

        return String.format("https://image.tmdb.org/t/p/w342/%s",posterPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public double getRating() {
        return rating;
    }

    public String getRelease_date() {
        return release_date;
    }

    public boolean isAdult() {
        return adult;
    }

    public int getMovieId() {
        return movieId;
    }
}
