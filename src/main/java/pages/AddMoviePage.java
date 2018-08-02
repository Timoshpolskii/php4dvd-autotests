package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddMoviePage extends BasePage {

    @FindBy(id = "submit")
    public WebElement btnSave;

    @FindBy(id = "name")
    public WebElement fldTitle;

    @FindBy(id = "year")
    public WebElement fldYear;

    @FindBy(id = "notes")
    public WebElement fldPersonalNotes;

    @FindBy(id = "languages")
    public WebElement fldLanguage;
}
