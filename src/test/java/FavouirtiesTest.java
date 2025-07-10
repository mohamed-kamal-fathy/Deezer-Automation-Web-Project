import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import config.Config;
import pages.FavouirtiesPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OffersPage;
import pages.StartPage;
import utils.WebActions;

public class FavouirtiesTest extends BaseTest {

    FavouirtiesPage favouirtiesPage;
     HomePage homePage;

    private final String PLAYLIST_NAME = "The Songs" ;
    private final String PLAYLIST_DESC = "Automatically created playlist";

     private void initFavoritesPage() {
        // Login and navigate to favorites
        StartPage startPage = new StartPage(driver);
         startPage.acceptCookies();
        LoginPage loginPage = startPage.navigateToLoginpage();
        loginPage.EmailLogin(
           Config.GetProperty("validEmail"),
            Config.GetProperty("validPassword")
        );
        
         OffersPage offersPage = new OffersPage(driver);
         homePage = offersPage.clickOnAccount();
    }



    @Test   
    public void testFavoritesPageLoads() {
        initFavoritesPage();
        // Navigate to Favorites page
         homePage.clickOnFavoriteButton();
         // Verify that the Favorites page is displayed by h2

        By favoritesHeader = By.cssSelector("h2[title='Favourites']");      
        WebActions webActions = new WebActions(driver);
        webActions.waitForVisibility(favoritesHeader, 10);
        String actualHeaderText = webActions.getText(favoritesHeader);
        String expectedHeaderText = "Favourites";
        Assert.assertEquals(actualHeaderText, expectedHeaderText, "Favorites page header text does not match expected text");   

    }
   

    
   
    
}
