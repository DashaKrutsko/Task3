package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends AbstractPage {

    private static final String HOME_PAGE_URL = "https://cloud.google.com/";

    @FindBy(name = "q")
    private WebElement searchField;

    public HomePage(WebDriver driver) {
       super(driver);
    }

    public HomePage openPage() {
        driver.get(HOME_PAGE_URL);
        return this;
    }

    public SearchResultsPage enterSearchString(String searchString) {
        waitForVisibilityOfElement(searchField).sendKeys(searchString);
        waitForVisibilityOfElement(searchField).sendKeys(Keys.ENTER);
        return new SearchResultsPage(driver);
    }

}
