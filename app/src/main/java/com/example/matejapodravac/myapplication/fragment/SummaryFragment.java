package com.example.matejapodravac.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.matejapodravac.myapplication.R;
import com.example.matejapodravac.myapplication.listeners.SummaryInfoDataSource;
import com.example.matejapodravac.myapplication.models.Person;
import com.example.matejapodravac.myapplication.models.Subject;

public class SummaryFragment extends Fragment {

    public static SummaryFragment newInstance() {

        Bundle args = new Bundle();

        SummaryFragment fragment = new SummaryFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public SummaryInfoDataSource dataSource;

    TextView tvName;
    TextView tvLastName;
    TextView tvBirthDate;
    TextView tvSubject;
    TextView tvProfesor;
    TextView tvAkGodina;
    TextView tvPredavanja;
    TextView tvVjezbe;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_summary, container, false);
        tvName = view.findViewById(R.id.tvName);
        tvLastName = view.findViewById(R.id.tvLastName);
        tvBirthDate = view.findViewById(R.id.tvBirthDate);
        tvSubject = view.findViewById(R.id.tvSubject);
        tvProfesor = view.findViewById(R.id.tvProfesor);
        tvAkGodina = view.findViewById(R.id.tvAkGodina);
        tvPredavanja = view.findViewById(R.id.tvPredavanja);
        tvVjezbe = view.findViewById(R.id.tvVjezbe);
        return view;

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser)
    {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){
            if(dataSource != null)
            {
                Person person = dataSource.getPerson();
                Subject subject = dataSource.getSubject();

                if(person != null && subject!= null){
                    setupTextViews(person);
                    setupTextViews(subject);
                }
            }
        }
    }

    private void setupTextViews(Person person) {
        tvName.setText(person.getName());
        tvLastName.setText(person.getLastName());
        tvBirthDate.setText(person.getBirthDate());
    }

    private void setupTextViews(Subject subject) {
        tvSubject.setText(subject.getNaziv());
        tvProfesor.setText(subject.getProfesor());
        tvAkGodina.setText(subject.getAkGodina());
        tvPredavanja.setText(subject.getPredavanja());
        tvVjezbe.setText(subject.getVjezbe());
    }
}
