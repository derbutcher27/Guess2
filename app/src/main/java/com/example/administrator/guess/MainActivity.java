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
import static com.example.administrator.guess.R.id.antwort;
import static com.example.administrator.guess.R.id.eingabe;
import static com.example.administrator.guess.R.id.tv1;
import static com.example.administrator.guess.R.id.yourLife;
import static java.lang.Long.parseLong;

//import static com.example.administrator.guess.DataBaseHandler.ArrayValue;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "LOG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide(); //<< this
        setContentView(R.layout.activity_main);

        final DataBaseHandler db = new DataBaseHandler(getApplicationContext(), "FragenUAntworten", 1);
        FragenUAntworten fragenUAntworten = new FragenUAntworten();

        //Neue Frage hinzufügen
        fragenUAntworten.setId(1);
        fragenUAntworten.setFragen("Wie hoch ist die ISS (in KM) ?");
        fragenUAntworten.setAntworten("400");
        db.addBook(fragenUAntworten);

        //Neue Frage hinzufügen
        fragenUAntworten.setId(2);
        fragenUAntworten.setFragen("Wie hoch ist die ISS (in KM) ?");
        fragenUAntworten.setAntworten("400");
        db.addBook(fragenUAntworten);
        //Neue Frage hinzufügen
        fragenUAntworten.setId(3);
        fragenUAntworten.setFragen("Wie hoch ist die ISS (in KM) ?");
        fragenUAntworten.setAntworten("400");
        db.addBook(fragenUAntworten);
        //Neue Frage hinzufügen
        fragenUAntworten.setId(4);
        fragenUAntworten.setFragen("Wie hoch ist die ISS (in KM) ?");
        fragenUAntworten.setAntworten("400");
        db.addBook(fragenUAntworten);
        //Neue Frage hinzufügen
        fragenUAntworten.setId(5);
        fragenUAntworten.setFragen("Wie hoch ist die ISS (in KM) ?");
        fragenUAntworten.setAntworten("400");
        db.addBook(fragenUAntworten);
        //Neue Frage hinzufügen
        fragenUAntworten.setId(6);
        fragenUAntworten.setFragen("Wie hoch ist die ISS (in KM) ?");
        fragenUAntworten.setAntworten("400");
        db.addBook(fragenUAntworten);


        Random rand = new Random();
        int n = rand.nextInt(5);

        final int ant = n;
        int fr = n;

        final long zahl1;
        final long zahl2 = parseLong(db.fragenUAntwortenArrayList().get(ant).getAntworten());

        TextView tv1 = (TextView) findViewById(R.id.tv1);
        tv1.setText(db.fragenUAntwortenArrayList().get(fr).getFragen());

        final TextView tv2 = (TextView) findViewById(R.id.tv2);
        tv2.setText("");

        final TextView diff = (TextView) findViewById(R.id.diff);
        final TextView eingabe = (TextView) findViewById(R.id.eingabe);
        final EditText antwort = (EditText) findViewById(R.id.antwort);
        final TextView yourLife = (TextView) findViewById(R.id.yourLife);


        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                tv2.setText(db.fragenUAntwortenArrayList().get(ant).getAntworten());

                if (!TextUtils.isEmpty(antwort.getText().toString().trim())) {

                    eingabe.setText(antwort.getText().toString());

                    long zahl1 = parseLong(antwort.getText().toString());
                    double prozRechnung = Math.abs(100 - zahl1 * 100 / zahl2);
                    double leben = 100 - prozRechnung;

                    if (prozRechnung >= 100) {
                        diff.setText("Du hast verloren! Du lagst: " + prozRechnung + "% daneben!");
                        yourLife.setText("0");
                    } else {
                        diff.setText("Du lagst: " + prozRechnung + "% daneben!");
                        yourLife.setText("");
                    }
                } else {
                    antwort.setError("Darf nicht leer sein");
                }
            }

        });


        final Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (!TextUtils.isEmpty(diff.getText().toString().trim())) {

                    Random rand2 = new Random();
                    int n = rand2.nextInt(5);

                    final int ant2 = n;
                    int fr2 = n;

                    TextView tv3 = (TextView) findViewById(R.id.tv1);
                    tv3.setText(db.fragenUAntwortenArrayList().get(fr2).getFragen());

                    final TextView tv4 = (TextView) findViewById(R.id.tv2);
                    tv4.setText("");

                    final TextView diff2 = (TextView) findViewById(R.id.diff);
                    final TextView eingabe2 = (TextView) findViewById(R.id.eingabe);
                    final EditText antwort2 = (EditText) findViewById(R.id.antwort);
                    final TextView yourLife2 = (TextView) findViewById(R.id.yourLife);

                    eingabe2.setText("");
                    diff2.setText("");
                    antwort2.setText("");

                    final long zahl3;
                    final long zahl4 = parseLong(db.fragenUAntwortenArrayList().get(ant2).getAntworten());

                    final Button button = (Button) findViewById(R.id.button);
                    button.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {

                            tv4.setText(db.fragenUAntwortenArrayList().get(ant2).getAntworten());

                            if (!TextUtils.isEmpty(antwort2.getText().toString().trim())) {

                                eingabe2.setText(antwort2.getText().toString());

                                long zahl3 = parseLong(antwort2.getText().toString());
                                double prozRechnung = Math.abs(100 - zahl3 * 100 / zahl4);

                                if (prozRechnung >= 100) {
                                    diff2.setText("Du hast verloren! Du lagst: " + prozRechnung + "% daneben!");
                                    yourLife2.setText("0");
                                } else {
                                    diff2.setText("Du lagst: " + prozRechnung + "% daneben!");
                                    yourLife2.setText("");


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

}


