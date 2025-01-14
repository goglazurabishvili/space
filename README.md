# space

API Automation Project: User Management API
Project Overview
This project automates the testing of the User Management API using Cucumber, TestNG, and RestAssured. It includes functionalities to create, get, update, and delete users, and validates the API responses based on the defined test scenarios.

Prerequisites
Before running the tests, ensure that the following tools are installed:



Java 8 or higher
Maven (for dependency management and building the project)
TestNG (for running tests)
Cucumber (for behavior-driven development (BDD) style testing)
RestAssured (for making API requests)
IDE (e.g., IntelliJ IDEA or Eclipse)


Clone the repository to your local machine:

https://github.com/goglazurabishvili/space


Option 1: Running through TestNG XML
Open the project in your IDE (IntelliJ IDEA or Eclipse).
Make sure your IDE is set up to run TestNG tests.
Locate the TestNG.xml file in the root directory of the project.
Right-click on the TestNG.xml file and select Run.

Option 2: Running Directly from Cucumber Feature File
Open the user_management.feature file located in src/test/java/features/UserManagement.feature.
Right-click on the feature file and choose Run (if your IDE supports running Cucumber feature files directly).


Test Scenarios
Feature File: src/test/java/features/user_management.feature
This feature file includes the following scenarios:

Create a new user
Get an existing user
Update an existing user
Delete an existing user
Create a user with missing fields
Get a non-existent user
Update a user with invalid data
Delete a non-existent user
Each scenario defines behavior using the Gherkin syntax. 
The step definitions are implemented in the UserStepDefinitions.java file.




Quora Mobile App Automation Project

Overview

This project automates key UI test scenarios for the Quora mobile application using Java, 
Appium, TestNG, and Selenium. It includes login/logout, search functionality, bookmarking posts,
and verification of post authors.

Setup Instructions

Prerequisites
Ensure you have the following installed:
Java Development Kit (JDK)
Maven
Appium Server
Android Emulator or a Physical Android Device
IntelliJ IDEA (or any preferred IDE)
TestNG Plugin

Run the tests using the TestNG XML file (testng.xml) or directly from the QuoraUITests class in IntelliJ IDEA.

Appium Capabilities

The SetupAppium class sets the following capabilities for the Android driver:

platformName: Android

automationName: UIAutomator2

deviceName: Poco (or any connected device)

app: Path to the Quora APK

noReset: false (ensures a fresh start for each test run)

uiautomator2ServerInstallTimeout: 60 seconds


FOR APPIUM INSPECTOR USE :


{
  "platformName": "Android",
  "appium:automationName": "UIAutomator2",
  "appium:deviceName": "Poco",
  "appium:app": "C:.........\\quora.apk",
  "appium:autoGrantPermissions": true,
  "appium:noReset": true,
  "appium:disableIdLocatorAutocompletion": false,
  "appium:uiautomator2ServerInstallTimeout": 60000,
  "appium:adbExecTimeout": 60000,
  "appium:newCommandTimeout": 300
}

https://github.com/goglazurabishvili/space