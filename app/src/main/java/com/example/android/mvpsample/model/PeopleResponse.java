package com.example.android.mvpsample.model;

import java.util.List;

public class PeopleResponse {
    private int count;
    private List<Person> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Person> getResults() {
        return results;
    }

    public void setResults(List<Person> results) {
        this.results = results;
    }
}
