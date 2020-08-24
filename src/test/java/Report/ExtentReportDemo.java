package Report;

import Base.Base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentReportDemo extends Base {

    WebDriver driver;

    @Test
    public void initialDemo(){
        ExtentReports extentReports = new ExtentReports();
        ExtentTest test = extentReports.createTest("Initial Demo");
        driver = initializeDriver(); // from base class chrome setup
        driver.get("https://rahulshettyacademy.com");
        System.out.println(driver.getTitle());
        driver.close();
        //test.fail("Result do not match"); // just for practice , to check how it looks like when it fail
        extentReports.flush(); // mandatory to do as long as you done

    }
}
