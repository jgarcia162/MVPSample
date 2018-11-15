package com.example.android.mvpsample.network;

import com.example.android.mvpsample.model.Joke;
import com.example.android.mvpsample.model.JokesResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JokesApi {

    @GET()
    Call<Joke> getRandomJoke();

    @GET("/search")
    Call<JokesResponse> getJokes();
}
