package com.example.guru_android_team30

import android.content.Intent
import android.content.pm.ModuleInfo
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.guru_android_team30.databinding.ActivityMainBinding
import com.example.guru_android_team30.databinding.ActivitySearchBinding

class Search : AppCompatActivity() {

    lateinit var binding : ActivitySearchBinding

    lateinit var calender : ImageButton
    lateinit var main : ImageButton
    lateinit var writing : ImageButton

    lateinit var myHelper: ReviewWrite.ReviewDB
    lateinit var sqlDB : SQLiteDatabase

    private lateinit var listData: ArrayList<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)


        calender = findViewById(R.id.calender)
        main = findViewById(R.id.main)
        writing = findViewById(R.id.writing)



        myHelper = ReviewWrite().ReviewDB(this)


        sqlDB = myHelper.readableDatabase
        var cursor: Cursor
        cursor = sqlDB.rawQuery("SELECT * FROM REVIEW;", null)

        lateinit var strReviewTitle : String

        val ref = arrayListOf<String>()
        while (cursor.moveToNext()) {
            strReviewTitle = cursor.getString(cursor.getColumnIndex("title")).toString()
            ref.add(strReviewTitle)
        }


        val reviewAdapter : ArrayAdapter<String> = ArrayAdapter(
            this, android.R.layout.simple_list_item_1, ref
        )

        binding.reviewList.adapter = reviewAdapter;


        binding.searchView.setOnQueryTextListener(object  : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.searchView.clearFocus()
                if (ref.contains(query)){

                    reviewAdapter.filter.filter(query)

                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                reviewAdapter.filter.filter(newText)
                return false
            }
        })

        var i :Int=0
        for (i in ref.indices) {
            listData = ArrayList(ref)
        }
        binding.reviewList.isClickable = true
        binding.reviewList.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            var intent = Intent(this, ReviewPageDetail::class.java)
            intent.putExtra("intent_name",listData[i])
            startActivity(intent)
        }



        calender.setOnClickListener {
            Toast.makeText(this, "calender", Toast.LENGTH_SHORT).show()
        }

        main.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        writing.setOnClickListener {
            startActivity(Intent(this, Writepage::class.java))
        }
    }

}