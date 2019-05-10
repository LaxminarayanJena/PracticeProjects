package Scripts;


import Resources.*;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static Resources.GlobalVariables.*;

/**
 * Created by agarwalp on 5/28/2017.
 */
public class CV_NB extends PDFTextStripper {
	
	static List<String> lines = new ArrayList<String>();
	public CV_NB() throws IOException {
	}

   // WebDriver driver;
	FirefoxDriver driver;
	
    @Test
    @Parameters({"iterationNumber",})
    public   void test(@Optional("15") int iterationNumber) throws InterruptedException, Exception {
        InputData inputData = new InputData(INPUT_DATA_PATH, "CV_NB", iterationNumber);
        Report report = new Report(REPORT_PATH);
        ObjectRepository OR = new ObjectRepository();

        PDDocument document = null;	
        HashMap<String, String> result = null;
		
       FirefoxProfile profile = new FirefoxProfile();		
		
		profile.setPreference("browser.download.dir",System.getProperty("user.dir")+"\\src\\PolicyDocuments");
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.download.manager.skipWinSecurityPolicyChecks", false);
		profile.setPreference("browser.download.manager.useWindow", false);
		profile.setPreference("browser.download.hide_plugins_without_extensions", true);
		profile.setPreference("pdfjs.disabled", true);
		profile.setPreference("pdfjs.enableWebGL", false);
		profile.setPreference("pdfjs.enabIedCache.initialized", true);
		profile.setPreference("pdfjs.enabIedCache.state", false);	
		profile.setPreference("pdfjs.previousHandler.alwaysAskBeforeHandling", true);
		profile.setPreference("pdfjs.renderer", false);
		profile.setPreference("pdfjs.enabledCache.initialized", true);
		profile.setPreference("pdfjs.enabledCache.state", false);		
		profile.setPreference("browser.download.useToolkitUI",false);
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/plain,application/octet-stream,application/pdf,application/x-pdf,application/vnd.pdf");
		profile.setPreference("browser.download.manager.showWhenStarting", false);
		profile.setPreference("browser.helperApps.neverAsk.openFile","text/plain,application/octet-stream,application/pdf,application/x-pdf,application/vnd.pdf");
		profile.setPreference("browser.helperApps.alwaysAsk.force", false);
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
		
		FirefoxOptions options = new FirefoxOptions();				
		//options.setHeadless(true); 
		FirefoxOptions profile1 = options.setProfile(profile);
		
		 driver = new FirefoxDriver(profile1);
		 
		 
	
        
        
        
//        *********************Loading Chrome Browser**********************
      // System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
   //    driver = new ChromeDriver();

//        *******************Loading PhantomJS Browser*******************
  /*      System.setProperty("phantomjs.binary.path", PHANTOMJS_DRIVER_PATH);
        driver = new PhantomJSDriver();
*/
//        *******************Loading URL and Sign In*******************
       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();  
       
        driver.get(GlobalVariables.ENV_URL_QA);
        driver.manage().timeouts().implicitlyWait(3L, TimeUnit.MINUTES);
        WebElement loginTextBox = driver.findElement(By.xpath(OR.getObjectProperty("login")));
        loginTextBox.clear();
        loginTextBox.sendKeys(USER_NAME_QA);
        Thread.sleep(2000);
        driver.findElement(By.xpath(OR.getObjectProperty("password"))).sendKeys(PASSWORD_QA);
        WebElement signInButton = driver.findElement(By.xpath(OR.getObjectProperty("signIn")));
        signInButton.click();

//        *******************Creating New Account*******************
        WebDriverWait wait = new WebDriverWait(driver, 80);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("newAccount"))));
        System.out.println("Successfully LoggedIn");
        driver.findElement(By.xpath(OR.getObjectProperty("newAccount"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("accountNameId"))));
        driver.findElement(By.xpath(OR.getObjectProperty("accountNameId"))).clear();
        driver.findElement(By.xpath(OR.getObjectProperty("accountNameId"))).sendKeys(inputData.getColumnData("AccountName"));
        driver.findElement(By.xpath(OR.getObjectProperty("line1"))).sendKeys(inputData.getColumnData("Line1"));
        driver.findElement(By.xpath(OR.getObjectProperty("city"))).sendKeys(inputData.getColumnData("city"));
        WebElement accountStateDropdown = driver.findElement(By.xpath(OR.getObjectProperty("state")));
        Select selectAccountState = new Select(accountStateDropdown);
        selectAccountState.selectByValue(inputData.getColumnData("state"));
        driver.findElement(By.xpath(OR.getObjectProperty("zipcode"))).sendKeys(inputData.getColumnData("zipcode"));
        WebElement accountTargetProductDropdown = driver.findElement(By.xpath(OR.getObjectProperty("targetProduct")));
        Select selectAccountTargetProduct = new Select(accountTargetProductDropdown);
        selectAccountTargetProduct.selectByValue(inputData.getColumnData("targetproduct"));
        driver.findElement(By.xpath(OR.getObjectProperty("saveAccount"))).click();
        System.out.println("Saved New Account");

//       *******************Validate Account Address*******************
        RSLibraryFile.waitForPopUpToOpen(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("validateAccountAddress"))));
        driver.findElement(By.xpath(OR.getObjectProperty("validateAccountAddress"))).click();
        System.out.println("Validated Account Address");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

//        *******************Adding new Contact**************************
        try {
            driver.findElement(By.xpath(OR.getObjectProperty("contacts"))).click();
            driver.findElement(By.xpath(OR.getObjectProperty("newContact"))).click();
        } catch (Exception e) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("createNewButton"))));
            driver.findElement(By.xpath(OR.getObjectProperty("createNewButton"))).click();
            RSLibraryFile.waitForPopUpToClose(driver);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("contacts"))));
            driver.findElement(By.xpath(OR.getObjectProperty("contacts"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("newContact"))));
            driver.findElement(By.xpath(OR.getObjectProperty("newContact"))).click();
        }
        driver.manage().timeouts().implicitlyWait(3L, TimeUnit.MINUTES);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("saveContact"))));
