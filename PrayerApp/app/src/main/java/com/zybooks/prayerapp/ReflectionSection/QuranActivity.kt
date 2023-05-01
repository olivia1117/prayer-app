package com.zybooks.prayerapp.ReflectionSection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.android.volley.VolleyError
import com.zybooks.prayerapp.ReflectionSection.QURAN_TAG
import com.zybooks.prayerapp.ReflectionSection.QuranFetcher
import com.zybooks.prayerapp.R

class QuranActivity : AppCompatActivity() {


    private lateinit var quranBox : TextView

    private val quranVerseListener = object : QuranFetcher.OnQuranVersesReceivedListener {

        override fun onQuranVersesReceived(quranString: String){
            quranBox.text = quranString //this sets the string to be placed into the text box
        }
        override fun onErrorResponse(error: VolleyError){
            //make an error message later
            Log.d(QURAN_TAG,error.toString())
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quran)
        quranBox = findViewById<TextView>(R.id.quran_box)

        val quranFetcher = QuranFetcher(this)
        quranFetcher.fetchQuranVerses(quranVerseListener)
    }
}