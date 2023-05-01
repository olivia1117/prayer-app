package com.zybooks.prayerapp.ReflectionSection

import android.content.Context
import android.net.Uri
import android.util.Log
import com.android.volley.Request
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

const val QURAN_TAG = "QuranFetcher"
const val QURAN_URL = "https://api.quraniclabs.com/quran/randomverse"

//"verse_text_english"
class QuranFetcher(val context: Context){


    interface OnQuranVersesReceivedListener{
        fun onQuranVersesReceived(quranString: String)
        fun onErrorResponse(error: VolleyError)
    }

    private var requestQueue = Volley.newRequestQueue(context)

    fun fetchQuranVerses(listener: OnQuranVersesReceivedListener){
        val url = Uri.parse(QURAN_URL).buildUpon()
            .build().toString()
        Log.d(QURAN_TAG, url)

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,
            url,
            null,
            {
                    response ->

                listener.onQuranVersesReceived(parseJsonQuranVerses(response))
            },
            {error -> listener.onErrorResponse(error)}
        )
        requestQueue.add(jsonObjectRequest)
    }


    fun parseJsonQuranVerses(jsonObject: JSONObject) : String {

        var quranString = ""


        try {
            //val jsonObj = JSONObject(jsonStr)
            //val verseTextEnglish = jsonObj.getJSONArray("data").getJSONObject(0).getString("verse_text_english")

            quranString = jsonObject.getJSONArray("data").getJSONObject(0).getString("verse_text_english")

//            val quranVerses = jsonObject.getJSONObject("data")
//            val quranArray = JSONArray(quranVerses)
//            val newQuranObject = jsonObject.getJSONArray(0)
//            quranString = quranVerses.getString("verse_text_english")

        } catch (e: Exception) {
            Log.d(QURAN_TAG, e.toString())
        }
        return quranString
    }
}
