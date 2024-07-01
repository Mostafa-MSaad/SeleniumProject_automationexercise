package automationExersice_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class confirmation_page {
    private WebDriver driver;

    public confirmation_page(WebDriver driver) {
        this.driver = driver;
    }

    // Element Locators
    //accountCreatedMessage, checkAccountisloggedin, checkAccountisdeleted
    private final By confirmationMessage = By.xpath("//h2[@class='title text-center']//b");
    private final By continueButton = By.className("btn-primary");

    ///Validations


    public void checkAccountCreated() {
        Assert.assertEquals(driver.findElement(confirmationMessage).getText(),"ACCOUNT CREATED!");
        driver.findElement(continueButton).click();
    }
    public void checkAccountisdeleted() {
        Assert.assertEquals(driver.findElement(confirmationMessage).getText(),"ACCOUNT DELETED!");
        driver.findElement(continueButton).click();
    }
}
