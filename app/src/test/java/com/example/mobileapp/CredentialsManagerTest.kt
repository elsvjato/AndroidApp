package com.example.mobileapp

import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Test

class CredentialsManagerTest {

    @Test
    fun givenEmptyEmail_thenReturnFalse() {
        val credentialsManager = CredentialsManager()
        val email = ""

        val result = credentialsManager.isEmailValid(email)
        assertFalse(result)
    }

    @Test
    fun givenWellFormattedEmail_thenReturnTrue() {
        val credentialsManager = CredentialsManager()
        val email = "tested@te.st"

        val result = credentialsManager.isEmailValid(email)
        assertTrue(result)
    }

    @Test
    fun givenWrongEmailFormat_thenReturnFalse() {
        val credentialsManager = CredentialsManager()
        val email = "wrongEmailFormat"

        val result = credentialsManager.isEmailValid(email)
        assertFalse(result)
    }
}
