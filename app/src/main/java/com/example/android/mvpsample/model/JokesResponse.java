package com.example.android.mvpsample.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JokesResponse {
    @SerializedName("total_jokes")
    private int totalJokes;
    private List<Joke> results;

    public int getTotalJokes() {
        return totalJokes;
    }

    public void setTotalJokes(int totalJokes) {
        this.totalJokes = totalJokes;
    }

    public List<Joke> getResults() {
        return results;
    }

    public void setResults(List<Joke> results) {
        this.results = results;
    }
}
