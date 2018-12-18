package com.example.matejapodravac.myapplication.models;

public class Student {
    public String Ime;
    public String Prezime;
    public String Predmet;

    public Student(String Ime, String Prezime, String Predmet)
    {
        this.Ime = Ime;
        this.Prezime = Prezime;
        this.Predmet = Predmet;
    }

    public String getIme() {
        return Ime;
    }

    public String getPrezime() {
        return Prezime;
    }

    public String getPredmet() {
        return Predmet;
    }
}
