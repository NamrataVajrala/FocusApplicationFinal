package com.example.focusapplicationfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button thirtyMin;
    private Button fortyFiveMin;
    private Button oneHour;
    private Button oneThirtyHours;
    private Button twoHours;
    private Button achieve;
    private int timerStatus;
    private Intent mainIntent;
    private Intent scoreIntent;

    private int[] arr = new int[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainIntent = new Intent(MainActivity.this, StartPage.class);

        scoreIntent = new Intent(MainActivity.this, DataPage.class);
        setContentView(R.layout.activity_main);
        thirtyMin = findViewById(R.id.thirtybutton);
        thirtyMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timerStatus = 0;
                mainIntent.putExtra("timer", timerStatus);
                newFile();
            }
        });

        fortyFiveMin = findViewById(R.id.fortyfivebutton);
        fortyFiveMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timerStatus = 1;
                mainIntent.putExtra("timer", timerStatus);
                newFile();
            }
        });

        oneHour = findViewById(R.id.onebutton);
        oneHour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timerStatus = 2;
                mainIntent.putExtra("timer", timerStatus);
                newFile();
            }
        });

        oneThirtyHours = findViewById(R.id.onethirtybutton);
        oneThirtyHours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timerStatus = 3;
                mainIntent.putExtra("timer", timerStatus);
                newFile();
            }
        });

        twoHours = findViewById(R.id.twobutton);
        twoHours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timerStatus = 4;
                mainIntent.putExtra("timer", timerStatus);
                newFile();
            }
        });

        achieve = findViewById(R.id.dataButton);
        achieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newFileTwo();
            }
        });
        mainIntent.putExtra("array", arr);
    }

    public int getStatus() {
        return timerStatus;
    }

    public void newFile() {
        startActivity(mainIntent);
        finish();
    }

    public void newFileTwo() {
        startActivity(scoreIntent);
        finish();
    }
}
