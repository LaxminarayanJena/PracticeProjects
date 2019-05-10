package Scripts;

import Resources.*;
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
import java.text.DateFormat;
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

/**
 * Created by agarwalp on 6/19/2017.
 */
public class CV_Endorsement {


    WebDriver driver;

    @Test
    @Parameters({"iterationNumber",})
    public void test(@Optional("1") int iterationNumber) throws InterruptedException, Exception {
        InputData inputData = new InputData(INPUT_DATA_PATH, "CV_Endorsement", iterationNumber);
        String policyState = inputData.getColumnData("StateCode");
        InputData policyData = new InputData(REPORT_PATH, "Results", "State", policyState);
        System.out.println(policyData.getColumnData("Policy_Number"));
        Report report = new Report(REPORT_PATH, "endorsement");
        report.addResult("Policy_Number", policyData.getColumnData("Policy_Number"));
        ObjectRepository OR = new ObjectRepository();

//        *********************Loading Chrome Browser**********************
//        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
//        driver = new ChromeDriver();

//        *********************Loading PhantomJS Browser*********************
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

//        *******************Searching for required Policy*******************
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("searchByPolicySearch"))));
        WebElement searchByPolicySearchDropdown = driver.findElement(By.xpath(OR.getObjectProperty("searchByPolicySearch")));
        Select searchByPolicySearch = new Select(searchByPolicySearchDropdown);
        searchByPolicySearch.selectByValue(inputData.getColumnData("SearchBy"));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("searchByCriteria"))));
        WebElement searchByCriteriaDropdown = driver.findElement(By.xpath(OR.getObjectProperty("searchByCriteria")));
        Select searchByCriteria = new Select(searchByCriteriaDropdown);
        searchByCriteria.selectByValue(inputData.getColumnData("SearchByCriteria"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("searchByValue"))));
        driver.findElement(By.xpath(OR.getObjectProperty("searchByValue"))).sendKeys(policyData.getColumnData("Policy_Number"));
        driver.findElement(By.xpath(OR.getObjectProperty("searchRefresh"))).click();

//        *******************Clicks on Endorse*******************
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("endorseLink"))));
        System.out.println("Policy search result successful");

//        *******************Filling Endorsement details*******************
        String strEffectiveDate = driver.findElement(By.xpath(OR.getObjectProperty("policyEffectiveDate"))).getText();
        System.out.println("strEffectiveDate=" + strEffectiveDate);
        String dayAddStr = inputData.getColumnData("EndDayValue");
        int dayAdd = Integer.parseInt(dayAddStr);
//      Selecting Date format
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String dateInString = strEffectiveDate;
        String endEffectiveDate = null;
        try {
            System.out.println("************");
            Date date = formatter.parse(dateInString);
//           Date
            System.out.println(date);
            System.out.println(formatter.format(date));
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.DATE, dayAdd);
            Date requiredDate = c.getTime();
            System.out.println(formatter.format(requiredDate));
            endEffectiveDate = formatter.format(requiredDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath(OR.getObjectProperty("endorseLink"))).click();
        RSLibraryFile.waitForPopUpToOpen(driver);
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("endorsementEffectiveDate"))));
        driver.findElement(By.xpath(OR.getObjectProperty("endorsementEffectiveDate"))).sendKeys(endEffectiveDate);
        driver.findElement(By.xpath(OR.getObjectProperty("endorsementComments"))).sendKeys(inputData.getColumnData("EndorsementComments"));
        driver.findElement(By.xpath(OR.getObjectProperty("endorsementOk"))).click();
        RSLibraryFile.waitForPopUpToClose(driver);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(OR.getObjectProperty("endorseLink"))));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("rate"))));

