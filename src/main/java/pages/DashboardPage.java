package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DashboardPage extends BasePage {

    @FindBy(xpath = "//i[@title='Settings']")
    public WebElement btnSettings;

    @FindBy(xpath = "//span[text()='Add']")
    public WebElement btnAdd;

    @FindBy(xpath = "//span[text()='Update all']")
    public WebElement btnUpdateAll;

    @FindBy(xpath = "//span[text()='Export']")
    public WebElement btnExport;

    @FindBy(className = "movie-link")
    public List<WebElement> movieContainers;

    public By txtMovieName = By.className("movie-title");

    public By btnLike = By.className("movie-icons btn-group-vertical");

    public By movieImage = By.className("movie-cover");
}
