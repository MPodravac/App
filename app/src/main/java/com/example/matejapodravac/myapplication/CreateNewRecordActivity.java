package com.example.matejapodravac.myapplication;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.matejapodravac.myapplication.adapter.FragmentAdapter;
import com.example.matejapodravac.myapplication.fragment.PersonalInfoFragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CreateNewRecordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_record);

        ViewPager viewPager = findViewById(R.id.viewPager);

        List<Integer> fragmentDataLisT = new ArrayList<>();
        fragmentDataLisT.add(1);
        fragmentDataLisT.add(2);
        fragmentDataLisT.add(3);
        Collections.sort(fragmentDataLisT);
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), fragmentDataLisT);
        viewPager.setAdapter(adapter);

    }


}
