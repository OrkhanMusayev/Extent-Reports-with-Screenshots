package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class Base {

    WebDriver driver;

    public WebDriver initializeDriver(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public String getScreenshotPath(String TestCaseName,WebDriver driver) throws IOException {

        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destPath = System.getProperty("user.dir")+"\\reports\\"+TestCaseName+".png";
        File file = new File (destPath);
        FileUtils.copyFile(source,file);
        // selenium will tak screenshot and it will located in your local comp
        return destPath;
    }
}
