package com.example.baytna.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.baytna.R

class Welcome : AppCompatActivity() {
   lateinit var login_btn :Button
    lateinit var signup_btn :Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        login_btn = findViewById(R.id.btn2)
        signup_btn = findViewById(R.id.btn1)

        login_btn.setOnClickListener{
            var intent_login = Intent(this,Login::class.java)
            startActivity(intent_login)

        }

        login_btn.setOnClickListener{
            var intent_signup = Intent(this,SignUp::class.java)
            startActivity(intent_signup)

        }

    }
}