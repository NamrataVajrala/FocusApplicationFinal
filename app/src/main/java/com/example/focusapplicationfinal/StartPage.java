package com.example.focusapplicationfinal;


import androidx.appcompat.app.AppCompatActivity;
import android.os.CountDownTimer;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class StartPage extends AppCompatActivity {

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
    private int chosenTime;
    private Intent dataIntent;
    private int[] arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);

        Intent passed = getIntent();
        chosenTime = passed.getIntExtra("timer", 0);

        arr = passed.getIntArrayExtra("array");

        quitFocus = findViewById(R.id.quitButton);
        quitFocus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newFile();
            }
        });
        dataIntent = new Intent(this, MainActivity.class);

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

        switch (chosenTime) {
            default:
                break;
            case 0:
                System.out.println("erhkwljerh0");
                totalTime = 1800000;
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

                switch (chosenTime) {
                    default:
                        break;
                    case 0:
                        text.setVisibility(View.GONE);
                        csim.setVisibility(View.VISIBLE);
                        prizeLabel.setVisibility(View.VISIBLE);
                        prizeLabel.setText("Prize: CS Badge!");
                        arr[0]++;
                        break;
                    case 1:
                        text.setVisibility(View.GONE);
                        xyzim.setVisibility(View.VISIBLE);
                        prizeLabel.setVisibility(View.VISIBLE);
                        prizeLabel.setText("Prize: XYZ Cat Badge!");
                        arr[1]++;
                        break;
                    case 2:
                        text.setVisibility(View.GONE);
                        chuchuim.setVisibility(View.VISIBLE);
                        prizeLabel.setVisibility(View.VISIBLE);
                        prizeLabel.setText("Prize: Chuchu Dog Badge!");
                        arr[2]++;
                        break;
                    case 3:
                        text.setVisibility(View.GONE);
                        benim.setVisibility(View.VISIBLE);
                        prizeLabel.setVisibility(View.VISIBLE);
                        prizeLabel.setText("Prize: Ben Head Badge!");
                        arr[3]++;
                        break;
                    case 4:
                        text.setVisibility(View.GONE);
                        geoffim.setVisibility(View.VISIBLE);
                        prizeLabel.setVisibility(View.VISIBLE);
                        prizeLabel.setText("Prize: Geoff Head Badge!");
                        arr[4]++;
                        break;
                }
            }
        }.start();
    }

    public void newFile() {
        timer.cancel();
        dataIntent.putExtra("array", arr);
        startActivity(dataIntent);
        finish();
    }
}
