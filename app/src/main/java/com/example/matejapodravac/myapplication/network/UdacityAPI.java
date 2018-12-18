package com.example.matejapodravac.myapplication.network;

import com.example.matejapodravac.myapplication.models.CoursesResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UdacityAPI {
    @GET("/public-api/v0/courses")
    Call<CoursesResponse> getCourses();
}
