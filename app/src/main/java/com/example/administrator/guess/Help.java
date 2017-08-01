package com.example.administrator.guess;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class Help extends AppCompatActivity {

    private TextView help1;
    private TextView help2;
    private TextView help3;
    private TextView help4;
    private TextView help5;
    private TextView help6;
    private TextView help7;
    private TextView help8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        help1 = (TextView) findViewById(R.id.help1);
        help2 = (TextView) findViewById(R.id.help2);
        help3 = (TextView) findViewById(R.id.help3);
        help4 = (TextView) findViewById(R.id.help4);
        help5 = (TextView) findViewById(R.id.help5);
        help6 = (TextView) findViewById(R.id.help6);
        help7 = (TextView) findViewById(R.id.help7);
        help8 = (TextView) findViewById(R.id.help8);

        help1.setText(R.string.help1);
        help2.setText(R.string.help2);
        help3.setText(R.string.help3);
        help4.setText(R.string.help4);
        help5.setText(R.string.help5);
        help6.setText(R.string.help6);
        help7.setText(R.string.help7);
        help8.setText(R.string.help8);



    }

}