//       *****************Adding Garage for CA State**********************
        if (inputData.getColumnData("StateCode").equalsIgnoreCase("CA")) {
            System.out.println("Adding New Garage 2");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("garages")))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("newGarage")))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("copyPrimaryAddress"))));
            driver.findElement(By.xpath((OR.getObjectProperty("garageAddressLine1")))).sendKeys(inputData.getColumnData("NewGarageAddressLine1"));
            driver.findElement(By.xpath((OR.getObjectProperty("garageCity")))).sendKeys(inputData.getColumnData("NewGarageCity"));
            WebElement garageStateDropdown = driver.findElement(By.xpath(OR.getObjectProperty("garageState")));
            Select garageState = new Select(garageStateDropdown);
            garageState.selectByValue(inputData.getColumnData("NewGarageState"));
            driver.findElement(By.xpath((OR.getObjectProperty("garageZipcode")))).clear();
            driver.findElement(By.xpath((OR.getObjectProperty("garageZipcode")))).sendKeys(inputData.getColumnData("NewGarageZipCode"));
            WebElement garageCountryDropdown = driver.findElement(By.xpath(OR.getObjectProperty("garageCountry")));
            Select garageCountry = new Select(garageCountryDropdown);
            garageCountry.selectByValue(inputData.getColumnData("NewGarageCountry"));
            driver.findElement(By.xpath((OR.getObjectProperty("saveGarage")))).click();
            System.out.println("Save New Garage");
            RSLibraryFile.waitForPopUpToOpen(driver);
            driver.findElement(By.xpath(OR.getObjectProperty("chooseAddress1"))).click();
            System.out.println("Validated Garage2 Address");
            RSLibraryFile.waitForPopUpToClose(driver);
        }

//          ***************Adding vehicle for CA State*************************
        if (inputData.getColumnData("StateCode").equalsIgnoreCase("CA")) {
            driver.manage().timeouts().implicitlyWait(3L, TimeUnit.MINUTES);
            System.out.println("Adding Vehicle4");
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("vehicle")))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("newVehicle")))).click();
            WebElement vehicleYearDropdown = driver.findElement(By.xpath(OR.getObjectProperty("vehicleYear")));
            Select vehicleYear = new Select(vehicleYearDropdown);
            vehicleYear.selectByVisibleText(inputData.getColumnData("VehicleYear"));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("vehicleMake1"))));
            WebElement vehicleMakeDropdown = driver.findElement(By.xpath((OR.getObjectProperty("vehicleMake"))));
            Select vehicleMake = new Select(vehicleMakeDropdown);
            vehicleMake.selectByVisibleText(inputData.getColumnData("VehicleMake"));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("vehicleModel1"))));
            WebElement vehicleModelDropdown = driver.findElement(By.xpath((OR.getObjectProperty("vehicleModel"))));
            Select vehicleModel = new Select(vehicleModelDropdown);
            vehicleModel.selectByIndex(28);
            wait.until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver driver) {
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("agreedValue"))));
                    String strAgreedValue = driver.findElement(By.xpath(OR.getObjectProperty("agreedValue"))).getAttribute("value");
                    if (!strAgreedValue.equalsIgnoreCase(inputData.getColumnData("VehicleAgreedvalue"))) {
                        driver.findElement(By.xpath(OR.getObjectProperty("agreedValue"))).clear();
                        driver.findElement(By.xpath(OR.getObjectProperty("agreedValue"))).sendKeys(inputData.getColumnData("VehicleAgreedvalue"));
                    } else {
                        String strAgreedValueCheck = driver.findElement(By.xpath(OR.getObjectProperty("agreedValue"))).getAttribute("value");
                        return strAgreedValueCheck.equalsIgnoreCase(inputData.getColumnData("VehicleAgreedvalue"));
                    }
                    return false;
                }
            });
            WebElement vehicleTypeDropdown = driver.findElement(By.xpath((OR.getObjectProperty("vehicleType"))));
            Select vehicleType = new Select(vehicleTypeDropdown);
            vehicleType.selectByIndex(3);
            Thread.sleep(1000);
            wait.until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver driver) {
                    try {
                        WebElement vehicleModificationTypeDropdown = driver.findElement(By.xpath((OR.getObjectProperty("modificationType"))));
                        Select vehicleModificationType = new Select(vehicleModificationTypeDropdown);
                        vehicleModificationType.selectByIndex(3);
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                }
            });
            WebElement vehicleGarageLocationDropdown = driver.findElement(By.xpath((OR.getObjectProperty("garagingLocation"))));
            Select vehicleGarageLocation = new Select(vehicleGarageLocationDropdown);
            vehicleGarageLocation.selectByIndex(1);
            Thread.sleep(2000);
            driver.findElement(By.xpath(OR.getObjectProperty("vin"))).sendKeys(inputData.getColumnData("vehicleVIN"));
            WebElement vehiclePrimaryUseDropdown = driver.findElement(By.xpath((OR.getObjectProperty("primaryUse"))));
            Select vehiclePrimaryUse = new Select(vehiclePrimaryUseDropdown);
            vehiclePrimaryUse.selectByIndex(5);
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
//            Adding Vehicle questions
            driver.findElement(By.xpath((OR.getObjectProperty("vehicleRegisteredNo")))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("AnnualMilageRange"))));
            WebElement vehicleAnnualMilageRangeDropdown = driver.findElement(By.xpath((OR.getObjectProperty("AnnualMilageRange"))));
            Select vehicleAnnualMilageRange = new Select(vehicleAnnualMilageRangeDropdown);
            vehicleAnnualMilageRange.selectByValue(inputData.getColumnData("AnnualMilageRange"));
            if (inputData.getColumnData("StateCode").equalsIgnoreCase("NC")) {
                WebElement factoryInstalledAirbagsDropdown = driver.findElement(By.xpath(OR.getObjectProperty("factoryInstalledAirbags")));
                Select factoryInstalledAirbags = new Select(factoryInstalledAirbagsDropdown);
                factoryInstalledAirbags.selectByValue(inputData.getColumnData("FactoryInstalledAirbags"));
            } else if (inputData.getColumnData("StateCode").equalsIgnoreCase("PA")) {
                WebElement passiveRegistrantSystemDropdown = driver.findElement(By.xpath(OR.getObjectProperty("passiveResistantSystem")));
                Select passiveRegistrantSystem = new Select(passiveRegistrantSystemDropdown);
                passiveRegistrantSystem.selectByValue(inputData.getColumnData("PassiveResistantSystem"));
            } else {
            }
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("saveVehicle")))).click();
            System.out.println("Saved Vehicle4");
        }

