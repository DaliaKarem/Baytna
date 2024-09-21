package com.example.baytna.Activity;

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.baytna.R

class onBoardingScreen : AppCompatActivity() {
    // Declare your views
    private lateinit var titletxt: TextView
    private lateinit var splashtxt: TextView
    private lateinit var img: ImageView
    private lateinit var btn: Button

    private var currentIndex = 0
    private val onBoardingImgs = arrayOf(
        R.drawable.cleaning_img,
        R.drawable.book_img,
        R.drawable.payment
    )

    private val titles = arrayOf(
        "Welcome to Service App",
        "Book Worker",
        "Payment Online"
    )

    private val splashs = arrayOf(
        "Choose from a variety of services like Cleaning, Electrical, Plumbing, and Garden workers to meet your needs.",
        "You can Book a worker at any time. Select the day and how many times you want this service.",
        "You have the option to pay using credit or cash as you like."
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding_screen);
        titletxt=findViewById(R.id.titletxt);
        splashtxt=findViewById(R.id.splashtxt);
        img=findViewById(R.id.imageId);
        btn=findViewById(R.id.next_btn);
        updateOnBoardingScreen()
        btn.setOnClickListener {
            currentIndex++

            if (currentIndex < titles.size) {
                updateOnBoardingScreen()
            } else {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }


    private fun updateOnBoardingScreen() {
        titletxt.text = titles[currentIndex]
        splashtxt.text = splashs[currentIndex]
        img.setImageResource(onBoardingImgs[currentIndex])

        // Optionally update button text on the last screen
        if (currentIndex == titles.size - 1) {
            btn.text = "Finish"
        } else {
            btn.text = "Next"
        }
    }
}