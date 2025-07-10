package base;

import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.WebDriverManager;

@Listeners({AllureTestNg.class})
public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    @Parameters({"browser"})
    public void setUp(@Optional("") String browser) {

        if (browser.isEmpty()) {
            driver = WebDriverManager.getDriver(); // uses config
        } else {
            driver = WebDriverManager.getDriver(browser); // uses parameter
        }
    }

    @AfterMethod
    public void tearDown() {
        WebDriverManager.quitDriver();
    }
}
