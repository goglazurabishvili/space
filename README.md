## Project Overview

This repository contains two automation projects:

1. **User Management API Automation**
2. **Quora Mobile App UI Automation**

Both projects are designed to streamline the testing process, ensuring robust and reliable software through automated scenarios. Below are detailed instructions and information about each project.

---

## 1. User Management API Automation Project

This project automates the testing of the **User Management API** using **Cucumber**, **TestNG**, and **RestAssured**. It covers various API functionalities, including creating, retrieving, updating, and deleting users, while validating API responses based on defined test scenarios.

### Prerequisites
Ensure the following tools are installed before running the tests:

- **Java 8** or higher
- **Maven** (for dependency management and building the project)
- **TestNG** (for running tests)
- **Cucumber** (for behavior-driven development (BDD) style testing)
- **RestAssured** (for making API requests)
- **IDE** (e.g., IntelliJ IDEA or Eclipse)

### Setup Instructions

#### Clone the Repository
```bash
https://github.com/goglazurabishvili/space
```

### Running the Tests

#### Option 1: Running through TestNG XML
1. Open the project in your IDE (IntelliJ IDEA or Eclipse).
2. Ensure your IDE is configured to run TestNG tests.
3. Locate the `TestNG.xml` file in the root directory.
4. Right-click on the `TestNG.xml` file and select **Run**.

#### Option 2: Running Directly from Cucumber Feature File
1. Open the `user_management.feature` file located in `src/test/java/features/UserManagement.feature`.
2. Right-click on the feature file and choose **Run** (if your IDE supports running Cucumber feature files directly).

### Test Scenarios

The feature file (`src/test/java/features/user_management.feature`) includes the following scenarios:

1. **Create a new user**
2. **Get an existing user**
3. **Update an existing user**
4. **Delete an existing user**
5. **Create a user with missing fields**
6. **Get a non-existent user**
7. **Update a user with invalid data**
8. **Delete a non-existent user**

Each scenario is defined using the **Gherkin** syntax and implemented in `UserStepDefinitions.java`.

---

## 2. Quora Mobile App UI Automation Project

This project automates key UI test scenarios for the **Quora mobile application** using **Java**, **Appium**, **TestNG**, and **Selenium**. It includes functionalities such as login/logout, searching for posts, bookmarking posts, and verifying post authors.

### Prerequisites
Ensure the following tools are installed:

- **Java Development Kit (JDK)**
- **Maven** (for dependency management)
- **Appium Server**
- **Android Emulator** or a physical Android device
- **IntelliJ IDEA** (or any preferred IDE)
- **TestNG Plugin**

### Setup Instructions

#### Clone the Repository
```bash
https://github.com/goglazurabishvili/space
```

### Running the Tests

You can run the tests using the `TestNG.xml` file or directly from the `QuoraUITests` class in IntelliJ IDEA.

#### Option 1: Running through TestNG XML
1. Open the project in your IDE.
2. Locate the `testng.xml` file in the root directory.
3. Right-click on the `testng.xml` file and select **Run**.

#### Option 2: Running Directly from the QuoraUITests Class
1. Open the `QuoraUITests` class in your IDE.
2. Right-click on the class and choose **Run**.

### Appium Capabilities

The `SetupAppium` class sets up the following capabilities for the Android driver:

```json
{
  "platformName": "Android",
  "appium:automationName": "UIAutomator2",
  "appium:deviceName": "Poco",
  "appium:app": "C:\\.........\\quora.apk",
  "appium:autoGrantPermissions": true,
  "appium:noReset": true,
  "appium:disableIdLocatorAutocompletion": false,
  "appium:uiautomator2ServerInstallTimeout": 60000,
  "appium:adbExecTimeout": 60000,
  "appium:newCommandTimeout": 300
}
```

### Appium Inspector Configuration

For Appium Inspector, use the following configuration:

- **platformName**: Android
- **automationName**: UIAutomator2
- **deviceName**: Poco (or any connected device)
- **app**: Path to the Quora APK
- **autoGrantPermissions**: true
- **noReset**: true
- **disableIdLocatorAutocompletion**: false
- **uiautomator2ServerInstallTimeout**: 60 seconds
- **adbExecTimeout**: 60 seconds
- **newCommandTimeout**: 300 seconds

---

## Repository Link
[GitHub Repository: Quiqstar Project](https://github.com/goglazurabishvili/space)

Feel free to clone the repository and contribute!

