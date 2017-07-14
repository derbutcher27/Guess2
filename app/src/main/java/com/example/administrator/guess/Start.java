package com.example.administrator.guess;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final DataBaseHandler db = new DataBaseHandler(getApplicationContext(), "FragenUAntworten", 1);
        FragenUAntworten fragenUAntworten = new FragenUAntworten();

        //Neue Frage hinzufügen
        fragenUAntworten.setId(1);
        fragenUAntworten.setFragen("Wie hoch ist die ISS (in KM) ?");
        fragenUAntworten.setAntworten("400");
        fragenUAntworten.setKapitel("Geographie");
        db.addFrageUndAntwort(fragenUAntworten);

        fragenUAntworten.setId(2);
        fragenUAntworten.setFragen("Wie lang ist die A7 (Autobahn)");
        fragenUAntworten.setAntworten("963");
        fragenUAntworten.setKapitel("Geographie");
        db.addFrageUndAntwort(fragenUAntworten);

        fragenUAntworten.setId(3);
        fragenUAntworten.setFragen("Wie viele Scheidungen gab es 2013 in Deutschland?");
        fragenUAntworten.setAntworten("170000");
        fragenUAntworten.setKapitel("Leben");
        db.addFrageUndAntwort(fragenUAntworten);

        fragenUAntworten.setId(4);
        fragenUAntworten.setFragen("Wie viele Satelliten befinden sich um All?");
        fragenUAntworten.setAntworten("1200");
        fragenUAntworten.setKapitel("Geographie");
        db.addFrageUndAntwort(fragenUAntworten);

        fragenUAntworten.setId(5);
        fragenUAntworten.setFragen("Vor wie vielen Jahren wurde Geld erfunden ?");
        fragenUAntworten.setAntworten("7000");
        fragenUAntworten.setKapitel("Leben");
        db.addFrageUndAntwort(fragenUAntworten);

        setContentView(R.layout.activity_start);

        Button buttonStart = (Button) findViewById(R.id.buttonStart);
        buttonStart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(Start.this, MainActivity.class);
                startActivity(i);
            }

        });

        Button buttonKapitel = (Button) findViewById(R.id.buttonKapitel);
        buttonKapitel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(Start.this, Kapitel.class);
                startActivity(i);
            }

        });

        Button buttonHilfe = (Button) findViewById(R.id.buttonHilfe);
        buttonHilfe.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(Start.this, Help.class);
                startActivity(i);
            }

        });

    }

}
