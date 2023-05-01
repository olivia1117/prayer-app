package com.zybooks.prayerapp

import com.zybooks.prayerapp.MeditationSection.MeditateActivity
import com.zybooks.prayerapp.ReflectionSection.ReflectActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.zybooks.prayerapp.GratitudeSection.GratitudeActivity

class MainActivity : AppCompatActivity() {
    private lateinit var prayer: Prayer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setTheme(R.style.Theme_PrayerApp)
        setContentView(R.layout.activity_main)

        prayer = Prayer()

        //button to get to gratitude journal
        val gratitudeButton = findViewById<Button>(R.id.gratitude_button)
        gratitudeButton.setOnClickListener { view ->
            // Do something when the button is clicked
            val gratitudeIntent = Intent(this, GratitudeActivity::class.java)
            startActivity(gratitudeIntent)
        }

        //button to get to reflection section
        val reflectButton = findViewById<Button>(R.id.reflect_button)
        reflectButton.setOnClickListener { view ->
            // Do something when the button is clicked
            val reflectIntent = Intent(this, ReflectActivity::class.java)
            startActivity(reflectIntent)
        }

        //button to get to meditate section
        val meditateButton = findViewById<Button>(R.id.meditate_button)
        meditateButton.setOnClickListener { view ->
            // Do something when the button is clicked
            val meditateIntent = Intent(this, MeditateActivity::class.java)
            startActivity(meditateIntent)
        }
    }
}