package com.zybooks.prayerapp.MeditationSection

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.zybooks.prayerapp.R

class IntentionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intention)



        //button to save the intentions and return to the meditation recycler view
        val SaveIntentionButton = findViewById<Button>(R.id.save_intentions)
        SaveIntentionButton.setOnClickListener { view ->
            // save all the data and then display the date on the recycler page
            //val date = date_box.text.toString()
            //navigate back to meditate activity

            val dateBox = findViewById<EditText>(R.id.date_box)
            val intention1 = findViewById<EditText>(R.id.intention1)
            val intention2 = findViewById<EditText>(R.id.intention2)
            val intention3 = findViewById<EditText>(R.id.intention3)

            //putting everything into a bundle to pass from this activity into the meditate recycler view activity
            val intent = Intent(this@IntentionActivity, MeditateActivity::class.java)
            val bundle = Bundle()
            bundle.putString("date", dateBox.getText().toString())
            bundle.putString("intention1", intention1.getText().toString())
            bundle.putString("intention2", intention2.getText().toString())
            bundle.putString("intention3", intention3.getText().toString())

            intent.putExtras(bundle)
            startActivity(intent)
            val IntentionIntent = Intent(this, MeditateActivity::class.java)
            startActivity(IntentionIntent)
        }
    }
}