//      Added sync
        wait.until(ExpectedConditions.elementToBeClickable((By.xpath(OR.getObjectProperty("firstName")))));
        driver.findElement(By.xpath(OR.getObjectProperty("firstName"))).clear();
        driver.findElement(By.xpath(OR.getObjectProperty("firstName"))).sendKeys(inputData.getColumnData("firstname"));
        driver.findElement(By.xpath(OR.getObjectProperty("lastName"))).sendKeys(inputData.getColumnData("lastname"));
        driver.findElement(By.xpath(OR.getObjectProperty("addressLine"))).sendKeys(inputData.getColumnData("addressline"));
        driver.findElement(By.xpath(OR.getObjectProperty("contactCity"))).sendKeys(inputData.getColumnData("contactcity"));
        WebElement contactState = driver.findElement(By.xpath(OR.getObjectProperty("contactState")));
        Select selectContactState = new Select(contactState);
        selectContactState.selectByValue(inputData.getColumnData("contactstate"));
        driver.findElement(By.xpath(OR.getObjectProperty("contactZipcode"))).sendKeys(inputData.getColumnData("contactzipcode"));
        driver.findElement(By.xpath(OR.getObjectProperty("phoneNo"))).sendKeys(inputData.getColumnData("phoneno"));
        driver.findElement(By.xpath(OR.getObjectProperty("saveContact"))).click();
        System.out.println("Saved New Contact");
        RSLibraryFile.waitForPopUpToOpen(driver);

//       *******************Added sync*******************
        WebElement chooseAddress1Element = driver.findElement(By.xpath(OR.getObjectProperty("chooseAddress1")));
        chooseAddress1Element.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("accountAddressPopupHeading"))));
        driver.findElement(By.xpath(OR.getObjectProperty("chooseAddress2"))).click();
        System.out.println("Validated Contact Address");
        RSLibraryFile.waitForPopUpToClose(driver);
        driver.findElement(By.xpath(OR.getObjectProperty("useAccount"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("done"))));
        driver.findElement(By.xpath(OR.getObjectProperty("customerService"))).click();
        driver.findElement(By.xpath(OR.getObjectProperty("endorsement"))).click();
        driver.findElement(By.xpath(OR.getObjectProperty("lossControl"))).click();
        driver.findElement(By.xpath(OR.getObjectProperty("policy"))).click();
        driver.findElement(By.xpath(OR.getObjectProperty("done"))).click();
        System.out.println("Selected Policy checkboxes");

//        *******************Added sync*******************
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("stateOfReg"))));
        WebElement stateOfRegistrationDropdown = driver.findElement(By.xpath(OR.getObjectProperty("stateOfReg")));

//        *******************Selecting Effective date and State of Policy registration*******************
        Select stateOfRegistration = new Select(stateOfRegistrationDropdown);
        stateOfRegistration.selectByValue(inputData.getColumnData("stateofreg"));
        System.out.println("Selected Effective date , Expire Date and Registration State");
        driver.findElement(By.xpath(OR.getObjectProperty("ok"))).click();
        RSLibraryFile.waitForPopUpToClose(driver);

//        *******************Selecting Phone Number*******************
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("phone"))));
        WebElement phoneTextBox = driver.findElement(By.xpath(OR.getObjectProperty("phone")));
        phoneTextBox.clear();
        phoneTextBox.sendKeys(inputData.getColumnData("phone"));

//       *******************Entering County for KY state*******************
        System.out.println("Entered Phone number on Policy Page");
        if (inputData.getColumnData("state").equalsIgnoreCase("KY")) {
            driver.findElement(By.xpath(OR.getObjectProperty("countyPolicyInfo"))).sendKeys(inputData.getColumnData("county"));
            System.out.println("Entered County on Policy Page");
        }

//        *******************Selecting Policy Questions*******************
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("policyQuestion"))));
        driver.findElement(By.xpath(OR.getObjectProperty("policyQuestion"))).click();
        System.out.println("Policy Question Tab");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("signedApplication"))));
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("signedApplication"))));
                if (!driver.findElement(By.xpath((OR.getObjectProperty("signedApplication")))).isSelected()) {
                    driver.findElement(By.xpath((OR.getObjectProperty("signedApplication")))).click();
                } else {
                    return true;
                }
                return false;
            }
        });
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("uim"))));
                if (!driver.findElement(By.xpath((OR.getObjectProperty("uim")))).isSelected()) {
                    driver.findElement(By.xpath((OR.getObjectProperty("uim")))).click();
                } else {
                    return true;
                }
                return false;
            }
        });
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("savePolicy"))));
                driver.findElement(By.xpath((OR.getObjectProperty("savePolicy")))).click();
                List<WebElement> webElements = driver.findElements(By.xpath(OR.getObjectProperty("policyEdit")));
                Boolean elementExist = webElements.size() != 0;
                return elementExist;
            }
        });
        System.out.println("Selected Signed Application, UIM checkbox and saved the Policy");

//        *******************Adding Driver Details*******************
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("policyInfo"))));
        driver.findElement(By.xpath(OR.getObjectProperty("policyInfo"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("driver"))));
        driver.findElement(By.xpath(OR.getObjectProperty("driver"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("addDriver"))));
        driver.findElement(By.xpath(OR.getObjectProperty("addDriver"))).click();
        System.out.println("Selected Policy Info and adding the driver details");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("driverFirstName"))));
        driver.findElement(By.xpath(OR.getObjectProperty("driverFirstName"))).sendKeys(inputData.getColumnData("driverfirstname"));
        driver.findElement(By.xpath(OR.getObjectProperty("licenseNumber"))).sendKeys(inputData.getColumnData("licensenumber"));
        driver.findElement(By.xpath(OR.getObjectProperty("driverLastName"))).sendKeys(inputData.getColumnData("driverlastname"));
        driver.findElement(By.xpath(OR.getObjectProperty("dailyDriving"))).sendKeys(inputData.getColumnData("dailydriving"));
        driver.findElement(By.xpath(OR.getObjectProperty("dob"))).sendKeys(inputData.getColumnData("dob"));
        driver.findElement(By.xpath(OR.getObjectProperty("collectorCar"))).click();
        if (inputData.getColumnData("state").equalsIgnoreCase("CA")) {
            WebElement yearLicenseDropdown = driver.findElement(By.xpath(OR.getObjectProperty("yearLicense")));
            Select yearLicense = new Select(yearLicenseDropdown);
            yearLicense.selectByValue(inputData.getColumnData("driverViolation"));
        } else {
        }
        
        
        
        WebElement lossesDropdown = driver.findElement(By.xpath(OR.getObjectProperty("lossesPA")));
        Select losses = new Select(lossesDropdown);
        losses.selectByValue(inputData.getColumnData("driverLosses"));
        
        if (inputData.getColumnData("state").equalsIgnoreCase("CA")) {
            WebElement pointsDropdown = driver.findElement(By.xpath(OR.getObjectProperty("points")));
            Select points = new Select(pointsDropdown);
            points.selectByValue(inputData.getColumnData("driverPoints"));
        } else {
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("saveDriver"))));
        System.out.println("Saved Driver details");
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("saveDriver"))));
                driver.findElement(By.xpath((OR.getObjectProperty("saveDriver")))).click();
                List<WebElement> webElements = driver.findElements(By.xpath(OR.getObjectProperty("addDriver")));
                Boolean elementExist = webElements.size() != 0;
                return elementExist;
            }
        });

