package com.example.mathlearninggames;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WishActivity extends AppCompatActivity {
    TextView questionText;
    EditText numQuestionsEnter;
    Button numQuestionsSubmit;
    String op;
    String userAnswer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish);
        questionText = findViewById(R.id.numQuestionsPrompt);
        numQuestionsEnter = findViewById(R.id.numQuestions);
        numQuestionsSubmit = findViewById(R.id.submitNumQuestions);

        op = getIntent().getStringExtra("op");

        numQuestionsSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userAnswer = numQuestionsEnter.getText().toString();
                Intent intent = new Intent(WishActivity.this, QuestionActivity.class);
                intent.putExtra("op", op);
                intent.putExtra("option", "wish");
                intent.putExtra("numQuestions", userAnswer);
                startActivity(intent);
            }
        });
    }
}

