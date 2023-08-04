# QA-Automation-Android-main

This repository contains the automated tests for the Palringo Android app. The tests are created using the Android Jetpack Compose UI testing framework.

## Tested Versions

This repository includes tests for two versions of the Palringo Android App:
- Version 0.9
- Version 1.0

## Differences between versions

### Version 0.9
In this version, clicking the button "Click me" on the main screen increments the label value from "0" to "1". Any further click sets the label to "MAX".

### Version 1.0
In this version, the increment is extended. Clicking the button "Click me" increments the label value from "0" to "1", then "1" to "2". Any further click sets the label to "MAX".

## Running the Tests

The tests are written in Kotlin and use the Android Jetpack Compose UI testing framework. Follow the steps below to run them:

1. Ensure you have the Android SDK and Emulator installed, or a physical device connected.
2. Open the project in Android Studio.
3. Navigate to the test file `MainScreenTest`.
4. Right-click on the file and choose "Run 'MainScreenTest'".

## Unit Testing

In addition to the UI tests, I've also incorporated unit tests for the ViewModel. The class `MainViewModelTest` is a testament to this, containing tests for the `onButtonClick` method of the `MainViewModel`.

I designed these tests to validate that the label updates correctly based on its current value:

- If the label reads "0", it should change to "1" upon clicking.
- For version 1.0, if the label reads "1", it should change to "2" upon clicking.
- If the label reads anything apart from "0" (or "1" for version 1.0), it should change to "MAX" upon clicking.

The purpose of these unit tests is to ensure the business logic embedded in the ViewModel functions as expected.

### Running the Unit Tests

The process to run the unit tests is similar to that of the UI tests:

1. I opened the project in Android Studio.
2. I navigated to the `MainViewModelUnitTest` file.
3. I then ran the file by right-clicking on it and selecting "Run 'MainViewModelUnitTest'".

## Testing Strategy

The tests check for the following:

- When the app opens, it contains a button with the text "Click me" and a label with the text "0".
- When the button is clicked once, the label changes to "1".
- In version 1.0, when the button is clicked again, the label changes to "2".
- When the button is clicked a third time (or second time in version 0.9), the label changes to "MAX".

You can find these tests in the `MainScreenTest` file.

## Findings

The main difference between versions 0.9 and 1.0 of the app is in the ViewModel's handling of button clicks. The UI components have remained consistent between the versions, and all acceptance criteria related to the presence and basic functionality of these components are met in both versions. However, the way the label updates when the "Click me" button is clicked differs between versions. 

In version 0.9, clicking the button increments the label value to "1" and then immediately to "MAX" on subsequent clicks. In version 1.0, the label increments from "0" to "1", then from "1" to "2", and then to "MAX" on any further clicks.
