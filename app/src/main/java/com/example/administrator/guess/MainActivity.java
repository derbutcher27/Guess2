package com.example.administrator.guess;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //erstellung aller der variablen
    private DataBaseHandler db;
    private List<Integer> shuffleList = new ArrayList<>();
    private Double live = 100d;
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
    private AlertDialog popupBonus;
    private ProgressBar pblive;
    Integer newIntLife, oldIntLife = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //DB-Objekt auf den alle abfragen zur DB erfolgen
        db = new DataBaseHandler(this);

        AlertDialog.Builder alertBuilderBonus = new AlertDialog.Builder(this);
        alertBuilderBonus.setCancelable(true);
        alertBuilderBonus.setMessage(getResources().getString(R.string.bonus));

        alertBuilderBonus.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        popupBonus = alertBuilderBonus.create();

        //layout elemente
        tvFrage = (TextView) findViewById(R.id.TextViewFrageDB);
        tvLive = (TextView) findViewById(R.id.tvYourLife);
        tvAntwortDB = (TextView) findViewById(R.id.TextViewAntwortDB);
        etAntwortUser = (EditText) findViewById(R.id.EditTextEingabeAntwort);
        btnLoesen = (Button) findViewById(R.id.buttonLoesen);
        btnNaechsteFrage = (Button) findViewById(R.id.buttonNaechsteFrage);
        btnNeuesSpiel = (Button) findViewById(R.id.buttonNewGame);
        tvHighscore = (TextView) findViewById(R.id.tvHighscore);
        pblive = (ProgressBar) findViewById(R.id.progressBar);

        btnNaechsteFrage.setVisibility(View.INVISIBLE);
        btnNeuesSpiel.setVisibility(View.INVISIBLE);

        //ermittelt die tabellen große von FragenUAntworten
        //erstellt eine zufaellige liste an hand der groeße er DB, die spaeter zur ermittlung der Fragen verwendet werden kann
        for (int i = 0; i < db.getSize("FragenUAntworten"); i++) {
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
                    btnNaechsteFrage.setVisibility(View.VISIBLE);

                    //finde die Anzeige der Antwort nicht notwendig da sie nach dem losen noch in der TextBox steht
                    //tvAntwortUser.setText(etAntwortUser.getText());

                    //ruft die berechnungsfunktion fuer das leben auf und uebergibt den wert des users und der db fuer die berechnung
                    liveCalc(Double.parseDouble(etAntwortUser.getText().toString()), Double.parseDouble(dbAntwort));

                    //zeigt das restleben des users nach der berechnung auf zwei nachkommastellen an
                    if (live <= 0) {
                        tvLive.setText("0");
                    } else {
                        tvLive.setText(String.valueOf(live));
                    }

                    //zeigt die richtige antwort aus der DB an
                    tvAntwortDB.setText("Richtige Antwort: " + dbAntwort);

                } catch (NumberFormatException e) {
                    //verhindert das der die TextBox des users leer ist
                    etAntwortUser.setError(getResources().getString(R.string.err_empty_ed));

                    //schaltet die buttons loesen und die TextBox des users wieder frei die vorher abgeschaltet wurden
                    btnLoesen.setEnabled(true);
                    etAntwortUser.setEnabled(true);
                }
            }
        });

        if (live >= 1) {

            //buttonNaechsteFrage ClickEvent
            btnNaechsteFrage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //Button Nächste Frage ausblenden
                    btnNaechsteFrage.setVisibility(View.INVISIBLE);

                    //Wenn Antwort leer Error
                    String antUser = etAntwortUser.getText().toString();
                    if (antUser.trim().equals("")) {
                        etAntwortUser.setError(getResources().getString(R.string.err_empty_ed));
                    }

                    //setzt die TextViews und die TextBox des users wieder zurück auf null
                    tvAntwortDB.setText(null);
                    etAntwortUser.setText(null);

                    //schaltet die buttons loesen und die TextBox des users wieder fuer die naechste frage frei
                    btnLoesen.setEnabled(true);
                    etAntwortUser.setEnabled(true);

                    //zeigt die naechste frage in der textview an und ermittelt bereits die antwort
                    tvFrage.setText(getFrage(shuffleList.get(shuffelListIncrease)));
                    dbAntwort = getAntwort(shuffleList.get(shuffelListIncrease));


                }
            });

        } else {

            btnNeuesSpiel.setVisibility(View.VISIBLE);

            //startet ein neues spiel in dem die activity neugeladen wird
            btnNeuesSpiel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);

                }
            });

        }

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

            db.addHighscore(new HighscoreWorker(String.valueOf(highscore)));

            //erzeugt ein popup und beschreibt diese fuer die spaetere anzeige
            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
            alertBuilder.setCancelable(true);
            alertBuilder.setMessage(getResources().getString(R.string.spiel_verloren));

            //zeigt die option ein neues spiel zu starten unter dem popup an
            alertBuilder.setNegativeButton(
                    getResources().getString(R.string.new_game),
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Intent intent = getIntent();
                            finish();
                            startActivity(intent);
                        }
                    });

            //zeigt die option sich den highscore anzuzeigen lassen unter dem popup an
            alertBuilder.setPositiveButton(
                    getResources().getString(R.string.highscore),
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Intent i = new Intent(MainActivity.this, HighScore.class);
                            startActivity(i);
                        }
                    });
            //baut den altertdialog fuer das popup
            AlertDialog popupLost = alertBuilder.create();

            //zeigt das popup an
            popupLost.show();
        } else {
            //erhoeht den wert fuer die naechste reihe in der DB die zubeginn ausgelesen und geshuffelt wurde
            shuffelListIncrease++;

            //erhoeht den punktestand nachdem eine frage erfolgreich beantwortet wurde
            highscore++;




            //zeigt den neuen highscore an
            tvHighscore.setText(getResources().getString(R.string.geschaffteFragen) + highscore);

            newIntLife = Integer.valueOf(live.intValue());


            ProgressBarAnimation anim = new ProgressBarAnimation(pblive, oldIntLife, newIntLife);
            anim.setDuration(1000);
            pblive.startAnimation(anim);

            pblive.setProgress(newIntLife);
            oldIntLife = newIntLife;

            if (highscore % 5 == 0) {
                popupBonus.show();
                live = live + 25d;
            }
        }
    }
}