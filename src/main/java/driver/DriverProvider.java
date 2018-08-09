package driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverProvider {
    private static WebDriver driver = null;
    private static final long DEFAULT_IMPLICITLY_WAIT = 5;
    private static Logger log = LogManager.getLogger();

    private DriverProvider(){}

    public static synchronized WebDriver getDriver() {
        //TODO create capability for different browsers
        if (driver == null) {
            String projectPath = System.getProperty("user.dir");
            System.setProperty("webdriver.chrome.driver", projectPath + "/src/main/resources/chromedriver");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            setDefaultImplicitlyWait();
            LogManager.getLogger().info("SUCCESS create WebDriver");
        }
        return driver;
    }

    public static void setCustomDriverImplicitlyWait(long seconds) {
        if (driver != null) {
            driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
        }
    }

    public static void setDefaultImplicitlyWait() {
        if (driver != null) {
            driver.manage().timeouts().implicitlyWait(DEFAULT_IMPLICITLY_WAIT, TimeUnit.SECONDS);
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            log.info("Closed Selenium driver");
        }
    }
}
