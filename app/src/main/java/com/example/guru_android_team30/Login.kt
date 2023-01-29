package com.example.guru_android_team30

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class Login : AppCompatActivity() {

    //변수 선언
    lateinit var email_edt : EditText
    lateinit var pw_edt : EditText
    lateinit var login_button : ImageButton
    lateinit var sign_up : TextView

    lateinit var myHelper: Signup.myDBHelper
    lateinit var sqlDB : SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //변수에 위젯 대입
        email_edt  = findViewById(R.id.Email_edit)
        pw_edt = findViewById(R.id.PW_edit)
        login_button = findViewById(R.id.Login_button)
        sign_up = findViewById(R.id.Sign_up)

        myHelper = Signup().myDBHelper(this)


        //로그인 버튼 클릭시 리스너 구현
        login_button.setOnClickListener{

            var email = email_edt.text.toString()
            var pw = pw_edt.text.toString()

            sqlDB = myHelper.readableDatabase
            var cursor: Cursor
            cursor = sqlDB.rawQuery("SELECT * FROM USER;", null)

            lateinit var strEmail : String
            lateinit var strPW : String

            while (cursor.moveToNext()) {
                strEmail = cursor.getString(1)
                strPW = cursor.getString(2)
            }

            //로그인 성공
            if(email == strEmail) {
                if(pw == strPW) {
                    //메인 화면 창 띄우기
                    Toast.makeText(applicationContext, "로그인되었습니다.", Toast.LENGTH_SHORT).show()

                    var intent = Intent (this, MainActivity::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(applicationContext, "비밀번호를 다시 입력해주세요.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(applicationContext, "존재하지 않는 이메일입니다.", Toast.LENGTH_SHORT).show()
            }
        }

        //회원가입 창 띄우기
        sign_up.setOnClickListener {
            var intent = Intent (this, Signup::class.java)
            startActivity(intent)
        }
    }
}