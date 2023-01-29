package com.example.guru_android_team30

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

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

//    lateinit var str_title : String
//    var eval : Int = 0

//    lateinit var review_title : TextView
//    lateinit var review_eval : TextView
//    lateinit var review_num : TextView

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

//        review_title = findViewById(R.id.Review_title1)
//        review_eval =findViewById(R.id.Review_grade1)
//        review_num = findViewById(R.id.Review_count1)

        // 리뷰 DB 불러오기
        myHelper = ReviewWrite().ReviewDB(this)
        sqlDB = myHelper.readableDatabase

        var cursor : Cursor
        cursor = sqlDB.rawQuery("SELECT * FROM REVIEW", null)

        var num : Int = 0
        while(cursor.moveToNext()) {
            var str_title = cursor.getString(cursor.getColumnIndex("title")).toString()
            var eval = cursor.getInt((cursor.getColumnIndex("eval")))
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
            tvNum.text = num.toString()
            layout_item.addView(tvNum)

            layout.addView(layout_item)
            num++;

        }

        cursor.close()
        sqlDB.close()
        myHelper.close()

//        review_title.text = str_title
//        review_eval.text = "" +eval
//        review_num.text = number.toString()



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