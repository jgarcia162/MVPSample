package com.example.android.mvpsample.util

import com.example.android.mvpsample.model.Person

class PersonSorter {

    companion object {
        fun sortByNameAscending(people: List<Person>) = people.sortedBy { it.name }
        fun sortByNameDescending(people: List<Person>) = people.sortedByDescending { it.name }
        fun shufflePeople(people: List<Person>) = people.shuffled()
    }
}