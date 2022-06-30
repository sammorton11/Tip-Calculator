package com.example.tipcalculator.tests

import androidx.core.content.res.TypedArrayUtils.getString
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.tipcalculator.R
import com.example.tipcalculator.TestRules

abstract class BaseTest : TestRules(){

    fun clickButton(resourceId: Int){
        onView(withId(resourceId))
            .perform(click())
    }

    fun checkVisibility(resourceId: Int){
        onView(withId(resourceId))
            .check(matches(isDisplayed()))
    }

    fun typeInText(resourceId: Int, text: String){
        onView(withId(resourceId))
            .perform(typeText(text))
    }


    fun checkTextVisibility(text: Int){
        onView(withText(text))
            .check(matches(isDisplayed()))
    }
}