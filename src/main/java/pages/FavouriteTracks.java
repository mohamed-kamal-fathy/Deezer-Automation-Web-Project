package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FavouriteTracks extends BasePage {

    // Locators
    private final By playOrStopTrack = By.cssSelector("svg[data-testid=PlayFilledIcon]");

    //constructor
    public FavouriteTracks(WebDriver driver) {
        super(driver);
        actions.waitForUrlToContain("/profile/6564324781/loved", 10);
    }

    //Actions
    public FavouriteTracks clickOnPlayOrStopTrack() {
        actions.waitForVisibility(playOrStopTrack, 5);     
        actions.click(playOrStopTrack);
        return this;
    }

}
