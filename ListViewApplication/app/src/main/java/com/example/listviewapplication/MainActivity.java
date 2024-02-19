package com.example.listviewapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private FloatingActionButton fab;
    private ArrayList<String> arrayList;
    private ArrayAdapter arrayAdapter;
    private int editedItemIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        fab = findViewById(R.id.fab);

        arrayList = FileHandler.readData(MainActivity.this);
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this, AddTaskActivity.class), 1);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                arrayList.remove(i);
                arrayAdapter.notifyDataSetChanged();
                FileHandler.writeData(arrayList, getApplicationContext());
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                editTask(i);
                return true;
            }
        });
    }

    private void editTask(int index) {
        editedItemIndex = index;
        String selectedTask = arrayList.get(index);
        Intent editTaskIntent = new Intent(MainActivity.this, AddTaskActivity.class);
        editTaskIntent.putExtra("editTask", selectedTask);
        startActivityForResult(editTaskIntent, 1);
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            String newTask = data.getStringExtra("newTask");

            if (newTask != null && !newTask.isEmpty()) {
                if (editedItemIndex != -1) {
                    arrayList.set(editedItemIndex, newTask);
                    editedItemIndex = -1;
                    Snackbar.make(fab, "Task edited successfully", Snackbar.LENGTH_SHORT).show();
                } else {
                    arrayList.add(newTask);
                    Snackbar.make(fab, "Task added successfully", Snackbar.LENGTH_SHORT).show();
                }
                FileHandler.writeData(arrayList, getApplicationContext());
                arrayAdapter.notifyDataSetChanged();
            } else {
                Snackbar.make(fab, "Failed to add/edit task", Snackbar.LENGTH_SHORT).show();
            }
        }
    }
}
