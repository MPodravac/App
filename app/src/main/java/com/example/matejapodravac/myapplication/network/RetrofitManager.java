package com.example.matejapodravac.myapplication.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {
    private static RetrofitManager instance;

    private UdacityAPI service;

    private RetrofitManager(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.udacity.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(UdacityAPI.class);

    }
    public static RetrofitManager getInstance(){

        if(instance == null){
            instance = new RetrofitManager();
        }

        return instance;
    }

    public UdacityAPI getService() {
        return service;
    }
}
