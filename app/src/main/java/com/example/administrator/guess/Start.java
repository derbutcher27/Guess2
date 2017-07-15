package com.example.administrator.guess;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        DataBaseHandler db = new DataBaseHandler(this);
        db.addFrage(new FragenUAntworten("Wie weit ist der Mond von der Erde entfernt (in km)?", "384000"));
       // Log.d("RAIK", "" + db.getSize());
        Log.d("RAIK", "fsdfsdf");
        //Fragen.addFragen();

        setContentView(R.layout.activity_start);

        Button start = (Button) findViewById(R.id.btnStart);
        start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(Start.this, MainActivity.class);

                startActivity(i);
            }

        });

        Button kapitel = (Button) findViewById(R.id.btnKapitel);
        kapitel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(Start.this, Kapitel.class);
                startActivity(i);
            }

        });

        Button hilfe = (Button) findViewById(R.id.btnHilfe);
        hilfe.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(Start.this, Help.class);
                startActivity(i);
            }

        });

    }

}
