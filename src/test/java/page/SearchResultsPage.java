package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends AbstractPage {
    private static final String CALCULATOR_PAGE_URL = "https://cloud.google.com/products/calculator";

    @FindBy(xpath = "//a[contains(@data-ctorig, 'calculator')]")
    private WebElement searchCalculatorPage;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public CalculatorPage getCalculatorPage() {
        waitForElementToBeClickable(searchCalculatorPage).click();
        return new CalculatorPage(driver);
    }

}
