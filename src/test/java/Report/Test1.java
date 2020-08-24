package Report;

import Base.Base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Test1 extends Base {

    WebDriver driver;

    @Test
    public void initialDemo(){

        driver = initializeDriver();
        driver.get("https://rahulshettyacademy.com");
        System.out.println(driver.getTitle());
        driver.close();
    }
}
