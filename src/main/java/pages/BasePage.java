package pages;

import config.Config;
import org.openqa.selenium.WebDriver;
import utils.WebActions;


public class BasePage {
    protected WebDriver driver;
    protected WebActions actions;
   

    // Constructor to initialize the WebDriver and WebActions
    // This constructor can be used by all page classes that extend BasePage
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.actions = new WebActions(driver);

    }

    public void beforeSuite(){

    }

    public  void navigateTo(String path){
        driver.get(Config.getBaseUrl()+path);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
    
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void refreshPage() {
        driver.navigate().refresh();
        actions.waitForPageLoad();
    }

    
}