//      ******************Deleting vehicle for NC and KY state******************
        if (inputData.getColumnData("StateCode").equalsIgnoreCase("NC") || inputData.getColumnData("StateCode").equalsIgnoreCase("PA")) {
            WebElement vehicleToBeDelete = null;
            String vehicleYearToBeDeleted = inputData.getColumnData("DeleteVehicleYear");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("vehicleLink")))).click();
            switch (vehicleYearToBeDeleted) {
                case "2002":
                    vehicleToBeDelete = driver.findElement(By.xpath((OR.getObjectProperty("vehicleOne"))));
                    System.out.println("2002 year Vehicle1 to be deleted");
                    break;
                case "1966":
                    vehicleToBeDelete = driver.findElement(By.xpath((OR.getObjectProperty("vehicleTwo"))));
                    System.out.println("1966 year Vehicle2 to be deleted");
                    break;
                case "1941":
                    vehicleToBeDelete = driver.findElement(By.xpath((OR.getObjectProperty("vehicleThree"))));
                    System.out.println("1941 year Vehicle3 to be deleted");
                    break;
                default:
                    System.out.println("Invalid Vehicle Year");
                    throw new IllegalArgumentException("The required year vehicle does not exist=" + vehicleYearToBeDeleted);
            }
            driver.manage().timeouts().implicitlyWait(3L, TimeUnit.MINUTES);
            wait.until(ExpectedConditions.visibilityOf(vehicleToBeDelete));
            vehicleToBeDelete.click();
            wait.until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver driver) {
                    Boolean matches = false;
                    Boolean displayed = false;
                    if (vehicleYearToBeDeleted.equalsIgnoreCase("1941")) {
                        displayed = driver.findElement(By.xpath((OR.getObjectProperty("endDeleteVehicleActualYear")))).isDisplayed();
                        matches = driver.findElement(By.xpath((OR.getObjectProperty("endDeleteVehicleActualYear")))).getAttribute("value").equalsIgnoreCase(vehicleYearToBeDeleted);
                    } else {
                        WebElement vehicleYear = driver.findElement(By.xpath(OR.getObjectProperty("endDeleteVehicleActualYearDropdown")));
                        Select vehicleYearDropdown = new Select(vehicleYear);
                        displayed = vehicleYear.isDisplayed();
                        matches = vehicleYearDropdown.getFirstSelectedOption().getAttribute("value").equalsIgnoreCase(vehicleYearToBeDeleted);
                    }
                    return displayed && matches;
                }
            });
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("vehicleCoverage"))));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("deleteVehicle")))).click();
//            Vehicle2 deleted
            wait.until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver driver) {
                    List<WebElement> webElements = driver.findElements(By.xpath(OR.getObjectProperty("vehicle2Tab")));
                    Boolean elementExist = webElements.size() != 0;
                    return elementExist;
                }
            });
        }

