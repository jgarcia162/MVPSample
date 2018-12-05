package com.example.android.mvpsample.view;

import android.os.Bundle;
import android.support.design.button.MaterialButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.android.mvpsample.R;
import com.example.android.mvpsample.model.Person;

import java.util.ArrayList;
import java.util.List;

import static android.support.v7.widget.LinearLayoutManager.VERTICAL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private PersonAdapter adapter;
    private MaterialButton randomPersonButton, refreshButton;
    private List<Person> people = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progress_bar);
        randomPersonButton = findViewById(R.id.random_person_button);
        refreshButton = findViewById(R.id.refresh_button);

        initRecyclerView(people);
        setClickListeners();
    }

    private void setClickListeners() {
        randomPersonButton.setOnClickListener(this);
        refreshButton.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    public void initRecyclerView(List<Person> people) {
        adapter = new PersonAdapter(people);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, VERTICAL, false));
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.random_person_button:
                // get random person
            case R.id.refresh_button:
                // refresh
        }
    }
}
