package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.WebDriverManager;

public class BaseHomeTest {

    protected WebDriver driver;

    @BeforeClass
    public void setUp() {

        driver = WebDriverManager.getDriver();
    }

    @AfterClass
    public void tearDown() {
        WebDriverManager.quitDriver();
    }
}
