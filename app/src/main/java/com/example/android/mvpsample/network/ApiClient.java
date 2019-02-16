package com.example.android.mvpsample.network;

import com.example.android.mvpsample.model.PeopleResponse;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private final String STAR_WARS_BASE_URL = "https://swapi.co/";
    private static ApiClient instance;
    private PeopleApi peopleApi;

    private ApiClient() {
        initApis();
    }

    public static ApiClient getInstance() {
        if (instance != null) {
            return instance;
        }

        instance = new ApiClient();

        return instance;
    }

    private void initApis() {
        peopleApi = createRetrofit(STAR_WARS_BASE_URL).create(PeopleApi.class);
    }

    private Retrofit createRetrofit(String baseUrl) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        OkHttpClient client = builder.build();
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    public Call<PeopleResponse> getPeople() {
        return peopleApi.getPeople();
    }
}
