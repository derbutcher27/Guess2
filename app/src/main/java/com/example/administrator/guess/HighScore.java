package com.example.administrator.guess;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class HighScore extends AppCompatActivity {
    private DataBaseHandler db;
    private TextView tv1Name;
    private TextView tv1Score;
    private TextView tv2Name;
    private TextView tv2Score;
    private TextView tv3Name;
    private TextView tv3Score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score2);

        db = new DataBaseHandler(this);
        tv1Name = (TextView) findViewById(R.id.tv1Name);
        tv1Score = (TextView) findViewById(R.id.tv1Score);
        tv2Name = (TextView) findViewById(R.id.tv2Name);
        tv2Score = (TextView) findViewById(R.id.tv2Score);
        tv3Name = (TextView) findViewById(R.id.tv3Name);
        tv3Score = (TextView) findViewById(R.id.tv3Score);

        if (db.getSize("Highscore") == 0) {
        } else {
            tv1Name.setText(db.getAllHighscores().get(0).getUsername());
            tv1Score.setText(db.getAllHighscores().get(0).getScore());
            tv2Name.setText(db.getAllHighscores().get(1).getUsername());
            tv2Score.setText(db.getAllHighscores().get(1).getScore());
            tv3Name.setText(db.getAllHighscores().get(2).getUsername());
            tv3Score.setText(db.getAllHighscores().get(2).getScore());
        }
    }

}
