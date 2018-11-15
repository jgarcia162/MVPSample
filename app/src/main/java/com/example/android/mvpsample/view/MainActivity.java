package com.example.android.mvpsample.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.android.mvpsample.R;
import com.example.android.mvpsample.model.Joke;
import com.example.android.mvpsample.presentation.MainPresentation;
import com.example.android.mvpsample.presenter.MainPresenter;

import java.util.ArrayList;
import java.util.List;

import static android.support.v7.widget.LinearLayoutManager.VERTICAL;

public class MainActivity extends AppCompatActivity implements MainPresentation {
    private MainPresenter presenter;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private JokesAdapter adapter;
    private Button randomJokeButton, refreshButton;
    private List<Joke> jokes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progress_bar);
        randomJokeButton = findViewById(R.id.random_joke_button);
        refreshButton = findViewById(R.id.refresh_button);
        initRecyclerView(jokes);
        setClickListeners();
    }

    private void setClickListeners() {
        randomJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.getRandomJoke();
            }
        });

        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.getJokes();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        presenter = new MainPresenter();
        presenter.attach(this);
        presenter.getJokes();
    }

    @Override
    protected void onStop() {
        super.onStop();

        presenter.detach();
    }

    public void initRecyclerView(List<Joke> jokes) {
        adapter = new JokesAdapter(jokes);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, VERTICAL, false));
    }

    @Override
    public void refresh() {
        presenter.getJokes();
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
        Toast.makeText(this, "Failed try again", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showJokes(List<Joke> jokes) {
        this.jokes = jokes;
        adapter.setData(jokes);
    }

    @Override
    public void showRandomJoke(String joke) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle(R.string.random_joke)
                .setMessage(joke)
                .setPositiveButton("Dismiss", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).show();
    }
}
