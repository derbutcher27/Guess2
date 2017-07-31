package com.example.administrator.guess;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

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
