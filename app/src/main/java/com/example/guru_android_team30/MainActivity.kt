package com.example.guru_android_team30

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    lateinit var main_navi : ImageButton
    lateinit var cal_navi : ImageButton
    lateinit var write_navi : ImageButton

    lateinit var search_icon : ImageButton

    lateinit var review_plus : ImageButton
    lateinit var write_plus : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_navi = findViewById(R.id.Main_navi_btn)
        cal_navi = findViewById(R.id.Cal_navi_btn)
        write_navi = findViewById(R.id.Write_navi_btn)

        search_icon = findViewById(R.id.search_icon)

        review_plus = findViewById(R.id.Review_plus)
        write_plus = findViewById(R.id.Write_plus)


        // 검색 아이콘 클릭
        search_icon.setOnClickListener {
            var intent = Intent(this, Search::class.java)
            startActivity(intent)
        }

        //네비게이션 바 - 캘린더 아이콘 클릭

        //네비게이션 바 - 메인 아이콘 클릭
        main_navi.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //네비게이션 바 - 작성 아이콘 클릭
        write_navi.setOnClickListener {
            var intent = Intent(this, Write_popup::class.java)
            startActivity(intent)
        }

        //리뷰
        review_plus.setOnClickListener {
            var intent = Intent(this, ReviewWrite::class.java)
            startActivity(intent)
        }

        write_plus.setOnClickListener {
            var intent = Intent(this, Writepage::class.java)
            startActivity(intent)
        }
    }
}