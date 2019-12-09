package com.example.focusapplicationfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        thirtyMin = findViewById(R.id.thirtybutton);
        thirtyMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timerStatus = 0;
                newFile();
            }
        });

        fortyFiveMin = findViewById(R.id.fortyfivebutton);
        fortyFiveMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timerStatus = 1;
                newFile();
            }
        });

        oneHour = findViewById(R.id.onebutton);
        oneHour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timerStatus = 2;
                newFile();
            }
        });

        oneThirtyHours = findViewById(R.id.onethirtybutton);
        oneThirtyHours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timerStatus = 3;
                newFile();
            }
        });

        twoHours = findViewById(R.id.twobutton);
        twoHours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timerStatus = 4;
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
    }

    public int getStatus() {
        return timerStatus;
    }
    public void setStatus(int t) {
        timerStatus = t;
    }


    public void newFile() {
        Intent intent = new Intent(MainActivity.this, StartPage.class);
        startActivity(intent);
        finish();
    }
    public void newFileTwo() {
        Intent intent = new Intent(MainActivity.this, DataPage.class);
        startActivity(intent);
        finish();
    }
}
