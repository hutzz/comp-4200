package com.comp4200.a1.q1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import androidx.core.view.isVisible
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val title = findViewById<TextView>(R.id.appTitle)
        val editText = findViewById<EditText>(R.id.inputName)
        val submitButton = findViewById<FloatingActionButton>(R.id.submit)
        val starImage = findViewById<ImageView>(R.id.starImage)
        val switch = findViewById<Switch>(R.id.modeSwitch)

        starImage.isVisible = false

        submitButton.setOnClickListener {
            val userInput = editText.text.toString()
            editText.setText("Welcome, $userInput!")
            editText.isEnabled = false
            editText.isFocusable = false
            editText.isFocusableInTouchMode = false
            submitButton.isEnabled = false
            submitButton.isFocusable = false
            submitButton.isFocusableInTouchMode = false
            starImage.isVisible = true
        }
        switch.setOnCheckedChangeListener {_, isChecked ->
            if (!isChecked) {
                window.decorView.setBackgroundColor(Color.WHITE)
                title.setTextColor(getColor(R.color.black))
                editText.setTextColor(getColor(R.color.black))

            } else {
                window.decorView.setBackgroundColor(Color.BLACK)
                title.setTextColor(getColor(R.color.white))
                editText.setTextColor(getColor(R.color.white))
            }
        }
    }
}