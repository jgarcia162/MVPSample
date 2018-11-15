package com.example.android.mvpsample.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.android.mvpsample.R;
import com.example.android.mvpsample.model.Joke;

public class JokesViewHolder extends RecyclerView.ViewHolder {
    private TextView jokeTextView;

    public JokesViewHolder(@NonNull View itemView) {
        super(itemView);
        jokeTextView = itemView.findViewById(R.id.item_joke_tv);
    }

    public void bindJoke(Joke joke){
        jokeTextView.setText(joke.getJoke());
    }
}
