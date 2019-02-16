package com.example.android.mvpsample.model;

import java.util.List;

public class PeopleResponse {
    private int count;
    private List<Person> results;

    public int getCount() {
        return count;
    }

    public List<Person> getResults() {
        return results;
    }
}
