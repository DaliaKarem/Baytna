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
        backToLogin.setOnClickListener{
            var intent2 = Intent(this, Login::class.java)
            startActivity(intent2)
        }
    }
}