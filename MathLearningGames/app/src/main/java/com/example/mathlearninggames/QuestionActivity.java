package com.example.mathlearninggames;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;
import java.util.Random;

public class QuestionActivity extends AppCompatActivity {
    Button btn_nextq, btn_submit;
    EditText et_answer;
    TextView tv_question;
    double actualAnswer;
    int score = 0;
    int count;
    String display_summary = "Summary:";
    String op;
    int numQuestions;
    String option;
    long startTime, endTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        btn_nextq = findViewById(R.id.button_nextq);
        btn_submit = findViewById(R.id.button_sub);
        et_answer = findViewById(R.id.et_answer);
        tv_question = findViewById(R.id.textView);

        op = getIntent().getStringExtra("op");
        numQuestions = Integer.parseInt(getIntent().getStringExtra("numQuestions"));

        if ("add".equals(op)) {
            actualAnswer = questionAdd();
        } else if ("sub".equals(op)) {
            actualAnswer = questionSubtraction();
        } else if ("mul".equals(op)) {
            actualAnswer = questionMultiplication();
        } else if ("div".equals(op)) {
            actualAnswer = questionDivision();
        } else if ("mixed".equals(op)) {
            actualAnswer = questionMixed();
        }

        startTime = System.currentTimeMillis();

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double userAnswer = Double.parseDouble(et_answer.getText().toString());
                display_summary = display_summary+" = "+removeTrailingZeros(userAnswer)+" : "+(Double.compare(userAnswer, actualAnswer) == 0);
                if(Double.compare(userAnswer, actualAnswer) == 0){
//                    tv_question.setText("Correct!");
                    score++;
                }else{
//                    tv_question.setText("Wrong!");
                }
                et_answer.setText("");
                count = numQuestions;
                count--;
                if(count <= 0){
                    endTime = System.currentTimeMillis();
                    long delta = endTime - startTime;
                    double seconds = delta / 1000.0;
                    Intent intent = new Intent(QuestionActivity.this, SummaryActivity.class);
                    intent.putExtra("key_score", score);
                    intent.putExtra("key_summary", display_summary);
                    intent.putExtra("time", String.valueOf(seconds));
                    startActivity(intent);
                } else {
                    if ("add".equals(op)) {
                        actualAnswer = questionAdd();
                    } else if ("sub".equals(op)) {
                        actualAnswer = questionSubtraction();
                    } else if ("mul".equals(op)) {
                        actualAnswer = questionMultiplication();
                    } else if ("div".equals(op)) {
                        actualAnswer = questionDivision();
                    } else if ("mixed".equals(op)) {
                        actualAnswer = questionMixed();
                    }
                }
            }
        });
    }
    private String removeTrailingZeros(double value) {
        String stringValue = String.valueOf(value);
        if (stringValue.contains(".")) {
            stringValue = stringValue.replaceAll("0*$", "");
            if (stringValue.endsWith(".")) {
                stringValue = stringValue.substring(0, stringValue.length() - 1);
            }
        }
        return stringValue;
    }
    public int questionAdd(){
        int num1, num2;
        num1 = (int)(Math.random() * 20);
        num2 = (int)(Math.random() * 20);
        tv_question.setText("What is "+num1+"+"+num2+"?");
        display_summary = display_summary +"\n"+num1+"+"+num2;
        return num1+num2;
    }

    public int questionSubtraction() {
        int num1, num2;
        num1 = (int)(Math.random() * 20);
        num2 = (int)(Math.random() * 20);
        if (num1 < num2) {
            int temp = num2;
            num2 = num1;
            num1 = temp;
        }
        tv_question.setText("What is " + num1 + "-" + num2);
        display_summary = display_summary +"\n"+num1+"-"+num2;
        return num1 - num2;
    }

    public int questionMultiplication() {
        int num1, num2;
        num1 = (int)(Math.random() * 20);
        num2 = (int)(Math.random() * 20);
        tv_question.setText("What is " + num1 + "*" + num2);
        display_summary = display_summary +"\n"+num1+"*"+num2;
        return num1 * num2;
    }

    public double questionDivision() {
        int num1, num2;
        num1 = (int) (Math.random() * 20);
        num2 = (int) (Math.random() * 20);
        while (num2 == 0) {
            Log.i("division", "divide by zero detected");
            num2 = (int) (Math.random() * 20);
        }
        tv_question.setText("What is " + num1 + "/" + num2 + ", rounded to two significant figures?");
        display_summary = display_summary + "\n" + num1 + "/" + num2;
        double result = (double) num1 / num2;
        Log.i("division", String.format("%.2f", result));
        return Double.parseDouble(String.format("%.2f", result));
    }
    public double questionMixed() {
        int random = new Random().nextInt(4);
        switch (random) {
            case 0: return questionAdd();
            case 1: return questionSubtraction();
            case 2: return questionMultiplication();
            case 3: return questionDivision();
        }
        return 1;
    }
}
