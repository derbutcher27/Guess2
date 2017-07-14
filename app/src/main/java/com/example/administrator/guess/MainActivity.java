package com.example.administrator.guess;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.nfc.Tag;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


import static android.R.attr.value;
import static android.R.id.input;
import static android.R.id.list;
import static com.example.administrator.guess.R.id.EditTextEingabeAntwort;
import static com.example.administrator.guess.R.id.TextViewAntwortUser;
import static com.example.administrator.guess.R.id.TextViewFrageDB;
import static com.example.administrator.guess.R.id.yourLife;
import static java.lang.Long.parseLong;

//import static com.example.administrator.guess.DataBaseHandler.ArrayValue;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "LOG";
    private static double Ergebnis = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide(); //<< this
        setContentView(R.layout.activity_main);

        final DataBaseHandler db = new DataBaseHandler(getApplicationContext(), "FragenUAntworten", 1);
        FragenUAntworten fragenUAntworten = new FragenUAntworten();

        Random rand = new Random();
        int n = rand.nextInt(5);

        final int ant = n;
        int fr = n;

        final long zahl2 = parseLong(db.fragenUAntwortenArrayList().get(ant).getAntworten());

        TextView TextViewFrageDB = (TextView) findViewById(R.id.TextViewFrageDB);
        TextViewFrageDB.setText(db.fragenUAntwortenArrayList().get(fr).getFragen());

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

                TextViewAntwortDB.setText(db.fragenUAntwortenArrayList().get(ant).getAntworten());

                if (!TextUtils.isEmpty(EditTextEingabeAntwort.getText().toString().trim())) {

                    TextViewAntwortUser.setText(EditTextEingabeAntwort.getText().toString());

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

                                    Random rand = new Random();
                                    int n = rand.nextInt(5);

                                    final int ant2 = n;
                                    int fr2 = n;

                                    TextView tv3 = (TextView) findViewById(R.id.TextViewFrageDB);
                                    tv3.setText(db.fragenUAntwortenArrayList().get(fr2).getFragen());

                                    final TextView tv4 = (TextView) findViewById(R.id.TextViewAntwortDB);
                                    tv4.setText("");

                                    final TextView diff2 = (TextView) findViewById(R.id.TextViewDifferenz);
                                    final TextView eingabe2 = (TextView) findViewById(R.id.TextViewAntwortUser);
                                    final EditText antwort2 = (EditText) findViewById(R.id.EditTextEingabeAntwort);
                                    final TextView yourLife = (TextView) findViewById(R.id.yourLife);

                                    eingabe2.setText("");
                                    diff2.setText("");
                                    antwort2.setText("");

                                    final long zahl3;
                                    final long zahl4 = parseLong(db.fragenUAntwortenArrayList().get(ant2).getAntworten());
                                    buttonNaechsteFrage.setVisibility(View.INVISIBLE);

                                    final Button buttonLoesen = (Button) findViewById(R.id.buttonLoesen);
                                    buttonLoesen.setOnClickListener(new View.OnClickListener() {
                                        public void onClick(View v) {

                                            tv4.setText(db.fragenUAntwortenArrayList().get(ant2).getAntworten());

                                            if (!TextUtils.isEmpty(antwort2.getText().toString().trim())) {

                                                eingabe2.setText(antwort2.getText().toString());

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


