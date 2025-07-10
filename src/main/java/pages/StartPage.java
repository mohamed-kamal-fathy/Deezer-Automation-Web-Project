package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import utils.WebActions;

public class StartPage extends BasePage {
    // Cookie consent locators
    private final By acceptCookiesBtn = By.id("gdpr-btn-accept-all");
    private final By cookieBanner = By.className("gdpr-modalContainer");
    private final By registerButton = By.id("topbar-register-button");
    private final By loginButton = By.id("topbar-login-button");


    public StartPage(WebDriver driver) {
        super(driver);
        //acceptCookies();

    }

    public void acceptCookies() {
        try {
            if (actions.isElementDisplayed(cookieBanner)) {
                actions.waitForVisibility(cookieBanner, 5);
                actions.click(acceptCookiesBtn);
                actions.waitForInvisibility(cookieBanner, 5);
                System.out.println("✅ Cookie banner accepted.");
            } else {
                System.out.println("⏭ No cookie banner displayed.");
            }
        } catch (Exception e) {
            System.out.println("⚠️ Cookie banner handling failed: " + e.getMessage());
        }
    }


    public SignUpPage navigateToSignUp() {
        actions.click(registerButton);
        return new SignUpPage(driver);
    }

    public LoginPage navigateToLoginpage() {
        actions.click(loginButton);
        return new LoginPage(driver);
    }

}