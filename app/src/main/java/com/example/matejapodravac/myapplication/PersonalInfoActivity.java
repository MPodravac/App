package com.example.matejapodravac.myapplication;

import android.content.Intent;
import android.support.v4.os.IResultReceiver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PersonalInfoActivity extends AppCompatActivity {

    private Button oBtnUnesi;
    private EditText oInputIme;
    private String sIme;
    private EditText oInputPrezime;
    private String sPrezime;
    private EditText oInputDatumRodenja;
    private String sDatumRodenja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);

        oInputIme = (EditText)findViewById(R.id.editIme);
        oInputPrezime = (EditText)findViewById(R.id.editPrezime);
        oInputDatumRodenja = (EditText)findViewById(R.id.editDatumRodenja);
        oBtnUnesi = (Button)findViewById(R.id.button3);

        oBtnUnesi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                sIme = oInputIme.getText().toString();
                sPrezime = oInputPrezime.getText().toString();
                sDatumRodenja = oInputDatumRodenja.getText().toString();
                Intent oUpisiOsnovnePodatke = new Intent(getApplicationContext(), StudentInfoActivity.class);
                oUpisiOsnovnePodatke.putExtra("ime", sIme);
                oUpisiOsnovnePodatke.putExtra("prezime", sPrezime);
                oUpisiOsnovnePodatke.putExtra("datum rodenja", sDatumRodenja);
                startActivity(oUpisiOsnovnePodatke);
            }

        });
    }
}
