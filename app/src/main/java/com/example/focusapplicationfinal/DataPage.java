package com.example.focusapplicationfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DataPage extends AppCompatActivity {

    private Button quitButton;
    private TextView csnum;
    private TextView catnum;
    private TextView dognum;
    private TextView bennum;
    private TextView geoffnum;

    private int[] arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_page);


        quitButton = findViewById(R.id.mainpage);
        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backtoMain();
            }
        });

        csnum = findViewById(R.id.csCount);
        catnum = findViewById(R.id.catCount);
        dognum = findViewById(R.id.dogCount);
        bennum = findViewById(R.id.benCount);
        geoffnum = findViewById(R.id.geoffCount);

        Intent other = getIntent();
        arr = other.getIntArrayExtra("array");
        System.out.println("xxxxxxx" + other.getIntExtra("csscore", 0));
        other.putExtra("array", arr);


        try {
            csnum.setText(arr[0]);
            catnum.setText(arr[1]);
            dognum.setText(arr[2]);
            bennum.setText(arr[3]);
            geoffnum.setText(arr[4]);
        } catch (Exception e){
            Log.d("ECTEOFJDOFJ", "AKDFPEKF");
        }

// original
//        csnum.setText(Integer.toString(other.getIntExtra("csscore", 0)));
//        catnum.setText(Integer.toString(other.getIntExtra("xyzscore", 0)));
//        dognum.setText(Integer.toString(other.getIntExtra("chuchuscore", 0)));
//        bennum.setText(Integer.toString(other.getIntExtra("benscore", 0)));
//        geoffnum.setText(Integer.toString(other.getIntExtra("geoffscore", 0)));
    }

    public void backtoMain() {
        Intent intent = new Intent(DataPage.this, MainActivity.class);
        intent.putExtra("array", arr);
        startActivity(intent);
        finish();
    }
}
