
import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.StartPage;
import config.Config;



public class LoginTest extends BaseTest {
   
    
    @Test
    public void testSuccessfulLogin() {

        StartPage startPage = new StartPage(driver);
        startPage.acceptCookies();
        LoginPage loginPage = startPage.navigateToLoginpage();

        String  valid_email = Config.GetProperty("validEmail");
        String valid_password = Config.GetProperty("validPassword");
        
        loginPage .EmailLogin(valid_email, valid_password);
        System.out.println(" Current URL: " + driver.getCurrentUrl());
        // Verify successful login by specific element on the Offers page
        Assert.assertTrue(driver.getCurrentUrl().contains("/en/offers"), "Login was not successful, URL does not contain 'offers'");
        

    }
    @Test
    public void testInvalidLogin() {   
        StartPage startPage = new StartPage(driver);
        startPage.acceptCookies();
        LoginPage loginPage = startPage.navigateToLoginpage();
        
        String invalid_email = Config.GetProperty("InvalidEmail");
        String invalid_password = Config.GetProperty("InvalidPassword");

        loginPage.EmailLoginExpectingFailure(invalid_email,invalid_password);
        System.out.println(" Current URL: " + driver.getCurrentUrl());
        // Verify that the login was unsuccessful by checking an url
        Assert.assertTrue(driver.getCurrentUrl().contains("/login/"), "Login was successful with invalid credentials, URL should contain 'login'");

    
       
    }

    @Test
    public void testLoginWithEmptyFields() {
        StartPage startPage = new StartPage(driver);
        startPage.acceptCookies();
        LoginPage loginPage = startPage.navigateToLoginpage();

        //  login with empty fields
        loginPage.EmailLoginExpectingFailure("","");
        System.out.println(" Current URL: " + driver.getCurrentUrl());
        // Verify that the login was unsuccessful by checking an error message 
        By errorMessage = By.cssSelector("div[data-testid='email-error']");
        String ActualErrorMessage = driver.findElement(errorMessage).getText();
        String ExpectedErrorMessage = "Field must not be empty.";
        Assert.assertEquals(ActualErrorMessage, ExpectedErrorMessage, "Error message does not match expected text");

        System.out.println(" Current URL: " + driver.getCurrentUrl());
        
    }



}
