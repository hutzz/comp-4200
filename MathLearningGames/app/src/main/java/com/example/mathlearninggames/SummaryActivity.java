package com.example.mathlearninggames;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {
    TextView textView_summary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        textView_summary = findViewById(R.id.textView_summary);
        Intent intent = getIntent();
        int score = intent.getIntExtra("key_score", 0);
        String time = intent.getStringExtra("time");
        String summary = intent.getStringExtra("key_summary");
        textView_summary.setText("!!! GAME OVER !!!\nYour Score: "+score+"\n"+summary+"\nTime elapsed: " + time + " seconds");

    }
}