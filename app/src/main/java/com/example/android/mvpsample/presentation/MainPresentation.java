package com.example.android.mvpsample.presentation;

import com.example.android.mvpsample.model.Joke;

import java.util.List;

public interface MainPresentation {
    void refresh();
    void showLoading();
    void hideLoading();

    void showFailedToast();

    void showJokes(List<Joke> jokes);

    void showRandomJoke(String joke);
}
