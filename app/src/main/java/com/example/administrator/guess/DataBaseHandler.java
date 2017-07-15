package com.example.administrator.guess;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHandler extends SQLiteOpenHelper {

    private int dbSize;
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "guessDB";
    // Table Name
    private static final String TABLE_NAME = "FragenUAntworten";

    // Columns of Table "FragenUAntworten"
    private static final String ID = "ID";
    private static final String FRAGE = "Fragen";
    private static final String ANTWORT = "Antworten";

    public DataBaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_FRAGEN_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + ID + " INTEGER PRIMARY KEY," + FRAGE + " TEXT,"
                + ANTWORT + " TEXT" + ")";
        db.execSQL(CREATE_FRAGEN_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    void addFrage(FragenUAntworten fragenUAntworten) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(FRAGE, fragenUAntworten.getFrage());
        cv.put(ANTWORT, fragenUAntworten.getAntwort());

        db.insert(TABLE_NAME, null, cv);
        db.close();
    }

    // Getting All Fragen
    public List<FragenUAntworten> getAllFragen() {
        List<FragenUAntworten> FragenList = new ArrayList<FragenUAntworten>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                FragenUAntworten fragenUAntworten = new FragenUAntworten();
                fragenUAntworten.setID(Integer.parseInt(cursor.getString(0)));
                fragenUAntworten.setFrage(cursor.getString(1));
                fragenUAntworten.setAntwort(cursor.getString(2));
                // Adding Frage to list
                FragenList.add(fragenUAntworten);
            } while (cursor.moveToNext());
        }

        // return Fragen list
        return FragenList;
    }

    public int getSize() {
        SQLiteDatabase db = this.getReadableDatabase();
        long dbSize = DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        db.close();
        Integer dbSizeINT = (int) (long) dbSize;

        return dbSizeINT;
    }
}
