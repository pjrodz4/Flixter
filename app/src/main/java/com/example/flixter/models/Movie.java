package com.example.flixter.models;

import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

@Parcel // annotation indicates class is Parcelable
public class Movie  {

    // Strings must be public for parceler
    // values from API
    String title;
    String overview;
    String posterPath;
    String backdropPath;
    Double voteAverage;
    String releaseDate;
    Integer id;

    // no-arg, empty constructor required for Parceler
    public Movie() {}

    // initialize from JSON data
    public Movie(JSONObject object) throws JSONException {
        title = object.getString("title");
        overview = object.getString("overview");
        posterPath = object.getString("poster_path");
        backdropPath = object.getString("backdrop_path");
        voteAverage = object.getDouble("vote_average");
        releaseDate = object.getString("release_date");
        id = object.getInt("id");
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getBackdropPath() { return backdropPath; }

    public Double getVoteAverage() { return voteAverage; }

    public String getReleaseDate() { return releaseDate; }

    public Integer getId() { return id; }
}
