package Scripts;

import Resources.GlobalVariables;
import Resources.InputData;
import Resources.ObjectRepository;
import Resources.Report;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static Resources.GlobalVariables.*;
import static Resources.GlobalVariables.PASSWORD_QA;

/**
 * Created by agarwalp on 7/15/2017.
 */
public class CV_Cancellation {

    WebDriver driver;

    @Test
    @Parameters({"iterationNumber",})
    public void test(@Optional("1") int iterationNumber) throws InterruptedException, Exception {
        InputData inputData = new InputData(INPUT_DATA_PATH, "CV_Cancellation", iterationNumber);
        String policyState = inputData.getColumnData("StateCode");
        InputData policyData = new InputData(REPORT_PATH, "Results", "State", policyState);
        System.out.println(policyData.getColumnData("Policy_Number"));
        Report report = new Report(REPORT_PATH, "cancel");
        report.addResult("Policy_Number", policyData.getColumnData("Policy_Number"));
        ObjectRepository OR = new ObjectRepository();

//        *********************Loading Chrome Browser**********************
//        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
//        driver = new ChromeDriver();

//        *******************Loading PhantomJS Browser*******************
        System.setProperty("phantomjs.binary.path", PHANTOMJS_DRIVER_PATH);
        driver = new PhantomJSDriver();

//        *******************Loading URL and Sign In*******************
        driver.get(GlobalVariables.ENV_URL_QA);
        WebElement loginTextBox = driver.findElement(By.xpath(OR.getObjectProperty("login")));
        loginTextBox.clear();
        loginTextBox.sendKeys(USER_NAME_QA);
        driver.findElement(By.xpath(OR.getObjectProperty("password"))).sendKeys(PASSWORD_QA);
        WebElement signInButton = driver.findElement(By.xpath(OR.getObjectProperty("signIn")));
        signInButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 80);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("newAccount"))));
        System.out.println("Successfully LoggedIn");

//       *******************Searching for required Policy*******************
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("searchByPolicySearch"))));
        WebElement searchByPolicySearchDropdown = driver.findElement(By.xpath(OR.getObjectProperty("searchByPolicySearch")));
        Select searchByPolicySearch = new Select(searchByPolicySearchDropdown);
        searchByPolicySearch.selectByValue(inputData.getColumnData("SearchBy"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("searchByCriteria"))));
        WebElement searchByCriteriaDropdown = driver.findElement(By.xpath(OR.getObjectProperty("searchByCriteria")));
        Select searchByCriteria = new Select(searchByCriteriaDropdown);
        searchByCriteria.selectByValue(inputData.getColumnData("SearchByCriteria"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("searchByValue"))));
        driver.findElement(By.xpath(OR.getObjectProperty("searchByValue"))).sendKeys(policyData.getColumnData("Policy_Number"));
        driver.findElement(By.xpath(OR.getObjectProperty("searchRefresh"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("dateCreated")))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("endorsementPolicyInTree")))).click();

//        *******************Clicks on Request Cancel*******************
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("requestCancelLink"))));
        String strCancelEffectiveDate = driver.findElement(By.xpath(OR.getObjectProperty("policyEffectiveDate"))).getText();
        System.out.println("strCancelEffectiveDate=" + strCancelEffectiveDate);
        driver.findElement(By.xpath(OR.getObjectProperty("requestCancelLink"))).click();
        System.out.println("Request Cancel Linked Clicked");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("cancelCheckPopUp"))));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("CancellationEffectiveDate"))));
//        Filling Cancellation Details
        driver.findElement(By.xpath(OR.getObjectProperty("CancellationEffectiveDate"))).clear();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("CancellationEffectiveDate"))));
        driver.findElement(By.xpath(OR.getObjectProperty("CancellationEffectiveDate"))).sendKeys(strCancelEffectiveDate);
        driver.findElement(By.xpath(OR.getObjectProperty("cancelCheckPopUp"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("flatCancelPopUp"))));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("cancellationReason"))));
        WebElement cancellationReason = driver.findElement(By.xpath(OR.getObjectProperty("cancellationReason")));
        Select cancellationReasonDropdown = new Select(cancellationReason);
        cancellationReasonDropdown.selectByValue(inputData.getColumnData("CancellationReason"));
        WebElement cancellationType = driver.findElement(By.xpath(OR.getObjectProperty("cancellationType")));
        Select cancellationTypeDropdown = new Select(cancellationType);
        cancellationTypeDropdown.selectByValue(inputData.getColumnData("CancellationType"));
        driver.findElement(By.xpath(OR.getObjectProperty("cancelComments"))).sendKeys(inputData.getColumnData("CancellationComments"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("okButton")))).click();
        System.out.println("Filled Up Cancellation Details");

