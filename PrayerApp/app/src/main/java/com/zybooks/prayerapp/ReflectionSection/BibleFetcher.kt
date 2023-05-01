package com.zybooks.prayerapp.ReflectionSection

import android.content.Context
import android.net.Uri
import android.util.Log
import com.android.volley.Request
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject


const val BIBLE_TAG = "BibleFetcher"
const val BIBLE_URL = "https://labs.bible.org/api/?passage=votd&type=json"

//"verse_text_english"
class BibleFetcher(val context: Context){


    interface OnBibleVersesReceivedListener{
        fun onBibleVersesReceived(bibleString: String)
        fun onErrorResponse(error: VolleyError)
    }

    private var requestQueue = Volley.newRequestQueue(context)

    fun fetchBibleVerses(listener: OnBibleVersesReceivedListener){
        val url = Uri.parse(BIBLE_URL).buildUpon()
            .build().toString()
        Log.d(BIBLE_TAG, url)

        val jsonArrayRequest = JsonArrayRequest(
            Request.Method.GET,
            url,
            null,
            {
                    response ->

                listener.onBibleVersesReceived(parseJsonBibleVerses(response))
            },
            {error -> listener.onErrorResponse(error)}
        )
        requestQueue.add(jsonArrayRequest)
    }

    fun parseJsonBibleVerses(jsonObject: JSONArray): String {

        var bibleString = ""

        try {
            val bibleVerses = jsonObject.getJSONObject(0)
            bibleString = bibleVerses.getString("text")

        } catch (e: Exception) {
            Log.d(BIBLE_TAG, e.toString())
        }
        return bibleString
    }
}

