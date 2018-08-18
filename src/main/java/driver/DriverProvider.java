package driver;

import helper.PropertiesReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public final class DriverProvider {
    private static WebDriver driver = null;
    private static final long DEFAULT_IMPLICITLY_WAIT = 5;
    private static Logger log = LogManager.getLogger();

    private DriverProvider(){}

    public static synchronized WebDriver getDriver() {
        if (driver == null) {
            driver = initDriver();
        }
        return driver;
    }

    private static WebDriver initDriver() {
        String browser = getBrowserName();
        String projectPath = System.getProperty("user.dir");
        switch (browser) {
            case "Firefox" :
                System.setProperty("webdriver.gecko.driver", projectPath + "/src/main/resources/geckodriver");
                driver = new FirefoxDriver();
                break;
            case "Safari" : //NOTE: Safari is not supported due to numerous server-side errors in driver
                driver = new SafariDriver();
                break;
            case "Chrome" :
                System.setProperty("webdriver.chrome.driver", projectPath + "/src/main/resources/chromedriver");
                driver = new ChromeDriver();
                break;
            default : throw new RuntimeException("BROWSER NAME is incorrect or not provided");
        }
        driver.manage().window().maximize();
        setDefaultImplicitlyWait();
        LogManager.getLogger().info("SUCCESS create WebDriver for browser " + browser);
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

    private static String readBrowserFromPropertiesFile() {
        String filePath = "/src/test/resources/browser_names.properties";
        return PropertiesReader.readPropertyFromFile(filePath, "browser_name");
    }

    private static String getBrowserName() {
        String browser = System.getProperty("browser");
        if (browser == null) {
            log.info("BROWSER is not set from gradle parameters. Will read browser from properties file");
            browser = readBrowserFromPropertiesFile();
        }
        log.info("CURRENT browser is " + browser);
        return browser;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            log.info("Closed Selenium driver");
        }
    }
}
