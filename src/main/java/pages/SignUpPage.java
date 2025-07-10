package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage  extends  BasePage{

    // Step 0 Elements (Email)
    private final By emailFieldInput = By.cssSelector("input[name='email']");;
    private final By continueButton0 = By.cssSelector("button[type='submit']");

    // Step 1 Elements (Password)
    private final By passwordInput = By.cssSelector("input[name='password']");;
    private final By continueButton1 = By.cssSelector("button[type='submit']");

    // Step 2 Elements (personal information)
    private final By AgeField = By.cssSelector("input[name='age']");
    private final By Identity = By.cssSelector("select[name='identity']");
    private final By continueButton2 = By.cssSelector("button[type='submit']");


    public SignUpPage(WebDriver driver) {
        super(driver);
        actions.waitForUrlToContain("/signup/?step=0", 10);
    }

    // Step 0: Email Submission
    public void enterEmail(String email) {
        actions.sendKeys( emailFieldInput, email);
    }

    public void submitEmail() {
        actions.click(continueButton0);
    }

    // Step 1: Password Submission
    public void enterPassword(String password) {
        // Wait for step 1 to load
        actions.waitForUrlToContain("step=1", 5);
        actions.sendKeys(passwordInput,password);
    }

    public void submitPassword() {
        actions.click(continueButton1);
    }

    // Step 2: add personal information
    public void enterAge(int age){
        actions.sendKeys(AgeField, String.valueOf(age));
    }

    public void chooseidentity(String identity){
        actions.selectDropdown(Identity, identity);
    }

    public LoginPage submitInfo(){
        actions.click(continueButton2);
        return new LoginPage(driver);
    }



}
