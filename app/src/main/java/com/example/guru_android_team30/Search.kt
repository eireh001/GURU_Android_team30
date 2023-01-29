package com.example.guru_android_team30

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class Search : AppCompatActivity() {

    lateinit var search_edit : EditText

    lateinit var calender : ImageButton
    lateinit var main : ImageButton
    lateinit var writing : ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        search_edit = findViewById(R.id.search_edit)

        calender = findViewById(R.id.calender)
        main = findViewById(R.id.main)
        writing = findViewById(R.id.writing)


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