//        *******************Adding Garage1*******************
        WebDriverWait waitMore = new WebDriverWait(driver, 180);
        System.out.println("Adding New Garage");
        waitMore.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("garages")))).click();
        waitMore.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("newGarage")))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("copyPrimaryAddress"))));
        if (inputData.getColumnData("state").equalsIgnoreCase("PA")) {
            driver.findElement(By.xpath((OR.getObjectProperty("garageAddressLine1")))).sendKeys(inputData.getColumnData("garage1AddressLine1"));
            driver.findElement(By.xpath((OR.getObjectProperty("garageCity")))).sendKeys(inputData.getColumnData("garage1City"));
            WebElement garageStateDropdown = driver.findElement(By.xpath(OR.getObjectProperty("garageState")));
            Select garageState = new Select(garageStateDropdown);
            garageState.selectByValue(inputData.getColumnData("garage1State"));
            driver.findElement(By.xpath((OR.getObjectProperty("garageZipcode")))).clear();
            driver.findElement(By.xpath((OR.getObjectProperty("garageZipcode")))).sendKeys(inputData.getColumnData("garage1Zipcode"));
            WebElement garageCountryDropdown = driver.findElement(By.xpath(OR.getObjectProperty("garageCountry")));
            Select garageCountry = new Select(garageCountryDropdown);
            garageCountry.selectByValue(inputData.getColumnData("garage1Country"));
            driver.findElement(By.xpath((OR.getObjectProperty("saveGarage")))).click();
            System.out.println("Save Garage1");
            RSLibraryFile.waitForPopUpToOpen(driver);
            driver.findElement(By.xpath(OR.getObjectProperty("chooseAddress1"))).click();
            System.out.println("Validated Garage1 Address");
            RSLibraryFile.waitForPopUpToClose(driver);
        } else {
            driver.findElement(By.xpath((OR.getObjectProperty("copyPrimaryAddress")))).click();

//            *******************Added Sync*******************
            wait.until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver driver) {
                    Boolean displayed = driver.findElement(By.xpath((OR.getObjectProperty("garageAddressLine1")))).isDisplayed();
                    Boolean enabled = driver.findElement(By.xpath((OR.getObjectProperty("garageAddressLine1")))).isEnabled();
                    Boolean notEmpty = driver.findElement(By.xpath((OR.getObjectProperty("garageAddressLine1")))).getAttribute("value").length() != 0;
                    return displayed && enabled && notEmpty;
                }
            });
            driver.findElement(By.xpath((OR.getObjectProperty("saveGarage")))).click();
            System.out.println("Save New Garage");
        }

//        *******************Selecting Territory Code for KY state*******************
        if (inputData.getColumnData("state").equalsIgnoreCase("KY")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("selectTerritory"))));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("territoryCode")))).click();
            RSLibraryFile.waitForPopUpToClose(driver);
        }

//       *******************Adding garage2 for PA state*******************
        if (inputData.getColumnData("state").equalsIgnoreCase("PA")) {
            System.out.println("Adding New Garage 2");
            waitMore.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("garages")))).click();
            waitMore.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("newGarage")))).click();
            waitMore.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("copyPrimaryAddress")))).click();
            driver.findElement(By.xpath((OR.getObjectProperty("garageAddressLine1")))).sendKeys(inputData.getColumnData("garage2AddressLine1"));
            driver.findElement(By.xpath((OR.getObjectProperty("garageCity")))).sendKeys(inputData.getColumnData("garage2City"));
            WebElement garageStateDropdown = driver.findElement(By.xpath(OR.getObjectProperty("garageState")));
            Select garageState = new Select(garageStateDropdown);
            garageState.selectByValue(inputData.getColumnData("garage2State"));
            driver.findElement(By.xpath((OR.getObjectProperty("garageZipcode")))).clear();
            driver.findElement(By.xpath((OR.getObjectProperty("garageZipcode")))).sendKeys(inputData.getColumnData("garage2Zipcode"));
            WebElement garageCountryDropdown = driver.findElement(By.xpath(OR.getObjectProperty("garageCountry")));
            Select garageCountry = new Select(garageCountryDropdown);
            garageCountry.selectByValue(inputData.getColumnData("garage2Country"));
            driver.findElement(By.xpath((OR.getObjectProperty("saveGarage")))).click();
            System.out.println("Save Garage2");
            RSLibraryFile.waitForPopUpToOpen(driver);
            driver.findElement(By.xpath(OR.getObjectProperty("chooseAddress1"))).click();
            System.out.println("Validated Garage2 Address");
            RSLibraryFile.waitForPopUpToClose(driver);
        }