//      *****************Delete collision value of vehicle for KY state*****************
        if (inputData.getColumnData("StateCode").equalsIgnoreCase("KY")) {
            WebElement vehicleToBeSelected = null;
            System.out.println("Number of vehicles=" + inputData.getColumnData("NumberOfVehicle"));
            int numVeh = Integer.parseInt(inputData.getColumnData("NumberOfVehicle"));
            for (int itrVehicle = 1; itrVehicle <= numVeh; itrVehicle++) {
                String vehicleYearToBeDeleted = inputData.getColumnData("vehicle" + itrVehicle + "Year");
                switch (vehicleYearToBeDeleted) {
                    case "2002":
                        vehicleToBeSelected = driver.findElement(By.xpath((OR.getObjectProperty("deleteVehicleOne"))));
                        System.out.println("2002 year Vehicle1 to be deleted");
                        break;
                    case "1966":
                        vehicleToBeSelected = driver.findElement(By.xpath((OR.getObjectProperty("deleteVehicleTwo"))));
                        System.out.println("1966 year Vehicle2 to be deleted");
                        break;
                    case "1941":
                        vehicleToBeSelected = driver.findElement(By.xpath((OR.getObjectProperty("deleteVehicleThree"))));
                        System.out.println("1941 year Vehicle3 to be deleted");
                        break;
                    default:
                        System.out.println("Invalid Vehicle Year");
                        throw new IllegalArgumentException("The required year vehicle does not exist=" + vehicleYearToBeDeleted);
                }
                driver.manage().timeouts().implicitlyWait(3L, TimeUnit.MINUTES);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("vehicleLink")))).click();
                wait.until(ExpectedConditions.visibilityOf(vehicleToBeSelected));
                vehicleToBeSelected.click();
                wait.until(new ExpectedCondition<Boolean>() {
                    @Override
                    public Boolean apply(WebDriver driver) {
                        Boolean matches = false;
                        Boolean displayed = false;
                        if (vehicleYearToBeDeleted.equalsIgnoreCase("1941")) {
                            displayed = driver.findElement(By.xpath((OR.getObjectProperty("endDeleteVehicleActualYear")))).isDisplayed();
                            matches = driver.findElement(By.xpath((OR.getObjectProperty("endDeleteVehicleActualYear")))).getAttribute("value").equalsIgnoreCase(vehicleYearToBeDeleted);
                        } else {
                            WebElement vehicleYear = driver.findElement(By.xpath(OR.getObjectProperty("endDeleteVehicleActualYearDropdown")));
                            Select vehicleYearDropdown = new Select(vehicleYear);
                            displayed = vehicleYear.isDisplayed();
                            matches = vehicleYearDropdown.getFirstSelectedOption().getAttribute("value").equalsIgnoreCase(vehicleYearToBeDeleted);
                        }
                        return displayed && matches;
                    }
                });
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("vehicleCoverage")))).click();
                wait.until(new ExpectedCondition<Boolean>() {
                    @Override
                    public Boolean apply(WebDriver driver) {
                        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("edit"))));
                        driver.findElement(By.xpath((OR.getObjectProperty("edit")))).click();
                        List<WebElement> webElements = driver.findElements(By.xpath(OR.getObjectProperty("savePolicy")));
                        Boolean elementExist = webElements.size() != 0;
                        return elementExist;
                    }
                });
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("deleteIcon")))).click();
                wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath(OR.getObjectProperty("deleteIcon")))));
                wait.until(new ExpectedCondition<Boolean>() {
                    @Override
                    public Boolean apply(WebDriver driver) {
                        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("savePolicy"))));
                        driver.findElement(By.xpath((OR.getObjectProperty("savePolicy")))).click();
                        List<WebElement> webElements = driver.findElements(By.xpath(OR.getObjectProperty("edit")));
                        Boolean elementExist = webElements.size() != 0;
                        return elementExist;
                    }
                });
            }
        }

