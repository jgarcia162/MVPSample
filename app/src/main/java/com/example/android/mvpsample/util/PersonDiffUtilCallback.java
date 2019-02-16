package com.example.android.mvpsample.util;

import android.support.v7.util.DiffUtil;

import com.example.android.mvpsample.model.Person;

import java.util.List;

public class PersonDiffUtilCallback extends DiffUtil.Callback {
    private List<Person> newList;
    private List<Person> oldList;

    public PersonDiffUtilCallback(List<Person> oldList, List<Person> newList) {
        this.newList = newList;
        this.oldList = oldList;
    }

    @Override
    public int getOldListSize() {
        return oldList != null ? oldList.size() : 0;
    }

    @Override
    public int getNewListSize() {
        return newList != null ? newList.size() : 0;
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).getName().equals(newList.get(newItemPosition).getName());
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return newList.get(newItemPosition).compareTo(oldList.get(oldItemPosition)) == 1;
    }
}
