package com.example.cupcake.test

import androidx.navigation.NavController
import junit.framework.TestCase.assertEquals
import org.junit.Test

@Test
fun NavController.assertCurrentRouteName(expectedRouteName: String) {
    assertEquals(expectedRouteName, currentBackStackEntry?.destination?.route)
}