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

class ReviewWrite : AppCompatActivity() {

    //책 정보
    lateinit var title : EditText
    lateinit var writer : EditText
    lateinit var publisher : EditText
    lateinit var date_publishing : EditText
    lateinit var date_writing : TextView

    //평점
    lateinit var review_eval : EditText

    //평가 버튼
    lateinit var review_short : ImageButton
    lateinit var review_correct : ImageButton
    lateinit var review_long : ImageButton

    lateinit var review_not : ImageButton
    lateinit var review_ok : ImageButton
    lateinit var review_funny : ImageButton

    //기록
    lateinit var review_record : EditText
    lateinit var check : ImageButton

    //네비게이션 바
    lateinit var calender : ImageButton
    lateinit var main : ImageButton
    lateinit var writing : ImageButton

    //DB
    lateinit var reviewDB: ReviewDB
    lateinit var sqlDB :SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review_write)

        title = findViewById(R.id.title)
        writer = findViewById(R.id.writer)
        publisher = findViewById(R.id.publisher)
        date_publishing = findViewById(R.id.date_publishing)
        date_writing = findViewById(R.id.date_writing)

        review_eval = findViewById(R.id.review_eval)

        review_short = findViewById(R.id.review_short)
        review_correct = findViewById(R.id.review_correct)
        review_long = findViewById(R.id.review_long)

        review_not = findViewById(R.id.review_not)
        review_ok = findViewById(R.id.review_ok)
        review_funny = findViewById(R.id.review_funny)

        review_record = findViewById(R.id.read_record)
        check = findViewById(R.id.check)

        calender = findViewById(R.id.calender)
        main = findViewById(R.id.main)
        writing = findViewById(R.id.writing)

        reviewDB = ReviewDB(this)



        //평가 버튼 클릭
        review_short.setOnClickListener {
            Toast.makeText(this, "짧아요", Toast.LENGTH_SHORT).show()
        }

        review_correct.setOnClickListener {
            Toast.makeText(this, "적당해요", Toast.LENGTH_SHORT).show()
        }

        review_long.setOnClickListener {
            Toast.makeText(this, "길어요", Toast.LENGTH_SHORT).show()
        }

        review_not.setOnClickListener {
            Toast.makeText(this, "별로에요", Toast.LENGTH_SHORT).show()
        }

        review_ok.setOnClickListener {
            Toast.makeText(this, "괜찮아요", Toast.LENGTH_SHORT).show()
        }

        review_funny.setOnClickListener {
            Toast.makeText(this, "재밌어요", Toast.LENGTH_SHORT).show()
        }


        //확인
        check.setOnClickListener {
            //책 정보 DB에 저장
            var title = title.text.toString()
            var writer = writer.text.toString()
            var publisher = publisher.text.toString()
            var date_publishing = date_publishing.text.toString()
            var date_writing = date_writing.text.toString()
            var eval = review_eval.text.toString()
            var review_record = review_record.text.toString()

            if(title.isEmpty() || writer.isEmpty() || publisher.isEmpty() || date_publishing.isEmpty()
                || date_writing.isEmpty() || eval.isEmpty() || review_record.isEmpty()) {
                Toast.makeText(this, "모두 입력해주세요.", Toast.LENGTH_LONG).show()
            } else {
                sqlDB = reviewDB.writableDatabase
                sqlDB.execSQL("INSERT INTO REVIEW VALUES ('$title', '$writer', '$publisher', " +
                        "'$date_publishing', '$date_writing', '$eval', '$review_record' );")
                sqlDB.close()

                Toast.makeText(this, "리뷰가 등록되었습니다.", Toast.LENGTH_LONG).show()
                var intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }


        //네비게이션 바
        calender.setOnClickListener {

        }

        main.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        writing.setOnClickListener {
            var intent = Intent(this, Write_popup::class.java)
            startActivity(intent)
        }

    }

    inner class ReviewDB (context: Context) : SQLiteOpenHelper (context, "reviewDB", null, 1) {
        override fun onCreate(db: SQLiteDatabase?) {
            db!!.execSQL("CREATE TABLE REVIEW (title CHAR(20), writer CHAR(20)," +
                    "publisher CHAR(20), date_publishing DATE, date_writing DATE, eval INTEGER, review_record CHAR(50));")
        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            db!!.execSQL("DROP TABLE IF EXISTS REVIEW")
            onCreate(db)
        }
    }
}