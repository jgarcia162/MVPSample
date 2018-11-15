package com.example.android.mvpsample.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.android.mvpsample.R;
import com.example.android.mvpsample.model.Person;

public class PersonViewHolder extends RecyclerView.ViewHolder {
    private TextView nameTextView;

    public PersonViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTextView = itemView.findViewById(R.id.item_name_tv);
    }

    public void bindJoke(Person person){
        nameTextView.setText(person.getName());
    }
}
