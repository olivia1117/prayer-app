package com.zybooks.prayerapp.GratitudeSection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.zybooks.prayerapp.R

class GratitudeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gratitude)
        //implementation for clearing the gratitude journal
        val clearButton = findViewById<Button>(R.id.clear_journal)
        val gratitudeEditText = findViewById<EditText>(R.id.gratitude_textbox)
        gratitudeEditText.setSelection(0) //this sets the cursor to the upper left hand corner
        clearButton.setOnClickListener { view ->
            gratitudeEditText.text.clear()
        }
    }
}