//       *****************Binding the Policy******************
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("bind")))).click();
        System.out.println("Bind**********");

//       *****************Issuing the Policy******************
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("issue")))).click();
        System.out.println("Issue**********");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("deliveryOptionPopUp"))));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("generateDocuments")))).click();
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                List<WebElement> webElements = driver.findElements(By.xpath(OR.getObjectProperty("deliveryOptionPopUp")));
                Boolean elementExist = webElements.size() == 0;
                return elementExist;
            }
        });
        driver.manage().timeouts().implicitlyWait(3L, TimeUnit.MINUTES);

//       ******************Getting Policy details from Summary Page*******************
        System.out.println("Getting Report details from policy page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("PolicySumaryTransactionEffectiveDate"))));
        String Policy_Amount = driver.findElement(By.xpath((OR.getObjectProperty("Policy_Amount")))).getText();
        String transactionEffectiveDate = driver.findElement(By.xpath((OR.getObjectProperty("PolicySumaryTransactionEffectiveDate")))).getText();
        String policy_ExpirationDate = driver.findElement(By.xpath((OR.getObjectProperty("PolicySumaryPolicyExpirationDate")))).getText();
        String policy_EffectiveDate = driver.findElement(By.xpath((OR.getObjectProperty("PolicySumaryPolicyEffectiveDate")))).getText();
        String policy_Status = driver.findElement(By.xpath((OR.getObjectProperty("PolicySummaryStatus")))).getText();
        String PremiumMatch_Status = "FAIL";
        if (Policy_Amount.equalsIgnoreCase(inputData.getColumnData("ExpectedPremium"))) {
            PremiumMatch_Status = "PASS";
        } else {
            PremiumMatch_Status = "FAIL";
        }
        System.out.println("Policy_Amount=" + Policy_Amount);
        System.out.println("Transaction_Effective_Date=" + transactionEffectiveDate);
        System.out.println("Policy_Expiration_Date=" + policy_ExpirationDate);
        System.out.println("Policy_Effective_Date=" + policy_EffectiveDate);
        System.out.println("Cancel_Status=" + policy_Status);
        System.out.println("Cancel_Comments=" + inputData.getColumnData("CancellationComments"));
        System.out.println("PremiumMatch_Status=" + PremiumMatch_Status);

//      *********************Reporting************************
        report.addResult("Total_Premium", Policy_Amount);
        report.addResult("Transaction_Effective_Date", transactionEffectiveDate);
        report.addResult("Policy_Effective_Date", policy_EffectiveDate);
        report.addResult("Policy_Expiration_Date", policy_ExpirationDate);
        report.addResult("Cancel_Status", policy_Status);
        report.addResult("Cancel_Comments", inputData.getColumnData("CancellationComments"));
        report.addResult("PremiumMatch_Status", PremiumMatch_Status);
        System.out.println("Final reporting");
        report.updateReportFile();
    }

    @AfterMethod
    public void screenShot(ITestResult result) {
        //using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
        System.out.println("inside screenshot method");
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                LocalDateTime ldt = LocalDateTime.now();
                String nameScreenshot = DateTimeFormatter.ofPattern("yyyyMMddHHmmss").format(ldt);
                // Created reference of TakesScreenshot
                TakesScreenshot screenshot = (TakesScreenshot) driver;
                // Captures the screenshot
                File src = screenshot.getScreenshotAs(OutputType.FILE);
                // Copy files to specific location
                FileUtils.copyFile(src, new File(SCREEN_SHOT_PATH + "\\ErrorScreenshot " + nameScreenshot + ".png"));
                System.out.println("Successfully captured a screenshot");
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }
//        driver.quit();
    }

}
