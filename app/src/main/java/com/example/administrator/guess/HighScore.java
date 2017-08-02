package com.example.administrator.guess;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class HighScore extends AppCompatActivity {
    private DataBaseHandler db;
    private TextView tv1Score;
    private TextView tv2Score;
    private TextView tv3Score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score2);

        db = new DataBaseHandler(this);
        tv1Score = (TextView) findViewById(R.id.tv1Score);
        tv2Score = (TextView) findViewById(R.id.tv2Score);
        tv3Score = (TextView) findViewById(R.id.tv3Score);

        Log.d("RAIK", " " + db.getSize("Highscore"));

        switch (db.getSize("Highscore")) {
            case 1:
                tv1Score.setText(db.getAllHighscores().get(0).getScore());
                break;
            case 2:
                tv1Score.setText(db.getAllHighscores().get(0).getScore());
                tv2Score.setText(db.getAllHighscores().get(1).getScore());
                break;
            case 3:
                tv1Score.setText(db.getAllHighscores().get(0).getScore());
                tv2Score.setText(db.getAllHighscores().get(1).getScore());
                tv3Score.setText(db.getAllHighscores().get(2).getScore());
                break;
            default:
        }
    }
}
