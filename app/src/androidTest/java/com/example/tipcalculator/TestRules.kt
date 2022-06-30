package com.example.tipcalculator

import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule

abstract class TestRules {

    @get:Rule()
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

}