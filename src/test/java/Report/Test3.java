package Report;

import Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test3 extends Base {

    WebDriver driver;

    @Test
    public void editBoxValidation(){

        driver = initializeDriver();
        driver.get("https://google.com");
        driver.findElement(By.name("q")).sendKeys("hello");
        System.out.println(driver.getTitle());
        Assert.assertTrue(false); // this step will fail
        driver.close();
    }
}
