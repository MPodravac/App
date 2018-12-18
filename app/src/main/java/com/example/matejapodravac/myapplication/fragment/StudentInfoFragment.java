package com.example.matejapodravac.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.matejapodravac.myapplication.R;
import com.example.matejapodravac.myapplication.listeners.StudentInfoListener;
import com.example.matejapodravac.myapplication.models.CoursesResponse;
import com.example.matejapodravac.myapplication.network.RetrofitManager;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentInfoFragment extends Fragment implements Callback<CoursesResponse>, AdapterView.OnItemSelectedListener  {

    public static StudentInfoFragment newInstance() {

        Bundle args = new Bundle();

        StudentInfoFragment fragment = new StudentInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    EditText etSubject;
    EditText etProfesor;
    EditText etAkGodina;
    EditText etPredavanja;
    EditText etVjezbe;
    Spinner spinner_predmet;
    Spinner spinner_profesor;

    public StudentInfoListener studentInfoListener;

    ArrayList<String> predmeti = new ArrayList<String>();
    ArrayList<String> profesori = new ArrayList<String>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student_info, container, false);

        Call<CoursesResponse> callResponse = RetrofitManager.getInstance().getService().getCourses();
        callResponse.enqueue(this);

        spinner_predmet = view.findViewById(R.id.spinner_predmet);
        spinner_predmet.setOnItemSelectedListener(this);
        predmeti.add("Predmeti");
        final ArrayAdapter predmetiAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, predmeti);
        predmetiAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_predmet.setAdapter(predmetiAdapter);


        spinner_profesor = view.findViewById(R.id.spinner_profesor);
        spinner_profesor.setOnItemSelectedListener(this);
        profesori.add("Profesori");
        final ArrayAdapter profesoriAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, profesori);
        profesoriAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_profesor.setAdapter(profesoriAdapter);

        /*etSubject = view.findViewById(R.id.etSubject);
        etSubject.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (studentInfoListener != null) {
                    studentInfoListener.setSubject(editable.toString());
                }
            }
        });
        etProfesor = view.findViewById(R.id.etProfesor);
        etProfesor.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (studentInfoListener != null) {
                    studentInfoListener.setProfesor(editable.toString());
                }
            }
        });*/
        etAkGodina = view.findViewById(R.id.etAkGodina);
        etAkGodina.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (studentInfoListener != null) {
                    studentInfoListener.setAkGodina(editable.toString());
                }
            }
        });
        etPredavanja = view.findViewById(R.id.etPredavanja);
        etPredavanja.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (studentInfoListener != null) {
                    studentInfoListener.setPredavanja(editable.toString());
                }
            }
        });
        etVjezbe = view.findViewById(R.id.etVjezbe);
        etVjezbe.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (studentInfoListener != null) {
                    studentInfoListener.setVjezbe(editable.toString());
                }
            }
        });
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        studentInfoListener = null;
    }

    @Override
    public void onResponse(@NonNull Call<CoursesResponse> call, @NonNull Response<CoursesResponse> response) {
        String text;
        if (response.isSuccessful() && response.body() != null){
            text = response.body().getCourses().toString();
        }
        else{
            text = "Došlo je do greške, podatci nisu dostupni";
        }
        setText(text);
    }

    @Override
    public void onFailure(@NonNull Call<CoursesResponse> call, @NonNull Throwable t) {
        setText("Došlo je do greške " + t.getMessage());
    }

    void setText(String text)
    {
        text = text.substring(1);
        text = text.replaceFirst(".$","");
        String[] items = text.split(",");
        for (String item : items)
        {
            predmeti.add(item);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        String predmet = adapterView.getItemAtPosition(position).toString();

        Toast.makeText(adapterView.getContext(), "Odabrano: " + predmet, Toast.LENGTH_LONG).show();
        if (studentInfoListener != null) {
            studentInfoListener.setSubject(predmet.toString());
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
