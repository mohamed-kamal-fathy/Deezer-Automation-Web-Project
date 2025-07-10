package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage {
    //Locators
    private final By chooseEmailToLogin = By.cssSelector("[data-testid='btn-switch-to-email']");
    private final By EmailField = By.cssSelector("[data-testid='email-field']");
    private final By PasswordField = By.cssSelector("[data-testid='password-field']");
    private final By LoginButton = By.cssSelector("[data-testid='login-button']");

    //Constructor 

    public LoginPage(WebDriver driver) {
        super(driver);
        actions.waitForUrlToContain("login/", 5);
    }

    //Actions
    public OffersPage EmailLogin(String email, String password) {


        driver.navigate().refresh(); // Refresh the page to ensure the login form is loaded
        actions.click(chooseEmailToLogin);
        actions.sendKeys(EmailField, email);
        actions.sendKeys(PasswordField, password);
        actions.click(LoginButton);
       
        // Wait for the user to solve the CAPTCHA manually
        actions.waitForPageLoad();
        return new OffersPage(driver);

    }
    public void EmailLoginExpectingFailure(String email, String password) {
        driver.navigate().refresh();
        actions.click(chooseEmailToLogin);
        actions.sendKeys(EmailField, email);
        actions.sendKeys(PasswordField, password);
        actions.click(LoginButton);
        actions.waitForPageLoad();

    }


}

