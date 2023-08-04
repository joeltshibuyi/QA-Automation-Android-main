package com.palringo.qa_automation_android

import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class MainViewModelUnitTest {

    @Test
    fun `when ButtonClicked for the first time, label should be 1`() = runBlocking {
        // Arrange
        val viewModel = MainViewModel()

        // Act
        viewModel.onButtonClick()

        // Assert
        val newState = viewModel.screenState.first()
        assertEquals("1", newState.label)
    }

    @Test
    fun `when ButtonClicked for the second time, label should be 2`() = runBlocking {
        // Arrange
        val viewModel = MainViewModel()

        // Act
        viewModel.onButtonClick()
        viewModel.onButtonClick()

        // Assert
        val newState = viewModel.screenState.first()
        assertEquals("2", newState.label)
    }

    @Test
    fun `when ButtonClicked for the third time, label should be MAX`() = runBlocking {
        // Arrange
        val viewModel = MainViewModel()

        // Act
        viewModel.onButtonClick()
        viewModel.onButtonClick()
        viewModel.onButtonClick()

        // Assert
        val newState = viewModel.screenState.first()
        assertEquals("MAX", newState.label)
    }
}