//      ******************Rating the Policy************************
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("rate")))).click();
        System.out.println("Rate***********");

//       ******************Overriding CV error******************
        Date endorsementEffectiveDateFormat = formatter.parse(endEffectiveDate);
        Date todayDate = new Date();
        long dateDifferenceInMs = endorsementEffectiveDateFormat.getTime() - todayDate.getTime();
        long daysDifference = TimeUnit.DAYS.convert(dateDifferenceInMs, TimeUnit.MILLISECONDS);
        System.out.println("endorsementEffectiveDateFormat=" + endorsementEffectiveDateFormat);
        System.out.println("dateDifferenceInMs=" + dateDifferenceInMs);
        System.out.println("daysDifference=" + daysDifference);
        if (daysDifference >= 60) {
            List<WebElement> buttons = driver.findElements(By.xpath(OR.getObjectProperty("buttons")));
            System.out.print("no of buttons are " + buttons.size() + "-----");
            for (int i = 0; i < buttons.size(); i++) {
                String imgID = buttons.get(i).getAttribute("id");
                System.out.println("imgID=" + imgID);
                //      Added Sync
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
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("rate")))).click();
        }

//       *****************Quoting the Policy******************
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("quote")))).click();
        System.out.println("Quote**********");

//       *****************Binding the Policy******************
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("bind")))).click();
        System.out.println("Bind**********");

//       ****************Overriding CV message for CA state*******************
        if (inputData.getColumnData("StateCode").equalsIgnoreCase("CA")) {
            List<WebElement> buttons = driver.findElements(By.xpath(OR.getObjectProperty("buttons")));
            System.out.print("no of buttons are " + buttons.size() + "-----");
            for (int i = 0; i < buttons.size(); i++) {
                String imgID = buttons.get(i).getAttribute("id");
                System.out.println("imgID=" + imgID);
                //      Added Sync
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
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("bind")))).click();
        }

//      ****************Issuing the Policy*********************
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

//        ****************OOS of 1 month for PA state************************
        if (inputData.getColumnData("StateCode").equalsIgnoreCase("PA")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("endorseLink"))));
            String strFirstEndorsementEffectiveDate = driver.findElement(By.xpath(OR.getObjectProperty("PolicySumaryTransactionEffectiveDate"))).getText();
            System.out.println("strFirstEndorsementEffectiveDate=" + strFirstEndorsementEffectiveDate);
            String dayUpdateStr = inputData.getColumnData("OOSEndDayValue");
            int dayUpdate = Integer.parseInt(dayUpdateStr);
