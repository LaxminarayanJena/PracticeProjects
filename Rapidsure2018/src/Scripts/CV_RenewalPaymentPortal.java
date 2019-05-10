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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static Resources.GlobalVariables.*;
import static Resources.GlobalVariables.PASSWORD_QA;
import static Resources.GlobalVariables.SCREEN_SHOT_PATH;

/**
 * Created by agarwalp on 7/20/2017.
 */
public class CV_RenewalPaymentPortal {

    WebDriver driver;

    @Test
    @Parameters({"iterationNumber",})
    public void test(@Optional("1") int iterationNumber) throws InterruptedException, Exception {
        InputData inputData = new InputData(INPUT_DATA_PATH, "CV_RenewalPaymentPortal", iterationNumber);
        String policyState = inputData.getColumnData("StateCode");
        InputData policyData = new InputData(REPORT_PATH, "Results", "State", policyState);
        System.out.println(policyData.getColumnData("Policy_Number"));
        Report report = new Report(REPORT_PATH, "renewal_payment_portal");
        report.addResult("Policy_Number", policyData.getColumnData("Policy_Number"));
        ObjectRepository OR = new ObjectRepository();

//        *********************Loading Chrome Browser**********************
       System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();

//        *********************Loading PhantomJS Browser********************
/*        System.setProperty("phantomjs.binary.path", PHANTOMJS_DRIVER_PATH);
        driver = new PhantomJSDriver();
        
        */
        driver.get(GlobalVariables.RENEW_PAYMENT_PORTAL_URL_QA);
        WebDriverWait wait = new WebDriverWait(driver, 120);

//       *****************Enter details on Verify Renewal Page**********************
        System.out.println("Verify Renewal Policy Page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("verifyRenewalHeader"))));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("RenewalPolicyNumber"))));
       // driver.findElement(By.xpath(OR.getObjectProperty("RenewalPolicyNumber"))).sendKeys(policyData.getColumnData("Policy_Number"));
        driver.findElement(By.xpath(OR.getObjectProperty("RenewalPolicyNumber"))).sendKeys("PHCV059166");
        
       // driver.findElement(By.xpath(OR.getObjectProperty("RenewalZipCode"))).sendKeys(inputData.getColumnData("ZipCode"));
        driver.findElement(By.xpath(OR.getObjectProperty("RenewalZipCode"))).sendKeys("75050"); 
        
        driver.findElement(By.xpath(OR.getObjectProperty("RenewalPolicyHolder"))).click();
        driver.findElement(By.xpath(OR.getObjectProperty("RenewalRetrieveRenewal"))).click();

//       *****************Enter details on Renewal Policy Contact Page**********************
        System.out.println("Verify Policy Contacts Page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("verifyPolicyContactHeader"))));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("RenewalSaveAndContinue")))).click();

//       *****************Enter details on Renewal Payment Information Page**********************
        System.out.println("Renewal Payment Information Page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("paymentRenewalHeader"))));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("RenewalPolicyAddressSame")))).click();
        System.out.println("Entering Card details*****");
        Thread.sleep(1000);
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("RenewalCardHolderName"))));
                String strRenewalCscCode = driver.findElement(By.xpath(OR.getObjectProperty("RenewalCardHolderName"))).getAttribute("value");
                if (!strRenewalCscCode.equalsIgnoreCase(inputData.getColumnData("CardHolderName"))) {
                    driver.findElement(By.xpath(OR.getObjectProperty("RenewalCardHolderName"))).clear();
                    driver.findElement(By.xpath(OR.getObjectProperty("RenewalCardHolderName"))).sendKeys(inputData.getColumnData("CardHolderName"));
                } else {
                    String strRenewalCscCodeCheck = driver.findElement(By.xpath(OR.getObjectProperty("RenewalCardHolderName"))).getAttribute("value");
                    return strRenewalCscCodeCheck.equalsIgnoreCase(inputData.getColumnData("CardHolderName"));
                }
                return false;
            }
        });

//       *****************Enter Card details**********************
        driver.findElement(By.xpath(OR.getObjectProperty("RenewalCardNumber"))).sendKeys(inputData.getColumnData("CardNumber"));
        WebElement cardExpirationMonth = driver.findElement(By.xpath(OR.getObjectProperty("RenewalExpirationDateMonth")));
        Select cardExpirationMonthDropdown = new Select(cardExpirationMonth);
        cardExpirationMonthDropdown.selectByValue(inputData.getColumnData("CardMonth"));
        WebElement cardExpirationYear = driver.findElement(By.xpath(OR.getObjectProperty("RenewalExpirationDateYear")));
        Select cardExpirationYearDropdown = new Select(cardExpirationYear);
        cardExpirationYearDropdown.selectByValue(inputData.getColumnData("CardYear"));
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("RenewalCscCode"))));
                String strRenewalCscCode = driver.findElement(By.xpath(OR.getObjectProperty("RenewalCscCode"))).getAttribute("value");
                if (!strRenewalCscCode.equalsIgnoreCase(inputData.getColumnData("CardCSCCode"))) {
                    driver.findElement(By.xpath(OR.getObjectProperty("RenewalCscCode"))).clear();
                    driver.findElement(By.xpath(OR.getObjectProperty("RenewalCscCode"))).sendKeys(inputData.getColumnData("CardCSCCode"));
                } else {
                    String strRenewalCscCodeCheck = driver.findElement(By.xpath(OR.getObjectProperty("RenewalCscCode"))).getAttribute("value");
                    return strRenewalCscCodeCheck.equalsIgnoreCase(inputData.getColumnData("CardCSCCode"));
                }
                return false;
            }
        });

//       *****************Getting Report details from Renewal Make Payment Page**********************
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("RenewalMakePayment")))).click();
        System.out.println("Successfully entered card details");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("PaymentSuccessHeader"))));
        System.out.println("Getting Report details from the page");
        String Confirmation_Code = driver.findElement(By.xpath((OR.getObjectProperty("confirmationCode")))).getText();
        String Amount_Charged = "$" + driver.findElement(By.xpath((OR.getObjectProperty("AmountCharged")))).getText();
        String Policy_Number = driver.findElement(By.xpath((OR.getObjectProperty("PolicyNumber")))).getText();
        String State_Code = policyState;
//      Date
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date todayDate = new Date();
        formatter.format(todayDate);
        String Payment_Date = formatter.format(todayDate);
        System.out.println("State_Code=" + State_Code);
        System.out.println("Confirmation_Code=" + Amount_Charged);
        System.out.println("Amount_Charged=" + Confirmation_Code);
        System.out.println("Policy_Number=" + Policy_Number);
        System.out.println("Payment_Date=" + Payment_Date);

//      *********************Reporting************************
        report.addResult("State_Code", State_Code);
        report.addResult("Confirmation_Code", Confirmation_Code);
        report.addResult("Amount_Charged", Amount_Charged);
        report.addResult("Policy_Number", Policy_Number);
        report.addResult("Payment_Date", Payment_Date);
        System.out.println("Final reporting");
        report.updateReportFile();
        System.out.println("Script Ends");
    }

    @AfterMethod
    public void screenShot(ITestResult result) {
        //using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
        System.out.println("inside screenshot method");
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                LocalDateTime ldt = LocalDateTime.now();
                String nameScreenshot = DateTimeFormatter.ofPattern("yyyyMMddHHmmss").format(ldt);
                // Create reference of TakesScreenshot
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
