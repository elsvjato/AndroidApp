package com.example.mobileapp

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignInActivity : AppCompatActivity() {
    private val credentialsManager = CredentialsManager()

    // Properties for views using custom getters
    private val emailEditText: EditText
        get() = findViewById(R.id.email)

    private val passwordEditText: EditText
        get() = findViewById(R.id.password)

    private val nextButton: Button
        get() = findViewById(R.id.next)

    private val newMemberTextView: TextView
        get() = findViewById(R.id.newMember)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_in)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val registerNowLabel = findViewById<TextView>(R.id.newMember)

        registerNowLabel.setOnClickListener {

            Log.d("Onboarding", "Register now pressed")

            val goToRegisterIntent = Intent(this@SignInActivity, CreateAccountActivity::class.java)
            startActivity(goToRegisterIntent)
        }

        val nextButton = findViewById<Button>(R.id.next)
        nextButton.setOnClickListener{
            validateAndLogin()
        }
    }

    private fun validateAndLogin() {
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()

        var isValid = true

        // Validate email
        if (!credentialsManager.isEmailValid(email)) {
            emailEditText.error = "Invalid email format"
            isValid = false
        } else {
            emailEditText.error = null
        }

        // Validate password
        if (!credentialsManager.isPasswordValid(password)) {
            passwordEditText.error = "Password cannot be empty"
            isValid = false
        } else {
            passwordEditText.error = null
        }

        // Check hardcoded credentials if validation passed
        if (isValid && credentialsManager.areCredentialsValid(email, password)) {
            emailEditText.error = null
            passwordEditText.error = null
            goToMainActivity()

        } else if (isValid) {
            passwordEditText.error = "Invalid credentials"
        }
    }
    private fun goToMainActivity() {
        val intent = Intent(this, MainPageActivity::class.java)
        startActivity(intent)

    }
}