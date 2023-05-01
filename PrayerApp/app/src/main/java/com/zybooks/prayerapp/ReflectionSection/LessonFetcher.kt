package com.zybooks.prayerapp.ReflectionSection

import android.content.Context
import android.net.Uri
import android.util.Log
import com.android.volley.Request
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

const val TAG = "RequestFetcher"
const val BASE_URL = "https://api.adviceslip.com/advice"

class LessonFetcher(val context: Context){

    interface OnLessonsReceivedListener{
        fun onLessonsReceived(lessonString: String)
        fun onErrorResponse(error: VolleyError)
    }

    private var requestQueue = Volley.newRequestQueue(context)

    fun fetchLessons(listener: OnLessonsReceivedListener){
        val url = Uri.parse(BASE_URL).buildUpon()
            .build().toString()
        Log.d(TAG, url)

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,
            url,
            null,
            {
                response ->

                    listener.onLessonsReceived(parseJsonLessons(response))
            },
            {error -> listener.onErrorResponse(error)}
        )
        requestQueue.add(jsonObjectRequest)
    }

    fun parseJsonLessons(jsonObject: JSONObject): String {

        var lessonString = ""

        try {
            val lessons = jsonObject.getJSONObject("slip")
            lessonString = lessons.getString("advice")

        } catch (e: Exception) {
            Log.d(TAG, e.toString())
        }
        return lessonString
    }
}