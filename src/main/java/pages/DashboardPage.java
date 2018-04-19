package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {

    @FindBy(xpath = "//i[@title='Settings']")
    public WebElement btnSettings;

    @FindBy(xpath = "//span[text()='Add']")
    public WebElement btnAdd;

    @FindBy(xpath = "//span[text()='Update all']")
    public WebElement btnUpdateAll;

    @FindBy(xpath = "//span[text()='Export']")
    public WebElement btnExport;
}
