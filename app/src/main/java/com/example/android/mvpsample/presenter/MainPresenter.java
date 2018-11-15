package com.example.android.mvpsample.presenter;

import com.example.android.mvpsample.model.Joke;
import com.example.android.mvpsample.model.JokesResponse;
import com.example.android.mvpsample.network.ApiClient;
import com.example.android.mvpsample.presentation.MainPresentation;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {
    private MainPresentation presentation;
    private ApiClient apiClient;

    public void attach(MainPresentation presentation){
        this.presentation = presentation;

        apiClient = new ApiClient("https://icanhazdadjoke.com/");
    }

    public void detach(){
        this.presentation = null;
    }

    public void getJokes(){
        presentation.showLoading();
        apiClient.getJokes().enqueue(new Callback<JokesResponse>() {
            @Override
            public void onResponse(Call<JokesResponse> call, Response<JokesResponse> response) {
                presentation.hideLoading();
                if (response.body() != null) {
                    presentation.showJokes(response.body().getResults());
                }
            }

            @Override
            public void onFailure(Call<JokesResponse> call, Throwable t) {
                presentation.hideLoading();
                presentation.showFailedToast();
            }
        });
    }

    public void getRandomJoke(){
        presentation.showLoading();
        apiClient.getRandomJoke().enqueue(new Callback<Joke>() {
            @Override
            public void onResponse(Call<Joke> call, Response<Joke> response) {
                presentation.hideLoading();
                if (response.body() != null) {
                    presentation.showRandomJoke(response.body().getJoke());
                }
            }

            @Override
            public void onFailure(Call<Joke> call, Throwable t) {
                presentation.hideLoading();
                presentation.showFailedToast();
            }
        });
    }
}
