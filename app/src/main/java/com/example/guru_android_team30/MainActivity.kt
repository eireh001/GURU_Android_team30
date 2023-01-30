package com.example.guru_android_team30

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var main_navi : ImageButton
    lateinit var cal_navi : ImageButton
    lateinit var write_navi : ImageButton

    lateinit var search_icon : ImageButton

    lateinit var review_plus : ImageButton
    lateinit var write_plus : ImageButton

    // 리뷰 DB
    lateinit var myHelper: ReviewWrite.ReviewDB
    lateinit var sqlDB : SQLiteDatabase


    lateinit var layout : LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_navi = findViewById(R.id.Main_navi_btn)
        cal_navi = findViewById(R.id.Cal_navi_btn)
        write_navi = findViewById(R.id.Write_navi_btn)

        search_icon = findViewById(R.id.search_icon)

        review_plus = findViewById(R.id.Review_plus)
        write_plus = findViewById(R.id.Write_plus)

        layout = findViewById(R.id.main_review)


        // 리뷰 DB 불러오기
        myHelper = ReviewWrite().ReviewDB(this)
        sqlDB = myHelper.readableDatabase

        var cursor : Cursor
        cursor = sqlDB.rawQuery("SELECT * FROM REVIEW", null)

        var cursor2 : Cursor
        cursor2 = sqlDB.rawQuery("SELECT *, count(*) FROM REVIEW group by title", null)

        var num : Int = 0
        while(cursor2.moveToNext()) {
            var str_title = cursor2.getString(cursor.getColumnIndex("title")).toString()
            var eval = cursor2.getInt((cursor.getColumnIndex("eval")))

            var count = cursor2.getInt(cursor.getColumnCount())

            num++;

            var layout_item : LinearLayout = LinearLayout(this)
            layout_item.orientation = LinearLayout.VERTICAL
            layout_item.id = num

            var tvTitle : TextView = TextView(this)
            tvTitle.text = str_title + "\t\t\t\t\t\t\t\t\t\t\t"
            layout_item.addView(tvTitle)

            var tvEval : TextView = TextView(this)
            tvEval.text = eval.toString()
            layout_item.addView(tvEval)

            var tvNum : TextView = TextView(this)
            tvNum.text = count.toString()
            layout_item.addView(tvNum)

            layout.addView(layout_item)

        }


        cursor2.close()
        sqlDB.close()
        myHelper.close()




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