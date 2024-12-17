package com.example.mobileapp

import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class CredentialsManagerTest {
    private lateinit var credentialsManager: CredentialsManager

    @Before
    fun setUp() {
        credentialsManager = CredentialsManager()
    }

    @Test
    fun givenEmptyEmailThenReturnFalse() {
        val credentialsManager = CredentialsManager()
        val email = ""

        val result = credentialsManager.isEmailValid(email)
        Assert.assertFalse(result)
    }

    @Test
    fun givenInvalidEmailFormatThenReturnFalse() {
        val credentialsManager = CredentialsManager()
        val email = "invalid-email"

        val result = credentialsManager.isEmailValid(email)
        Assert.assertFalse(result)
    }

    @Test
    fun givenValidEmailThenReturnTrue() {
        val credentialsManager = CredentialsManager()
        val email = "test@example.com"
        val result = credentialsManager.isEmailValid(email)
        Assert.assertTrue(result)
    }

    @Test
    fun givenEmptyPasswordThenReturnFalse() {
        val credentialsManager = CredentialsManager()
        val password = ""
        val result = credentialsManager.isPasswordValid(password)
        Assert.assertFalse(result)
    }

    @Test
    fun givenNonEmptyPasswordThenReturnTrue() {
        val credentialsManager = CredentialsManager()
        val password = "password123"
        val result = credentialsManager.isPasswordValid(password)
        Assert.assertTrue(result)
    }
}