package com.example.baytna.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.baytna.R

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var backToLogin: ImageButton
        lateinit var signUpBtn: Button


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        backToLogin = findViewById(R.id.backtoLogin_id)
        signUpBtn = findViewById(R.id.sign_btn2_id)


        backToLogin.setOnClickListener{
            var intent_back_login = Intent(this, Login::class.java)
            startActivity(intent_back_login)
        }

        signUpBtn.setOnClickListener{

            var intent_signup_btn2 = Intent(this, Home::class.java)
            startActivity(intent_signup_btn2)

        }





    }
}