package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyProfilePage extends BasePage {

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement btnSave;

    @FindBy(id = "username")
    public WebElement txtUserName;
}
