package com.example.android.mvpsample.presenter;

import android.util.Log;

import com.example.android.mvpsample.model.Person;
import com.example.android.mvpsample.model.PeopleResponse;
import com.example.android.mvpsample.network.ApiClient;
import com.example.android.mvpsample.presentation.MainPresentation;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {
    private MainPresentation presentation;
    private ApiClient apiClient;

    public void attach(MainPresentation presentation) {
        this.presentation = presentation;

        apiClient = new ApiClient("https://swapi.co/");
    }

    public void detach() {
        this.presentation = null;
    }

    public void getJokes() {
        presentation.showLoading();
        Call<PeopleResponse> call = apiClient.getPeople();
        Log.d("REQUEST: ", "getRandomPerson: " + call.request());

        call.enqueue(new Callback<PeopleResponse>() {
            @Override
            public void onResponse(Call<PeopleResponse> call, Response<PeopleResponse> response) {
                presentation.hideLoading();
                if(response.body() != null){
                    presentation.showPeople(response.body().getResults());
                }
            }

            @Override
            public void onFailure(Call<PeopleResponse> call, Throwable t) {
                presentation.showFailedToast();
                presentation.hideLoading();
                Log.d("FAILED RESPONSE: ", "onFailure: " + t.getMessage());
                Log.d("FAILED RESPONSE: ", "onFailure: " + call.request());
            }
        });
    }

    public void getRandomJoke() {
        presentation.showLoading();
        Call<Person> call = apiClient.getRandomPerson();
        Log.d("REQUEST: ", "getRandomPerson: " + call.request());
        call.enqueue(new Callback<Person>() {
            @Override
            public void onResponse(Call<Person> call, Response<Person> response) {
                presentation.hideLoading();
                if (response.body() != null) {
                    presentation.showRandomPerson(response.body().getName());
                }
            }

            @Override
            public void onFailure(Call<Person> call, Throwable t) {
                presentation.hideLoading();
                presentation.showFailedToast();
            }
        });
    }
}
