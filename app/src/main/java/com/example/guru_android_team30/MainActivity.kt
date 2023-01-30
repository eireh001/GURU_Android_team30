package com.example.guru_android_team30

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.marginLeft
import androidx.core.view.marginRight
import androidx.core.view.marginStart

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

    // 독서 기록 DB
    lateinit var myWriteDB : Writepage.WriteDB
    lateinit var sqlWriteDB : SQLiteDatabase

    lateinit var write_title1 : TextView
    lateinit var write_content1 : TextView
    lateinit var write_title2 : TextView
    lateinit var write_content2 : TextView

    // 리뷰 layout
    lateinit var layout : LinearLayout
    lateinit var layout2 : LinearLayout
    lateinit var layout3 : LinearLayout


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
        layout2 = findViewById(R.id.main2_review)
        layout3 = findViewById(R.id.main3_review)


        // DB 불러오기
        myHelper = ReviewWrite().ReviewDB(this)
        sqlDB = myHelper.readableDatabase

        myWriteDB = Writepage().WriteDB(this)
        sqlWriteDB = myWriteDB.readableDatabase

        write_title1 = findViewById(R.id.Write_title1)
        write_content1 = findViewById(R.id.Write_content1)
        write_title2 = findViewById(R.id.Write_title2)
        write_content2 = findViewById(R.id.Write_content2)


        //리뷰 기록
        var cursor : Cursor
        cursor = sqlDB.rawQuery("SELECT * FROM REVIEW", null)

        var cursor2 : Cursor
        cursor2 = sqlDB.rawQuery("SELECT *, count(*) FROM REVIEW group by title", null)

        var cursor4 : Cursor
        cursor4 = sqlDB.rawQuery("SELECT *, count(*) FROM REVIEW group by eval", null)
        

        var num : Int = 0

        // 리뷰 작성하는데 가장 최근에 작성된 리뷰
        if (cursor2.moveToLast())
        {
            var str_title = cursor2.getString(cursor.getColumnIndex("title")).toString()
            var count = cursor2.getInt(cursor.getColumnCount())

            var layout_item : LinearLayout = LinearLayout(this)
            layout_item.orientation = LinearLayout.VERTICAL
            layout_item.id = num

            var tvTitle : TextView = TextView(this)
            tvTitle.text = str_title
            tvTitle.width = 255
            tvTitle.setTextSize(10F)
            layout_item.addView(tvTitle)

            var eval3 = cursor2.getInt(cursor.getColumnIndex("eval"))
            var tvEval: TextView = TextView(this)
            tvEval.text = "평점 평균 :   " + eval3.toString()
            tvEval.setTextSize(10F)
            layout_item.addView(tvEval)

            var tvNum : TextView = TextView(this)
            tvNum.text = "리뷰 개수 :   " + count.toString()
            tvNum.setTextSize(10F)
            layout_item.addView(tvNum)

            layout.addView(layout_item)
            num++

        }

        // 리뷰 작성하는데 최근에 작성된 리뷰
        if (cursor2.moveToPrevious())
        {
            var str_title2 = cursor2.getString(cursor.getColumnIndex("title")).toString()
            var count2 = cursor2.getInt(cursor.getColumnCount())

            var layout_item2 : LinearLayout = LinearLayout(this)
            layout_item2.orientation = LinearLayout.VERTICAL
            layout_item2.id = num

            var tvTitle2 : TextView = TextView(this)
            tvTitle2.text = str_title2
            tvTitle2.width = 255
            tvTitle2.setTextSize(10F)
            layout_item2.addView(tvTitle2)

                    var eval2 = cursor2.getInt(cursor.getColumnIndex("eval"))
                    var tvEval2 : TextView = TextView(this)
                    tvEval2.text = "평점 평균 :   " + eval2.toString()
                    tvEval2.setTextSize(10F)
                    layout_item2.addView(tvEval2)

            var tvNum2 : TextView = TextView(this)
            tvNum2.text = "리뷰 개수 :   " + count2.toString()
            tvNum2.setTextSize(10F)
            layout_item2.addView(tvNum2)

            layout2.addView(layout_item2)
            num++

        }

        // 리뷰 작성하는데 마지막에 작성된 리뷰
        if (cursor2. moveToFirst())
        {
            var str_title3 = cursor2.getString(cursor.getColumnIndex("title")).toString()
            var count3 = cursor2.getInt(cursor.getColumnCount())

            var layout_item3 : LinearLayout = LinearLayout(this)
            layout_item3.orientation = LinearLayout.VERTICAL
            layout_item3.id = num

            var tvTitle3 : TextView = TextView(this)
            tvTitle3.text = str_title3
            tvTitle3.width = 255
            tvTitle3.setTextSize(10F)
            layout_item3.addView(tvTitle3)

                var eval3 = cursor2.getInt(cursor.getColumnIndex("eval"))
                var tvEval3 : TextView = TextView(this)
                tvEval3.text = "평점 평균 :   " + eval3.toString()
                tvEval3.setTextSize(10F)
                layout_item3.addView(tvEval3)

            var tvNum3 : TextView = TextView(this)
            tvNum3.text = "리뷰 개수 :   " + count3.toString()
            tvNum3.setTextSize(10F)
            layout_item3.addView(tvNum3)

            layout3.addView(layout_item3)
            num++

        }


        cursor2.close()
        sqlDB.close()
        myHelper.close()


        //독서기록
//        var cursor3 : Cursor = sqlWriteDB.rawQuery("SELECT * FROM WRITE;", null)
//
//        cursor3.moveToLast()
//        var title = cursor3.getString(0)
//        var content = cursor3.getString(5)
//        write_title1.setText(title)
//        write_content1.setText(content)
//
//        cursor3.moveToPrevious()
//        title = cursor3.getString(0)
//        content = cursor3.getString(5)
//        write_title2.setText(title)
//        write_content2.setText(content)
//
//        cursor3.close()
//        sqlWriteDB.close()


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