package automationExersice_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class homePage {
    private WebDriver driver;

    public homePage(WebDriver driver) {
        this.driver = driver;
    }

    String automationExerciseHomePageUrl = "http://automationexercise.com";

    // Element Locators
    private final By homepage_featuredItemsTittle = By.cssSelector("div[class=col-sm-6]>h1>span");
    private final By logInButton = By.cssSelector("ul>li:nth-child(4)>a");
    private final By loggedInUsername = By.cssSelector("li>a:last-child>b");
    private final By deleteAccountButton = By.className("fa-trash-o");
    private final By logOutButton = By.cssSelector("ul>li:nth-child(4)>a");

    //////Actions
    public void navigateToAutomationExerciseHomePageUrl() {driver.navigate().to(automationExerciseHomePageUrl);
    }

    public void checkHomePageReached() {
        Assert.assertEquals(driver.findElement(homepage_featuredItemsTittle).getText(),"Automation");
    }


    public void reachLoginPageFromHomePage() {
        driver.findElement(logInButton).click();
    }

    public void checkAccountisloggedin(String username) {
        Assert.assertEquals(driver.findElement(loggedInUsername).getText(),username);
    }

    public void deleteaccount() {
        driver.findElement(deleteAccountButton).click();
    }

    public void logOut() {
        driver.findElement(logOutButton).click();
    }
}
