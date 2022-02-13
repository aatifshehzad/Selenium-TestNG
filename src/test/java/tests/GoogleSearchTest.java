package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.GoogleSearchPageObjects;
import utilities.Browser;

import static utilities.extentReports.ExtentTestManager.startTest;

public class GoogleSearchTest extends Browser{

    WebDriver driver;
    GoogleSearchPageObjects googleSearchPage_obj;

    @BeforeMethod
    public void setUp() {
        driver = getDriver();
        googleSearchPage_obj = new GoogleSearchPageObjects(driver);
    }

    @Test(description = "Google Search testing.")
    public void test_googleSearch() {
        startTest(new Object(){}.getClass().getEnclosingMethod().getName(), "Google Search testing.");
        googleSearchPage_obj.setSearchText("POM with TestNG");
        googleSearchPage_obj.waitForElement();
        googleSearchPage_obj.clickSearchButton();
    }
}
