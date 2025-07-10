package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends BasePage {

    // Locators
    private final By MixButton = By.cssSelector("button[aria-label='Mix']");
    private final By favoriteIconArtist = By.cssSelector("button[aria-label='Add'] ");
    private final By favoriteIconTrack = By.cssSelector(" button[aria-label='Add to Favourite tracks'] ");

    // constructor
    public SearchResultPage(WebDriver driver) {
        super(driver);

    }

    // Actions
    public SearchResultPage clickOnMixButton_toStart() {
        actions.waitForVisibility(MixButton, 5);
        actions.click(MixButton);
        return this;
    }

    public SearchResultPage clickOnMixButton_toEnd() {
        actions.waitForVisibility(MixButton, 5);
        actions.click(MixButton);
        return this;
    }

    public SearchResultPage clickOnFavoriteIcon() {
        actions.waitForVisibility(favoriteIconArtist, 5);
        actions.click(favoriteIconArtist);
        return this ;
    }

    public FavouirtiesPage clickOnFavoriteIconTrack() {
        actions.waitForVisibility(favoriteIconTrack, 5);
        actions.click(favoriteIconTrack);
        return new  FavouirtiesPage(driver);
    }

    public boolean areSearchResultsDisplayed(){
        return actions.isElementDisplayed(By.cssSelector("div[class='css-euuyyz'] h2[class='chakra-heading css-uae1qr']"));
    }
    
        
}
