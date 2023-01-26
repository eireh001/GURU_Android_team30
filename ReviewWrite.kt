package com.example.book

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class ReviewWrite : AppCompatActivity() {

    lateinit var title : EditText
    lateinit var writer : EditText
    lateinit var publisher : EditText
    lateinit var date_reading : TextView
    lateinit var date_writing : TextView

//    평가 버튼
    lateinit var review_short : ImageButton
    lateinit var review_correct : ImageButton
    lateinit var review_long : ImageButton

    lateinit var review_eval : EditText

    lateinit var review_not : ImageButton
    lateinit var review_ok : ImageButton
    lateinit var review_funny : ImageButton
//    평가 버튼

    lateinit var read_record : EditText

    lateinit var calender : ImageButton
    lateinit var house : ImageButton
    lateinit var writing : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review_write)

        title = findViewById(R.id.title)
        writer = findViewById(R.id.writer)
        publisher = findViewById(R.id.publisher)
        date_reading = findViewById(R.id.date_reading)
        date_writing = findViewById(R.id.date_writing)

        review_eval = findViewById(R.id.review_eval)

//        평가 id
        review_short = findViewById(R.id.review_short)
        review_correct = findViewById(R.id.review_correct)
        review_long = findViewById(R.id.review_long)

        review_not = findViewById(R.id.review_not)
        review_ok = findViewById(R.id.review_ok)
        review_funny = findViewById(R.id.review_funny)
//        평가 id

        read_record = findViewById(R.id.read_record)

        calender = findViewById(R.id.calender)
        house = findViewById(R.id.house)
        writing = findViewById(R.id.writing)


//        평가 버튼 클릭
        review_short.setOnClickListener {
            Toast.makeText(this, "review_short", Toast.LENGTH_SHORT).show()
        }

        review_correct.setOnClickListener {
            Toast.makeText(this, "review_correct", Toast.LENGTH_SHORT).show()
        }

        review_long.setOnClickListener {
            Toast.makeText(this, "review_long", Toast.LENGTH_SHORT).show()
        }

        review_not.setOnClickListener {
            Toast.makeText(this, "review_not", Toast.LENGTH_SHORT).show()
        }

        review_ok.setOnClickListener {
            Toast.makeText(this, "review_ok", Toast.LENGTH_SHORT).show()
        }

        review_funny.setOnClickListener {
            Toast.makeText(this, "review_funny", Toast.LENGTH_SHORT).show()
        }

//        평가 버튼 클릭


        calender.setOnClickListener {
            Toast.makeText(this, "calender", Toast.LENGTH_SHORT).show()
        }

        house.setOnClickListener {
            Toast.makeText(this, "house", Toast.LENGTH_SHORT).show()
        }

        writing.setOnClickListener {
            startActivity(Intent(this, Writepage::class.java))
        }

    }


}