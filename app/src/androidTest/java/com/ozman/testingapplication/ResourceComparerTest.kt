package com.ozman.testingapplication

import android.content.Context
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test


class ResourceComparerTest {

    private lateinit var resourceComparer: ResourceComparer

    @Before
    fun setup() {
        resourceComparer = ResourceComparer()
    }

    @Test
    fun stringResourceSameAsGivenString_returnTrue() {
        val context = getApplicationContext<Context>()
        val result = resourceComparer.isEqual(context, R.string.app_name, "Testing Application")
        assertThat(result).isTrue()
    }

    @Test
    fun stringResourceDifferentAsGivenString_returnFalse() {
        val context = getApplicationContext<Context>()
        val result = resourceComparer.isEqual(context, R.string.app_name, "hello")
        assertThat(result).isFalse()
    }

}