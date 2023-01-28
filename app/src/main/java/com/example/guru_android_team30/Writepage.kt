package com.example.guru_android_team30

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class Writepage : AppCompatActivity() {
    lateinit var title : EditText
    lateinit var writer : EditText
    lateinit var publisher : EditText
    lateinit var date_reading : TextView
    lateinit var date_writing : TextView

    lateinit var read_record : EditText

    lateinit var check : ImageButton

    lateinit var calender : ImageButton
    lateinit var house : ImageButton
    lateinit var writing : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_writepage)

        title = findViewById(R.id.title)
        writer = findViewById(R.id.writer)
        publisher = findViewById(R.id.publisher)
        date_reading = findViewById(R.id.date_reading)
        date_writing = findViewById(R.id.date_writing)

        read_record = findViewById(R.id.read_record)

        check = findViewById(R.id.check)

        calender = findViewById(R.id.calender)
        house = findViewById(R.id.house)
        writing = findViewById(R.id.writing)


        check.setOnClickListener {
            Toast.makeText(this, "check", Toast.LENGTH_SHORT).show()
        }

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