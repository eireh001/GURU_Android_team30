package com.example.guru_android_team30

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class SignupActivity : AppCompatActivity() {

    lateinit var sign_up : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        sign_up = findViewById(R.id.Sign_up)

        sign_up.setOnClickListener {
            var intent = Intent(this, Signup_CompleteActivity::class.java)

            startActivity(intent)
        }
    }
}