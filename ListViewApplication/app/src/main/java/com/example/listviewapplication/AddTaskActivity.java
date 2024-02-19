package com.example.listviewapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.Nullable;
import com.google.android.material.snackbar.Snackbar;

public class AddTaskActivity extends Activity {
    private EditText editTextTask;
    private Button btnAddTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        editTextTask = findViewById(R.id.editTextTask);
        btnAddTask = findViewById(R.id.btnAddTask);

        btnAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newTask = editTextTask.getText().toString().trim();

                if (!newTask.isEmpty()) {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("newTask", newTask);
                    setResult(RESULT_OK, resultIntent);
                    finish();
                } else {
                    Snackbar.make(view, "Task cannot be empty", Snackbar.LENGTH_SHORT).show();
                }
            }
        });
    }
}
