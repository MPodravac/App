package com.example.matejapodravac.myapplication.models;

import android.support.annotation.NonNull;

import java.util.ArrayList;

public class Course {
    ArrayList<Instructor> instructors;
    String subtitle;
    String image;
    String title;
    Boolean featured;

    public Course(ArrayList<Instructor> instructors, String subtitle, String image, String title, Boolean featured) {
        this.instructors = instructors;
        this.subtitle = subtitle;
        this.image = image;
        this.title = title;
        this.featured = featured;
    }

    public ArrayList<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(ArrayList<Instructor> instructors) {
        this.instructors = instructors;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getFeatured() {
        return featured;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }
    @NonNull
    @Override
    public String toString(){
        return "instruktori: " + instructors.toString() + "\n" + "naslov: " + title + "\n";
    }
}
