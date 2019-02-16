package com.example.android.mvpsample.presenter;

import com.example.android.mvpsample.model.PeopleResponse;
import com.example.android.mvpsample.model.Person;
import com.example.android.mvpsample.network.ApiClient;
import com.example.android.mvpsample.presentation.MainPresentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {
    private MainPresentation presentation;
    private ApiClient apiClient;
    private List<Person> people = new ArrayList<>();

    public MainPresenter(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public void attach(MainPresentation presentation) {
        this.presentation = presentation;
    }

    public void detach() {
        this.presentation = null;
    }

    public void getPeople() {
        presentation.showLoading();

        apiClient.getPeople().enqueue(new Callback<PeopleResponse>() {
            @Override
            public void onResponse(Call<PeopleResponse> call, Response<PeopleResponse> response) {
                presentation.hideLoading();
                if(response.body() != null){
                    people = response.body().getResults();
                    presentation.showPeople(people);
                }
            }

            @Override
            public void onFailure(Call<PeopleResponse> call, Throwable t) {
                presentation.hideLoading();
                presentation.showFailedToast();
            }
        });
    }

    public void getRandomPerson() {
        presentation.showRandomPerson(people.get(getRandomIndex()).getName());
    }

    private int getRandomIndex() {
        return new Random().nextInt(people.size() - 1);
    }
}
