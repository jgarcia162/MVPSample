package com.example.android.mvpsample.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.android.mvpsample.R;
import com.example.android.mvpsample.presentation.MainPresentation;
import com.example.android.mvpsample.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainPresentation {
    private MainPresenter presenter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        presenter.attach(this);
    }

    @Override
    protected void onStop() {
        super.onStop();

        presenter.detach();
    }
}
