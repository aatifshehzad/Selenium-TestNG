package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class Browser {
    protected static WebDriver driver;
    ConfigFileReader configFileReader= new ConfigFileReader();

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void StartBrowser()
    {
        String browsername = configFileReader.getBrowser();
        String url = configFileReader.getApplicationUrl();

        // If the browser is Firefox
        if(browsername.equalsIgnoreCase("Firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        // If the browser is Chrome
        else if(browsername.equalsIgnoreCase("Chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        // If the browser is IE
        else if(browsername.equalsIgnoreCase("IE"))
        {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }

        // If the browser is EDGE
        else if(browsername.equalsIgnoreCase("EDGE"))
        {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(configFileReader.getImplicitlyWait()));
        driver.get(url);
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
