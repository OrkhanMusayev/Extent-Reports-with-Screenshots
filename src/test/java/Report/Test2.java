package Report;

import Base.Base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Test2 extends Base {

    WebDriver driver;

    @Test
    public void googleTitleValidation(){

        driver = initializeDriver();
        driver.get("https://google.com");
        System.out.println(driver.getTitle());
        driver.close();
    }

}
