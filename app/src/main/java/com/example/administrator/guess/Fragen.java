package com.example.administrator.guess;


import android.support.v7.app.AppCompatActivity;

public class Fragen extends AppCompatActivity {

    public void addFragen()

    {
        DataBaseHandler db = new DataBaseHandler(this);
        db.addFrage(new FragenUAntworten("Wie?", "500"));

    }
}
