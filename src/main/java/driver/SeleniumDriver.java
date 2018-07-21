package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumDriver {
    private static WebDriver driver = null;

    private SeleniumDriver(){}

    public static synchronized WebDriver getDriver() {
        //TODO create capability for different browsers
        if (driver == null) {
            String projectPath = System.getProperty("user.dir");
            System.setProperty("webdriver.chrome.driver", projectPath + "/src/main/resources/chromedriver");
            driver = new ChromeDriver();
//            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
        return driver;
    }
}
