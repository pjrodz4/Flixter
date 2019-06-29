package com.example.flixter.activities;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.flixter.R;
import com.example.flixter.models.Config;
import com.example.flixter.models.Movie;
import com.loopj.android.http.AsyncHttpClient;

import org.parceler.Parcels;

public class MovieDetailsActivity extends AppCompatActivity {

    // the movie to display
    Movie movie;
    // instance fields
    AsyncHttpClient client;
    // the youtube key
    String key;
    // image config
    Config config;
    // context for rendering
    Context context;

    // base url for the API
    public final static String API_BASE_URL = "https://api.themoviedb.org/3";
    // parameter name for the API key
    public final static String API_KEY_PARAM = "api_key";

    // the view objects
    TextView tvTitle;
    TextView tvOverview;
    TextView tvReleaseDate;
    RatingBar rbVoteAverage;
    ImageView ivPoster;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        // initialize the client
        client = new AsyncHttpClient();
        // resolve view objects
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvOverview = (TextView) findViewById(R.id.tvOverview);
        tvReleaseDate = (TextView) findViewById(R.id.tvReleaseDate);
        rbVoteAverage = (RatingBar) findViewById(R.id.rbVoteAverage);
        // wrap the movie passed in via intent, using its simple name as a key
        movie = (Movie) Parcels.unwrap(getIntent().getParcelableExtra(Movie.class.getSimpleName()));
        //config = (Config) Parcels.unwrap(getIntent().getParcelableExtra(Config.class.getSimpleName()));
        //context = (Context) Parcels.unwrap(getIntent().getParcelableExtra(MovieAdapter.class.getSimpleName()));
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

//        String imageUrl = config.getImageUrl(config.getPosterSize(), movie.getPosterPath());
//        ivPoster = (ImageView) findViewById(R.id.ivPoster);
//
//        // load image using glide
//        Glide.with(context)
//                .load(imageUrl)
//                .bitmapTransform(new RoundedCornersTransformation(context, 25, 0))
//                .placeholder(R.drawable.flicks_backdrop_placeholder)
//                .error(R.drawable.flicks_backdrop_placeholder)
//                .into(ivPoster);
    }

//    private void getTrailer() {
//        // create the url
//        String url = API_BASE_URL + "/movie/" + movie.getId() + "/videos" ;
//        // set the request parameters
//        RequestParams params = new RequestParams();
//        params.put(API_KEY_PARAM, getString(R.string.api_key)); // API key, always required
//        // execute a GET request expecting a JSON object response
//        client.get(url, params, new JsonHttpResponseHandler() {
//            @Override
//            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
//                try {
//                    JSONArray results = response.getJSONArray("results");
//                    JSONObject movie = results.getJSONObject(0);
//                    key = movie.getString("key");
//                } catch (JSONException e) {
//                    Log.i("MovieDetailsActivity", "Failed to parse trailer", e);
//                }
//            }
//        });
//    }

}
