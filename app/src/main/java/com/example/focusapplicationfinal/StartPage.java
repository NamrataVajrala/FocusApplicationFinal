package com.example.focusapplicationfinal;


import androidx.appcompat.app.AppCompatActivity;
import android.os.CountDownTimer;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class StartPage extends MainActivity {

    private Button quitFocus;
    private long totalTime;
    private TextView text;
    private CountDownTimer timer;
    private ImageView geoffim;
    private ImageView benim;
    private ImageView chuchuim;
    private ImageView xyzim;
    private ImageView csim;
    private TextView prizeLabel;
    private int geoffscore;
    private int benscore;
    private int chuchuscore;
    private int xyzscore;
    private int csscore;
    private int chosenTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
        Intent passed = getIntent();
        chosenTime = passed.getIntExtra("timer", 0);
        quitFocus = findViewById(R.id.quitButton);
        quitFocus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newFile();
            }
        });

        text = findViewById(R.id.txt);
        geoffim = findViewById(R.id.geoffimage);
        benim = findViewById(R.id.benimage);
        chuchuim = findViewById(R.id.chuchuimage);
        xyzim = findViewById(R.id.xyzimage);
        csim = findViewById(R.id.csimage);
        prizeLabel = findViewById(R.id.prizelabel);

        geoffim.setVisibility(View.GONE);
        benim.setVisibility(View.GONE);
        chuchuim.setVisibility(View.GONE);
        xyzim.setVisibility(View.GONE);
        csim.setVisibility(View.GONE);
        prizeLabel.setVisibility(View.GONE);
        text.setVisibility(View.VISIBLE);


        //Log.d("mytag", "timer status " + Integer.toString(chosenTime));

        switch (chosenTime) {
            default:
                break;
            case 0:
                System.out.println("erhkwljerh0");
                totalTime = 30000;
                break;
            case 1:
                System.out.println("fnfdkjfi1");
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
        timer();
    }

    public void timer() {

        timer = new CountDownTimer(totalTime, 1000) {
            public void onTick(long millisUntilFinished) {
                long minutes = (millisUntilFinished / 1000) / 60;
                long seconds = (millisUntilFinished / 1000) % 60;
                String remaining = minutes + ":" + seconds;
                text.setText(remaining);
            }

            public void onFinish() {
                text.setText("You're done!");
                timer.cancel();
                switch (getStatus()) {
                    default:
                        break;
                    case 0:
                        text.setVisibility(View.GONE);
                        csim.setVisibility(View.VISIBLE);
                        prizeLabel.setVisibility(View.VISIBLE);
                        prizeLabel.setText("Prize: CS Badge!");
                        csscore++;
                        break;
                    case 1:
                        text.setVisibility(View.GONE);
                        xyzim.setVisibility(View.VISIBLE);
                        prizeLabel.setVisibility(View.VISIBLE);
                        prizeLabel.setText("Prize: XYZ Cat Badge!");
                        xyzscore++;
                        break;
                    case 2:
                        text.setVisibility(View.GONE);
                        chuchuim.setVisibility(View.VISIBLE);
                        prizeLabel.setVisibility(View.VISIBLE);
                        prizeLabel.setText("Prize: Chuchu Dog Badge!");
                        chuchuscore++;
                        break;
                    case 3:
                        text.setVisibility(View.GONE);
                        benim.setVisibility(View.VISIBLE);
                        prizeLabel.setVisibility(View.VISIBLE);
                        prizeLabel.setText("Prize: Ben Head Badge!");
                        benscore++;
                        break;
                    case 4:
                        text.setVisibility(View.GONE);
                        geoffim.setVisibility(View.VISIBLE);
                        prizeLabel.setVisibility(View.VISIBLE);
                        prizeLabel.setText("Prize: Geoff Head Badge!");
                        geoffscore++;
                        break;
                }
            }
        }.start();
    }

    public void newFile() {
        timer.cancel();
        Intent intent = new Intent(StartPage.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public int getGeoffscore() {
        return geoffscore;
    }

    public int getBenscore() {
        return benscore;
    }

    public int getChuchuscore() {
        return chuchuscore;
    }

    public int getXyzscore() {
        return xyzscore;
    }

    public int getCsscore() {
        return csscore;
    }
}
