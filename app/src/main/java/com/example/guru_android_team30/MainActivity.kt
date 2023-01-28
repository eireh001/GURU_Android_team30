package com.example.guru_android_team30

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    lateinit var main_navi : ImageButton
    lateinit var cal_navi : ImageButton
    lateinit var write_navi : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_navi = findViewById(R.id.Main_navi_btn)
        cal_navi = findViewById(R.id.Cal_navi_btn)
        write_navi = findViewById(R.id.write_navi_btn)

        //네비게이션 바 클릭
        main_navi.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}