package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FavouirtiesPage extends BasePage {

    // Locators
    private final By favouriteTracks = By.cssSelector("a[data-testid=loved-tab]");
    private final By favouriteArtists = By.cssSelector("a[data-testid=artists-tab]"); 
    private final By favouriteAlbums = By.cssSelector("a[data-testid=albums-tab]");
    private final By favouritePlaylists = By.cssSelector("a[data-testid=playlists-tab]");
    private final By favouritePodcasts = By.cssSelector("a[data-testid=shows-tab]");

    private final By CreatePlayList =  By.className("cCDZT"); 
    private final By PlaylistName = By.cssSelector("input[data-testid=playlist_name_field]");
    private final By playlistPublicOption = By.className("chakra-switch__track css-19b7o7u");
    private final By PlaylistDescription = By.cssSelector("textarea[data-testid=playlist_description_title]");
    private final By playlist_create_button = By.cssSelector("button[data-testid=playlist_create_button]");
  


    //constructor
     public FavouirtiesPage(WebDriver driver) {
         super(driver);
         actions.waitForUrlToContain("/profile/6564324781", 10);
     }

    //Actions
    public FavouriteTracks clickOnFavouriteTracks() {
        actions.waitForVisibility(favouriteTracks, 5);
        actions.click(favouriteTracks);
        return new FavouriteTracks(driver);
    }

    public FavouirtiesPage clickOnFavouritePlayList() {
        actions.waitForUrlToContain("/profile/6564324781/playlists", 5);
        actions.waitForVisibility(favouritePlaylists, 5);
        actions.click(favouritePlaylists);
        return this;
    }

    public FavouirtiesPage toCreatePlaylist(String playlistName , String playlistDescription) {
        actions.waitForVisibility(CreatePlayList, 5);
        actions.click(CreatePlayList);
        actions .waitForVisibility(PlaylistName, 5);
        actions.sendKeys(PlaylistName, playlistName);
        actions.click(playlistPublicOption);
        actions.sendKeys(PlaylistDescription, playlistDescription);
        actions.click(playlist_create_button);
        return this;
    }
        
}
