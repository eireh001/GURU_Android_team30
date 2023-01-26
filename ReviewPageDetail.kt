package com.example.book

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class ReviewPageDetail : AppCompatActivity() {
    lateinit var writer : EditText
    lateinit var publisher : EditText
    lateinit var genre : EditText
    lateinit var date_publishing : TextView

//    평가 TextView
   lateinit var eval1 : TextView
    lateinit var score1 : TextView
    lateinit var review1 : TextView

    lateinit var eval2 : TextView
    lateinit var score2 : TextView
    lateinit var review2 : TextView

    lateinit var eval3 : TextView
    lateinit var score3 : TextView
    lateinit var review3 : TextView
//    평가 TextView

    lateinit var calender : ImageButton
    lateinit var house : ImageButton
    lateinit var writing : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review_page_detail)

        writer = findViewById(R.id.writer)
        publisher = findViewById(R.id.publisher)
        genre = findViewById(R.id.genre)
        date_publishing = findViewById(R.id.date_publishing)

//        평가 TextView id
        eval1 = findViewById(R.id.eval1)
        score1 = findViewById(R.id.score1)
        review1 = findViewById(R.id.review1)

        eval2 = findViewById(R.id.eval2)
        score2 = findViewById(R.id.score2)
        review2 = findViewById(R.id.review2)

        eval3 = findViewById(R.id.eval3)
        score3 = findViewById(R.id.score3)
        review3 = findViewById(R.id.review3)
//        평가 TextView id

        calender = findViewById(R.id.calender)
        house = findViewById(R.id.house)
        writing = findViewById(R.id.writing)


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