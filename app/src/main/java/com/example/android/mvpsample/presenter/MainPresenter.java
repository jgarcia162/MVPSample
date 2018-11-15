package com.example.android.mvpsample.presenter;

import android.content.Context;

import com.example.android.mvpsample.presentation.MainPresentation;

public class MainPresenter {
    private MainPresentation presentation;
    private Context context;

    MainPresenter(Context context){
        this.context = context;
    }

    public void attach(MainPresentation presentation){
        this.presentation = presentation;
    }

    public void detach(){
        this.presentation = null;
    }
}