//       *******************Adding Vehicle1*******************
        driver.findElement(By.xpath((OR.getObjectProperty("vehicle")))).click();
        System.out.println("Adding Vehicle1");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("newVehicle")))).click();
        WebElement vehicleYearDropdown = driver.findElement(By.xpath(OR.getObjectProperty("vehicleYear")));
        Select vehicleYear = new Select(vehicleYearDropdown);
        vehicleYear.selectByVisibleText(inputData.getColumnData("vehicle1Year"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("vehicleMake1"))));
        WebElement vehicleMakeDropdown = driver.findElement(By.xpath((OR.getObjectProperty("vehicleMake"))));
        Select vehicleMake = new Select(vehicleMakeDropdown);
        vehicleMake.selectByVisibleText(inputData.getColumnData("vehicle1Make"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("vehicleModel1"))));
        WebElement vehicleModelDropdown = driver.findElement(By.xpath((OR.getObjectProperty("vehicleModel"))));
        Select vehicleModel = new Select(vehicleModelDropdown);
        vehicleModel.selectByIndex(18);
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("agreedValue"))));
                String strAgreedValue = driver.findElement(By.xpath(OR.getObjectProperty("agreedValue"))).getAttribute("value");
                if (!strAgreedValue.equalsIgnoreCase(inputData.getColumnData("agreedvalue"))) {
                    driver.findElement(By.xpath(OR.getObjectProperty("agreedValue"))).clear();
                    driver.findElement(By.xpath(OR.getObjectProperty("agreedValue"))).sendKeys(inputData.getColumnData("agreedvalue"));
                } else {
                    String strAgreedValueCheck = driver.findElement(By.xpath(OR.getObjectProperty("agreedValue"))).getAttribute("value");
                    return strAgreedValueCheck.equalsIgnoreCase(inputData.getColumnData("agreedvalue"));
                }
                return false;
            }
        });
        WebElement vehicleTypeDropdown = driver.findElement(By.xpath((OR.getObjectProperty("vehicleType"))));
        Select vehicleType = new Select(vehicleTypeDropdown);
        vehicleType.selectByValue(inputData.getColumnData("vehicle1Type"));
        WebElement modificationTypeDropdown = driver.findElement(By.xpath((OR.getObjectProperty("modificationType"))));
        Select modificationType = new Select(modificationTypeDropdown);
        modificationType.selectByVisibleText(inputData.getColumnData("vehicle1ModificationType"));
        WebElement garageLocationDropdown = driver.findElement(By.xpath((OR.getObjectProperty("garagingLocation"))));
        Select garageLocation = new Select(garageLocationDropdown);
        garageLocation.selectByIndex(1);
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("vin"))));
                String strAgreedValue = driver.findElement(By.xpath(OR.getObjectProperty("vin"))).getAttribute("value");
                if (!strAgreedValue.equalsIgnoreCase(inputData.getColumnData("vehicle1VIN"))) {
                    driver.findElement(By.xpath(OR.getObjectProperty("vin"))).clear();
                    driver.findElement(By.xpath(OR.getObjectProperty("vin"))).sendKeys(inputData.getColumnData("vehicle1VIN"));
                } else {
                    String strAgreedValueCheck = driver.findElement(By.xpath(OR.getObjectProperty("vin"))).getAttribute("value");
                    return strAgreedValueCheck.equalsIgnoreCase(inputData.getColumnData("vehicle1VIN"));
                }
                return false;
            }
        });
        WebElement primaryUseDropdown = driver.findElement(By.xpath((OR.getObjectProperty("primaryUse"))));
        Select primaryUse = new Select(primaryUseDropdown);
        primaryUse.selectByIndex(5);
        driver.findElement(By.xpath((OR.getObjectProperty("photoReview")))).click();
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("vehicleQuestion"))));
                    driver.findElement(By.xpath((OR.getObjectProperty("vehicleQuestion")))).click();
                    List<WebElement> webElements = driver.findElements(By.xpath(OR.getObjectProperty("AnnualMilageRange")));
                    Boolean elementExist = webElements.size() != 0;
                    return elementExist;
                } catch (Exception e) {
                    return false;
                }
            }
        });
        driver.manage().timeouts().implicitlyWait(3L, TimeUnit.MINUTES);

//       *******************Adding Vehicle1 Questions*******************
        driver.findElement(By.xpath((OR.getObjectProperty("vehicleRegistered")))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("AnnualMilageRange"))));
        WebElement annualMilageRangeDropdown = driver.findElement(By.xpath((OR.getObjectProperty("AnnualMilageRange"))));
        Select annualMilageRange = new Select(annualMilageRangeDropdown);
        annualMilageRange.selectByValue(inputData.getColumnData("AnnualMilageRange"));
        
        if (inputData.getColumnData("state").equalsIgnoreCase("NC")) {
            WebElement factoryInstalledAirbagsDropdown = driver.findElement(By.xpath(OR.getObjectProperty("factoryInstalledAirbags")));
            Select factoryInstalledAirbags = new Select(factoryInstalledAirbagsDropdown);
            factoryInstalledAirbags.selectByValue(inputData.getColumnData("factoryInstalledAirbags"));
        } else if (inputData.getColumnData("state").equalsIgnoreCase("PA")) {
            WebElement passiveRegistrantSystemDropdown = driver.findElement(By.xpath(OR.getObjectProperty("passiveResistantSystem")));
            Select passiveRegistrantSystem = new Select(passiveRegistrantSystemDropdown);
            passiveRegistrantSystem.selectByValue(inputData.getColumnData("passiveResistantSystem"));
        } else {
        }
               
        
        if (inputData.getColumnData("state").equalsIgnoreCase("MI") || inputData.getColumnData("state").equalsIgnoreCase("NY")) {
            WebElement VehicleRegistrationTypeDropdown = driver.findElement(By.xpath("//*[text()[contains(.,'vehicle registration type?')]]//following::select[1]"));
            Select VehicleRegistrationType = new Select(VehicleRegistrationTypeDropdown);
            VehicleRegistrationType.selectByIndex(2);           
        }
        else
        {
        	
        }             
                
        waitMore.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("saveVehicle")))).click();
        System.out.println("Saved Vehicle1");

