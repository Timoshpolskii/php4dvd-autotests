package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilmDetailsPage extends BasePage {

    @FindBy(xpath = "//i[@title='Back']")
    public WebElement btnBack;

    @FindBy(xpath = "//i[@title='Edit']")
    public WebElement btnEdit;

    @FindBy(xpath = "//i[@title='Remove']")
    public WebElement btnRemove;

    @FindBy(xpath = "//section[@class='content-header']/h1")
    public WebElement txtFilmTitle;

    @FindBy(className = "languages")
    public WebElement txtLanguage;

    @FindBy(className = "notes")
    public WebElement txtPersonalNotes;
}
