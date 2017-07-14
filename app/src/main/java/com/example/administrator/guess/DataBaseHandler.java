package com.example.administrator.guess;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static com.example.administrator.guess.R.id.TextViewFrageDB;
import static java.security.AccessController.getContext;


public class DataBaseHandler extends SQLiteOpenHelper {

    public String FragenUAntwortenTable = "FragenUAntworten";
    public String FuA_Id = "id";
    public String Fragen = "Fragen";
    public String Antworten = "Antworten";
    public String Kapitel = "Kapitel";

    private final int DB_Version = 1;

    public DataBaseHandler(Context context, String DBName, int DBVersion) {
        super(context, DBName, null, DBVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table " + FragenUAntwortenTable + "(" + FuA_Id + " INTEGER PRIMARY KEY, " + Fragen + " Text, " + Antworten + " Text, " + Kapitel + " Text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addFrageUndAntwort(FragenUAntworten fragenUAntworten) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FuA_Id, fragenUAntworten.getId());
        values.put(Fragen, fragenUAntworten.getFragen());
        values.put(Antworten, fragenUAntworten.getAntworten());
        values.put(Kapitel, fragenUAntworten.getKapitel());

        db.insert(FragenUAntwortenTable, null, values);
        db.close();
    }


    public ArrayList<FragenUAntworten> fragenUAntwortenArrayList() {
        ArrayList<FragenUAntworten> FuAList = new ArrayList<FragenUAntworten>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.query(FragenUAntwortenTable, null, null, null, null, null, null);
        c.moveToFirst();

        while (!c.isAfterLast()) {
            FragenUAntworten fragenUAntworten = new FragenUAntworten();
            fragenUAntworten.setId(c.getInt(0));
            fragenUAntworten.setFragen(c.getString(1));
            fragenUAntworten.setAntworten(c.getString(2));
            fragenUAntworten.setKapitel(c.getString(3));
            FuAList.add(fragenUAntworten);
            c.moveToNext();

        }

        db.close();
        return FuAList;

    }

    //public static String ArrayValue = FragenUAntworten. ;

}
