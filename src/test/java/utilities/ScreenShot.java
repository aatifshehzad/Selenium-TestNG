package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ScreenShot {

    public static void captureScreenShot(WebDriver driver, String ScreenShotName)
    {
        try {
            String rootPath = System.getProperty("user.dir");
            File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot,new File(rootPath + "/Screenshots/"+ScreenShotName+".jpg"));
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
