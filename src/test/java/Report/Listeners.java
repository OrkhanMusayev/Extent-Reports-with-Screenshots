package Report;

import Base.Base;
import ExtentReporterNG.ExtentReporterNG;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends Base implements ITestListener {

    ExtentReports extentReporterNG = ExtentReporterNG.extentReportGenerator();
    ExtentTest test;
    private static ThreadLocal <ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

    public void onTestStart(ITestResult result) {
        test = extentReporterNG.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS,"Successful");
    }

    public void onTestFailure(ITestResult result) {
        WebDriver driver = null;
        extentTest.get().fail(result.getThrowable()); //  it will give error message
        Object testObject = result.getInstance();
        Class clazz = result.getTestClass().getRealClass();
        try {
            driver = (WebDriver) clazz.getDeclaredField("driver").get(testObject);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        // here we need take a screenshot to report
        try {
            extentTest.get().addScreenCaptureFromPath(getScreenshotPath(result.getMethod().getMethodName(),driver), result.getMethod().getMethodName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onFinish(ITestContext context) {
        extentReporterNG.flush();
    }
}
