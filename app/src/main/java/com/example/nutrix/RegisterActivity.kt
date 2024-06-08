package com.example.nutrix

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import android.app.DatePickerDialog
import java.util.*

class RegisterActivity : AppCompatActivity() {
    private lateinit var btnRegister: Button
    private lateinit var editTextName: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var editTextDob: EditText
    private lateinit var editTextAllergies: EditText
    private lateinit var editTextWeight: EditText
    private lateinit var editTextHeight: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        // Hide ActionBar
        supportActionBar?.hide()

        btnRegister = findViewById(R.id.btn_register)
        editTextName = findViewById(R.id.edit_name)
        editTextEmail = findViewById(R.id.edit_email)
        editTextPassword = findViewById(R.id.edit_password)
        editTextDob = findViewById(R.id.edit_dob)
        editTextAllergies = findViewById(R.id.edit_allergies)
        editTextWeight = findViewById(R.id.edit_weight)
        editTextHeight = findViewById(R.id.edit_height)

        editTextDob.inputType = 0
        editTextDob.setOnClickListener{
            showDatePickerDialog()
        }
        editTextDob.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                showDatePickerDialog()
            }
        }
        btnRegister.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { _, selectedYear, selectedMonth, selectedDay ->
                val selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                editTextDob.setText(selectedDate)
            },
            year,
            month,
            day
        )

        // Set the minimum and maximum dates
        val minDate = Calendar.getInstance().apply { set(year - 60, month, day) }.timeInMillis
        val maxDate = Calendar.getInstance().apply { set(year - 7, month, day) }.timeInMillis
        datePickerDialog.datePicker.minDate = minDate
        datePickerDialog.datePicker.maxDate = maxDate

        datePickerDialog.show()
    }
}