//      *******************Adding vehicle 2*******************
        System.out.println("Adding Vehicle2");
        waitMore.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("vehicle")))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("newVehicle")))).click();
        WebElement vehicle2YearDropdown = driver.findElement(By.xpath(OR.getObjectProperty("vehicleYear")));
        Select vehicle2Year = new Select(vehicle2YearDropdown);
        vehicle2Year.selectByVisibleText(inputData.getColumnData("vehicle2Year"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("vehicleMake1"))));
        WebElement vehicle2MakeDropdown = driver.findElement(By.xpath((OR.getObjectProperty("vehicleMake"))));
        Select vehicle2Make = new Select(vehicle2MakeDropdown);
        vehicle2Make.selectByVisibleText(inputData.getColumnData("vehicle2Make"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("vehicleModel1"))));
        WebElement vehicle2ModelDropdown = driver.findElement(By.xpath((OR.getObjectProperty("vehicleModel"))));
        Select vehicle2Model = new Select(vehicle2ModelDropdown);
        vehicle2Model.selectByIndex(27);
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("agreedValue"))));
                String strAgreedValue = driver.findElement(By.xpath(OR.getObjectProperty("agreedValue"))).getAttribute("value");
                if (!strAgreedValue.equalsIgnoreCase(inputData.getColumnData("vehicle2Agreedvalue"))) {
                    driver.findElement(By.xpath(OR.getObjectProperty("agreedValue"))).clear();
                    driver.findElement(By.xpath(OR.getObjectProperty("agreedValue"))).sendKeys(inputData.getColumnData("vehicle2Agreedvalue"));
                } else {
                    String strAgreedValueCheck = driver.findElement(By.xpath(OR.getObjectProperty("agreedValue"))).getAttribute("value");
                    return strAgreedValueCheck.equalsIgnoreCase(inputData.getColumnData("vehicle2Agreedvalue"));
                }
                return false;
            }
        });
        WebElement vehicle2TypeDropdown = driver.findElement(By.xpath((OR.getObjectProperty("vehicleType"))));
        Select vehicle2Type = new Select(vehicle2TypeDropdown);
        vehicle2Type.selectByIndex(1);
        WebElement vehicle2ModificationTypeDropdown = driver.findElement(By.xpath((OR.getObjectProperty("modificationType"))));
        Select vehicle2ModificationType = new Select(vehicle2ModificationTypeDropdown);
        vehicle2ModificationType.selectByVisibleText(inputData.getColumnData("vehicle1ModificationType"));
    
        
        
        
        WebElement vehicle2GarageLocationDropdown = driver.findElement(By.xpath((OR.getObjectProperty("garagingLocation"))));
        Select vehicle2GarageLocation = new Select(vehicle2GarageLocationDropdown);
        vehicle2GarageLocation.selectByIndex(1);
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("vin"))));
                String strAgreedValue = driver.findElement(By.xpath(OR.getObjectProperty("vin"))).getAttribute("value");
                if (!strAgreedValue.equalsIgnoreCase(inputData.getColumnData("vehicle2VIN"))) {
                    driver.findElement(By.xpath(OR.getObjectProperty("vin"))).clear();
                    driver.findElement(By.xpath(OR.getObjectProperty("vin"))).sendKeys(inputData.getColumnData("vehicle2VIN"));
                } else {
                    String strAgreedValueCheck = driver.findElement(By.xpath(OR.getObjectProperty("vin"))).getAttribute("value");
                    return strAgreedValueCheck.equalsIgnoreCase(inputData.getColumnData("vehicle2VIN"));
                }
                return false;
            }
        });
        WebElement vehicle2PrimaryUseDropdown = driver.findElement(By.xpath((OR.getObjectProperty("primaryUse"))));
        Select vehicle2PrimaryUse = new Select(vehicle2PrimaryUseDropdown);
        vehicle2PrimaryUse.selectByIndex(5);
        driver.findElement(By.xpath((OR.getObjectProperty("photoReview")))).click();
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("vehicleQuestion"))));
                    driver.findElement(By.xpath((OR.getObjectProperty("vehicleQuestion")))).click();
                    List<WebElement> webElements = driver.findElements(By.xpath(OR.getObjectProperty("AnnualMilageRange")));
                    Boolean elementExist = webElements.size() != 0;
                    return elementExist;
                } catch (Exception e) {
                    return false;
                }
            }
        });
        driver.manage().timeouts().implicitlyWait(3L, TimeUnit.MINUTES);

//       *******************Adding Vehicle2 Questions*******************
        driver.findElement(By.xpath((OR.getObjectProperty("vehicleRegistered")))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("AnnualMilageRange"))));
        WebElement vehicle2AnnualMilageRangeDropdown = driver.findElement(By.xpath((OR.getObjectProperty("AnnualMilageRange"))));
        Select vehicle2AnnualMilageRange = new Select(vehicle2AnnualMilageRangeDropdown);
        vehicle2AnnualMilageRange.selectByValue(inputData.getColumnData("AnnualMilageRange"));
        if (inputData.getColumnData("state").equalsIgnoreCase("NC")) {
            WebElement factoryInstalledAirbagsDropdown = driver.findElement(By.xpath(OR.getObjectProperty("factoryInstalledAirbags")));
            Select factoryInstalledAirbags = new Select(factoryInstalledAirbagsDropdown);
            factoryInstalledAirbags.selectByValue(inputData.getColumnData("factoryInstalledAirbags"));
        } else if (inputData.getColumnData("state").equalsIgnoreCase("PA")) {
            WebElement passiveRegistrantSystemDropdown = driver.findElement(By.xpath(OR.getObjectProperty("passiveResistantSystem")));
            Select passiveRegistrantSystem = new Select(passiveRegistrantSystemDropdown);
            passiveRegistrantSystem.selectByValue(inputData.getColumnData("passiveResistantSystem"));
        } else {
        }
        

        if (inputData.getColumnData("state").equalsIgnoreCase("MI") || inputData.getColumnData("state").equalsIgnoreCase("NY")) {
            WebElement VehicleRegistrationTypeDropdown = driver.findElement(By.xpath("//*[text()[contains(.,'vehicle registration type?')]]//following::select[1]"));
            Select VehicleRegistrationType = new Select(VehicleRegistrationTypeDropdown);
            VehicleRegistrationType.selectByIndex(2);
            
        }
        else
        {
        	
        }
        
        
        waitMore.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("saveVehicle")))).click();
        System.out.println("Saved Vehicle2");
        
     //   *******************Adding vehicle 3*******************
        System.out.println("Adding Vehicle3");
        waitMore.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("vehicle")))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("newVehicle")))).click();
        WebElement vehicle3YearDropdown = driver.findElement(By.xpath(OR.getObjectProperty("vehicleYear")));
        Select vehicle3Year = new Select(vehicle3YearDropdown);
        vehicle3Year.selectByVisibleText(inputData.getColumnData("vehicle3Year"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("vehicleActualYear"))));
        driver.findElement(By.xpath(OR.getObjectProperty("vehicleActualYear"))).sendKeys(inputData.getColumnData("vehicle3ActualYear"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("vehicleMakePre"))));
        driver.findElement(By.xpath(OR.getObjectProperty("vehicleMakePre"))).sendKeys(inputData.getColumnData("vehicle3Make"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("vehicleModelPre"))));
        driver.findElement(By.xpath(OR.getObjectProperty("vehicleModelPre"))).sendKeys(inputData.getColumnData("vehicle3Model"));
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("agreedValue"))));
                String strAgreedValue = driver.findElement(By.xpath(OR.getObjectProperty("agreedValue"))).getAttribute("value");
                if (!strAgreedValue.equalsIgnoreCase(inputData.getColumnData("vehicle3Agreedvalue"))) {
                    driver.findElement(By.xpath(OR.getObjectProperty("agreedValue"))).clear();
                    driver.findElement(By.xpath(OR.getObjectProperty("agreedValue"))).sendKeys(inputData.getColumnData("vehicle3Agreedvalue"));
                } else {
                    String strAgreedValueCheck = driver.findElement(By.xpath(OR.getObjectProperty("agreedValue"))).getAttribute("value");
                    return strAgreedValueCheck.equalsIgnoreCase(inputData.getColumnData("vehicle3Agreedvalue"));
                }
                return false;
            }
        });
        WebElement vehicle3TypeDropdown = driver.findElement(By.xpath((OR.getObjectProperty("vehicleType"))));
        Select vehicle3Type = new Select(vehicle3TypeDropdown);
        vehicle3Type.selectByIndex(1);
        WebElement vehicle3ModificationTypeDropdown = driver.findElement(By.xpath((OR.getObjectProperty("modificationType"))));
        
        Thread.sleep(1300);
        Select vehicle3ModificationType = new Select(vehicle3ModificationTypeDropdown);
        vehicle3ModificationType.selectByVisibleText(inputData.getColumnData("vehicle1ModificationType"));
        
        
        
        WebElement vehicle3GarageLocationDropdown = driver.findElement(By.xpath((OR.getObjectProperty("garagingLocation"))));
        Select vehicle3GarageLocation = new Select(vehicle3GarageLocationDropdown);
        vehicle3GarageLocation.selectByIndex(1);
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("vin"))));
                String strAgreedValue = driver.findElement(By.xpath(OR.getObjectProperty("vin"))).getAttribute("value");
                if (!strAgreedValue.equalsIgnoreCase(inputData.getColumnData("vehicle3VIN"))) {
                    driver.findElement(By.xpath(OR.getObjectProperty("vin"))).clear();
                    driver.findElement(By.xpath(OR.getObjectProperty("vin"))).sendKeys(inputData.getColumnData("vehicle3VIN"));
                } else {
                    String strAgreedValueCheck = driver.findElement(By.xpath(OR.getObjectProperty("vin"))).getAttribute("value");
                    return strAgreedValueCheck.equalsIgnoreCase(inputData.getColumnData("vehicle3VIN"));
                }
                return false;
            }
        });
        WebElement vehicle3PrimaryUseDropdown = driver.findElement(By.xpath((OR.getObjectProperty("primaryUse"))));
        Select vehicle3PrimaryUse = new Select(vehicle3PrimaryUseDropdown);
        vehicle3PrimaryUse.selectByIndex(5);
        driver.findElement(By.xpath((OR.getObjectProperty("photoReview")))).click();
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("vehicleQuestion"))));
                    driver.findElement(By.xpath((OR.getObjectProperty("vehicleQuestion")))).click();
                    List<WebElement> webElements = driver.findElements(By.xpath(OR.getObjectProperty("AnnualMilageRange")));
                    Boolean elementExist = webElements.size() != 0;
                    return elementExist;
                } catch (Exception e) {
                    return false;
                }
            }
        });
        driver.manage().timeouts().implicitlyWait(3L, TimeUnit.MINUTES);

