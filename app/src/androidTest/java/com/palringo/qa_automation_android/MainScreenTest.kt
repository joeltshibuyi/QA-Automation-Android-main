package com.palringo.qa_automation_android

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainScreenTest {

    @get:Rule
    val mainActivityTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun whenAppOpensButtonAndLabelShowsCorrectly() {
        mainActivityTestRule.onNodeWithText("Click me").assertExists()
        mainActivityTestRule.onNodeWithText("0").assertExists()
    }

    @Test
    fun whenButtonNotClickedLabelRemainsAt0() {
        mainActivityTestRule.onNodeWithText("0").assertExists()
        mainActivityTestRule.onNodeWithText("1").assertDoesNotExist()
    }

    @Test
    fun whenButtonClickedOnceLabelUpdatesTo1() {
        mainActivityTestRule.onNodeWithText("Click me").performClick()
        mainActivityTestRule.onNodeWithText("1").assertExists()
    }

    @Test
    fun whenButtonClickedTwiceLabelUpdatesTo2() {
        clickButtonNTimes(2)
        mainActivityTestRule.onNodeWithText("2").assertExists()
    }

    @Test
    fun whenButtonClickedThriceLabelUpdatesToMax() {
        clickButtonNTimes(3)
        mainActivityTestRule.onNodeWithText("MAX").assertExists()
    }

    @Test
    fun whenButtonClickedMoreThanThriceLabelRemainsAtMax() {
        clickButtonNTimes(4)
        mainActivityTestRule.onNodeWithText("MAX").assertExists()
        mainActivityTestRule.onNodeWithText("1").assertDoesNotExist()
        mainActivityTestRule.onNodeWithText("2").assertDoesNotExist()
    }

    private fun clickButtonNTimes(n: Int) {
        repeat(n) {
            mainActivityTestRule.onNodeWithText("Click me").performClick()
        }
    }
}
