package com.timkontrakan.moviedb.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.timkontrakan.moviedb.R;
import com.timkontrakan.moviedb.api.API;
import com.timkontrakan.moviedb.model.Movie;

public class MovieDetailActivity extends AppCompatActivity {

    private Movie movie;
    private ImageView backdrop;
    private ImageView poster;
    private TextView title;
    private RatingBar ratingBar;
    private TextView releaseDate;
    private TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        movie = (Movie) getIntent().getSerializableExtra("movie");
        initUI();
    }

    private void initUI() {

        backdrop = findViewById(R.id.movie_backdrop);
        Picasso.get().load(API.BACK_DROP + movie.getBackdropPath()).centerCrop().fit().into(backdrop);

        poster = findViewById(R.id.movie_poster);
        Picasso.get().load(API.POSTER + movie.getPosterPath()).centerCrop().fit().into(poster);

        title = findViewById(R.id.movie_title);
        title.setText(movie.getTitle());

        ratingBar = findViewById(R.id.movie_rating);
        ratingBar.setRating((float) (movie.getRating() / 2));

        releaseDate = findViewById(R.id.movie_release_date);
        releaseDate.setText(movie.getDate());

        description = findViewById(R.id.movie_overview);
        description.setText(movie.getDescription());
    }
}
