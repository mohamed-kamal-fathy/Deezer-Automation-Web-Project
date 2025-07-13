# Deezer Automation Testing Project
**This is an end-to-end automation test framework for the Real World **Deezer web application**, implemented using **Java**, **Selenium WebDriver**, **TestNG**, and **Allure Reporting**. The project follows the **Page Object Model (POM)** design pattern and includes logging, screenshots, and test configuration via properties files.**  

 ## 🚀 Technologies Used
 
- **Selenium WebDriver**
- **TestNG**
- **Maven**
- **Allure Reports**
- **Log4j**
- **Apache POI** (for Excel/JSON handling)


## 📁 Project Structure

```
DeezerProject/
├── .idea/                  # IntelliJ IDEA configuration files
├── .vscode/                # VS Code configuration files
├── allure-results/         # Allure test reports
│   └── Logs/               # Test execution logs
├── src/
│   └── main/
│       └── java/
│           ├── config/     # Configuration files
│           │   └── Config.java
│           ├── pages/      # Page object classes
│           │   ├── BasePage.java
│           │   ├── FavouritesPage.java
│           │   ├── FavouriteTracks.java
│           │   ├── HomePage.java
│           │   ├── LoginPage.java
│           │   ├── OffersPage.java
│           │   ├── SearchResultPage.java
│           │   ├── SignUpPage.java
│           │   └── StartPage.java
│           └── utils/      # Utility classes
│               ├── Log.java
│               ├── ScreenshotUtils.java
│               ├── WebActions.java
│               └── WebDriverManager.java
├── resources/              # Resource files
│   ├── allure-config.yml   # Allure configuration
│   ├── config.properties   # Application configuration
│   └── log4j2.properties   # Logging configuration
├── test/
│   └── java/
│       ├── base/           # Base test classes
│       │   ├── BaseHomeTest.java
│       │   └── BaseTest.java
│       ├── FavouirtiesTest.java
│       ├── HomeTest.java
│       ├── LoginTest.java
│       ├── OffersTest.java
│       └── SignUpTest.java
├── target/                 # Build output directory
├── .gitignore              # Git ignore rules
├── pom.xml                 # Maven configuration
└── testing.xml             # Test suite configuration
```

## ✅ Features

- Selenium WebDriver for browser automation
- TestNG for test execution
- Allure for beautiful test reports
- Page Object Model (POM) design pattern
- Utilities for logging, screenshots, and browser management


## ⚠️ Challenges Faced

| **Challenge**                        | **Cause**                            | **Solution**                                                                                                                                                  
|--------------------------------------|--------------------------------------|------------------------------------------------------------------------|
| **Authentication Challenges**        | CAPTCHA enforced after login         | Reuse session cookies, avoid repeated logins, or do manual login and inject cookies     
| **Dynamic and Changing UI**          | Frequent UI updates                  | Use stable locators (e.g., `data-*`, visible text), and apply Page Object Model (POM)   
| **Performance & Loading Delays**     | Lazy-loaded content                  | Use Explicit Waits + scroll with JavaScript to ensure full content loads before testing  
| **Test Data Management**             | Shared test account                  | Use separate accounts or reset state before each test using UI/API                      
| **Maintaining Test Independence**    | Test dependencies                    | Design isolated tests with proper setup and teardown methods                            
| **Flaky Tests**                      | Timing & async behavior              | Apply smart waits (WebDriverWait), use retry logic, and run in stable environments      


## Prerequisites
- Java JDK 8 or higher
- Maven 3.6.0 or higher
- Chrome/Firefox browser (depending on your WebDriver configuration)


## 📦 Usage

```bash
mvn clean test
allure serve allure-results
