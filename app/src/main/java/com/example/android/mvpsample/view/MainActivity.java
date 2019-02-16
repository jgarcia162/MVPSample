package com.example.android.mvpsample.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.button.MaterialButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.android.mvpsample.R;
import com.example.android.mvpsample.model.Person;
import com.example.android.mvpsample.network.ApiClient;
import com.example.android.mvpsample.presentation.MainPresentation;
import com.example.android.mvpsample.presenter.MainPresenter;

import java.util.ArrayList;
import java.util.List;

import static android.support.v7.widget.LinearLayoutManager.VERTICAL;

public class MainActivity extends AppCompatActivity implements MainPresentation {
    private MainPresenter presenter;
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
        presenter = new MainPresenter(ApiClient.getInstance());
        initRecyclerView(people);
        setClickListeners();
    }

    private void setClickListeners() {
        randomPersonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.getRandomPerson();
            }
        });

        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.getPeople();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        presenter.attach(this);
        presenter.getPeople();
    }

    @Override
    protected void onStop() {
        super.onStop();

        presenter.detach();
    }

    public void initRecyclerView(List<Person> people) {
        adapter = new PersonAdapter(people);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, VERTICAL, false));
    }

    @Override
    public void refresh() {
        presenter.getPeople();
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showFailedToast() {
        Toast.makeText(this, R.string.failed, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showPeople(List<Person> people) {
        this.people = people;
        adapter.setData(people);
    }

    @Override
    public void showRandomPerson(String name) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle(R.string.random_person)
                .setMessage(name)
                .setPositiveButton(R.string.dismiss, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).show();
    }
}
