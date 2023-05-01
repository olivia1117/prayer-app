package com.zybooks.prayerapp.ReflectionSection


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.android.volley.VolleyError
import com.zybooks.prayerapp.R


class LessonsActivity : AppCompatActivity() {

    private lateinit var lessonBox : TextView

    private val adviceListener = object : LessonFetcher.OnLessonsReceivedListener {

        override fun onLessonsReceived(lessonString: String){
            lessonBox.text =lessonString //this sets the string to be placed into the text box
        }
        override fun onErrorResponse(error: VolleyError){
            //make an error message later
        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lessons)
        lessonBox = findViewById<TextView>(R.id.lesson_box)

        //creates instance of fetcher and then fetches from url

        val lessonFetcher = LessonFetcher(this)
        lessonFetcher.fetchLessons(adviceListener)
        //need to have page refresh to set a new lesson

    }



}