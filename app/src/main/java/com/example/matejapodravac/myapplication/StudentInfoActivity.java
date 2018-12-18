package com.example.matejapodravac.myapplication;

import android.content.Intent;
import android.support.v4.os.IResultReceiver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class StudentInfoActivity extends AppCompatActivity {

    private Button oBtnUpisi;
    private String sIme;
    private String sPrezime;
    private String sDatumRodenja;
    private EditText oInputPredmet;
    private String sPredmet;
    private EditText oInputProfesor;
    private String sProfesor;
    private EditText oInputAkGodina;
    private String sAkGodina;
    private EditText oInputPredavanja;
    private String nPredavanja;
    private EditText oInputVjezbe;
    private String nVjezbe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);

        Bundle oExtras = getIntent().getExtras();
        sIme = oExtras.getString("ime");
        sPrezime = oExtras.getString("prezime");
        sDatumRodenja = oExtras.getString("datum rodenja");


        oInputPredmet = (EditText)findViewById(R.id.editPredmet);
        oInputProfesor = (EditText)findViewById(R.id.editProfesor);
        oInputAkGodina = (EditText)findViewById(R.id.editAkGodina);
        oInputPredavanja = (EditText)findViewById(R.id.editPredavanja);
        oInputVjezbe = (EditText) findViewById(R.id.editVjezbe);
        oBtnUpisi = (Button) findViewById(R.id.btnUpisi);

        oBtnUpisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sPredmet = oInputPredmet.getText().toString();
                sProfesor = oInputProfesor.getText().toString();
                sAkGodina = oInputAkGodina.getText().toString();
                nPredavanja = oInputPredavanja.getText().toString();
                nVjezbe = oInputVjezbe.getText().toString();

                Intent oUpisiPredmet=new Intent(getApplicationContext(), SummaryActivity.class);
                oUpisiPredmet.putExtra("ime", sIme);
                oUpisiPredmet.putExtra("prezime", sPrezime);
                oUpisiPredmet.putExtra("datum rodenja", sDatumRodenja);
                oUpisiPredmet.putExtra("predmet", sPredmet);
                oUpisiPredmet.putExtra("profesor", sProfesor);
                oUpisiPredmet.putExtra("ak godina", sAkGodina);
                oUpisiPredmet.putExtra("predavanja", nPredavanja);
                oUpisiPredmet.putExtra("vjezbe", nVjezbe);
                startActivity(oUpisiPredmet);
            }
        });
    }
}
