
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import config.Config;
import pages.LoginPage;
import pages.OffersPage;
import pages.StartPage;

public class OffersTest extends BaseTest {
    @Test
    public void testOffersPageLoads(){


        StartPage startPage = new StartPage(driver);
        startPage.acceptCookies();
        LoginPage loginPage = startPage.navigateToLoginpage();

        String  valid_email = Config.GetProperty("validEmail");
        String valid_password = Config.GetProperty("validPassword");

        loginPage.EmailLogin(valid_email, valid_password);

        OffersPage offersPage = new OffersPage(driver);
        offersPage.clickOnAccount();
        // Verify that the Offers page is loaded by checking URL
        String ActualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.deezer.com/account/";   
        Assert.assertTrue(ActualUrl.contains(expectedUrl), "Offers page did not load successfully, current URL: " + ActualUrl);
        
        
       
        
    }
}
