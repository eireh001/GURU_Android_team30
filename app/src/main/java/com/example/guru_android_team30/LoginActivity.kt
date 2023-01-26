package com.example.guru_android_team30

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class LoginActivity : AppCompatActivity() {

    lateinit var login_button : ImageButton
    lateinit var sign_up : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_button = findViewById(R.id.Login_button)
        sign_up = findViewById(R.id.Sign_up)

        login_button.setOnClickListener{
            var intent = Intent (this, MainActivity::class.java)

            startActivity(intent)
        }

        sign_up.setOnClickListener {
            var intent = Intent (this, SignupActivity::class.java)

            startActivity(intent)
        }
    }


}