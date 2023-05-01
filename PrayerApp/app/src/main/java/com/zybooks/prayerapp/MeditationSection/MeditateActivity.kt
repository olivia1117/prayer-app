package com.zybooks.prayerapp.MeditationSection

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

import com.zybooks.prayerapp.R


class MeditateActivity : AppCompatActivity() {
    private lateinit var plusButton: FloatingActionButton
    private lateinit var recyclerView: RecyclerView
//    private lateinit var intentionList: List<Intention>
//    private lateinit var recyclerViewAdapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?){
        //inflater: LayoutInflater,
                          //container: ViewGroup?,

        //super.onCreate(savedInstanceState)
        //: View?

         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_meditate)
        //need to have floating action button launch an empty intention screen
        //user should then be able to enter in the date and 3 intentions and click the save button
        //once they do that, their data should be saved where they can view previous intentions in the recycler view
        //the data will be stored as dates as strings on the recycler view page
        //when the user clicks on a previous date, it should launch an intention screen that will load their previous date and intentions


        //this is the floating action button to launch a new IntentionActivity screen
            plusButton = findViewById(R.id.plus_button) ?: return // If myView is null, return from the function
            plusButton.setOnClickListener { view ->
//            val inflater = LayoutInflater.from(this)
//            val v = inflater.inflate(R.layout.activity_intention, null)
//            val date = v.findViewById<EditText>(R.id.date_box)
//
//            val addIntention = .Builder(this)
                //launch intention activity
                val meditateIntent = Intent(this, IntentionActivity::class.java)
                startActivity(meditateIntent)
            }

            //not sure if I need all of this because I was using the week 8 and 10 videos and projects for reference
            //and we used fragments for those examples
            //but from my understanding, this should inflate the recycler layout and specifically the recyclerview and fab components
            //then we set an onclicklistener to bind the date? so that it will appear on the recycler view/meditate activity screen?
            //I'm not sure if a date_id is necessary or not since I'm not doing fragments?


//            val rootView = inflater.inflate(R.layout.intention_recycler, container, false)
//            val recyclerView: RecyclerView = rootView.findViewById(R.id.recyclerview)
//            //val dates = IntentionRepo.getInstance(requireContext()).intentionList
//            val floatingActionButton = rootView.findViewById<FloatingActionButton>(R.id.plus_button)
//            val onClickListener = View.OnClickListener { itemView: View ->
//                val selectedDate = itemView.tag as Int //set the id as tag in bind
//                val args = Bundle(0)
//                args.putInt("date_id", selectedDate)
//
//
//                //.findNavController(itemView).navigate(R.id.show_item_detail, args)
//            }


//            floatingActionButton.setOnClickListener{
//                val args = Bundle()
//                args.putInt("date_id", 0)
//                //Navigation.findNavController(it).navigate(R.id.show_item_detail, args)
//            }


//            val intentionList = campusRatingViewModel.getIntentionList()
//            intentionList.observe(viewLifecycleOwner) { dates ->
//                //sends campus ratings to the recycler view
//                val adapter = RecyclerViewAdapter(dates, onClickListener)
//                recyclerView.adapter = adapter
//            }

            //sends dates to the recycler view so when the user clicks on a previous one, they can
            //see that info and their previous intentions
            //not sure what the error message is about?





        val bundle: Bundle? = intent.extras
        val date = bundle?.getString("date")!!
        val intention1 = bundle?.getString("intention1")!!
        val intention2 = bundle?.getString("intention2")!!
        val intention3 = bundle?.getString("intention3")!!
        val intentionList = ArrayList<Intention>()
        intentionList.add(Intention(date, intention1, intention2, intention3))

        // Set up the RecyclerView and adapter
        recyclerView = findViewById(R.id.intention_recycler)
        val adapter = RecyclerViewAdapter(intentionList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
//            val adapter = RecyclerViewAdapter(dates, onClickListener)
//            recyclerView.adapter = adapter
            //creating dividers between the campus names to make it look pretty
//            val divider =
//                DividerItemDecoration(recyclerView.context, DividerItemDecoration.VERTICAL)
//            recyclerView.addItemDecoration(divider)




            //return rootView
        }






}