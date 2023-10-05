package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.HomePage;
import page.CalculatorPage;
import page.YopmailPage;

public class TestOfCorrectCostCalculation {

    private WebDriver driver;
    private static final String SEARCH_STRING = "Google Cloud Platform Pricing Calculator";
    private static final String COMPUTE_ENGINE = "Compute Engine";
    private static final String NUMBER_OF_INSTANCES = "4";

    @BeforeTest(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "Check the calculated costs")
    public void checkCalculatedCosts() {
        SoftAssert softAssertion = new SoftAssert();

        CalculatorPage newPaste = new HomePage(driver)
                .openPage()
                .enterSearchString(SEARCH_STRING)
                .getCalculatorPage()
                .clickButtonCookies()
                .selectFrames()
                .insertComputeEngine(COMPUTE_ENGINE)
                .insertNumberOfInstances(NUMBER_OF_INSTANCES)
                .selectOperatingSystem()
                .selectProvisioningModel()
                .selectMachineFamily()
                .selectSeries()
                .selectMachineType()
                .selectAddGPU()
                .selectTypeGPU()
                .selectNumberGPU()
                .selectSSD()
                .selectLocation()
                .selectUsage()
                .clickAddToEstimate();

        Double costEstimated = newPaste.getEstimatedCost();

        softAssertion.assertTrue(costEstimated != null && costEstimated > 0, "The price hasn't been calculated");

        newPaste.clickEmailEstimate();
        YopmailPage newYopmailPage = new YopmailPage(driver)
                .openPage()
                .acceptCookies()
                .clickRandomEmailGenerator();

        String newRandomEmail = newYopmailPage.copyEmail();
        newPaste.insertEmail(newRandomEmail).sendEmail();
        Double costEmailed = newYopmailPage.checkInbox().getCostFromEmail();

        softAssertion.assertEquals(costEstimated, costEmailed, "Prices aren't equal");
        softAssertion.assertAll();

    }

    @AfterTest(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
