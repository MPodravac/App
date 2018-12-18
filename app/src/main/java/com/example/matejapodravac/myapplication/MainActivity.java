package com.example.matejapodravac.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import com.example.matejapodravac.myapplication.adapter.MyRecyclerAdapter;
import com.example.matejapodravac.myapplication.models.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Object> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner);
        spinner.setPrompt("Odaberite jezik");
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Jezici, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Button oBtnNoviStudent = findViewById(R.id.novi_student);
        oBtnNoviStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent oDodajNovogStudenta = new Intent(getApplicationContext(), PersonalInfoActivity.class);
                startActivity(oDodajNovogStudenta);
            }
});

        RecyclerView mRecyclerView = findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        List<Object> studentiList = generateList();
        InitializeRecyclerView(mRecyclerView, studentiList);
    }

    List<Object> generateList() {
        List<Object> list = new ArrayList<>();
        list.add("Studenti");
        list.add(new Student("Mateja", "Podravac", "CMS sustavi"));
        list.add(new Student("Petar", "Mačinković", "Programiranje mobilnih aplikacija"));
        list.add(new Student("Ivan", "Ivić", "Osnove programiranja"));
        list.add(new Student("Maja", "Majić", "Baze podataka"));
        return list;
    }


    void InitializeRecyclerView(RecyclerView recyclerView, List<Object> studentList) {
        recyclerView.setAdapter(new MyRecyclerAdapter(studentList));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
