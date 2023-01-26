package com.example.book

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var WritePage : Button
    lateinit var ReviewWritePage : Button
    lateinit var ReviewDetail : Button
    lateinit var SearchPage : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        WritePage = findViewById(R.id.writepage)
        ReviewWritePage = findViewById(R.id.review_writepage)
        ReviewDetail = findViewById(R.id.review_page_deatil)
        SearchPage = findViewById(R.id.search_page)

        WritePage.setOnClickListener {
            val nextIntent1 = Intent(this, Writepage::class.java)
            startActivity(nextIntent1)
        }

        ReviewWritePage.setOnClickListener {
            val nextIntent2 = Intent(this, ReviewWrite::class.java)
            startActivity(nextIntent2)
        }

        ReviewDetail.setOnClickListener {
            val nextIntent3 = Intent(this, ReviewPageDetail::class.java)
            startActivity(nextIntent3)
        }

        SearchPage.setOnClickListener {
            val nextIntent3 = Intent(this, Search::class.java)
            startActivity(nextIntent3)
        }
    }

}