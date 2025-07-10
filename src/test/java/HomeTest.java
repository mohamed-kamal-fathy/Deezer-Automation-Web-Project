import base.BaseHomeTest;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import config.Config;
import pages.HomePage;
import pages.LoginPage;
import pages.OffersPage;
import pages.SearchResultPage;
import pages.StartPage;
import utils.WebActions;

public class HomeTest extends BaseHomeTest {

    HomePage homePage;
    private final WebActions actions = new WebActions(driver);

    @BeforeClass
    private void initializeHomePage() {
        driver.navigate().to(Config.GetProperty("baseUrl"));

        // Fix: initialize actions manually
        WebActions actions = new WebActions(driver);
        actions.waitForPageLoad();

        // Navigate to Home Page
        StartPage startPage = new StartPage(driver);
        startPage.acceptCookies();
        LoginPage loginPage = startPage.navigateToLoginpage();

        String valid_email = Config.GetProperty("validEmail");
        String valid_password = Config.GetProperty("validPassword");
        loginPage.EmailLogin(valid_email, valid_password);

        OffersPage offersPage = new OffersPage(driver);
        homePage = offersPage.clickOnAccount();
        actions.waitForPageLoad();

        System.out.println("🏠 Ready on Home Page");
    }




    @Test(priority =  1)
    public void testNavigation_Home_Button() {
       // initializeHomePage();
        homePage.clickOnHomeButton();
        System.out.println(" Current URL: " + driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("/us/"),
                "Should be on home page after clicking home button");

    }

    @Test(priority =  4)
    public void testNavigation_Explore_Button() {
        //initializeHomePage();
        homePage.clickOnExploreButton();
        System.out.println(" Current URL: " + driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("/explore/explore-tab"),
                "Should be on explore page after clicking explore button");
    }

    @Test(priority =  3)
    public void testNavigation_Favorite_Button() {
        //initializeHomePage();
        homePage.clickOnHomeButton().clickOnFavoriteButton();
        //homePage.clickOnFavoriteButton();
        System.out.println(" Current URL: " + driver.getCurrentUrl());
        Assert.assertTrue(homePage.isfavoritiesVeiwDisplayed(),
                "Should be on favorite page after clicking favorite button");

    }

    @Test(priority =  8)
    public void testCreatePlaylistButton() {
        //initializeHomePage();
        System.out.println(" Current URL: " + driver.getCurrentUrl());
        Assert.assertTrue(homePage.clickOnCreatePlayListButton().isCreatePlaylistButtonDisplayed(),
                "Create Playlist button should be displayed after clicking on create playlist button");
    }

    @Test(priority =  5)
    public void testSearchTracks_ByArtist() {
       // initializeHomePage();
        String Artist = "Michael Jackson";
        SearchResultPage searchResult = homePage.SearchTracks(Artist).clickOnSearchResult();
        System.out.println(" Current URL: " + driver.getCurrentUrl());
        Assert.assertTrue(searchResult.areSearchResultsDisplayed(),
                "Search results should be displayed after searching for tracks");
    }

    @Test(priority =  6)
    public void testSearchTracks_ByTrack() {
       // initializeHomePage();
        String Track = "Billie Jean";
        SearchResultPage searchResult = homePage.SearchTracks(Track).clickOnSearchResult();
        System.out.println(" Current URL: " + driver.getCurrentUrl());
        Assert.assertTrue(searchResult.areSearchResultsDisplayed(),
                "Search results should be displayed after searching for tracks");
    }

    @Test(priority =  7)
    public void testMusicPlayControl() {
        //initializeHomePage();
        homePage.clickOnHomeButton().playTrack();
        System.out.println(" Current URL: " + driver.getCurrentUrl());
        Assert.assertTrue(homePage.isTrackPlaying(), "Track should be playing after clicking play button");

    }

    @Test(priority =  2)
    public void testMusicPlayAndPause() {
        //initializeHomePage();
        homePage.clickOnHomeButton().playTrack();
        System.out.println(" Current URL: " + driver.getCurrentUrl());
        //Assert.assertTrue(homePage.isTrackPlaying(),
          //      "Track should be playing after clicking play");

        homePage.pauseTrack();
        System.out.println(" Current URL: " + driver.getCurrentUrl());
        Assert.assertTrue(homePage.isTrackPaused(),
                "Track should be paused after clicking pause");
    }



}
