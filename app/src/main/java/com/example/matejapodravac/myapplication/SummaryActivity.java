package com.example.matejapodravac.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    private String sIme;
    private String sPrezime;
    private String sDatumRodenja;
    private String sPredmet;
    private String sProfesor;
    private String sAkGodina;
    private String nPredavanja;
    private String nVjezbe;
    private TextView oIme;
    private TextView oPrezime;
    private TextView oDatumRodenja;
    private TextView oPredmet;
    private TextView oProfesor;
    private TextView oAkGodina;
    private TextView oPredavanja;
    private TextView oVjezbe;
    private Button oBtnPotvrdi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        final Bundle oExtras=getIntent().getExtras();
        sIme = oExtras.getString("ime");
        sPrezime = oExtras.getString("prezime");
        sDatumRodenja = oExtras.getString("datum rodenja");
        sPredmet = oExtras.getString("predmet");
        sProfesor = oExtras.getString("profesor");
        sAkGodina = oExtras.getString("ak godina");
        nPredavanja = oExtras.getString("predavanja");
        nVjezbe = oExtras.getString("vjezbe");

        oIme = (TextView)findViewById(R.id.textViewIme);
        oIme.setText(sIme);
        oPrezime = (TextView)findViewById(R.id.textViewPrezime);
        oPrezime.setText(sPrezime);
        oDatumRodenja = (TextView)findViewById(R.id.textViewDatumRodenja);
        oDatumRodenja.setText(sDatumRodenja);
        oPredmet = (TextView)findViewById(R.id.textViewPredmet);
        oPredmet.setText(sPredmet);
        oProfesor = (TextView)findViewById(R.id.textViewProfesor);
        oProfesor.setText(sProfesor);
        oAkGodina = (TextView)findViewById(R.id.textViewAkGodina);
        oAkGodina.setText(sAkGodina);
        oPredavanja = (TextView)findViewById(R.id.textViewPredavanja);
        oPredavanja.setText(nPredavanja);
        oVjezbe = (TextView)findViewById(R.id.textViewVjezbe);
        oVjezbe.setText(nVjezbe);

        oBtnPotvrdi = (Button)findViewById(R.id.btnPotvrdi);
        oBtnPotvrdi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent oPotvrdi = new Intent(getApplicationContext(), PersonalInfoActivity.class);
                startActivity(oPotvrdi);
            }
        });
    }
    @Override
    public void onBackPressed() {

    }
}
