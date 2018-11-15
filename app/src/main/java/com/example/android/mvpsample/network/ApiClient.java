package com.example.android.mvpsample.network;

import com.example.android.mvpsample.model.Person;
import com.example.android.mvpsample.model.PeopleResponse;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private String peopleBaseUrl;
    private PeopleApi peopleApi;

    public ApiClient(String peopleBaseUrl){
        super();
        this.peopleBaseUrl = peopleBaseUrl;
        initApis();
    }

    private void initApis(){
        peopleApi = createRetrofit(peopleBaseUrl).create(PeopleApi.class);
    }

    private Retrofit createRetrofit (String baseUrl){
        OkHttpClient.Builder builder  = new OkHttpClient.Builder();
        OkHttpClient client = builder.build();
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    public Call<Person> getRandomPerson(){
        return peopleApi.getRandomPerson();
    }

    public Call<PeopleResponse> getPeople(){ return peopleApi.getPeople(); }
}
