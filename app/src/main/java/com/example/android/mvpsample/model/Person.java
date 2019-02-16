package com.example.android.mvpsample.model;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Person implements Comparable<Person> {
    private String name;
    private String height;
    private String mass;
    @SerializedName("hair_color")
    private String hairColor;
    @SerializedName("skin_color")
    private String skinColor;
    @SerializedName("eye_color")
    private String eyeColor;
    private String gender;

    public String getName() {
        return name;
    }

    public String getHeight() {
        return height;
    }

    public String getMass() {
        return mass;
    }

    public String getHairColor() {
        return hairColor;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public int compareTo(@NonNull Person o) {
        return this.getName().equals(o.getName()) ? 1 : 0;
    }
}
