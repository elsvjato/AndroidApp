package com.example.mobileapp

class CredentialsManager {
    private val emailPattern =
        "^[a-zA-Z0-9+._%\\-]{1,256}@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}\\.[a-zA-Z]{2,6}$"

    private val validEmail = "test@te.st"
    private val validPassword = "1234"

    fun isEmailValid(mail: String): Boolean {
        val regex = Regex(emailPattern)
        return regex.matches(mail)
    }

    fun isPasswordValid(password: String): Boolean {
        return password.isNotEmpty()
    }

    fun areCredentialsValid(email: String, password: String): Boolean {
        return email == validEmail && password == validPassword
    }
}



