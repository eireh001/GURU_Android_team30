package com.example.guru_android_team30

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Signup_Complete : AppCompatActivity() {

    lateinit var sign_up_done : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_complete)

        sign_up_done = findViewById(R.id.Sign_up_done)

        sign_up_done.setOnClickListener{
            var intent = Intent (this, Login::class.java)

            startActivity(intent)
        }
    }
}