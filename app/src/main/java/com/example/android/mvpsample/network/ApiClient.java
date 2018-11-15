package com.example.android.mvpsample.network;

import com.example.android.mvpsample.model.Joke;
import com.example.android.mvpsample.model.JokesResponse;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private String jokesBaseUrl;
    private JokesApi jokesApi;

    public ApiClient(String jokesBaseUrl){
        super();
        this.jokesBaseUrl = jokesBaseUrl;
        initApi();
    }

    private void initApi(){
        jokesApi = (JokesApi) createApi(jokesBaseUrl);
    }

    private Object createApi(String baseUrl){
        OkHttpClient.Builder builder  = new OkHttpClient.Builder();
        OkHttpClient client = builder.build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        return retrofit.create(Object.class);
    }

    public Call<Joke> getRandomJoke(){
        return jokesApi.getRandomJoke();
    }

    public Call<JokesResponse> getJokes(){ return jokesApi.getJokes(); }
}
