# Deezer-Automation-Web-Project
**Deezer Web Automation**  
 ✅ Java + Selenium + TestNG framework  
 📊 Tests login, signup, favorites &amp; offers  
 🚀 POM design with Allure reporting   
⚡ Maven project ready for CI/CD  
 🔧 Utilities: Screenshots, logging, WebActions

# 🎧 Deezer Automation Testing Project

This is an end-to-end automation test framework for the **Deezer web application**, implemented using **Java**, **Selenium WebDriver**, **TestNG**, and **Allure Reporting**. The project follows the **Page Object Model (POM)** design pattern and includes logging, screenshots, and test configuration via properties files.

---

## 📁 Project Structure

DeezerProject/
├── .idea/ # IntelliJ IDEA configuration files
├── .vscode/ # VS Code configuration files
├── allure-results/ # Allure test reports
│ └── Logs/ # Test execution logs
├── src/
│ └── main/
│ └── java/
│ ├── config/ # Configuration files
│ │ └── Config.java
│ ├── pages/ # Page object classes
│ │ ├── BasePage.java
│ │ ├── FavouritesPage.java
│ │ ├── FavouriteTracks.java
│ │ ├── HomePage.java
│ │ ├── LoginPage.java
│ │ ├── OffersPage.java
│ │ ├── SearchResultPage.java
│ │ ├── SignUpPage.java
│ │ └── StartPage.java
│ └── utils/ # Utility classes
│ ├── Log.java
│ ├── ScreenshotUtils.java
│ ├── WebActions.java
│ └── WebDriverManager.java
├── resources/ # Resource files
│ ├── allure-config.yml # Allure configuration
│ ├── config.properties # Application configuration
│ └── log4j2.properties # Logging configuration
├── test/ # Test classes
│ └── java/
│ ├── base/ # Base test classes
│ │ ├── BaseHomeTest.java
│ │ └── BaseTest.java
│ ├── FavouirtiesTest.java
│ ├── HomeTest.java
│ ├── LoginTest.java
│ ├── OffersTest.java
│ └── SignUpTest.java
├── target/ # Build output directory
├── .gitignore # Git ignore rules
├── pom.xml # Maven configuration
└── testing.xml # Test suite configuration


## Prerequisites
- Java JDK 8 or higher
- Maven 3.6.0 or higher
- Chrome/Firefox browser (depending on your WebDriver configuration)

## Setup Instructions

1. Clone the repository:
   ```bash
   git clone [repository-url]

