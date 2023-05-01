package com.zybooks.prayerapp.ReflectionSection

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.zybooks.prayerapp.R

class ReflectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reflect)
        //implementation for each of the buttons to launch a particular text

        //button to get to bible section
        val bibleButton = findViewById<Button>(R.id.bible_button)
        bibleButton.setOnClickListener { view ->
            // Do something when the button is clicked
            val bibleIntent = Intent(this, BibleActivity::class.java)
            startActivity(bibleIntent)
        }

        val quranButton = findViewById<Button>(R.id.quran_button)
        quranButton.setOnClickListener { view ->
            // Do something when the button is clicked
            val quranIntent = Intent(this, QuranActivity::class.java)
            startActivity(quranIntent)
        }

        val lessonsButton = findViewById<Button>(R.id.lessons_button)
        lessonsButton.setOnClickListener { view ->
            // Do something when the button is clicked
            val lessonsIntent = Intent(this, LessonsActivity::class.java)
            startActivity(lessonsIntent)
        }
    }
}