package com.example.flixter.activities;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.flixter.R;
import com.example.flixter.models.Movie;

import org.parceler.Parcels;

public class MovieDetailsActivity extends AppCompatActivity {

    // the movie to display
    Movie movie;

    // the view objects
    TextView tvTitle;
    TextView tvOverview;
    TextView tvReleaseDate;
    RatingBar rbVoteAverage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        // resolve view objects
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvOverview = (TextView) findViewById(R.id.tvOverview);
        tvReleaseDate = (TextView) findViewById(R.id.tvReleaseDate);
        rbVoteAverage = (RatingBar) findViewById(R.id.rbVoteAverage);
        // wrap the movie passed in via intent, using its simple name as a key
        movie = (Movie) Parcels.unwrap(getIntent().getParcelableExtra(Movie.class.getSimpleName()));
        Log.d("MovieDetailsActivity", String.format("Showing details for '%s'", movie.getTitle()));
        // set the title and overview
        tvTitle.setText(movie.getTitle());
        tvTitle.setTextColor(Color.WHITE);
        tvTitle.setTypeface(tvTitle.getTypeface(), Typeface.BOLD);

        tvReleaseDate.setText(movie.getReleaseDate());
        tvReleaseDate.setTextColor(Color.WHITE);

        tvOverview.setText(movie.getOverview());
        tvOverview.setTextColor(Color.WHITE);
        // vote average is 0..10, convert to 0..5 by dividing by 2
        float voteAverage = movie.getVoteAverage().floatValue();
        rbVoteAverage.setRating(voteAverage = voteAverage > 0 ? voteAverage / 2.0f : voteAverage);
    }
}