//            Formatting the date
            SimpleDateFormat formatterOOS = new SimpleDateFormat("MM/dd/yyyy");
            String dateInStringOOS = strFirstEndorsementEffectiveDate;
            String endOOSEffectiveDate = null;
            try {
                System.out.println("************");
                Date date = formatterOOS.parse(dateInStringOOS);
//              Date.
                System.out.println(date);
                System.out.println(formatterOOS.format(date));
                Calendar c = Calendar.getInstance();
                c.setTime(date);
                c.add(Calendar.MONTH, dayUpdate);
                Date requiredOOSDate = c.getTime();
                System.out.println(formatterOOS.format(requiredOOSDate));
                endOOSEffectiveDate = formatterOOS.format(requiredOOSDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            driver.findElement(By.xpath(OR.getObjectProperty("endorseLink"))).click();
            RSLibraryFile.waitForPopUpToOpen(driver);

//          *************Filling OOS Endorsement Details*****************************
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("endorsementEffectiveDate"))));
            Thread.sleep(1000);
            driver.findElement(By.xpath(OR.getObjectProperty("endorsementEffectiveDate"))).sendKeys(endOOSEffectiveDate);
            driver.findElement(By.xpath(OR.getObjectProperty("endorsementComments"))).sendKeys(inputData.getColumnData("EndorsementComments"));
            driver.findElement(By.xpath(OR.getObjectProperty("endorsementOk"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("endorsementOOSLabel"))));
            driver.findElement(By.xpath(OR.getObjectProperty("okButton"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("rate"))));

//          ************Adding Additional Interest********************
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("policyInfo"))));
            driver.findElement(By.xpath(OR.getObjectProperty("policyInfo"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("addInterestLink"))));
            driver.findElement(By.xpath(OR.getObjectProperty("addInterestLink"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("addInterest"))));
            driver.findElement(By.xpath(OR.getObjectProperty("addInterest"))).click();
            System.out.println("Selected Policy Info and adding additional Insured");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("addInterestType"))));
            WebElement addInterestType = driver.findElement(By.xpath(OR.getObjectProperty("addInterestType")));
            Select dropdownAddInterestType = new Select(addInterestType);
            dropdownAddInterestType.selectByValue(inputData.getColumnData("addInterestType"));
            driver.findElement(By.xpath(OR.getObjectProperty("addInterestName"))).sendKeys(inputData.getColumnData("addInterestName"));
            driver.findElement(By.xpath(OR.getObjectProperty("addInterestAddressLine1"))).sendKeys(inputData.getColumnData("addInterestAddressLine1"));
            driver.findElement(By.xpath(OR.getObjectProperty("addInterestCity"))).sendKeys(inputData.getColumnData("addInterestCity"));
            WebElement addInterestState = driver.findElement(By.xpath(OR.getObjectProperty("addInterestState")));
            Select dropdownAddInterestState = new Select(addInterestState);
            dropdownAddInterestState.selectByValue(inputData.getColumnData("addInterestState"));
            driver.findElement(By.xpath(OR.getObjectProperty("addInterestZip"))).sendKeys(inputData.getColumnData("addInterestZip"));
            WebElement addInterestCountry = driver.findElement(By.xpath(OR.getObjectProperty("addInterestCountry")));
            Select dropdownAddInterestCountry = new Select(addInterestCountry);
            dropdownAddInterestCountry.selectByValue(inputData.getColumnData("addInterestCountry"));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("save"))));
            driver.findElement(By.xpath(OR.getObjectProperty("save"))).click();
            System.out.println("Saved Additional Insured");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("addInsuredPopUpHeader"))));
            driver.findElement(By.xpath(OR.getObjectProperty("validateAccountAddress"))).click();
            System.out.println("Validated Additional Insured Address");
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("addInterest"))));

//           **************Rating the Policy******************
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("rate")))).click();
            System.out.println("Rate***********");

//           **************Quoting the Policy******************
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getObjectProperty("quote")))).click();
            System.out.println("Quote**********");

//           **************Binding the Policy******************
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getObjectProperty("bind")))).click();
            System.out.println("Bind**********");

//           **************Issuing the Policy******************
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
        }

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
        System.out.println("End_Status=" + policy_Status);
        System.out.println("End_Comments=" + inputData.getColumnData("EndorsementComments"));
        System.out.println("PremiumMatch_Status=" + PremiumMatch_Status);

//      *********************Reporting************************
        report.addResult("Total_Premium", Policy_Amount);
        report.addResult("Transaction_Effective_Date", transactionEffectiveDate);
        report.addResult("Policy_Effective_Date", policy_EffectiveDate);
        report.addResult("Policy_Expiration_Date", policy_ExpirationDate);
        report.addResult("End_Status", policy_Status);
        report.addResult("Endorsement_Comments", inputData.getColumnData("EndorsementComments"));
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
