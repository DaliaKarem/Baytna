package com.example.baytna.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.baytna.R



class Profile : AppCompatActivity() {
    private lateinit var mobileEditText: EditText
    private lateinit var addressEditText: EditText
    private lateinit var editMobileButton: ImageButton
    private lateinit var editAddressButton: ImageButton
    private lateinit var logoutButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
// Toolbar setup
        val toolbar: Toolbar = findViewById(R.id.profile_toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Initialize views
        mobileEditText = findViewById(R.id.mobile_edit)
        addressEditText = findViewById(R.id.address_edit)
        editMobileButton = findViewById(R.id.edit_mobile_btn)
        editAddressButton = findViewById(R.id.edit_address_btn)
        logoutButton = findViewById(R.id.logout_btn)





        // Edit mobile number logic
        editMobileButton.setOnClickListener {
            if (mobileEditText.isEnabled) {
                // Save changes
                val updatedMobile = mobileEditText.text.toString()
                Toast.makeText(this, "Mobile number updated: $updatedMobile", Toast.LENGTH_SHORT).show()
                mobileEditText.isEnabled = false
            } else {
                // Enable editing
                mobileEditText.isEnabled = true
                mobileEditText.requestFocus()
            }
        }

        // Edit address logic
        editAddressButton.setOnClickListener {
            if (addressEditText.isEnabled) {
                // Save changes
                val updatedAddress = addressEditText.text.toString()
                // Show a confirmation message
                Toast.makeText(this, "Address updated: $updatedAddress", Toast.LENGTH_SHORT).show()
                addressEditText.isEnabled = false

            } else {
                // Enable editing
                addressEditText.isEnabled = true
                addressEditText.requestFocus()

                // Show the keyboard
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE)  as InputMethodManager
                imm.showSoftInput(addressEditText, InputMethodManager.SHOW_IMPLICIT)


            }
        }

        // Logout button logic with confirmation dialog
        logoutButton.setOnClickListener {
            showLogoutDialog()
        }
    }

    // Function to show the logout confirmation dialog
    private fun showLogoutDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Logout")
        builder.setMessage("Are you sure you want to logout?")

        // Positive button (Logout)
        builder.setPositiveButton("Logout") { dialogInterface: DialogInterface, _: Int ->
            // Perform logout action here
            Toast.makeText(this, "Logged out successfully!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish() // Close the current activity
        }

        // Negative button (Cancel)
        builder.setNegativeButton("Cancel") { dialogInterface: DialogInterface, _: Int ->
            dialogInterface.dismiss() // Close the dialog
        }

        // Show the dialog
        builder.show()
    }

    // Handle back button in the toolbar
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

