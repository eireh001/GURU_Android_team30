package com.example.guru_android_team30

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.view.Window
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class Write_popup : AppCompatActivity() {

    lateinit var review : ImageButton
    lateinit var write : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_write_popup)


        review = findViewById(R.id.review_btn)
        write = findViewById(R.id.write_btn)

        review.setOnClickListener {
            var intent = Intent (this, ReviewWrite::class.java)
            startActivity(intent)
        }

        write.setOnClickListener {
            var intent = Intent(this, Writepage::class.java)
            startActivity(intent)
        }
    }

}