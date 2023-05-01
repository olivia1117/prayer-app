package com.zybooks.prayerapp.MeditationSection

import android.content.Context
import com.zybooks.prayerapp.R

//also part of the model class
//this class holds our data

//I'm honestly a bit confused about this part
//I think I need a repository, but I'm not 100% sure
//From my understanding, this mostly works to get the data and uses arrays later
//on to set the previous intentions and date back if if the user clicks on it again in the recycler view

//class IntentionRepo private constructor(context: Context) {
//    var intentionList: MutableList<Intention> = mutableListOf()
//
//
//
//    //like a static method in java
//    companion object{
//        private var instance: IntentionRepo? = null
//        //has a reference to the repo
//        fun getInstance(context: Context): IntentionRepo {
//
//            //if null, then create new instance of repo
//            if(instance == null){
//                instance = IntentionRepo(context)
//
//            }
//            return instance!!
//
//
//        }
//    }
//
//    //get our array of ratings here
//    init {
//        val date = context.resources.getStringArray(R.array.date)
//        val intention1 = context.resources.getStringArray(R.array.intention1)
//        val intention2 = context.resources.getStringArray(R.array.intention2)
//        val intention3 = context.resources.getStringArray(R.array.intention3)
//        for (i in date.indices){
//            intentionList.add(Intention(i + 1, date[i], intention1[i], intention2[i], intention3[i]))
//        }
//    }
//
//    //given an id, it finds the intention object at the location
//    fun getIntentions(intentionId: Int): Intention?{
//        return intentionList.find {it.id == intentionId}
//    }
//
//}