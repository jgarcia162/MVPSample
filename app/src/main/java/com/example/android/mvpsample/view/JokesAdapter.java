package com.example.android.mvpsample.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.android.mvpsample.R;
import com.example.android.mvpsample.model.Joke;

import java.util.List;

public class JokesAdapter extends RecyclerView.Adapter<JokesViewHolder> {
    private List<Joke> jokesList;

    public JokesAdapter(List<Joke> jokes){
        jokesList = jokes;
    }

    @NonNull
    @Override
    public JokesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        return new JokesViewHolder (LayoutInflater.from(parent.getContext()).inflate(R.layout.joke_list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull JokesViewHolder viewHolder, int position) {
        viewHolder.bindJoke(jokesList.get(position));
    }

    @Override
    public int getItemCount() {
        return jokesList.size();
    }

    public void setData(List<Joke> newJokes){
        jokesList = newJokes;
        notifyDataSetChanged();
    }
}
