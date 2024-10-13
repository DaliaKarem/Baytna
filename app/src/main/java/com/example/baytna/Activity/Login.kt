package com.example.baytna.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.baytna.R

class Login : AppCompatActivity() {
    lateinit var login_btn: Button
    lateinit var signup_btn: Button
    lateinit var back_btn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        login_btn = findViewById(R.id.login_btn_id)
        signup_btn = findViewById(R.id.Signup_btn_id)
        back_btn = findViewById(R.id.imageView2)
        signup_btn.setOnClickListener{
            var intent1 : Intent = Intent(this, SignUp::class.java)
            startActivity(intent1)
        }

        login_btn.setOnClickListener{
            var intent2 : Intent = Intent(this, Home::class.java)
            startActivity(intent2)
        }
        back_btn.setOnClickListener{
            var intent3 : Intent = Intent(this, Welcome::class.java)
            startActivity(intent3)
        }

    }
}