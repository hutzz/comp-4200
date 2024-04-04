package com.example.mathlearninggames;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

public class OptionsActivity extends AppCompatActivity {
    Button btnWish, btnMistake, btnChance, btnTrial;
    String op;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        btnWish = findViewById(R.id.wishButton);
        btnMistake = findViewById(R.id.mistakeButton);
        btnChance = findViewById(R.id.chanceButton);
        btnTrial = findViewById(R.id.trialButton);

        op = getIntent().getStringExtra("op");

        btnWish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OptionsActivity.this, WishActivity.class);
                intent.putExtra("op", op);
                startActivity(intent);
            }
        });

        btnMistake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OptionsActivity.this, QuestionActivity.class);
                intent.putExtra("op", op);
                intent.putExtra("option", "mistake");
                startActivity(intent);
            }
        });

        btnChance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OptionsActivity.this, QuestionActivity.class);
                intent.putExtra("op", op);
                intent.putExtra("option", "chance");
                startActivity(intent);
            }
        });
    }
}
