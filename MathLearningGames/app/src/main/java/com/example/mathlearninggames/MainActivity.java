package com.example.mathlearninggames;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_add, btn_sub, btn_mul, btn_div, btn_mixed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_add = findViewById(R.id.button_add);
        btn_sub = findViewById(R.id.button_sub);
        btn_mul = findViewById(R.id.button_mul);
        btn_div = findViewById(R.id.button_div);
        btn_mixed = findViewById(R.id.button_mix);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OptionsActivity.class);
                intent.putExtra("op", "add");
                startActivity(intent);
            }
        });
        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OptionsActivity.class);
                intent.putExtra("op", "sub");
                startActivity(intent);
            }
        });
        btn_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OptionsActivity.class);
                intent.putExtra("op", "mul");
                startActivity(intent);
            }
        });
        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OptionsActivity.class);
                intent.putExtra("op", "div");
                startActivity(intent);
            }
        });
        btn_mixed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OptionsActivity.class);
                intent.putExtra("op", "mixed");
                startActivity(intent);
            }
        });
    }
}