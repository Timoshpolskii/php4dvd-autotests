package helper;

import driver.DriverProvider;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.allure.annotations.Attachment;

public class Screenshot {

    @Attachment(value = "{0}", type = "image/png")
    public static synchronized byte[] takeScreenshot(String screenShot){
        return ((TakesScreenshot)(DriverProvider.getDriver())).getScreenshotAs(OutputType.BYTES);
    }
}
