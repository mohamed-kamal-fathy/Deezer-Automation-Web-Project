
import base.BaseTest;
import org.testng.annotations.Test;

import config.Config;
import pages.SignUpPage;
import pages.StartPage;


public class SignUpTest extends BaseTest {
    @Test
    public void testSignupSuccessfull() throws InterruptedException {
        
        StartPage startPage = new StartPage(driver);
        startPage.acceptCookies();
        SignUpPage signUpPage = startPage.navigateToSignUp();

         String  valid_email = Config.GetProperty("validEmail");
         String  valid_password = Config.GetProperty("validPassword");
         String  age = Config.GetProperty("age"); 
         String  identity = Config.GetProperty("identity"); 

        signUpPage.enterEmail(valid_email);
        signUpPage.submitEmail();

        signUpPage.enterPassword(valid_password);
        signUpPage.submitPassword();

        if (driver.getCurrentUrl().contains("en/signup/?step=1")) {
            System.out.println("Redirected to Offers page after CAPTCHA, skipping personal info step.");
            return;
        }
        signUpPage.enterAge(Integer.parseInt(age));
        signUpPage.chooseidentity(identity);
        signUpPage.submitInfo();

    }
}
