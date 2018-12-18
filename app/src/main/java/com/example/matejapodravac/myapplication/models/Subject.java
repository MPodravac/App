package com.example.matejapodravac.myapplication.models;

public class Subject {
    private String naziv;
    private String profesor;
    private String akGodina;
    private String predavanja;
    private String vjezbe;

    public Subject(String naziv, String profesor, String akGodina, String predavanja, String vjezbe)
    {
        this.naziv = naziv;
        this.profesor = profesor;
        this.akGodina = akGodina;
        this.predavanja = predavanja;
        this.vjezbe = vjezbe;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getProfesor() {
        return profesor;
    }

    public String getAkGodina() {
        return akGodina;
    }

    public String getPredavanja() {
        return predavanja;
    }

    public String getVjezbe() {
        return vjezbe;
    }
}
