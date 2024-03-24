package com.example.viewrecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<MyDataSet> dataSets = new ArrayList<>();
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        dataSets.add(new MyDataSet("Card 1", R.drawable.image4, "Red"));
        dataSets.add(new MyDataSet("Card 2", R.drawable.image5, "Yellow"));
        dataSets.add(new MyDataSet("Card 3", R.drawable.image6, "Black"));

        MyAdapter myAdapter = new MyAdapter(dataSets, MainActivity.this);
        recyclerView.setAdapter(myAdapter);


    }
}