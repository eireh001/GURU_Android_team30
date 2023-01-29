package com.example.guru_android_team30

import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
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
    lateinit var date_reading : EditText
    lateinit var date_writing : EditText

    lateinit var read_record : EditText
    lateinit var check : ImageButton

    lateinit var calender : ImageButton
    lateinit var house : ImageButton
    lateinit var writing : ImageButton

    lateinit var writeDB : ReviewWrite.ReviewDB
    lateinit var sqlDB : SQLiteDatabase

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

        writeDB = ReviewWrite().ReviewDB(this)


        check.setOnClickListener {
            var title = title.text.toString()
            var writer = writer.text.toString()
            var publisher = publisher.text.toString()
            var date_reading = date_reading.text.toString()
            var date_writing = date_writing.text.toString()
            var read_record = read_record.text.toString()


            if(title.isEmpty() || writer.isEmpty() || publisher.isEmpty()
                || date_reading.isEmpty() || date_writing.isEmpty()) {
                Toast.makeText(this, "모두 입력해주세요.", Toast.LENGTH_SHORT).show()
            } else {
                sqlDB = writeDB.writableDatabase
                sqlDB.execSQL("INSERT INTO WRITE VALUES ('$title', '$writer', '$publisher', "+
                               "'$date_reading', '$date_writing', '$read_record');")
                sqlDB.close()

                Toast.makeText(this, "독서 기록장이 등록되었습니다.", Toast.LENGTH_SHORT).show()
                var intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }

        calender.setOnClickListener {

        }

        house.setOnClickListener {
            var intent = Intent(this, ReviewWrite::class.java)
            startActivity(intent)
        }

        writing.setOnClickListener {
            var intent = Intent(this, Write_popup::class.java)
            startActivity(intent)
        }
    }
}