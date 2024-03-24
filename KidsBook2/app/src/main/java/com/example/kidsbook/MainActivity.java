package com.example.kidsbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("test_frag", "onCreate() in MainActivity (Zach Hutz)");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("test_frag", "onStart() in MainActivity (Zach Hutz)");
    }

    public void displayApple(View view){
        Apple apple = new Apple();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame, apple);
        ft.commit();

    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("test_frag", "onResume() in MainActivity (Zach Hutz)");
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.d("test_frag", "onPause() in MainActivity (Zach Hutz)");
    }
    @Override
    public void onStop() {
        super.onStop();
        Log.d("test_frag", "onStop() in MainActivity (Zach Hutz)");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("test_frag", "onDestroy() in MainActivity (Zach Hutz)");
    }


    public  void displayBird(View view){
        Bird bird = new Bird();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame, bird);
        fragmentTransaction.commit();
    }

    public void displayCat(View view){
        Cat cat = new Cat();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame, cat);
        fragmentTransaction.commit();
    }


}