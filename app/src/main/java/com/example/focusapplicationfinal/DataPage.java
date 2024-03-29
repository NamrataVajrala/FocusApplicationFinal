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
    }

    public void backtoMain() {
        Intent intent = new Intent(DataPage.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
