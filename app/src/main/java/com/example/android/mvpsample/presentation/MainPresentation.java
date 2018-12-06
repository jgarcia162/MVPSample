package com.example.android.mvpsample.presentation;

import com.example.android.mvpsample.model.Person;

import java.util.List;

public interface MainPresentation {
    void refresh();

    void showLoading();
    void hideLoading();

    void showFailedToast();

    void showPeople(List<Person> people);

    void showRandomPerson(String personName);
}
