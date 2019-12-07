package com.example.focusapplicationfinal;


import androidx.appcompat.app.AppCompatActivity;
import android.os.CountDownTimer;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StartPage extends MainActivity {

    private Button quitFocus;
    private long totalTime;
    private long interval;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);

        quitFocus = findViewById(R.id.quitButton);
        quitFocus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newFile();
            }
        });
        text = findViewById(R.id.txt);
    }

    public void timer() {
        switch (getStatus()) {
            default:
                break;
            case 0:
                totalTime = 1800000;
                break;
            case 1:
                totalTime = 2700000;
                break;
            case 2:
                totalTime = 3600000;
                break;
            case 3:
                totalTime = 5400000;
                break;
            case 4:
                totalTime = 7200000;
                break;
        }
        CountDownTimer timer = new CountDownTimer(totalTime, interval) {
            public void onTick(long millisUntilFinished) {
                long minutes = (millisUntilFinished / 1000) / 60;
                long seconds = (millisUntilFinished / 1000) % 60;
                String remaining = minutes + ":" + seconds;
                text.setText(remaining);
            }

            public void onFinish() {
                text.setText("You're done!");
            }
        }.start();
    }

    public void newFile() {
        Intent intent = new Intent(StartPage.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
