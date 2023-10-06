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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestOfCorrectCostCalculation {

    private WebDriver driver;
    private static final String SEARCH_STRING = "Google Cloud Platform Pricing Calculator";
    private static final String COMPUTE_ENGINE = "Compute Engine";
    private static final String NUMBER_OF_INSTANCES = "4";
    private static final String FLAG_NEW_MAIL = "1 mail";
    private static final String PATTERN_DOUBLE = "\\d+[.]\\d+";

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

        String costEstimatedString = newPaste.getStringEstimatedCost();
        Double costEstimated = getDoubleCost(costEstimatedString);

        softAssertion.assertTrue(costEstimated != null && costEstimated > 0, "The price hasn't been calculated");

        newPaste.clickEmailEstimate();
        YopmailPage newYopmailPage = new YopmailPage(driver)
                .openPage()
                .acceptCookies()
                .clickRandomEmailGenerator();

        String newRandomEmail = newYopmailPage.copyEmail();
        newPaste.insertEmail(newRandomEmail).sendEmail();

        String costEmailedString = newYopmailPage
                .checkInbox()
                .waitEmail(FLAG_NEW_MAIL)
                .getCostFromEmail();

        Double costEmailed = getDoubleCost(costEmailedString);

        softAssertion.assertEquals(costEmailed, costEstimated, "Costs aren't equal");
        softAssertion.assertAll();

    }

    @AfterTest(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

    private Double getDoubleCost(String costString) {
        costString = costString.replaceAll(",", "");
        Double costDouble = null;
        Pattern pattern = Pattern.compile(PATTERN_DOUBLE);
        Matcher matcher = pattern.matcher(costString);
        if (matcher.find()) {
            try {
                costDouble = Double.parseDouble(matcher.group(0));
            } catch (NumberFormatException e) {
                System.out.println("Total cost isn't a number");
            }
        }
        return costDouble;
    }

}