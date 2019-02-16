package com.example.android.mvpsample.network;

import com.example.android.mvpsample.model.PeopleResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PeopleApi {
    @GET("api/people")
    Call<PeopleResponse> getPeople();
}
