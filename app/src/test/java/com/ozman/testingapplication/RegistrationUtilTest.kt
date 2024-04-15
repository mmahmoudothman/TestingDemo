package com.ozman.testingapplication

import com.google.common.truth.Truth.assertThat
import org.junit.Test


class RegistrationUtilTest {

    @Test
    fun `empty username return false`() {
        val result = RegistrationUtil.validatedRegistrationInput(
            "",
            "123",
            "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `valid username and correctly repeated password returns true`() {
        val result = RegistrationUtil.validatedRegistrationInput(
            "Philipp",
            "123",
            "123"
        )
        assertThat(result).isTrue()
    }

    @Test
    fun `username already exist returns false`() {
        val result = RegistrationUtil.validatedRegistrationInput(
            "Carl",
            "123",
            "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `empty password returns false`() {
        val result = RegistrationUtil.validatedRegistrationInput(
            "Carl",
            "",
            "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `incorrectly confirm password returns false`() {
        val result = RegistrationUtil.validatedRegistrationInput(
            "Carl",
            "123",
            "12333"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `less than two digits password returns false`() {
        val result = RegistrationUtil.validatedRegistrationInput(
            "Carl",
            "abcdef",
            "abcdef"
        )
        assertThat(result).isFalse()
    }
}