package automationExersice_tests;

import automationExersice_Pages.confirmation_page;
import automationExersice_Pages.enterAccountInfo_page;
import automationExersice_Pages.homePage;
import automationExersice_Pages.logInPage;
import frameWork_Engine.DriverFactory;
import frameWork_Engine.JsonFileManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestSuite {
    private static WebDriver driver;
    private homePage HomePage;
    private logInPage LogINPage;
    private enterAccountInfo_page EnterAccountInfo;
    private confirmation_page ConfirmAccount;

    JsonFileManager testData;

    @Test
    public void TestCase1RegisterUser() {

        HomePage.navigateToAutomationExerciseHomePageUrl();
        HomePage.checkHomePageReached();
        HomePage.reachLoginPageFromHomePage();
        LogINPage.checkLoginPageReached();
        LogINPage.signupFromLoginPage(testData.getTestData("test1.name"), testData.getTestData("test1.email"));
        EnterAccountInfo.checkSignupPageReached();
        EnterAccountInfo.AddAccountInfo(testData.getTestData("test1.password"), Integer.parseInt(testData.getTestData("test1.days")),
                Integer.parseInt(testData.getTestData("test1.months")), Integer.parseInt(testData.getTestData("test1.years")),
                Integer.parseInt(testData.getTestData("test1.countryindex")),
                testData.getTestData("test1.fristname"), testData.getTestData("test1.lastname"),
                testData.getTestData("test1.company"), testData.getTestData("test1.address1"),
                testData.getTestData("test1.address2"), testData.getTestData("test1.state"),
                testData.getTestData("test1.city"), testData.getTestData("test1.zipcode"),
                testData.getTestData("test1.mobile")
             );

        ConfirmAccount.checkAccountCreated();
        HomePage.checkAccountisloggedin(testData.getTestData("test1.fristname"));
        HomePage.deleteaccount();
        ConfirmAccount.checkAccountisdeleted();
    }


    @Test
    public void TestCase2LoginUserWithCorrectEmailAndPassword() {

        HomePage.navigateToAutomationExerciseHomePageUrl();
        HomePage.checkHomePageReached();
        HomePage.reachLoginPageFromHomePage();
        LogINPage.checkLoginPageReached();
        LogINPage.signupFromLoginPage(testData.getTestData("test1.name"), testData.getTestData("test1.email"));
        EnterAccountInfo.checkSignupPageReached();
        EnterAccountInfo.AddAccountInfo(testData.getTestData("test1.password"), Integer.parseInt(testData.getTestData("test1.days")),
                Integer.parseInt(testData.getTestData("test1.months")), Integer.parseInt(testData.getTestData("test1.years")),
                Integer.parseInt(testData.getTestData("test1.countryindex")),
                testData.getTestData("test1.fristname"), testData.getTestData("test1.lastname"),
                testData.getTestData("test1.company"), testData.getTestData("test1.address1"),
                testData.getTestData("test1.address2"), testData.getTestData("test1.state"),
                testData.getTestData("test1.city"), testData.getTestData("test1.zipcode"),
                testData.getTestData("test1.mobile")
        );

        ConfirmAccount.checkAccountCreated();
        HomePage.checkAccountisloggedin(testData.getTestData("test1.fristname"));

        HomePage.logOut();
        LogINPage.LogInWithUser(testData.getTestData("test1.email"), testData.getTestData("test1.password"));

        HomePage.checkAccountisloggedin(testData.getTestData("test1.fristname"));
        HomePage.deleteaccount();
        ConfirmAccount.checkAccountisdeleted();

    }


    /////////////////////////// Configurations

    @BeforeMethod
    public void beforeMethod() {

        driver = DriverFactory.initDriver();
        HomePage = new homePage(driver);
        LogINPage = new logInPage(driver);
        EnterAccountInfo = new enterAccountInfo_page(driver);
        ConfirmAccount = new confirmation_page(driver);

    }


    @AfterMethod
    public void afterMethod() {

        driver.quit();
    }

    @BeforeClass
    public void beforeClass() {
        frameWork_Engine.PropertiesReader.loadProperties();
        testData = new JsonFileManager("src/test/resources/TestData.json");
    }


}
