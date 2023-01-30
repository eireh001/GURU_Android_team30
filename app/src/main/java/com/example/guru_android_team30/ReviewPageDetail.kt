package com.example.guru_android_team30

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import java.lang.Exception

class ReviewPageDetail : AppCompatActivity() {

    lateinit var writer : TextView
    lateinit var publisher : TextView
    lateinit var title : TextView
    lateinit var date_publishing : TextView

    lateinit var layout : LinearLayout

    lateinit var calender : ImageButton
    lateinit var house : ImageButton
    lateinit var writing : ImageButton

    // 리뷰 DB
    lateinit var myHelper: ReviewWrite.ReviewDB
    lateinit var sqlDB : SQLiteDatabase

    lateinit var str_title : String
    lateinit var str_writer : String
    lateinit var str_publisher : String
    lateinit var str_datepublishing : String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review_page_datail)

        writer = findViewById(R.id.writer)
        publisher = findViewById(R.id.publisher)
        title = findViewById(R.id.title)
        date_publishing = findViewById(R.id.date_publishing)


        layout = findViewById(R.id.bookRecyclerView)

        calender = findViewById(R.id.calender)
        house = findViewById(R.id.house)
        writing = findViewById(R.id.writing)

        val intent = intent
        str_title = intent.getStringExtra("intent_name").toString()

        myHelper = ReviewWrite().ReviewDB(this)
        sqlDB = myHelper.readableDatabase

        var cursor : Cursor
        cursor = sqlDB.rawQuery("SELECT * FROM REVIEW WHERE title = '"+str_title+"';", null)

        if (cursor.moveToNext()) {
            str_writer = cursor.getString(cursor.getColumnIndex("writer")).toString()
            str_publisher = cursor.getString((cursor.getColumnIndex("publisher"))).toString()
//            eval = cursor.getInt((cursor.getColumnIndex("eval")))
//            str_review = cursor.getString((cursor.getColumnIndex("review_record"))).toString()
            str_datepublishing = cursor.getString((cursor.getColumnIndex("date_publishing"))).toString()
            var eval1 = cursor.getInt((cursor.getColumnIndex("eval")))
            var str_review1 = cursor.getString((cursor.getColumnIndex("review_record"))).toString()

            var layout_item : LinearLayout = LinearLayout(this)
            layout_item.orientation = LinearLayout.VERTICAL

            var tvEval : TextView = TextView(this)
            tvEval.text = "평가   " + eval1.toString()
            layout_item.addView(tvEval)

            var tvReview : TextView = TextView(this)
            tvReview.text = str_review1 + "\n"
            layout_item.addView(tvReview)

            layout.addView(layout_item)
        }

        var num : Int = 0
        while(cursor.moveToNext()) {
            var eval = cursor.getInt((cursor.getColumnIndex("eval")))
            var str_review = cursor.getString((cursor.getColumnIndex("review_record"))).toString()

            var layout_item : LinearLayout = LinearLayout(this)
            layout_item.orientation = LinearLayout.VERTICAL
            layout_item.id = num

            var tvEval : TextView = TextView(this)
            tvEval.text = "평가   " + eval.toString()
            layout_item.addView(tvEval)

            var tvReview : TextView = TextView(this)
            tvReview.text = str_review + "\n"
            layout_item.addView(tvReview)


            layout.addView(layout_item)
            num++;
        }


        cursor.close()
        sqlDB.close()
        myHelper.close()

        title.text = str_title
        writer.text = str_writer
        publisher.text = str_publisher
        date_publishing.text = str_datepublishing


        calender.setOnClickListener {
            Toast.makeText(this, "calender", Toast.LENGTH_SHORT).show()
        }

        house.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        writing.setOnClickListener {
            startActivity(Intent(this, Writepage::class.java))
        }
    }
}