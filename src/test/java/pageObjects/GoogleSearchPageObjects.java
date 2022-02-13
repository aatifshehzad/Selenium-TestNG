package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleSearchPageObjects {

    WebDriver driver;

    By textBox_Search = By.name("q");
    By button_Search = By.name("btnK");

    public GoogleSearchPageObjects(WebDriver _driver){
        this.driver = _driver;
    }

    public void waitForElement(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(button_Search));
    }
    public void setSearchText(String searchText){
        driver.findElement(textBox_Search).sendKeys(searchText);
    }

    public void clickSearchButton(){
        driver.findElement(button_Search).sendKeys(Keys.RETURN);
    }
}
