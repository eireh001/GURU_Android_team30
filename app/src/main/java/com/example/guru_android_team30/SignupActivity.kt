package com.example.guru_android_team30

import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class SignupActivity : AppCompatActivity() {

    //변수 선언
    lateinit var sign_up_name : EditText
    lateinit var sign_up_email : EditText
    lateinit var sign_up_pw : EditText
    lateinit var sign_up_chkPw : EditText
    lateinit var sign_up_btn : ImageButton

    lateinit var myHelper : myDBHelper
    lateinit var sqlDB : SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        //변수에 위젯 대입
        sign_up_name = findViewById(R.id.Sign_up_name)
        sign_up_email = findViewById(R.id.Sign_up_email)
        sign_up_pw = findViewById(R.id.Sign_up_pw)
        sign_up_chkPw = findViewById(R.id.Sign_up_chkPw)
        sign_up_btn = findViewById(R.id.Sign_up_btn)

        myHelper = myDBHelper(this)

        //가입하기 버튼 클릭했을 때 동작하는 리스너 구현
        sign_up_btn.setOnClickListener {

            var name = sign_up_name.text.toString()
            var email = sign_up_email.text.toString()
            var pw = sign_up_pw.text.toString()
            var chkPw = sign_up_chkPw.text.toString()

            //회원가입 창에 비어져 있는 부분이 있으면 회원가입 실패
            if(name.isEmpty() || email.isEmpty() || pw.isEmpty() || chkPw.isEmpty()) {
                Toast.makeText(applicationContext, "빠진 부분 없이 입력해주세요.", Toast.LENGTH_SHORT).show()
            } else { //비어있는 부분이 없고 비번 칸과 비번 확인 칸이 같으면 회원가입 성공
                if (pw == chkPw) {
                    //userDB에 회원정보 저장
                    sqlDB = myHelper.writableDatabase
                    sqlDB.execSQL("INSERT INTO USER VALUES ('$name', '$email', '$pw', '$chkPw');")
                    sqlDB.close()

                    //회원가입 완료 창 띄우기
                    var intent = Intent(this, Signup_CompleteActivity::class.java)
                    startActivity(intent)
                }
                else { //비번 칸과 비번 확인 칸이 다르면 회원가입 실패
                    Toast.makeText(applicationContext, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    //DB, 테이블 생성  DB 이름 : userDB, 테이블 이름 : USER
    inner class myDBHelper(context: Context) : SQLiteOpenHelper (context, "userDB", null, 1) {
        override fun onCreate(db: SQLiteDatabase?) {
            db!!.execSQL("CREATE TABLE USER (name char(20), email char(20) PRIMARY KEY, " +
                    "pw char(20), chkPw char(20));")
        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            db!!.execSQL("DROP TABLE IF EXISTS USER")
            onCreate(db)
        }
    }

}