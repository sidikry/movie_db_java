package com.timkontrakan.moviedb.api;

import com.timkontrakan.moviedb.model.Movie;
import com.timkontrakan.moviedb.model.MovieResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IRetrofit {

    @GET("now_playing?api_key=14953188405961ad80873021665c9f67")
    Call<List<Movie>> getMoviesT();

    @GET("popular?api_key=14953188405961ad80873021665c9f67")
    Call<MovieResponse> getMovies();

    @GET("top_rated?api_key=14953188405961ad80873021665c9f67")
    Call<MovieResponse> getMoviesTop();

    @GET("upcoming?api_key=14953188405961ad80873021665c9f67")
    Call<MovieResponse> getMoviesUpcoming();
}
