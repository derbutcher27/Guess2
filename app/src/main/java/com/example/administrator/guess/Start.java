package com.example.administrator.guess;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DataBaseHandler db = new DataBaseHandler(this);

        //ueberpueft ob Fragen bereits in der DB vorhanden sind und fuegt sie wenn noetig hinzu
        if (db.getSize("FragenUAntworten") != 0) {
        } else {
            db.addFrage(new FragenUAntworten("Wie viele Weihnachtsbäume werden in Deutschland pro Jahr verkauft?","30000000"));
            db.addFrage(new FragenUAntworten("Im Jahr 2013 gab es in Deutschland ungefähr 15.000 Tankstellen. Wie viele Tankstellen gab es vor noch 50 Jahren um das Jahr 1970?","60000"));
            db.addFrage(new FragenUAntworten("Wie viele Liter Bier werden in Deutschland pro Kopf jährlich getrunken?","100"));
            db.addFrage(new FragenUAntworten("Wie viele Piratenüberfälle gab es 2012 weltweit?","300"));
            db.addFrage(new FragenUAntworten("Wie viele Menschen in Deutschland nutzen ein Smartphone?","40000000"));
            db.addFrage(new FragenUAntworten("Wie viele gesetzliche Krankenkassen gibt es in Deutschland?","1815"));
            db.addFrage(new FragenUAntworten("Wie viele Kinder wurden 2014 nicht im Krankenhaus geboren?","11391"));
            db.addFrage(new FragenUAntworten("Durchschnittliche Entferung, in der Menschen in den USA zu Ihrer Mutter Wohnen (km)", "29"));
            db.addFrage(new FragenUAntworten("Wie viel Prozent der Tinder Nutzer sind in einer Beziehung?", "42"));
            db.addFrage(new FragenUAntworten("Betrag, den Facebook-Mitarbeiter bekommen können, wenn sie ihre Eizelle einfrieren lassen ($)", "20000"));
            db.addFrage(new FragenUAntworten("Feinstaubbelastung in Deutschland durch den Straßenverkehr eines Monats (t)", "2222"));
            db.addFrage(new FragenUAntworten("Feinstaubbelastung in Deutschland durch die Feuerwerke einer Sylvesternacht (t)", "4000"));
            db.addFrage(new FragenUAntworten("Bei welchen Olympischen Spielen gab es die ersten Goldmedaillen für die Sieger?", "1908"));
            db.addFrage(new FragenUAntworten("Wann wurde das World Wide Web öffentlich nutzbar gemacht?", "1990"));
            db.addFrage(new FragenUAntworten("In Welchem Jahr wurde die erste Domain unter der Top Level Domain .com registriert?", "1985"));
            db.addFrage(new FragenUAntworten("Wie viele .com Domains gab es im September 2009?", "82447376"));
            db.addFrage(new FragenUAntworten("Wer hoch ist das höchste Gebäude (m) ?", "828"));
            db.addFrage(new FragenUAntworten("Wie hoch ist der Mt. Everest (m) ?", "8848"));
            db.addFrage(new FragenUAntworten("In welchem Jahr fiel die Berliner Mauer ?", "1989"));
            db.addFrage(new FragenUAntworten("Wie schnell ist ein Gepard (km/h) ?", "120"));
            db.addFrage(new FragenUAntworten("Wie lang ist der Mittellandkanal (km) ?", "325"));
            db.addFrage(new FragenUAntworten("Wie viel darf ein Boxer der Fliegengewichtklasse maximal wiegen (kg) ?", "51"));
            db.addFrage(new FragenUAntworten("In welchem Jahr kam die CD auf den Markt ?", "1982"));
            db.addFrage(new FragenUAntworten("Wie viele Stellen hat der Strichcode der Europäischen Artikelnummer ?", "19"));
            db.addFrage(new FragenUAntworten("Wie oft wird der Deutsche Aktienindex (DAX) pro Stunde errechnet ?", "3600"));
            db.addFrage(new FragenUAntworten("Wie viele Federn hat ein ausgewachsener Schwan ?", "25000"));
            db.addFrage(new FragenUAntworten("Wie hoch ist der Berliner Fernsehturm (m) ?", "365"));
            db.addFrage(new FragenUAntworten("Wie viele Jahre braucht ein Mensch, um bis 1 Milliarde zu zählen ?", "80"));
            db.addFrage(new FragenUAntworten("Wie viele Buchstaben hat das hawaiianische Alphabet?", "12"));
            db.addFrage(new FragenUAntworten("Wie viel Einkerbungen hat ein Golfball ?", "336"));
            db.addFrage(new FragenUAntworten("Wie viele Buchstaben hat das längste englische Wort laut dem Oxford Dictionary ?", "44"));
            db.addFrage(new FragenUAntworten("Wie viele Räume hat der Buckingham Palast ?", "602"));
            db.addFrage(new FragenUAntworten("Wie viele Minuten muss man ein Straußenei kochen, bis es hartgekocht ist ?", "40"));
            db.addFrage(new FragenUAntworten("Ein ausgewachsener Mensch besitzt 206 Knochen - aber mit Wie vielen werden wir geboren?", "301"));
            db.addFrage(new FragenUAntworten("Wie hoch ist das weltweite Durchschnittsalter beim 1. Sex ?", "17"));
            db.addFrage(new FragenUAntworten("Wie viele Teile Besteck gibt es im Weißen Haus ?", "13092"));
            db.addFrage(new FragenUAntworten("Wie viel Prozent der Weltbevölkerung hat noch nie einen Telefonanruf erhalten oder getätigt ?", "53"));
            db.addFrage(new FragenUAntworten("Wann wurde die Riesenschildkröte Awiata geboren, die 2006 als älteste ihrer Art im Zoo von Kalkutta gestorben ist ?", "1750"));
            db.addFrage(new FragenUAntworten("Wie tief ist der tiefste natürliche See Deutschlands ?", "254"));
            db.addFrage(new FragenUAntworten("Wie viele Kinder brachten unter 15 Jährige Mädchen 2014 insgesamt zur Welt ?", "66"));
            db.addFrage(new FragenUAntworten("Wie viele Menschen saßen 2015 in Deutschland im Gefängnis ?", "61872"));
            db.addFrage(new FragenUAntworten("In welchem Jahr fand die Markteinführung der Playmobilfiguren statt?", "1974"));
            db.addFrage(new FragenUAntworten("Wie viele Spiele absolvierte Franz Beckenbauer für die deutsche Nationalmannschaft ?", "103"));
            db.addFrage(new FragenUAntworten("In welchem Jahr startete in Deutschland Wer wird Millionär ?", "1999"));
            db.addFrage(new FragenUAntworten("Wie alt wurde Konrad Adenauer?", "91"));
            db.addFrage(new FragenUAntworten("Wann wurde der erste McDonals-Drive-In eingeführt ?", "1975"));
            db.addFrage(new FragenUAntworten("Aus Wie vielen Inseln bestehen die Malediven ?", "1196"));
            db.addFrage(new FragenUAntworten("Wie viele Stunden Videomaterial werden pro Minute weltweit bei YouTube hochgeladen ?", "48"));
            db.addFrage(new FragenUAntworten("In welchem Jahr wurde in Berlin das erste deutsche Telefonbuch veröffentlicht ?", "1881"));
            db.addFrage(new FragenUAntworten("Seit wann existiert die Verkehrssünderkartei in Flensburg ?", "1958"));
            db.addFrage(new FragenUAntworten("Wie hoch ist der höchste Baum Deutschlands (m) ?", "63"));
            db.addFrage(new FragenUAntworten("Wie viele Sterne sieht man von der Erde aus mit dem bloßen Auge ?", "6000"));
            db.addFrage(new FragenUAntworten("Vor wie vielen Jahren wurde Geld erfunden ? ", "7000"));
            db.addFrage(new FragenUAntworten("Wie viele Schritte muss man etwa gehen, um von Karlsruhe nach Stuttgart zu kommen ?", "118500"));
            db.addFrage(new FragenUAntworten("Wie viele Satelliten befinden sich im All ?", "1200"));
            db.addFrage(new FragenUAntworten("Wie viele Scheidungen gab es 2013 in Deutschland ?", "170000"));
            db.addFrage(new FragenUAntworten("Wie viele Kinder sterben weltweit täglich infolge unsauberem Trinkwasser ?", "6000"));
            db.addFrage(new FragenUAntworten("Wie viele Liter Wasser werden benötigt, um 1 Kilo Baumwolle anzubauen ?", "10000"));
            db.addFrage(new FragenUAntworten("Wie warm kann es an der Oberfläche der Sonne werden (Grad Celsius) ?", "5780"));
            db.addFrage(new FragenUAntworten("Wie viele (bekannte) Insektenarten gibt es in der Schweiz ?", "22300"));
            db.addFrage(new FragenUAntworten("Wie viele Unternehmen gab es 2015 in Deutschland ?", "3469039"));
            db.addFrage(new FragenUAntworten("Wie viele Kilometer legt ein TShirt insgesamt zurück bis es fertig im Laden hängt ?", "50000"));
            db.addFrage(new FragenUAntworten("Wie lang ist ein Marathon (m) ?", "42195"));
            db.addFrage(new FragenUAntworten("Wie hoch war das durchschnittliche Bruttoentgelt in Deutschland 2015", "34999"));
            db.addFrage(new FragenUAntworten("Wie viele Kennzeichenkürzel gab es 2013 in Deutschland", "777"));

            db.addFrage(new FragenUAntworten("Wie viel Geld geben Männer durchschnittlich im Monat für Kleidung aus? (€)", "23"));
            db.addFrage(new FragenUAntworten("Wie viel Geld geben Frauen durchschnittlich im Monat für Kleidung aus? (€)", "44"));
            db.addFrage(new FragenUAntworten("Wie viel Geld geben Deutsche durchschnittlich für einen Neuwagen aus (€)", "31400"));
        }

        setContentView(R.layout.activity_start);

        Button start = (Button) findViewById(R.id.btnStart);
        start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(Start.this, MainActivity.class);
                startActivity(i);
            }
        });

        Button highscore = (Button) findViewById(R.id.btnHighScore);
        highscore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Start.this, HighScore.class);
                startActivity(i);
            }
        });

        Button hilfe = (Button) findViewById(R.id.btnHilfe);
        hilfe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Start.this, Help.class);
                startActivity(i);
            }
        });
    }



}
