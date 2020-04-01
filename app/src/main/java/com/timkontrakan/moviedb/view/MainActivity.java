package com.timkontrakan.moviedb.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.timkontrakan.moviedb.R;
import com.timkontrakan.moviedb.adapter.MovieAdapter;
import com.timkontrakan.moviedb.api.API;
import com.timkontrakan.moviedb.api.IRetrofit;
import com.timkontrakan.moviedb.api.RetrofitClient;
import com.timkontrakan.moviedb.model.Movie;
import com.timkontrakan.moviedb.model.MovieResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvpopularMovies;
    private RecyclerView rvtopRatedMovies;
    private RecyclerView rvupcomingMovies;
    private MovieAdapter popularAdapter;
    private MovieAdapter topRatedAdapter;
    private List<Movie> movieList;
    private IRetrofit iRetrofit;
    private MovieAdapter upcomingMovieAdapter;

    String TAG = "TES";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iRetrofit = RetrofitClient.getClient(API.NOW_PLAYING).create(IRetrofit.class);
        movieList = new ArrayList<>();

        popularMovies();
        topRatedMovies();
        upcomingMovies();
    }

    private void popularMovies(){
        popularAdapter = new MovieAdapter(this, movieList);
        rvpopularMovies = findViewById(R.id.popular_movies);
        rvpopularMovies.setAdapter(popularAdapter);
        rvpopularMovies.setLayoutManager
                (new LinearLayoutManager(this,
                        LinearLayoutManager.HORIZONTAL,
                        false));
        getMovies();
    }

    private void topRatedMovies(){

        topRatedAdapter = new MovieAdapter(this, movieList);
        rvtopRatedMovies = findViewById(R.id.top_rated_movies);
        rvtopRatedMovies.setAdapter(topRatedAdapter);
        rvtopRatedMovies.setLayoutManager
                (new LinearLayoutManager(this,
                        LinearLayoutManager.HORIZONTAL,
                        false));
        getMoviesTop();
    }

    private void upcomingMovies(){
        upcomingMovieAdapter = new MovieAdapter(this, movieList);
        rvupcomingMovies = findViewById(R.id.upcoming_movies);
        rvupcomingMovies.setAdapter(upcomingMovieAdapter);
        rvupcomingMovies.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL,
                false));

        getMoviesUpcoming();
    }



    private void getMovies(){
        iRetrofit.getMovies().enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.body() !=null){
                    movieList.clear();
                    movieList.addAll(response.body().getResults());
                    popularAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.d(TAG,"onFailrule" + t.getMessage());
            }
        });
    }

    private void getMoviesTop(){
        iRetrofit.getMoviesTop().enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.body() !=null){
                    movieList.clear();
                    movieList.addAll(response.body().getResults());
                    topRatedAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.d(TAG,"onFailrule" + t.getMessage());
            }
        });
    }

    private void getMoviesUpcoming(){
        iRetrofit.getMoviesUpcoming().enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.body() !=null){
                    movieList.clear();
                    movieList.addAll(response.body().getResults());
                    upcomingMovieAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.d(TAG,"onFailrule" + t.getMessage());
            }
        });
    }
}