//       *******************Adding Vehicle3 Questions*******************
        driver.findElement(By.xpath((OR.getObjectProperty("vehicleRegistered")))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("AnnualMilageRange"))));
        WebElement vehicle3AnnualMilageRangeDropdown = driver.findElement(By.xpath((OR.getObjectProperty("AnnualMilageRange"))));
        Select vehicle3AnnualMilageRange = new Select(vehicle3AnnualMilageRangeDropdown);
        vehicle3AnnualMilageRange.selectByValue(inputData.getColumnData("AnnualMilageRange"));
        if (inputData.getColumnData("state").equalsIgnoreCase("NC")) {
            WebElement factoryInstalledAirbagsDropdown = driver.findElement(By.xpath(OR.getObjectProperty("factoryInstalledAirbags")));
            Select factoryInstalledAirbags = new Select(factoryInstalledAirbagsDropdown);
            factoryInstalledAirbags.selectByValue(inputData.getColumnData("factoryInstalledAirbags"));
        } else if (inputData.getColumnData("state").equalsIgnoreCase("PA")) {
            WebElement passiveRegistrantSystemDropdown = driver.findElement(By.xpath(OR.getObjectProperty("passiveResistantSystem")));
            Select passiveRegistrantSystem = new Select(passiveRegistrantSystemDropdown);
            passiveRegistrantSystem.selectByValue(inputData.getColumnData("passiveResistantSystem"));
        } else {
        }
        

        if (inputData.getColumnData("state").equalsIgnoreCase("MI") || inputData.getColumnData("state").equalsIgnoreCase("NY")) {
            WebElement VehicleRegistrationTypeDropdown = driver.findElement(By.xpath("//*[text()[contains(.,'vehicle registration type?')]]//following::select[1]"));
            Select VehicleRegistrationType = new Select(VehicleRegistrationTypeDropdown);
            VehicleRegistrationType.selectByIndex(2);
            
        }
        else
        {
        	
        }
        

        if (inputData.getColumnData("state").equalsIgnoreCase("NY")) {
           
        	driver.findElement(By.xpath("//tr[6]/td[3]/fieldset[1]/table[1]/tbody[1]/tr[1]/td[1]/input[1]")).click();
            
        }
        else
        {
        	
        }
        
        
        waitMore.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("saveVehicle")))).click();
        System.out.println("Saved Vehicle3");
        
    

//        *******************Rating the Policy*******************
        waitMore.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("rate")))).click();
        System.out.println("Rate***********");

//        *******************Quoting the Policy*******************
        waitMore.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("quote")))).click();
        System.out.println("Quote**********");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("deliveryOptionPopUp"))));
        waitMore.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("generateDocuments")))).click();
//      Added Sync
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

//        *******************Adding Billing Info*******************
        System.out.println("Billing Info Page");
        waitMore.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("billingInfo"))));
        driver.findElement(By.xpath((OR.getObjectProperty("billingInfo")))).click();
        waitMore.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("edit")))).click();
        waitMore.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("billingContact"))));
        WebElement billingContactDropdown = driver.findElement(By.xpath((OR.getObjectProperty("billingContact"))));
        Select billingContact = new Select(billingContactDropdown);
        billingContact.selectByIndex(1);
        Thread.sleep(2000);
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("saveBillingInfo"))));
                driver.findElement(By.xpath((OR.getObjectProperty("saveBillingInfo")))).click();
                List<WebElement> webElements = driver.findElements(By.xpath(OR.getObjectProperty("policyEdit")));
                Boolean elementExist = webElements.size() != 0;
                return elementExist;
            }
        });
        System.out.println("Saved Billing Info");
        waitMore.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("bind")))).click();

