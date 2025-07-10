package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage extends BasePage {

    // Locators
    private final By accountButton = By.id("open-account");
    private final By logOutButton = By.cssSelector("#logout-btn");

    public OffersPage(WebDriver driver) {
        super(driver);
        actions.waitForVisibility(accountButton, 50); // Explicit wait added
        System.out.println("✅ Offers Page loaded successfully.");
    }

    public HomePage clickOnAccount() {
        actions.click(accountButton);
        actions.waitForPageLoad();
        System.out.println("➡️ Clicked on Account button, navigating to HomePage...");
        return new HomePage(driver);
    }

    public OffersPage logOut() {
        actions.click(logOutButton);
        return new OffersPage(driver);
    }
}
