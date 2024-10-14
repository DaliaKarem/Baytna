package com.example.baytna.View

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.baytna.Model.UserModel
import com.example.baytna.Presenter.LoginPresenter
import com.example.baytna.R

class Login : AppCompatActivity(),LoginView {

    private var presenter: LoginPresenter? = null

    lateinit var login_btn: Button
    lateinit var signup_btn: Button
    lateinit var back_btn:ImageButton
    lateinit var emailEditText: EditText
    lateinit var passwordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_login)


        presenter = LoginPresenter(this, UserModel())
        val rootView: View = findViewById(R.id.main)
        setupUI(rootView)
        login_btn = findViewById(R.id.login_btn_id)
        signup_btn = findViewById(R.id.Signup_btn_id)
        back_btn = findViewById(R.id.imageView2)
        emailEditText = findViewById(R.id.Email_edt_id)
        passwordEditText = findViewById(R.id.Pass_edt_id)
        setupUI(findViewById(R.id.main))



        signup_btn.setOnClickListener{
            var intent1 : Intent = Intent(this, SignUp::class.java)
            startActivity(intent1)
        }

        login_btn.setOnClickListener{
            val email: String = emailEditText.getText().toString()
            val password: String = passwordEditText.getText().toString()
            presenter!!.login(email, password)


    }

        back_btn.setOnClickListener{
            var intent3 : Intent = Intent(this, Welcome::class.java)
            startActivity(intent3)
        }





    }override fun onLoginSuccess() {
        Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show();

        var intent2 : Intent = Intent(this, Home::class.java)
        startActivity(intent2)

    }

    override fun onLoginFailure(message: String) {
        Toast.makeText(this, "Login Failed: " + message, Toast.LENGTH_SHORT).show();
    }

    private fun setupUI(view: View) {
        // Set up touch listener for non-text box views to hide the keyboard
        if (view !is EditText && view !is Button && view !is ImageButton) {
            view.setOnTouchListener { v, event ->
                hideKeyboard(v)
                true
            }
        }

        // If a layout contains children, iterate through them and apply the touch listener
        if (view is ViewGroup) {
            for (i in 0 until view.childCount) {
                val innerView = view.getChildAt(i)
                setupUI(innerView)
            }
        }
    }

    // Method to hide the keyboard
    private fun hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
    }
}