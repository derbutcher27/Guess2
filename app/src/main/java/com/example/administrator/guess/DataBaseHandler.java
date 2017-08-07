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
    // Table Name fuer FragenUAntworten
    private static final String TABLE_NAME_FA = "FragenUAntworten";

    // Table Name fuer Highscore
    private static final String TABLE_NAME_HS = "Highscore";
    //Columns of Table "Highscore"
    private static final String SCORE = "score";
    private static final String DATE = "date";


    // Table Name fuer XP
    private static final String TABLE_NAME_XP = "Experience";
    //Columns of Table "XP"
    private static final String XP = "xp";
    //Columns of Table "RANKING"

    // Columns of Table "FragenUAntworten"
    private static final String ID = "ID";
    private static final String FRAGE = "Fragen";
    private static final String ANTWORT = "Antworten";

    public DataBaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_FRAGEN_TABLE = "CREATE TABLE " + TABLE_NAME_FA + "("
                + ID + " INTEGER PRIMARY KEY," + FRAGE + " TEXT,"
                + ANTWORT + " TEXT" + ")";
        db.execSQL(CREATE_FRAGEN_TABLE);

        String CREATE_HIGHSCORE_TABLE = "CREATE TABLE " + TABLE_NAME_HS + "("
                + ID + " INTEGER PRIMARY KEY," + DATE + " TEXT,"
                + SCORE + " INTEGER" + ")";
        db.execSQL(CREATE_HIGHSCORE_TABLE);

        String CREATE_XP_TABLE = "CREATE TABLE " + TABLE_NAME_XP + "("
                + ID + " INTEGER PRIMARY KEY," + XP + " INTEGER" + ")";
        db.execSQL(CREATE_XP_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_FA);

        // Create tables again
        onCreate(db);
    }

    void addFrage(FragenUAntworten fragenUAntworten) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(FRAGE, fragenUAntworten.getFrage());
        cv.put(ANTWORT, fragenUAntworten.getAntwort());

        db.insert(TABLE_NAME_FA, null, cv);
        db.close();
    }

    // Getting All Fragen
    public List<FragenUAntworten> getAllFragen() {
        List<FragenUAntworten> FragenList = new ArrayList<FragenUAntworten>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME_FA;

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

    //read DBsize of table FragenUAntworten
    public int getSize(String tabellenName) {
        SQLiteDatabase db = this.getReadableDatabase();
        long dbSize = DatabaseUtils.queryNumEntries(db, tabellenName);
        db.close();
        Integer dbSizeINT = (int) (long) dbSize;

        return dbSizeINT;
    }

    public void addHighscore(HighscoreWorker highscore) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DATE, highscore.getDate());
        cv.put(SCORE, highscore.getScore());

        db.insert(TABLE_NAME_HS, null, cv);
        db.close();
    }

    // Getting All HighScores
    public List<HighscoreWorker> getAllHighscores() {
        List<HighscoreWorker> HighScoreList = new ArrayList<HighscoreWorker>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME_HS + " order by " + SCORE + " desc";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                HighscoreWorker hsworker = new HighscoreWorker();
                hsworker.setID(Integer.parseInt(cursor.getString(0)));
                hsworker.setDate(cursor.getString(1));
                hsworker.setScore(cursor.getInt(2));
                // Adding Highscore to list
                HighScoreList.add(hsworker);
            } while (cursor.moveToNext());
        }

        // return Highscore list
        return HighScoreList;
    }

    public void addExperience(ErfahrungsstufenHandler erfahrung) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(XP, erfahrung.getXp());

        db.insert(TABLE_NAME_XP, null, cv);
        db.close();
    }

    // Getting All HighScores
    public List<ErfahrungsstufenHandler> getAllXP() {
        List<ErfahrungsstufenHandler> XPList = new ArrayList<ErfahrungsstufenHandler>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME_XP;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ErfahrungsstufenHandler efshandler = new ErfahrungsstufenHandler();
                efshandler.setID(Integer.parseInt(cursor.getString(0)));
                efshandler.setXp(cursor.getString(1));
                // Adding XP to list
                XPList.add(efshandler);
            } while (cursor.moveToNext());
        }

        // return XPList list
        return XPList;
    }

}
