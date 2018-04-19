package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddFilmPage extends BasePage {

    @FindBy(xpath = "//button[@id='submit']")
    public WebElement btnSave;

    @FindBy(xpath = "//input[@id='name']")
    public WebElement fldTitle;

    @FindBy(xpath = "//input[@id='year']")
    public WebElement fldYear;
}
