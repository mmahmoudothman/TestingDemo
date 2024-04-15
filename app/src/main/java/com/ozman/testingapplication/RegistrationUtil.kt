package com.ozman.testingapplication

object RegistrationUtil {

    private val existingUsers = listOf("Perter", "Carl")

    /**
     * the input in not valid if ...
     * .... the username/ password is empty
     * .... the username is already token
     * .... the confirm password is not the same oas the real password
     * .... the password contains less than 2 digits
     * */
    fun validatedRegistrationInput(
        username: String,
        password: String,
        confirmPassword: String
    ): Boolean {
        if (username.isEmpty() || password.isEmpty())
            return false
        if (username in existingUsers)
            return false
        if (password != confirmPassword)
            return false
        if (password.count { it.isDigit() } < 2)
            return false
        return true
    }
}