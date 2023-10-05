package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalculatorPage extends AbstractPage {

    @FindBy(id = "myFrame")
    private WebElement searchFrameInner;

    @FindBy(xpath = "//button[@class = 'devsite-snackbar-action']")
    private WebElement searchButtonCookies;

    @FindBy(id = "input-0")
    private WebElement searchFieldComputeEngine;

    @FindBy(id = "input_98")
    private WebElement searchFieldNumberOfInstances;

    @FindBy(id = "select_115")
    private WebElement searchFieldProvisioningModel;
    @FindBy(xpath = "//md-option[@id = 'select_option_113']")
    private WebElement searchOptionProvisioningModel;

    @FindBy(id = "select_111")
    private WebElement searchFieldOperatingSystem;
    @FindBy(xpath = "//md-option[@id = 'select_option_100']")
    private WebElement searchOptionOperatingSystem;

    @FindBy(id = "select_121")
    private WebElement searchFieldMachineFamily;
    @FindBy(xpath = "//md-option[@id = 'select_option_117']")
    private WebElement searchOptionMachineFamily;

    @FindBy(id = "select_123")
    private WebElement searchFieldSeries;
    @FindBy(xpath = "//md-option[@id = 'select_option_220']")
    private WebElement searchOptionSeries;

    @FindBy(id = "select_125")
    private WebElement searchFieldMachineType;
    @FindBy(xpath = "//md-option[@id = 'select_option_470']")
    private WebElement searchOptionMachineType;

    @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
    private WebElement searchCheckboxAddGPU;

    @FindBy(id = "select_506")
    private WebElement searchFieldTypeGPU;
    @FindBy(xpath = "//md-option[@id = 'select_option_513']")
    private WebElement searchOptionGPU;

    @FindBy(id = "select_508")
    private WebElement searchFieldNumberGPU;
    @FindBy(xpath = "//md-option[@id = 'select_option_516']")
    private WebElement searchOptionNumberGPU;

    @FindBy(id = "select_465")
    private WebElement searchFieldSSD;
    @FindBy(xpath = "//md-option[@id = 'select_option_494']")
    private WebElement searchOptionSSD;

    @FindBy(id = "select_131")
    private WebElement searchFieldLocation;
    @FindBy(xpath = "//md-option[@id = 'select_option_263']")
    private WebElement searchOptionLocation;

    @FindBy(id = "select_138")
    private WebElement searchFieldUsage;
    @FindBy(xpath = "//md-option[@id = 'select_option_136']")
    private WebElement searchOptionUsage;

    @FindBy(xpath = "//button[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'add to estimate')]")
    private WebElement searchButtonAddToEstimate;

    @FindBy(xpath = "//*[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'total estimated cost')]")
    private WebElement searchEstimatedCost;

    @FindBy(id = "Email Estimate")
    private WebElement searchButtonEmailEstimate;

    @FindBy(id = "input_616")
    private WebElement searchFieldEmail;

    @FindBy(xpath = "//button[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'send email')]")
    private WebElement searchButtonSendEmail;

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    public CalculatorPage clickButtonCookies() {
        waitForVisibilityOfElement(searchButtonCookies).click();
        return this;
    }

    public CalculatorPage selectFrames() {
        waitForVisibilityOfFrameAndSwitchToItByIndex(0);
        waitForVisibilityOfFrameAndSwitchToIt(searchFrameInner);
        return this;
    }

    public CalculatorPage insertComputeEngine(String typeComputeEngine) {
        waitForVisibilityOfElement(searchFieldComputeEngine).sendKeys(typeComputeEngine);
        return this;
    }

    public CalculatorPage insertNumberOfInstances(String numberOfInstances) {
        waitForVisibilityOfElement(searchFieldNumberOfInstances).sendKeys(numberOfInstances);
        return this;
    }

    public CalculatorPage selectOperatingSystem() {
        selectDropboxElement(searchFieldOperatingSystem, searchOptionOperatingSystem);
        return this;
    }

    public CalculatorPage selectProvisioningModel() {
        selectDropboxElement(searchFieldProvisioningModel, searchOptionProvisioningModel);
        return this;
    }

    public CalculatorPage selectMachineFamily() {
        selectDropboxElement(searchFieldMachineFamily, searchOptionMachineFamily);
        return this;
    }

    public CalculatorPage selectSeries() {
        selectDropboxElement(searchFieldSeries, searchOptionSeries);
        return this;
    }

    public CalculatorPage selectMachineType() {
        selectDropboxElement(searchFieldMachineType, searchOptionMachineType);
        return this;
    }

    public CalculatorPage selectAddGPU() {
        waitForElementToBeClickable(searchCheckboxAddGPU).click();
        return this;
    }

    public CalculatorPage selectTypeGPU() {
        selectDropboxElement(searchFieldTypeGPU, searchOptionGPU);
        return this;
    }

    public CalculatorPage selectNumberGPU() {
        selectDropboxElement(searchFieldNumberGPU, searchOptionNumberGPU);
        return this;
    }

    public CalculatorPage selectSSD() {
        selectDropboxElement(searchFieldSSD, searchOptionSSD);
        return this;
    }

    public CalculatorPage selectLocation() {
        selectDropboxElement(searchFieldLocation, searchOptionLocation);
        return this;
    }

    public CalculatorPage selectUsage() {
        selectDropboxElement(searchFieldUsage, searchOptionUsage);
        return this;
    }

    public CalculatorPage clickAddToEstimate() {
        waitForElementToBeClickable(searchButtonAddToEstimate).click();
        return this;
    }

    public String getStringEstimatedCost() {
        return waitForVisibilityOfElement(searchEstimatedCost).getText();
    }

    public void clickEmailEstimate() {
        waitForElementToBeClickable(searchButtonEmailEstimate).click();
    }

    public CalculatorPage insertEmail(String email) {
        switchToTab(0);
        selectFrames();
        waitForVisibilityOfElement(searchFieldEmail).sendKeys(email);
        return this;
    }

    public void sendEmail() {
        waitForElementToBeClickable(searchButtonSendEmail).click();
    }

    private void selectDropboxElement(WebElement dropboxElement, WebElement option) {
        waitForElementToBeClickable(dropboxElement).click();
        waitForElementToBeClickable(option).click();
    }

}
