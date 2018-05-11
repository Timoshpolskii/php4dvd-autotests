package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "username")
    public WebElement fldUserName;

    @FindBy(id = "password")
    public WebElement fldPassword;

    @FindBy(id = "rememberme")
    public WebElement chbxRememberMe;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement btnSubmit;

    @FindBy(xpath = "//div[@class='callout callout-danger']/p")
    public WebElement txtLoginAlert;
}
