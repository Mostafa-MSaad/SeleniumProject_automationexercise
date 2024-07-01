package automationExersice_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class logInPage {
    private WebDriver driver;

    public logInPage(WebDriver driver) {
        this.driver = driver;
    }

    // Element Locators
    private final By newUserSignupFormTittle = By.cssSelector("div[class=signup-form]>h2");
    private final By newUserSignupName = By.cssSelector("input[name=name]");
    private final By newUserSignupEmail = By.cssSelector("input[data-qa=signup-email]");
    private final By newUserSignupButton = By.cssSelector("button[data-qa=signup-button]");
    private final By logInEmail = By.cssSelector("input[data-qa=login-email]");
    private final By logInPassword = By.cssSelector("input[data-qa=login-password]");
    private final By userLogInButton = By.cssSelector("button[data-qa=login-button]");
    //////actions
    public void checkLoginPageReached() {

        Assert.assertEquals(driver.findElement(newUserSignupFormTittle).getText(),"New User Signup!");
    }


    public void signupFromLoginPage(String name,String Email) {
        driver.findElement(newUserSignupName).sendKeys(name);
        driver.findElement(newUserSignupEmail).sendKeys(Email);
        driver.findElement(newUserSignupButton).click();
    }
    public void LogInWithUser(String Email, String Password) {
        driver.findElement(logInEmail).sendKeys(Email);
        driver.findElement(logInPassword).sendKeys(Password);
        driver.findElement(userLogInButton).click();
    }
}
