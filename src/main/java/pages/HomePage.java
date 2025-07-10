package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    // Locators
    private final By HomeButton = By.cssSelector("div[role='group'] a:nth-child(1)");
    private final By ExploreButton = By.cssSelector("[data-testid='CompassOutlinedIcon']");
    private final By FavoriteButton = By.cssSelector("[class='css-1qay7vc'] a:nth-child(3)");
    private final By CreatePlayListButton = By.cssSelector("[aria-label='Create a playlist']");
    private final By SearchONSongs = By.cssSelector("input[data-testid='search_field']");
    private final By SearchResult = By.cssSelector("div[class='css-euuyyz'] h2[class='chakra-heading css-uae1qr']");

    private final By StartSadSong = By.cssSelector("div[class='css-z18i2b'] button[aria-label='Play'] ");
    private final By PauseSadSong = By.cssSelector("div[class='css-inv7vp'] button[aria-label='Pause']");

    private final By favoritiesVeiw = By.cssSelector("h2[title='Favourites']");
    private final By PlayListVeiw = By.cssSelector("[data-testid='modal_header']");

    
    // Constructor
    public HomePage(WebDriver driver) {
        super(driver);
        actions.waitForUrlToContain("/account/", 10);

    }

    // Actions
    public HomePage clickOnHomeButton() {
        actions.waitForClickable(HomeButton,20);
        actions.click(HomeButton);
        return this;
    }

    public HomePage clickOnExploreButton() {
        actions.waitForVisibility(ExploreButton, 20);
        actions.click(ExploreButton);
        return this;
    }

    public HomePage clickOnFavoriteButton() {
        actions.waitForVisibility(FavoriteButton, 5);
        actions.click(FavoriteButton);
        return this;
    }

    public HomePage clickOnCreatePlayListButton() {
        actions.waitForVisibility(CreatePlayListButton, 20);
        actions.click(CreatePlayListButton);

        return this;
    }

    public HomePage SearchTracks(String trackName) {
        actions.waitForVisibility(SearchONSongs, 20);
        actions.sendKeys(SearchONSongs, trackName);
        return this;
    }

    public SearchResultPage clickOnSearchResult() {
        actions.waitForVisibility(SearchResult, 20);
        actions.click(SearchResult);
        return new SearchResultPage(driver);
    }

    public boolean isfavoritiesVeiwDisplayed() {
        return actions.isElementDisplayed(favoritiesVeiw);
    }

    public boolean isCreatePlaylistButtonDisplayed() {
        return actions.isElementDisplayed(PlayListVeiw);
    }

    public HomePage playTrack() {
        actions.waitForClickable(StartSadSong,20);
        actions.click(StartSadSong);
        return this;
    }

    public HomePage pauseTrack() {
        actions.waitForClickable(PauseSadSong,20);
        actions.click(PauseSadSong);
        return this;

}
    public boolean isTrackPlaying() {
        return actions.isElementDisplayed(PauseSadSong);
    }
    public boolean isTrackPaused() {
        return actions.isElementDisplayed(StartSadSong);    

    }
}
