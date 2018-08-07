package driver;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverProvider {
    private static WebDriver driver = null;

    private DriverProvider(){}

    public static synchronized WebDriver getDriver() {
        //TODO create capability for different browsers
        if (driver == null) {
            String projectPath = System.getProperty("user.dir");
            System.setProperty("webdriver.chrome.driver", projectPath + "/src/main/resources/chromedriver");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            LogManager.getLogger().info("Success create WebDriver");
        }
        return driver;
    }
}
