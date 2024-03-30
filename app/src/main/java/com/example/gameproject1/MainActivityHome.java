package com.example.gameproject1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivityHome extends AppCompatActivity {

    Button button_easy, button_medium, button_hard, button_start;

    public static Boolean easy_mode = true;
    public static Boolean medium_mode = false;
    public static Boolean hard_mode = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);
        button_easy = findViewById(R.id.button_easy);
        button_medium = findViewById(R.id.button_medium);
        button_hard = findViewById(R.id.button_hard);
        button_start = findViewById(R.id.button_start);
        easy_mode = true;
        medium_mode = false;
        hard_mode = false;

        button_easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                easy_mode = true;
                medium_mode = false;
                hard_mode = false;
            }
        });

        button_medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                easy_mode = false;
                medium_mode = true;
                hard_mode = false;
            }
        });

        button_hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                easy_mode = false;
                medium_mode = false;
                hard_mode = true;
            }
        });
        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityHome.this,MainActivity.class);
                startActivity(intent);

            }
        });
    }
}