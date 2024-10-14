package com.example.baytna.View
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity

import com.example.baytna.R
import com.example.baytna.databinding.ActivityBookTimeBinding

class Book_time : AppCompatActivity() {

    private lateinit var binding: ActivityBookTimeBinding
    private lateinit var dropMenuCity: AutoCompleteTextView
    private lateinit var selectDate: AutoCompleteTextView
    private lateinit var selectTime: AutoCompleteTextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_time)

        binding = ActivityBookTimeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listOfCity = listOf("Cairo", "Giza", "Alexandria")
        val adapter = ArrayAdapter(this, R.layout.drop_down_list_item, listOfCity)
        dropMenuCity = binding.cityDropdown
        dropMenuCity.setAdapter(adapter)

        selectDate = binding.dateEditText
        selectTime = binding.timeEditText

        selectDate.setOnClickListener {
            dateDialog()
        }

        selectTime.setOnClickListener {
            timeDialog()
        }
    }

    private fun dateDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        calendar.add(Calendar.DAY_OF_MONTH, 1)
        val minDate = calendar.timeInMillis

        val datePickerDialog = DatePickerDialog(this,
            { _, selectedYear, selectedMonth, selectedDayOfMonth ->
                val selectedDate = "$selectedDayOfMonth/${selectedMonth + 1}/$selectedYear"
                selectDate.setText(selectedDate)
            }, year, month, day)

        datePickerDialog.datePicker.minDate = minDate

        datePickerDialog.show()
    }

    private fun timeDialog() {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val timePickerDialog = TimePickerDialog(this,
            { _, selectedHour, selectedMinute ->
                val selectedTime = String.format("%02d:%02d", selectedHour, selectedMinute)
                selectTime.setText(selectedTime)
            }, hour, minute, true)

        timePickerDialog.show()
    }
}
