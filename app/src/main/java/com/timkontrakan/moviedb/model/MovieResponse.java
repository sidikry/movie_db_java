package com.timkontrakan.moviedb.model;

import java.util.List;

public class MovieResponse {

    private List<Movie> results;

    public MovieResponse() {
    }

    public MovieResponse(List<Movie> results) {
        this.results = results;
    }

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }
}
