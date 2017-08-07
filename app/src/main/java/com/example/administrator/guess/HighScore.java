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
    private TextView tv1Score, tv2Score, tv3Score, tv4Score, tv5Score, tv6Score, tv7Score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score2);

        db = new DataBaseHandler(this);
        tv1Score = (TextView) findViewById(R.id.tv1Score);
        tv2Score = (TextView) findViewById(R.id.tv2Score);
        tv3Score = (TextView) findViewById(R.id.tv3Score);
        tv4Score = (TextView) findViewById(R.id.tv3Score);
        tv5Score = (TextView) findViewById(R.id.tv3Score);
        tv6Score = (TextView) findViewById(R.id.tv3Score);
        tv7Score = (TextView) findViewById(R.id.tv3Score);

        Log.d("RAIK", " " + db.getSize("Highscore"));
        Log.d("RAIK", " dfgdfg");

        switch (db.getSize("Highscore")) {
            case 1:
                tv1Score.setText(db.getAllHighscores().get(0).getScore() + " " + " " + db.getAllHighscores().get(0).getDate());
                break;
            case 2:
                tv1Score.setText(db.getAllHighscores().get(0).getScore() + " " + " " + db.getAllHighscores().get(0).getDate());
                tv2Score.setText(db.getAllHighscores().get(1).getScore() + " " + " " + db.getAllHighscores().get(1).getDate());
                break;
            case 3:
                tv1Score.setText(db.getAllHighscores().get(0).getScore() + " " + " " + db.getAllHighscores().get(0).getDate());
                tv2Score.setText(db.getAllHighscores().get(1).getScore() + " " + " " + db.getAllHighscores().get(1).getDate());
                tv3Score.setText(db.getAllHighscores().get(2).getScore() + " " + " " + db.getAllHighscores().get(2).getDate());
                break;
            case 4:
                tv1Score.setText(db.getAllHighscores().get(0).getScore() + " " + " " + db.getAllHighscores().get(0).getDate());
                tv2Score.setText(db.getAllHighscores().get(1).getScore() + " " + " " + db.getAllHighscores().get(1).getDate());
                tv3Score.setText(db.getAllHighscores().get(2).getScore() + " " + " " + db.getAllHighscores().get(2).getDate());
                tv4Score.setText(db.getAllHighscores().get(3).getScore() + " " + " " + db.getAllHighscores().get(3).getDate());
                break;
            case 5:
                tv1Score.setText(db.getAllHighscores().get(0).getScore() + " " + " " + db.getAllHighscores().get(0).getDate());
                tv2Score.setText(db.getAllHighscores().get(1).getScore() + " " + " " + db.getAllHighscores().get(1).getDate());
                tv3Score.setText(db.getAllHighscores().get(2).getScore() + " " + " " + db.getAllHighscores().get(2).getDate());
                tv4Score.setText(db.getAllHighscores().get(3).getScore() + " " + " " + db.getAllHighscores().get(3).getDate());
                tv5Score.setText(db.getAllHighscores().get(4).getScore() + " " + " " + db.getAllHighscores().get(4).getDate());
                break;
            case 6:
                tv1Score.setText(db.getAllHighscores().get(0).getScore() + " " + " " + db.getAllHighscores().get(0).getDate());
                tv2Score.setText(db.getAllHighscores().get(1).getScore() + " " + " " + db.getAllHighscores().get(1).getDate());
                tv3Score.setText(db.getAllHighscores().get(2).getScore() + " " + " " + db.getAllHighscores().get(2).getDate());
                tv4Score.setText(db.getAllHighscores().get(3).getScore() + " " + " " + db.getAllHighscores().get(3).getDate());
                tv5Score.setText(db.getAllHighscores().get(4).getScore() + " " + " " + db.getAllHighscores().get(4).getDate());
                tv6Score.setText(db.getAllHighscores().get(5).getScore() + " " + " " + db.getAllHighscores().get(5).getDate());
                break;
            case 7:
                tv1Score.setText(db.getAllHighscores().get(0).getScore() + " " + " " + db.getAllHighscores().get(0).getDate());
                tv2Score.setText(db.getAllHighscores().get(1).getScore() + " " + " " + db.getAllHighscores().get(1).getDate());
                tv3Score.setText(db.getAllHighscores().get(2).getScore() + " " + " " + db.getAllHighscores().get(2).getDate());
                tv4Score.setText(db.getAllHighscores().get(3).getScore() + " " + " " + db.getAllHighscores().get(3).getDate());
                tv5Score.setText(db.getAllHighscores().get(4).getScore() + " " + " " + db.getAllHighscores().get(4).getDate());
                tv6Score.setText(db.getAllHighscores().get(5).getScore() + " " + " " + db.getAllHighscores().get(5).getDate());
                tv7Score.setText(db.getAllHighscores().get(6).getScore() + " " + " " + db.getAllHighscores().get(6).getDate());
                break;
            default:
        }
    }
}
