package com.zybooks.prayerapp.MeditationSection

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zybooks.prayerapp.R

//this is my recycler view that will display on the MeditationActivity screen
class RecyclerViewAdapter(private val intentionList: List<Intention>): //private val onClickListener: View.OnClickListener) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_view, parent, false)
        return ViewHolder(layoutInflater)
    }

    //this binds the data to the views
    //main issue here is the id not working
    //not sure if I need it or not?
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val intentionList = intentionList[position]
//        holder.itemView.tag = intentionList.id
//        holder.itemView.setOnClickListener(onClickListener)
//        holder.bind(intentionList)
        holder.dateTextView.text = intentionList.date
        holder.intention1TextView.text = intentionList.intention1
        holder.intention2TextView.text = intentionList.intention2
        holder.intention3TextView.text = intentionList.intention3

        //holder.intentionTextView.text = intentionList[position].date
    }

    override fun getItemCount(): Int {
        return intentionList.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dateTextView: TextView = itemView.findViewById(R.id.date_box)
        val intention1TextView: TextView = itemView.findViewById(R.id.intention1)
        val intention2TextView: TextView = itemView.findViewById(R.id.intention2)
        val intention3TextView: TextView = itemView.findViewById(R.id.intention3)

    }

    //this inflates the list_item_view layout which works with the intention_recycler layout to customize each list item in the view
//    inner class ViewHolder(inflater: LayoutInflater, parent: ViewGroup?):
//        RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item_view, parent, false)) {
//        private val intentionView: TextView
//
//        init {
//           intentionView = itemView.findViewById(R.id.intention_view)
//        }
//
//        //binding the date to this as well so it can be displayed in the recycler view
//        fun bind(intentionList: Intention) {
//            intentionView.text = intentionList.date
//
//
//        }
//
//    }
//    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val intentionTextView: TextView = view.findViewById(R.id.intention_view)
//    }
}