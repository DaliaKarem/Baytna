package com.example.baytna.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.baytna.R

class Login : AppCompatActivity() {

    lateinit var signup_btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        signup_btn = findViewById(R.id.Signup_btn_id)
        signup_btn.setOnClickListener{
            var intent1 : Intent = Intent(this, SignUp::class.java)
            startActivity(intent1)
        }
    }
}