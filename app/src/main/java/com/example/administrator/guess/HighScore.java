package com.example.administrator.guess;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HighScore extends AppCompatActivity {
    private DataBaseHandler db;
    private TextView tv1Name;
    private TextView tv1Score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score2);

        db = new DataBaseHandler(this);
        tv1Name = (TextView) findViewById(R.id.tv1Name);
        tv1Score = (TextView) findViewById(R.id.tv1Score);

        tv1Name.setText(db.getAllHighscores().get(0).getUsername());
        tv1Score.setText(db.getAllHighscores().get(0).getScore());


        Log.d("RAIK", db.getAllHighscores().get(0).getScore());
        Log.d("RAIK", db.getAllHighscores().get(0).getUsername());
    }

}
