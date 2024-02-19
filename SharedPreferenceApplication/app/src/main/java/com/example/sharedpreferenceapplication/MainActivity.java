package com.example.sharedpreferenceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    EditText et_username, et_password;
    Button btn_submit;
    Switch btn_switch;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor spe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_password = findViewById(R.id.editTextTextPassword);
        et_username = findViewById(R.id.et_username);
        btn_submit = findViewById(R.id.button_submit);
        btn_switch = findViewById(R.id.btn_switch);
        removeUserData();
        getUserData();

    }

    @Override
    protected void onPause() {
        super.onPause();
        saveUserData();
    }

    public void saveUserData(){
        sharedPreferences = getPreferences(MODE_PRIVATE);
        spe  = sharedPreferences.edit();
        if (btn_switch.isChecked()) {
            spe.putString("key_user", et_username.getText().toString());
            spe.putString("key_pass", et_password.getText().toString());
        } else {
            removeUserData();
        }
        spe.putBoolean("key_switch", btn_switch.isChecked());
        //System.out.println(""+sharedPreferences.getBoolean("key_switch", false));
        spe.commit();
    }

    public void getUserData(){
        sharedPreferences = getPreferences(MODE_PRIVATE);
        et_username.setText(sharedPreferences.getString("key_user", null));
        et_password.setText(sharedPreferences.getString("key_pass", null));
        btn_switch.setChecked(sharedPreferences.getBoolean("key_switch", false));

    }
    public void removeUserData(){
        sharedPreferences = getPreferences(MODE_PRIVATE);
        spe  = sharedPreferences.edit();
        spe.remove("key_user");
        spe.remove("key_pass"); //
        spe.remove("key_switch"); //
        spe.commit();
    }

}