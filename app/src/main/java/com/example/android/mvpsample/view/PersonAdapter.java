package com.example.android.mvpsample.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.android.mvpsample.R;
import com.example.android.mvpsample.model.Person;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonViewHolder> {
    private List<Person> peopleList;

    PersonAdapter(List<Person> people) {
        peopleList = people;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        return new PersonViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.person_list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder viewHolder, int position) {
        viewHolder.bind(peopleList.get(position));
    }

    @Override
    public int getItemCount() {
        return peopleList.size();
    }

    void setData(List<Person> newPeople) {
        peopleList = newPeople;
        //should use DiffUtils class for better performance, this is fine for this simple example. See "optimized" branch for DiffUtils implementation
        notifyDataSetChanged();
    }
}
