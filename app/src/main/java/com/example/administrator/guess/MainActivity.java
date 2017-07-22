package com.example.administrator.guess;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DataBaseHandler db;
    private List<Integer> shuffleList = new ArrayList<>();
    private int dbSize;
    private double live = 100;
    private int shuffelListIncrease = 0;
    private String dbAntwort;
    private int highscore = 0;
    private TextView tvHighscore;
    private Button btnNaechsteFrage;
    private TextView tvFrage;
    private TextView tvLive;
    private TextView tvAntwortDB;
    private TextView tvAntwortUser;
    private EditText etAntwortUser;
    private Button btnLoesen;
    private Button btnNeuesSpiel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvHighscore = (TextView) findViewById(R.id.tvHighscore);

        db = new DataBaseHandler(this);

        //layout elemente
        tvFrage = (TextView) findViewById(R.id.TextViewFrageDB);
        tvLive = (TextView) findViewById(R.id.tvYourLife);
        tvAntwortDB = (TextView) findViewById(R.id.TextViewAntwortDB);
        tvAntwortUser = (TextView) findViewById(R.id.TextViewAntwortUser);
        etAntwortUser = (EditText) findViewById(R.id.EditTextEingabeAntwort);
        btnLoesen = (Button) findViewById(R.id.buttonLoesen);
        btnNaechsteFrage = (Button) findViewById(R.id.buttonNaechsteFrage);
        btnNeuesSpiel = (Button) findViewById(R.id.buttonNewGame);


        dbSize = db.getSize();

        //erstellt eine zufaellige liste an hand der groeße er DB, die spaeter zur ermittlung der Fragen verwendet werden kann
        for (int i = 0; i < db.getSize(); i++) {
            shuffleList.add(i);
        }
        Collections.shuffle(shuffleList);

        //Setzt die erste Frage in die TextView
        tvFrage.setText(getFrage(shuffleList.get(shuffelListIncrease)));

        //ermittelt bereits die antwort aus der DB ohne sie anzuzeigen
        dbAntwort = getAntwort(shuffleList.get(shuffelListIncrease));

        //ButtonLoesen ClickEvent
        btnLoesen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    etAntwortUser.setEnabled(false);
                    btnLoesen.setEnabled(false);

                    //tvAntwortUser.setText(etAntwortUser.getText());

                    liveCalc(Double.parseDouble(etAntwortUser.getText().toString()), Double.parseDouble(dbAntwort));
                    tvLive.setText(String.valueOf(live));

                    tvAntwortDB.setText(dbAntwort);

                } catch (NumberFormatException e) {
                    etAntwortUser.setError("Darf nicht leer sein");
                    btnLoesen.setEnabled(true);
                    etAntwortUser.setEnabled(true);
                }
            }
        });

        //buttonNaechsteFrage ClickEvent
        btnNaechsteFrage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    tvAntwortDB.setText(null);
                    etAntwortUser.setText(null);
                    tvAntwortUser.setText(null);

                    btnLoesen.setEnabled(true);
                    etAntwortUser.setEnabled(true);

                    tvFrage.setText(getFrage(shuffleList.get(shuffelListIncrease)));
                    dbAntwort = getAntwort(shuffleList.get(shuffelListIncrease));

                } catch (NumberFormatException e) {
                }
            }
        });

        btnNeuesSpiel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                } catch (NumberFormatException e) {
                }
            }
        });

    }

    //holt die Frage aus der DB zur anzeige in der TextView
    public String getFrage(int iFrage) {

        return db.getAllFragen().get(iFrage).getFrage();
    }

    //holt die Antwort aus der DB zur anzeige in der TextView
    public String getAntwort(int iAntwort) {

        return db.getAllFragen().get(iAntwort).getAntwort();
    }

    //berechnet das Leben neu
    public void liveCalc(double prozentwert, double grundwert) {
        double abzug = Math.abs(100d - ((prozentwert / grundwert) * 100d));
        live = Math.round(100 * (live - abzug)) / 100.0;

        if (live <= 0) {
            btnNaechsteFrage.setEnabled(false);

            db.addHighscore(new HighscoreWorker("UsernameRAIK",String.valueOf(highscore)));

            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
            alertBuilder.setCancelable(true);
            alertBuilder.setMessage("Du hast Leider kein leben mehr. :/");

            alertBuilder.setNegativeButton(
                    "Neues Spiel",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Intent intent = getIntent();
                            finish();
                            startActivity(intent);
                        }
                    });

            alertBuilder.setPositiveButton(
                    "Highscore",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //dialog.cancel();
                            finish();
                            //System.exit(0);
                        }
                    });

            AlertDialog popupLost = alertBuilder.create();
            popupLost.show();
        } else {
            shuffelListIncrease++;
            highscore++;
            tvHighscore.setText("Geschaffte Fragen: " + highscore);
        }
    }
}