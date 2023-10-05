package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YopmailPage extends AbstractPage {

    private static final String YOPMAIL_PAGE_URL = "https://yopmail.com/";

    @FindBy(id = "accept")
    private WebElement searchButtonAcceptCookies;

    @FindBy(xpath = "//a[@href ='email-generator']")
    private WebElement searchLinkRandom;

    @FindBy(xpath = "//div[@id = 'geny']")
    private WebElement searchTextEmail;

    @FindBy(xpath = "//button[@onclick='egengo();']")
    private WebElement searchLinkInbox;

    @FindBy(id = "refresh")
    private WebElement searchButtonRefresh;

    @FindBy(xpath = "//h3[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'total estimated monthly cost')]//following::td/h3[1]")

    private WebElement searchCostEmailed;

    public YopmailPage(WebDriver driver) {
        super(driver);
    }

    public YopmailPage openPage() {
        JavascriptExecutor jscript = (JavascriptExecutor) driver;
        jscript.executeScript("window.open(\"" + YOPMAIL_PAGE_URL + "\")");
        switchToTab(1);
        return this;
    }

    public YopmailPage acceptCookies() {
        waitForElementToBeClickable(searchButtonAcceptCookies).click();
        return this;
    }

    public YopmailPage clickRandomEmailGenerator() {
        waitForElementToBeClickable(searchLinkRandom).click();
        return this;
    }

    public String copyEmail() {
        return waitForVisibilityOfElement(searchTextEmail).getText();
    }

    public YopmailPage checkInbox() {
        switchToTab(1);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", waitForVisibilityOfElement(searchLinkInbox));
        waitForVisibilityOfElement(searchLinkInbox).click();
        return this;
    }

    public Double getCostFromEmail() {
        waitForElementToBeClickable(searchButtonRefresh).click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ifmail"));

        String costString = waitForVisibilityOfElement(searchCostEmailed).getText().replaceAll("[^0-9.]", "");
        Double costDouble = null;
        try {
            costDouble = Double.parseDouble(costString);
        } catch (NumberFormatException e) {
            System.out.println("Total Estimated Monthly Cost isn't a number ");
        }
        return costDouble;
    }

}
