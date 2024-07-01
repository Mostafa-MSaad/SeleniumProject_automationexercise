package automationExersice_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class enterAccountInfo_page {
    private WebDriver driver;

    public enterAccountInfo_page(WebDriver driver) {
        this.driver = driver;
    }
    // Element Locators

    private final By eNTERACCOUNTINFORMATIONTitle = By.xpath("(//h2[@class='title text-center']//b)[1]");
    private final By titleRadioButtonMR = By.id("id_gender1");
    private final By password = By.id("password");
    private final By days = By.id("days");
    private final By months = By.id("months");
    private final By years = By.id("years");
    private final By newsletterCheck = By.id("newsletter");
    private final By specialOffersCheck = By.id("optin");

    private final By firstname = By.id("first_name");
    private final By lastname = By.id("last_name");
    private final By company = By.id("company");

    private final By address1 = By.id("address1");

    private final By address2 = By.id("address2");
    private final By state = By.id("state");

    private final By city = By.id("city");
    private final By zipcode = By.id("zipcode");
    private final By mobile_number = By.id("mobile_number");
    private final By country = By.id("country");
    private final By createAccountButton = By.cssSelector("button[data-qa=create-account]");


    /////actions
    public void checkSignupPageReached() {

        Assert.assertEquals(driver.findElement(eNTERACCOUNTINFORMATIONTitle).getText(),"ENTER ACCOUNT INFORMATION");
    }


    public void AddAccountInfo(String Password, int daysI, int monthsI, int yearsI, int countryI, String fristName,String lastName,String Company,
                               String Address1,String Address2,String State,String City,String Zipcode,String Mobilenumber) {

        driver.findElement(titleRadioButtonMR).click();
        driver.findElement(password).sendKeys(Password);


        Select mySelect1= new Select(driver.findElement(days));
        mySelect1.selectByIndex(daysI);

        Select mySelect2= new Select(driver.findElement(months));
        mySelect2.selectByIndex(monthsI);

        Select mySelect3= new Select(driver.findElement(years));
        mySelect3.selectByIndex(yearsI);

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(company));
        actions.perform();

        driver.findElement(newsletterCheck).click();
        driver.findElement(specialOffersCheck).click();

        driver.findElement(firstname).sendKeys(fristName);
        driver.findElement(lastname).sendKeys(lastName);
        driver.findElement(company).sendKeys(Company);

        driver.findElement(address1).sendKeys(Address1);
        driver.findElement(address2).sendKeys(Address2);
        driver.findElement(state).sendKeys(State);

        driver.findElement(city).sendKeys(City);
        driver.findElement(zipcode).sendKeys(Zipcode);
        driver.findElement(mobile_number).sendKeys(Mobilenumber);

        Select mySelect4= new Select(driver.findElement(country));
        mySelect4.selectByIndex(countryI);

        driver.findElement(createAccountButton).click();
    }
}
