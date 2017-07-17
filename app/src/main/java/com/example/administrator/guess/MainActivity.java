package com.example.administrator.guess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


import static java.lang.Long.parseLong;

//import static com.example.administrator.guess.DataBaseHandler.ArrayValue;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "LOG";
    private double Ergebnis = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide(); //<< this
        setContentView(R.layout.activity_main);

        // final DataBaseHandler db = new DataBaseHandler(getApplicationContext(), "FragenUAntworten", 1);
        final DataBaseHandler db = new DataBaseHandler(this);

        List<Integer> list = new ArrayList<Integer>();
        int max = db.getSize();
        Integer n = 0;
        for (int i = 1; i <= max; i++)
            list.add(i);

        Collections.shuffle(list);

        for (int i = 0; i < max; i++) {
            n = list.get(i);
        }

        final int ant = n;
        int fr = n;

        final long zahl2 = parseLong(db.getAllFragen().get(ant).getAntwort());

        TextView TextViewFrageDB = (TextView) findViewById(R.id.TextViewFrageDB);
        TextViewFrageDB.setText(db.getAllFragen().get(fr).getFrage());

        final TextView TextViewAntwortDB = (TextView) findViewById(R.id.TextViewAntwortDB);
        TextViewAntwortDB.setText("");

        final TextView TextViewDifferenz = (TextView) findViewById(R.id.TextViewDifferenz);
        final TextView TextViewAntwortUser = (TextView) findViewById(R.id.TextViewAntwortUser);
        final EditText EditTextEingabeAntwort = (EditText) findViewById(R.id.EditTextEingabeAntwort);
        final TextView yourLife = (TextView) findViewById(R.id.yourLife);

        final Button buttonNaechsteFrage = (Button) findViewById(R.id.buttonNaechsteFrage);
        buttonNaechsteFrage.setVisibility(View.INVISIBLE);

        final Button buttonNewGame = (Button) findViewById(R.id.buttonNewGame);
        buttonNewGame.setVisibility(View.INVISIBLE);

        final Button buttonLoesen = (Button) findViewById(R.id.buttonLoesen);
        buttonLoesen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (!TextUtils.isEmpty(EditTextEingabeAntwort.getText().toString().trim())) {

                    TextViewAntwortUser.setText(EditTextEingabeAntwort.getText().toString());
                    TextViewAntwortDB.setText(db.getAllFragen().get(ant).getAntwort());

                    long zahl1 = parseLong(EditTextEingabeAntwort.getText().toString());
                    double prozRechnung = Math.abs(100 - zahl1 * 100 / zahl2);
                    Ergebnis = 100 - prozRechnung;

                    if (prozRechnung >= 100) {

                        TextViewDifferenz.setText("Du hast verloren! Du lagst " + prozRechnung + "% daneben!");
                        yourLife.setText("0");
                        buttonLoesen.setVisibility(View.INVISIBLE);
                        buttonNewGame.setVisibility(View.VISIBLE);

                        final Intent returnToStart = new Intent(MainActivity.this, Start.class);
                        buttonNewGame.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {

                                startActivity(returnToStart);

                            }
                        });


                    } else {

                        TextViewDifferenz.setText("Du lagst: " + prozRechnung + "% daneben!");
                        yourLife.setText("" + Ergebnis);

                        buttonNaechsteFrage.setVisibility(View.VISIBLE);
                        buttonNaechsteFrage.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {

                                if (!TextUtils.isEmpty(TextViewDifferenz.getText().toString().trim())) {

                                    List<Integer> list = new ArrayList<Integer>();
                                    int max = db.getSize();
                                    Integer n = 0;
                                    for (int i = 1; i <= max; i++)
                                        list.add(i);

                                    Collections.shuffle(list);

                                    for (int i = 0; i < max; i++) {
                                        n = list.get(i);
                                    }

                                    final int ant2 = n;
                                    int fr2 = n;

                                    TextView tv3 = (TextView) findViewById(R.id.TextViewFrageDB);
                                    tv3.setText(db.getAllFragen().get(fr2).getFrage());

                                    final TextView tv4 = (TextView) findViewById(R.id.TextViewAntwortDB);
                                    tv4.setText("");

                                    final TextView diff2 = (TextView) findViewById(R.id.TextViewDifferenz);
                                    final TextView eingabe2 = (TextView) findViewById(R.id.TextViewAntwortUser);
                                    final EditText antwort2 = (EditText) findViewById(R.id.EditTextEingabeAntwort);
                                    final TextView yourLife = (TextView) findViewById(R.id.yourLife);

                                    eingabe2.setText("");
                                    diff2.setText("");
                                    antwort2.setText("");

                                    final long zahl4 = parseLong(db.getAllFragen().get(ant2).getAntwort());
                                    buttonNaechsteFrage.setVisibility(View.INVISIBLE);

                                    final Button buttonLoesen = (Button) findViewById(R.id.buttonLoesen);
                                    buttonLoesen.setOnClickListener(new View.OnClickListener() {
                                        public void onClick(View v) {

                                            tv4.setText(db.getAllFragen().get(ant2).getAntwort());


                                            if (!TextUtils.isEmpty(antwort2.getText().toString().trim())) {

                                                eingabe2.setText(antwort2.getText().toString());
                                                TextViewAntwortDB.setText(db.getAllFragen().get(ant).getAntwort());

                                                long zahl3 = parseLong(antwort2.getText().toString());
                                                double prozRechnung = Math.abs(100 - zahl3 * 100 / zahl4);
                                                Ergebnis = Ergebnis - prozRechnung;

                                                if (prozRechnung >= 100) {

                                                    diff2.setText("Du hast verloren! Du lagst " + prozRechnung + "% daneben!");
                                                    yourLife.setText("0");
                                                    buttonLoesen.setVisibility(View.INVISIBLE);
                                                    buttonNaechsteFrage.setVisibility(View.INVISIBLE);
                                                    buttonNewGame.setVisibility(View.VISIBLE);

                                                    final Intent returnToStart = new Intent(MainActivity.this, Start.class);
                                                    buttonNewGame.setOnClickListener(new View.OnClickListener() {
                                                        public void onClick(View v) {

                                                            startActivity(returnToStart);

                                                        }
                                                    });


                                                } else if (Ergebnis <= 0) {

                                                    diff2.setText("Du hast verloren! Du lagst " + prozRechnung + "% daneben!");
                                                    yourLife.setText("0");
                                                    buttonLoesen.setVisibility(View.INVISIBLE);
                                                    buttonNaechsteFrage.setVisibility(View.INVISIBLE);
                                                    buttonNewGame.setVisibility(View.VISIBLE);

                                                    final Intent returnToStart = new Intent(MainActivity.this, Start.class);
                                                    buttonNewGame.setOnClickListener(new View.OnClickListener() {
                                                        public void onClick(View v) {

                                                            startActivity(returnToStart);

                                                        }
                                                    });


                                                } else {

                                                    diff2.setText("Du lagst " + prozRechnung + "% daneben!");
                                                    yourLife.setText("" + Ergebnis);
                                                    buttonNaechsteFrage.setVisibility(View.VISIBLE);

                                                }

                                            } else {
                                                antwort2.setError("Darf nicht leer sein");
                                            }

                                        }
                                    });

                                }
                            }


                        });


                    }
                } else {
                    EditTextEingabeAntwort.setError("Darf nicht leer sein");
                }
            }

        });


    }

}


