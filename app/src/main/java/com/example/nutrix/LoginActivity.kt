package com.example.nutrix

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var moveRegister:TextView
    private lateinit var btnLogin: Button
    private lateinit var editTextEmail : EditText
    private lateinit var editTextPassword : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        // Hide ActionBar
        supportActionBar?.hide()

        moveRegister = findViewById(R.id.move_register)
        btnLogin = findViewById(R.id.btn_login)
        editTextEmail = findViewById(R.id.edit_email)
        editTextPassword = findViewById(R.id.edit_password)


        moveRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        btnLogin.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}