//       *******************Binding the Policy*******************
        System.out.println("Bind**********");
        List<WebElement> buttons = driver.findElements(By.xpath(OR.getObjectProperty("buttons")));
        System.out.print("no of buttons are " + buttons.size() + "-----");
        for (int i = 0; i < buttons.size(); i++) {
            String imgID = buttons.get(i).getAttribute("id");
            System.out.println("imgID=" + imgID);
//             Added Sync
            wait.until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver driver) {
                    String source = driver.findElement(By.id(imgID)).getAttribute("src");
                    if (!source.endsWith("override-1.gif")) {
                        try {
                            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(imgID)))).click();
                            Thread.sleep(5000);
                        } catch (Exception e) {
                            return false;
                        }
                    } else {
                        String sourceCheck = driver.findElement(By.id(imgID)).getAttribute("src");
                        return sourceCheck.endsWith("override-1.gif");
                    }
                    return false;
                }
            });
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("bind")))).click();

//        *******************Issuing the Policy*******************
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
        

//        *******************Getting Policy Details from Summary Page*******************
        System.out.println("Getting Report details from policy page");
        String Account_Name = driver.findElement(By.xpath((OR.getObjectProperty("Account_Name")))).getText();
        String Address_line1 = driver.findElement(By.xpath((OR.getObjectProperty("Address_line1")))).getText();
        String city = driver.findElement(By.xpath((OR.getObjectProperty("account_city")))).getText();
        String State = driver.findElement(By.xpath((OR.getObjectProperty("account_state")))).getText();
        String Zip_Code = driver.findElement(By.xpath((OR.getObjectProperty("zip_code")))).getText();
        String Policy_Number = driver.findElement(By.xpath((OR.getObjectProperty("Policy_Number")))).getText();
        String Policy_Amount = driver.findElement(By.xpath((OR.getObjectProperty("Policy_Amount")))).getText();
        String Account_Number = driver.findElement(By.xpath((OR.getObjectProperty("Account_Number")))).getText();
        String PremiumMatch_Status = "FAIL";
        if (Policy_Amount.equalsIgnoreCase(inputData.getColumnData("ExpectedPremium"))) {
            PremiumMatch_Status = "PASS";
        } else {
            PremiumMatch_Status = "FAIL";
        }
        System.out.println("Account_Name=" + Account_Name);
        System.out.println("Address_line1=" + Address_line1);
        System.out.println("city=" + city);
        System.out.println("State=" + State);
        System.out.println("Zip_Code=" + Zip_Code);
        System.out.println("Policy_Number=" + Policy_Number);
        System.out.println("Policy_Amount=" + Policy_Amount);
        System.out.println("Account_Number=" + Account_Number);
        System.out.println("PremiumMatch_Status=" + PremiumMatch_Status);
       
        String Date = driver.findElement(By.xpath("//*[@id='_PHYLINSPortlet_WAR_PHYLINSPortlet_INSTANCE_o3P5_:form_PolicyContent_UI2:termeffective_CVPolicyInfoSummary']")).getText();
        String Quote_Number = driver.findElement(By.xpath("//*[@id='_PHYLINSPortlet_WAR_PHYLINSPortlet_INSTANCE_o3P5_:form_PolicyContent_UI2:quoteid_CVPolicyInfoSummary']")).getText();
        System.out.println("Date=" + Date );
        System.out.println("Quote_Number=" + Quote_Number);
            
       //Document and PDF
        
        driver.findElement(By.xpath("//span[contains(text(),'Documents')]")).click();      
        String fileName= driver.findElement(By.xpath("//*[contains(text(),'Submission/Rating Information')]//following::span[2]")).getText();
        System.out.println("downloded pdf file name-"+ fileName);
        driver.findElement(By.xpath("//*[contains(text(),'Submission/Rating Information')]//preceding::div[1]//a")).click();       
        String downloadedfilename=System.getProperty("user.dir")+"\\src\\PolicyDocuments\\"+fileName;
        Thread.sleep(3000);
     
        
        /**
         * Validating the pdf 
         * pdfstripping method strips the downloaded policy document page wise
         * validatePDF method validates the qoute number,account number and billing date 
         * present in downloaded pdf with the content generated from application
         */
        
        try {	     	
	        RSLibraryFile.pdfstripping( document, downloadedfilename);	           
            String pdfqoute_number=lines.get(GlobalVariables.pdfqoute_number);
            System.out.println("pdf qoute no-"+ pdfqoute_number);           
            String PdfAccount_Number=lines.get(GlobalVariables.PdfAccount_Number); 
            System.out.println("pdf account no-"+PdfAccount_Number);            
            String PdfBILLING_DATE=lines.get(GlobalVariables.PdfBILLING_DATE);
            System.out.println("pdf billing date-"+PdfBILLING_DATE);                     
            System.out.println("------------------------------VALIDATIONS-----------------------------------");                      
            result=RSLibraryFile.validatePDF(pdfqoute_number, Quote_Number, PdfAccount_Number, Account_Number, PdfBILLING_DATE, Date);           
       	        
                       
        }      
