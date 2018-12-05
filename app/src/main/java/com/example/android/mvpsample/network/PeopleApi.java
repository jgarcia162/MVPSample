package com.example.android.mvpsample.network;

import com.example.android.mvpsample.model.Person;
import com.example.android.mvpsample.model.PeopleResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PeopleApi {

    @GET("api/people")
    Call<PeopleResponse> getPeople();
}
