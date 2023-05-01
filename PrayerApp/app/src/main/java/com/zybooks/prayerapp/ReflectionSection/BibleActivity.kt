package com.zybooks.prayerapp.ReflectionSection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.android.volley.VolleyError
import com.zybooks.prayerapp.ReflectionSection.BIBLE_TAG
import com.zybooks.prayerapp.ReflectionSection.BibleFetcher
import com.zybooks.prayerapp.R

class BibleActivity : AppCompatActivity() {

    private lateinit var bibleBox : TextView

    private val bibleVerseListener = object : BibleFetcher.OnBibleVersesReceivedListener {

        override fun onBibleVersesReceived(bibleString: String){
            bibleBox.text = bibleString //this sets the string to be placed into the text box
        }
        override fun onErrorResponse(error: VolleyError){
            //make an error message later
            Log.d(BIBLE_TAG,error.toString())
        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bible)
        bibleBox = findViewById<TextView>(R.id.bible_box)

        val bibleFetcher = BibleFetcher(this)
        bibleFetcher.fetchBibleVerses(bibleVerseListener)
    }
}