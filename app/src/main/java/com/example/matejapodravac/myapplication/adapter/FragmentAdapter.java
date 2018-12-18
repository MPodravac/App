package com.example.matejapodravac.myapplication.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.matejapodravac.myapplication.fragment.PersonalInfoFragment;
import com.example.matejapodravac.myapplication.fragment.StudentInfoFragment;
import com.example.matejapodravac.myapplication.fragment.SummaryFragment;
import com.example.matejapodravac.myapplication.listeners.PersonalInfoListener;
import com.example.matejapodravac.myapplication.listeners.StudentInfoListener;
import com.example.matejapodravac.myapplication.listeners.SummaryInfoDataSource;
import com.example.matejapodravac.myapplication.models.Person;
import com.example.matejapodravac.myapplication.models.Subject;

import java.util.List;

public class FragmentAdapter extends FragmentPagerAdapter implements PersonalInfoListener, StudentInfoListener, SummaryInfoDataSource {
    List<Integer> dataList;
    private String name = "";
    private String lastName = "";
    private String birthDate = "";
    private String subject = "";
    private String profesor = "";
    private String akGodina = "";
    private String predavanja = "";
    private String vjezbe = "";

    public FragmentAdapter(FragmentManager fm, List<Integer> dataList) {
        super(fm);
        this.dataList = dataList;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        int dataType = dataList.get(position);
        if(dataType == 1)
        {
            fragment = PersonalInfoFragment.newInstance();
            ((PersonalInfoFragment)fragment).personalInfoListener = this;
        }
        else if(dataType == 2)
        {
            fragment = StudentInfoFragment.newInstance();
            ((StudentInfoFragment)fragment).studentInfoListener = this;
        }
        else
        {
            fragment = SummaryFragment.newInstance();
            ((SummaryFragment) fragment).dataSource = this;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;

    }

    @Override
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public Person getPerson() {
        return new Person(name, lastName, birthDate);
    }

    @Override
    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    @Override
    public void setAkGodina(String akGodina) {
        this.akGodina = akGodina;
    }

    @Override
    public void setPredavanja(String predavanja) {
        this.predavanja = predavanja;
    }

    @Override
    public void setVjezbe(String vjezbe) {
        this.vjezbe = vjezbe;
    }

    @Override
    public Subject getSubject() {
        return new Subject(subject, profesor, akGodina, predavanja, vjezbe);
    }
}