finally {
	if( document != null ) {
		document.close();
	}
        
                 
         
//        *******************Reporting*******************
	
        report.addResult("Policy_Number", Policy_Number);
        report.addResult("Account_Name", Account_Name);
        report.addResult("Address_line1", Address_line1);
        report.addResult("City", city);
        report.addResult("State", State);
        report.addResult("Zip_Code", Zip_Code);
        report.addResult("Policy_Amount", Policy_Amount);
        report.addResult("Account_Number", Account_Number);
        report.addResult("PremiumMatch_Status", PremiumMatch_Status);
        report.addResult("PDF_Name", fileName);
        report.addResult("Result", result.get("result"));
        report.addResult("ValidationMessage", result.get("finalvldmsg"));

//       *******************Getting vehicle1 collision and comprehensive details*******************
        System.out.println("vehicle1 collision and comprehensive verifications");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("vehicleLink")))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("vehicleOne")))).click();
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                String valueVIN = driver.findElement(By.xpath(OR.getObjectProperty("vin"))).getAttribute("value");
                return valueVIN.equalsIgnoreCase(inputData.getColumnData("vehicle1VIN"));
            }
        });
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("vehicleCoverage")))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("collision"))));
        String CollisionVehicle1 = driver.findElement(By.xpath(OR.getObjectProperty("collision"))).getText();
        String ComprehensiveVehicle1 = driver.findElement(By.xpath(OR.getObjectProperty("comprehensive"))).getText();
        System.out.println("CollisionVehicle1=" + CollisionVehicle1);
        System.out.println("ComprehensiveVehicle1=" + ComprehensiveVehicle1);
        report.addResult("CollisionVehicle1", CollisionVehicle1);
        report.addResult("ComprehensiveVehicle1", ComprehensiveVehicle1);

        
        
        
        
      //  report.addResult("poltu", "testing");
        
        
        
       
        
        
        
        String statusCollisionVehicle1;
        String statusComprehensiveVehicle1;
        Double dCollisionVehicle1 = Double.parseDouble(CollisionVehicle1);
        Double dReqCollisionVehicle1 = Double.parseDouble(inputData.getColumnData("collision"));
        if (dCollisionVehicle1.equals(dReqCollisionVehicle1)) {
            statusCollisionVehicle1 = "PASS";
        } else {
            statusCollisionVehicle1 = "FAIL";
        }

        Double dComprehensiveVehicle1 = Double.parseDouble(ComprehensiveVehicle1);
        Double dReqComprehensiveVehicle1 = Double.parseDouble(inputData.getColumnData("comprehensive"));
        if (dComprehensiveVehicle1.equals(dReqComprehensiveVehicle1)) {
            statusComprehensiveVehicle1 = "PASS";
        } else {
            statusComprehensiveVehicle1 = "FAIL";
        }
        report.addResult("statusCollisionVehicle1", statusCollisionVehicle1);
        report.addResult("statusComprehensiveVehicle1", statusComprehensiveVehicle1);

//        *******************Getting vehicle2 collision and comprehensive details*******************
        System.out.println("vehicle2 collision and comprehensive verifications");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("vehicleLink")))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("vehicleTwo")))).click();
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                String valueVIN = driver.findElement(By.xpath(OR.getObjectProperty("vin"))).getAttribute("value");
                return valueVIN.equalsIgnoreCase(inputData.getColumnData("vehicle2VIN"));
            }
        });
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("vehicleCoverage")))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("collision"))));
        String CollisionVehicle2 = driver.findElement(By.xpath(OR.getObjectProperty("collision"))).getText();
        String ComprehensiveVehicle2 = driver.findElement(By.xpath(OR.getObjectProperty("comprehensive"))).getText();
        System.out.println("CollisionVehicle2=" + CollisionVehicle2);
        System.out.println("ComprehensiveVehicle2=" + ComprehensiveVehicle2);
        
       
        report.addResult("CollisionVehicle2", CollisionVehicle2);
        report.addResult("ComprehensiveVehicle2", ComprehensiveVehicle2);

        String statusCollisionVehicle2;
        String statusComprehensiveVehicle2;
        Double dCollisionVehicle2 = Double.parseDouble(CollisionVehicle2);
        Double dReqCollisionVehicle2 = Double.parseDouble(inputData.getColumnData("collisionVehicle2"));
        if (dCollisionVehicle2.equals(dReqCollisionVehicle2)) {
            statusCollisionVehicle2 = "PASS";
        } else {
            statusCollisionVehicle2 = "FAIL";
        }

        Double dComprehensiveVehicle2 = Double.parseDouble(ComprehensiveVehicle2);
        Double dReqComprehensiveVehicle2 = Double.parseDouble(inputData.getColumnData("comprehensiveVehicle2"));
        if (dComprehensiveVehicle2.equals(dReqComprehensiveVehicle2)) {
            statusComprehensiveVehicle2 = "PASS";
        } else {
            statusComprehensiveVehicle2 = "FAIL";
        }
        report.addResult("statusCollisionVehicle2", statusCollisionVehicle2);
        report.addResult("statusComprehensiveVehicle2", statusComprehensiveVehicle2);

        
//      *******************Getting vehicle3 collision and comprehensive details*******************
        System.out.println("vehicle3 collision and comprehensive verifications");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("vehicleLink")))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("vehicleThree")))).click();
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                String valueVIN = driver.findElement(By.xpath(OR.getObjectProperty("vin"))).getAttribute("value");
                return valueVIN.equalsIgnoreCase(inputData.getColumnData("vehicle3VIN"));
            }
        });
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("vehicleCoverage")))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("collision"))));
        String CollisionVehicle3 = driver.findElement(By.xpath(OR.getObjectProperty("collision"))).getText();
        String ComprehensiveVehicle3 = driver.findElement(By.xpath(OR.getObjectProperty("comprehensive"))).getText();
        System.out.println("CollisionVehicle3=" + CollisionVehicle3);
        System.out.println("ComprehensiveVehicle3=" + ComprehensiveVehicle3);
        report.addResult("CollisionVehicle3", CollisionVehicle3);
        report.addResult("ComprehensiveVehicle3", ComprehensiveVehicle3);
        

        String statusCollisionVehicle3;
        String statusComprehensiveVehicle3;
        Double dCollisionVehicle3 = Double.parseDouble(CollisionVehicle1);
        Double dReqCollisionVehicle3 = Double.parseDouble(inputData.getColumnData("collisionVehicle3"));
        if (dCollisionVehicle3.equals(dReqCollisionVehicle3)) {
            statusCollisionVehicle3 = "PASS";
        } else {
            statusCollisionVehicle3 = "FAIL";
        }

        Double dComprehensiveVehicle3 = Double.parseDouble(ComprehensiveVehicle3);
        Double dReqComprehensiveVehicle3 = Double.parseDouble(inputData.getColumnData("comprehensiveVehicle3"));
        if (dComprehensiveVehicle3.equals(dReqComprehensiveVehicle3)) {
            statusComprehensiveVehicle3 = "PASS";
        } else {
            statusComprehensiveVehicle3 = "FAIL";
        }
        report.addResult("statusCollisionVehicle3", statusCollisionVehicle3);
        report.addResult("statusComprehensiveVehicle3", statusComprehensiveVehicle3);

        System.out.println("Final reporting");
        report.updateReportFile();
        
        
        System.out.println("Script Ends");
        driver.quit();
} 
      
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
    }
    @Override
    protected void writeString(String str, List<TextPosition> textPositions) throws IOException {
   		lines.add(str);	
   		
   	}
}
