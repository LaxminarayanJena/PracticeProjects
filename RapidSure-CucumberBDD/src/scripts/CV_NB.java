/*============================================================
'Description : CV_NB
'Author : Laxminarayan Jena
'Date Created : Feb 02, 2017
'Last Date Modified : Feb, 15 ,2017
'Modified by : Laxminarayan Jena
'==================================================================== */

package scripts;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CV_NB extends Utility {

	WebDriver driver = Utility.getDriver();

	static Properties config;

	public void configSetup() throws Exception {
		Utility.nologs();
		config = Utility.prop();

	}

	@Before
	public void setUp() throws Exception {

		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);

	}

	@After
	public void tearDown(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
			captureScreenshot();
		}
	}

	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		driver.get(config.getProperty("url"));

	}

	@When("^User enters email and password$")
	public void user_enters_email_and_password() throws Throwable {

		WebElement element = driver.findElement(By.id(config.getProperty("login")));
		element.clear();
		element.sendKeys(config.getProperty("username"));
		driver.findElement(By.id(config.getProperty("password"))).sendKeys(config.getProperty("pwd"));

	}

	@When("^User clicks on signin$")
	public void user_clicks_on_signin() throws Throwable {

		WebElement element1 = driver.findElement(By.id(config.getProperty("password")));
		element1.submit();

	}

	@Then("^the page title should be \"([^\"]*)\"$")
	public void the_page_title_should_be(String expected) throws Throwable {

		// Assert.assertEquals(expected, driver.getTitle());

	}

	@When("^User clicks on New Account$")
	public void user_clicks_on_New_Account() throws Throwable {

		driver.findElement(By.xpath((config.getProperty("NewAccount")))).click();

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(config.getProperty("accountname"))));

	}

	@When("^User enters account name$")
	public void user_enters_account_name() throws Throwable {
		String accountname = excel2.getCellData("CV_NB", "AccountName", 2);
		driver.findElement(By.xpath((config.getProperty("accountname")))).sendKeys(accountname);

	}

	@When("^User enters line(\\d+)$")
	public void user_enters_line(int arg1) throws Throwable {
		String line1 = excel2.getCellData("CV_NB", "Line1", 2);
		driver.findElement(By.xpath((config.getProperty("line1")))).sendKeys(line1);

	}

	@When("^User enters city$")
	public void user_enters_city() throws Throwable {
		String city = excel2.getCellData("CV_NB", "city", 2);
		driver.findElement(By.xpath((config.getProperty("city")))).sendKeys(city);
	}

	@When("^User select state$")
	public void user_select_state() throws Throwable {

		String state = excel2.getCellData("CV_NB", "state", 2);

		WebElement dropdown = driver.findElement(By.xpath((config.getProperty("state"))));
		Select select = new Select(dropdown);
		select.selectByValue(state);
	}

	@When("^User enters zipcode$")
	public void user_enters_zipcode() throws Throwable {

		String zipcode = excel2.getCellData("CV_NB", "zipcode", 2);
		driver.findElement(By.xpath((config.getProperty("zipcode")))).sendKeys(zipcode);
	}

	@When("^User select target Product$")
	public void user_select_target_Product() throws Throwable {

		String targetproduct = excel2.getCellData("CV_NB", "targetproduct", 2);
		WebElement dropdown = driver.findElement(By.xpath((config.getProperty("targetproduct"))));
		Select select = new Select(dropdown);
		select.selectByValue(targetproduct);

	}

	@When("^User clicks on save account$")
	public void user_clicks_on_save_account() throws Throwable {
		driver.findElement(By.xpath((config.getProperty("saveaccount")))).click();

	}

	@When("^user clicks on Validate and standardize account address$")
	public void user_clicks_on_Validate_and_standardize_account_address() throws Throwable {

		driver.findElement(By.xpath((config.getProperty("validateaccountaddress")))).click();

	}

	@Then("^user should be able to see \"([^\"]*)\" message Sucessfully$")
	public void user_should_be_able_to_see_message_Sucessfully(String expected) throws Throwable {

		// Assert.assertTrue(driver.findElement(By.xpath("//tr[2]/td/div/ul/li/span")).getText().contains(expected));
	}

	@When("^User clicks on Contact$")
	public void user_clicks_on_Contact() throws Throwable {

		WebDriverWait wait = new WebDriverWait(driver, 60);

		try {
			driver.findElement(By.xpath((config.getProperty("Contacts")))).click();
			driver.findElement(By.xpath((config.getProperty("newcontact")))).click();

		} catch (Exception e) {

			driver.findElement(By.xpath((config.getProperty("bullet_add")))).click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(config.getProperty("duplicate")))).click();
			// Thread.sleep(2000);
			// driver.findElement(By.xpath((config.getProperty("duplicate")))).click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(config.getProperty("newcontact")))).click();

			// driver.findElement(By.xpath((config.getProperty("newcontact")))).click();
			// Thread.sleep(2000L);
		}

	}

	@When("^User clicks on Create new contact$")
	public void user_clicks_on_Create_new_contact() throws Throwable {

	}

	@When("^User enters first name$")
	public void user_enters_first_name() throws Throwable {

		Thread.sleep(1000);
		String firstname = excel2.getCellData("CV_NB", "firstname", 2);
		driver.findElement(By.xpath((config.getProperty("firstname")))).sendKeys(firstname);

	}

	@When("^User enters last name$")
	public void user_enters_last_name() throws Throwable {

		String lastname = excel2.getCellData("CV_NB", "lastname", 2);
		driver.findElement(By.xpath((config.getProperty("lastname")))).sendKeys(lastname);
	}

	@When("^User enters address line(\\d+)$")
	public void user_enters_address_line(int arg1) throws Throwable {
		String addressline = excel2.getCellData("CV_NB", "addressline", 2);
		driver.findElement(By.xpath((config.getProperty("addressline")))).sendKeys(addressline);

	}

	@When("^User enters contactcity$")
	public void user_enters_contactcity() throws Throwable {
		String contactcity = excel2.getCellData("CV_NB", "contactcity", 2);
		driver.findElement(By.xpath((config.getProperty("contactcity")))).sendKeys(contactcity);

	}

	@When("^User select contactstate$")
	public void user_select_contactstate() throws Throwable {

		String contactstate = excel2.getCellData("CV_NB", "contactstate", 2);
		WebElement dropdown = driver.findElement(By.xpath((config.getProperty("contactstate"))));
		Select select = new Select(dropdown);
		select.selectByValue(contactstate);

	}

	@When("^User enters contactzipcode$")
	public void user_enters_contactzipcode() throws Throwable {
		String contactzipcode = excel2.getCellData("CV_NB", "contactzipcode", 2);
		driver.findElement(By.xpath((config.getProperty("contactzipcode")))).sendKeys(contactzipcode);
	}

	@When("^User enters phone number$")
	public void user_enters_phone_number() throws Throwable {

		String phoneno = excel2.getCellData("CV_NB", "phoneno", 2);
		driver.findElement(By.xpath((config.getProperty("phoneno")))).sendKeys(phoneno);

	}

	@When("^User save contact$")
	public void user_save_contact() throws Throwable {

		driver.findElement(By.xpath((config.getProperty("savecontact")))).click();
	}

	@When("^user clicks on Validate and standardize contact address$")
	public void user_clicks_on_Validate_and_standardize_contact_address() throws Throwable {
		driver.findElement(By.xpath((config.getProperty("chooseaddress1")))).click();
		Thread.sleep(3000L);

		driver.findElement(By.xpath((config.getProperty("chooseaddress2")))).click();
	}

	@Then("^user should be able to see \"([^\"]*)\"(\\d+)\"([^\"]*)\" message Sucessfully$")
	public void user_should_be_able_to_see_message_Sucessfully(String arg1, int arg2, String arg3) throws Throwable {

	}

	@Then("^user clicks on \"([^\"]*)\"(\\d+)\"([^\"]*)\" message$")
	public void user_clicks_on_message(String arg1, int arg2, String arg3) throws Throwable {

		Thread.sleep(2000L);
		driver.findElement(By.xpath((config.getProperty("useaccount")))).click();
	}

	@Then("^user checks customer Service, Endorsement,Loss Control, Policy$")
	public void user_checks_customer_Service_Endorsement_Loss_Control_Policy() throws Throwable {

		driver.findElement(By.xpath((config.getProperty("customerservice")))).click();
		driver.findElement(By.xpath((config.getProperty("endorsement")))).click();
		driver.findElement(By.xpath((config.getProperty("losscontrol")))).click();
		driver.findElement(By.xpath((config.getProperty("policy")))).click();

	}

	@Then("^user clicks on Done$")
	public void user_clicks_on_Done() throws Throwable {

		driver.findElement(By.xpath((config.getProperty("done")))).click();
	}

	@Then("^New window will appear for filling policy details$")
	public void new_window_will_appear_for_filling_policy_details() throws Throwable {

	}

	@Then("^user select state of registration$")
	public void user_select_state_of_registration() throws Throwable {

		String stateofreg = excel2.getCellData("CV_NB", "stateofreg", 2);
		WebElement dropdown = driver.findElement(By.xpath((config.getProperty("stateofreg"))));
		Select select = new Select(dropdown);
		select.selectByValue(stateofreg);

	}

	@Then("^user clicks on OK$")
	public void user_clicks_on_OK() throws Throwable {

		driver.findElement(By.xpath((config.getProperty("ok")))).click();
	}

	@Then("^user should be able to see policy info page with status as \"([^\"]*)\"$")
	public void user_should_be_able_to_see_policy_info_page_with_status_as(String arg1) throws Throwable {

	}

	@When("^User enters phone number in policy info creation page$")
	public void user_enters_phone_number_in_policy_info_creation_page() throws Throwable {

		driver.manage().timeouts().implicitlyWait(3L, TimeUnit.MINUTES);

		String phone = excel2.getCellData("CV_NB", "phone", 2);
		driver.findElement(By.xpath(config.getProperty("phone"))).clear();
		driver.findElement(By.xpath(config.getProperty("phone"))).sendKeys(phone);

	}

	@When("^User clicks on policy question tab$")
	public void user_clicks_on_policy_question_tab() throws Throwable {

		driver.findElement(By.xpath((config.getProperty("policyquestion")))).click();

	}

	@When("^User checks Signed Application Reviewed$")
	public void user_checks_Signed_Application_Reviewed() throws Throwable {

		driver.findElement(By.xpath((config.getProperty("signedapplication")))).click();

	}

	@When("^User checks Signed UM/UIM Forms Reviewed$")
	public void user_checks_Signed_UM_UIM_Forms_Reviewed() throws Throwable {

		WebDriverWait wait = new WebDriverWait(driver, 60);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(config.getProperty("uim")))).click();

	}

	@When("^User clicks on save$")
	public void user_clicks_on_save() throws Throwable {

		Thread.sleep(2000);

		driver.findElement(By.xpath((config.getProperty("savepolicy")))).click();
	}

	@Then("^user should be able to see policy info creation page with status as \"([^\"]*)\"$")
	public void user_should_be_able_to_see_policy_info_creation_page_with_status_as(String arg1) throws Throwable {

	}

	@When("^User clicks on policy info$")
	public void user_clicks_on_policy_info() throws Throwable {

		WebDriverWait wait = new WebDriverWait(driver, 180);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(config.getProperty("policyinfo")))).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(config.getProperty("driver")))).click();

	}

	@When("^User clicks on drivers from dropdown$")
	public void user_clicks_on_drivers_from_dropdown() throws Throwable {

	}

	@When("^User clicks on Add Driver$")
	public void user_clicks_on_Add_Driver() throws Throwable {
		driver.findElement(By.xpath((config.getProperty("adddriver")))).click();

	}

	@When("^user enters firstName$")
	public void user_enters_firstName() throws Throwable {

		String driverfirstname = excel2.getCellData("CV_NB", "driverfirstname", 2);
		driver.findElement(By.xpath(config.getProperty("driverfirstname"))).sendKeys(driverfirstname);

	}

	@When("^user enters  License Number$")
	public void user_enters_License_Number() throws Throwable {

		String licensenumber = excel2.getCellData("CV_NB", "licensenumber", 2);
		driver.findElement(By.xpath(config.getProperty("licensenumber"))).sendKeys(licensenumber);

	}

	@When("^user enters lastName$")
	public void user_enters_lastName() throws Throwable {

		String driverlastname = excel2.getCellData("CV_NB", "driverlastname", 2);
		driver.findElement(By.xpath(config.getProperty("driverlastname"))).sendKeys(driverlastname);

	}

	@When("^user enters  Daily Driving Vehicle$")
	public void user_enters_Daily_Driving_Vehicle() throws Throwable {
		String dailydriving = excel2.getCellData("CV_NB", "dailydriving", 2);
		driver.findElement(By.xpath(config.getProperty("dailydriving"))).sendKeys(dailydriving);
	}

	@When("^user enters Date of Birth$")
	public void user_enters_Date_of_Birth() throws Throwable {
		String dob = excel2.getCellData("CV_NB", "dob", 2);
		driver.findElement(By.xpath(config.getProperty("dob"))).sendKeys(dob);
	}

	@When("^user checks collector car option$")
	public void user_checks_collector_car_option() throws Throwable {
		driver.findElement(By.xpath((config.getProperty("collectorcar")))).click();
	}

	@When("^user selects year licensed$")
	public void user_selects_year_licensed() throws Throwable {

		WebElement dropdown = driver.findElement(By.xpath((config.getProperty("yearlicense"))));
		Select select = new Select(dropdown);
		select.selectByValue("3-5");

	}

	@When("^user selects losses$")
	public void user_selects_losses() throws Throwable {
		WebElement dropdown = driver.findElement(By.xpath((config.getProperty("losses"))));
		Select select = new Select(dropdown);
		select.selectByValue("None");

	}

	@When("^user selects no of points$")
	public void user_selects_no_of_points() throws Throwable {
		WebElement dropdown = driver.findElement(By.xpath((config.getProperty("points"))));
		Select select = new Select(dropdown);
		select.selectByValue("0-1");
		Thread.sleep(1500);

	}

	@When("^user clicks on save button$")
	public void user_clicks_on_save_button() throws Throwable {

		WebDriverWait wait = new WebDriverWait(driver, 60);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(config.getProperty("savedriver")))).click();

	}

	@Then("^driver details get added$")
	public void driver_details_get_added() throws Throwable {

	}

	@When("^User clicks on Garages$")
	public void user_clicks_on_Garages() throws Throwable {

		WebDriverWait wait = new WebDriverWait(driver, 120);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(config.getProperty("garages")))).click();

	}

	@When("^User clicks on New garages$")
	public void user_clicks_on_New_garages() throws Throwable {

		WebDriverWait wait = new WebDriverWait(driver, 180);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(config.getProperty("newgarage")))).click();

	}

	@When("^User clicks on Copy Primary address$")
	public void user_clicks_on_Copy_Primary_address() throws Throwable {

		driver.findElement(By.xpath((config.getProperty("copyprimaryaddress")))).click();
		Thread.sleep(1000);

	}

	@When("^user clicks on save in garage info$")
	public void user_clicks_on_save_in_garage_info() throws Throwable {

		driver.findElement(By.xpath((config.getProperty("savegarage")))).click();

		// WebDriverWait wait = new WebDriverWait(driver,60);
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Save']//ancestor::span"))).click();

		// WebElement element =
		// driver.findElement(By.xpath("//*[text()='Save']//ancestor::span"));
		// Actions action = new Actions(driver);
		// action.moveToElement(element).click().perform();

	}

	@Then("^garage details get added$")
	public void garage_details_get_added() throws Throwable {

	}

	@When("^User clicks on Vehicles$")
	public void user_clicks_on_Vehicles() throws Throwable {

		driver.manage().timeouts().implicitlyWait(3L, TimeUnit.MINUTES);
		WebDriverWait wait = new WebDriverWait(driver, 60);

		try {
			driver.findElement(By.xpath((config.getProperty("vehicle")))).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(config.getProperty("newvehicle")))).click();

	}

	@When("^User selects vehicle year$")
	public void user_selects_vehicle_year() throws Throwable {

		WebElement dropdown = driver.findElement(By.xpath((config.getProperty("vehicleyear"))));
		Select select = new Select(dropdown);

		select.selectByIndex(19);
		// select.getFirstSelectedOption();
	}

	@When("^User selects vehicle make$")
	public void user_selects_vehicle_make() throws Throwable {

		WebDriverWait wait = new WebDriverWait(driver, 60);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(config.getProperty("vehiclemake1"))));

		WebElement dropdown = driver.findElement(By.xpath((config.getProperty("vehiclemake"))));
		Select select = new Select(dropdown);
		select.selectByIndex(15);

	}

	@When("^User selects vehicle model$")
	public void user_selects_vehicle_model() throws Throwable {

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(config.getProperty("vehiclemodel1"))));

		WebElement dropdown = driver.findElement(By.xpath((config.getProperty("vehiclemodel"))));
		Select select = new Select(dropdown);
		select.selectByIndex(1);
	}

	@When("^User enters agreed value$")
	public void user_enters_agreed_value() throws Throwable {

		Thread.sleep(1000);
		String agreedvalue = excel2.getCellData("CV_NB", "agreedvalue", 2);
		driver.findElement(By.xpath(config.getProperty("agreedvalue"))).sendKeys(agreedvalue);

	}

	@When("^user selects vehicle type$")
	public void user_selects_vehicle_type() throws Throwable {

		WebElement dropdown = driver.findElement(By.xpath((config.getProperty("vehicletype"))));
		Select select = new Select(dropdown);
		select.selectByIndex(1);

	}

	@When("^user selects modification type$")
	public void user_selects_modification_type() throws Throwable {

		WebElement dropdown = driver.findElement(By.xpath((config.getProperty("modificationtype"))));
		Select select = new Select(dropdown);
		select.selectByIndex(1);
	}

	@When("^user selects Garaging Location$")
	public void user_selects_Garaging_Location() throws Throwable {
		WebElement dropdown = driver.findElement(By.xpath((config.getProperty("garaginglocation"))));
		Select select = new Select(dropdown);
		select.selectByIndex(1);
	}

	@When("^user enters \"([^\"]*)\"$")
	public void user_enters(String VIN) throws Throwable {

		Thread.sleep(1000);
		driver.findElement(By.xpath(config.getProperty("vin"))).sendKeys(VIN);
	}

	@When("^user selects Primary Use$")
	public void user_selects_Primary_Use() throws Throwable {
		WebElement dropdown = driver.findElement(By.xpath((config.getProperty("primaryuse"))));
		Select select = new Select(dropdown);
		select.selectByIndex(5);
	}

	@When("^user checks on photo Reviewed$")
	public void user_checks_on_photo_Reviewed() throws Throwable {
		Thread.sleep(800);
		driver.findElement(By.xpath((config.getProperty("photoreview")))).click();
	}

	@When("^user clicks on vehicle question tab$")
	public void user_clicks_on_vehicle_question_tab() throws Throwable {
		Thread.sleep(1000);
		driver.findElement(By.xpath((config.getProperty("vehiclequestion")))).click();

	}

	@When("^user clicks on vehicle registered combobox$")
	public void user_clicks_on_vehicle_registered_combobox() throws Throwable {
		driver.findElement(By.xpath((config.getProperty("vehicleregistered")))).click();
		Thread.sleep(1200);
	}

	@When("^user clicks on save in vehicle page$")
	public void user_clicks_on_save_in_vehicle_page() throws Throwable {

		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(config.getProperty("savevehicle")))).click();

	}

	@Then("^vehicle details get added$")
	public void vehicle_details_get_added() throws Throwable {

	}

	@When("^User clicks on rate$")
	public void user_clicks_on_rate() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(config.getProperty("rate")))).click();

	}

	@Then("^Status changed to 'RATED'$")
	public void status_changed_to_RATED() throws Throwable {

	}

	@When("^User clicks on quote$")
	public void user_clicks_on_qoute() throws Throwable {

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(config.getProperty("quote")))).click();

	}

	@When("^User click on generate documents$")
	public void user_click_on_generate_documents() throws Throwable {

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(config.getProperty("generatedocuments")))).click();

	}

	@Then("^Status changed to 'QUOTED'$")
	public void status_changed_to_QUOTED() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(config.getProperty("generatedocuments"))));
	}

	@When("^User clicks on Billing Info$")
	public void user_clicks_on_Billing_Info() throws Throwable {

		driver.findElement(By.xpath((config.getProperty("billinginfo")))).click();

	}

	@When("^User clicks on edit$")
	public void user_clicks_on_edit() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 240);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(config.getProperty("edit")))).click();

	}

	@When("^User selects billing contact$")
	public void user_selects_billing_contact() throws Throwable {

		Thread.sleep(1500);
		WebElement dropdown = driver.findElement(By.xpath((config.getProperty("billingcontact"))));
		Select select = new Select(dropdown);
		select.selectByIndex(1);
	}

	@When("^user clicks on save in billing info$")
	public void user_clicks_on_save_in_billing_info() throws Throwable {
		Thread.sleep(1200);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(config.getProperty("savebillinginfo")))).click();

	}

	@When("^User clicks on bind$")
	public void user_clicks_on_bind() throws Throwable {
		Thread.sleep(1000);

		WebDriverWait wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(config.getProperty("bind")))).click();

	}

	@When("^User clicks on override$")
	public void user_clicks_on_override() throws Throwable {

		List<WebElement> buttons = driver.findElements(By.xpath(config.getProperty("buttons")));

		System.out.print("no ofbuttons are " + buttons.size() + "-----");
		for (int i = 0; i < buttons.size(); i++) {
			Thread.sleep(1000);
			buttons.get(i).click();
			Thread.sleep(4000);
		}

		/*
		 * for(WebElement button:buttons) { button.click(); Thread.sleep(4100);
		 * 
		 * }
		 */

		/*
		 * for(int i=1;i<=buttons.size();i++) { driver.findElement(By.xpath(
		 * "//img[(@src='/PHYLINSPortlet/images/override-0.gif')]")); }
		 */

	}

	@Then("^Status changed to 'BOUND'$")
	public void status_changed_to_BOUND() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 80);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(config.getProperty("bind")))).click();

	}

	@When("^User clicks on issue$")
	public void user_clicks_on_issue() throws Throwable {

		WebDriverWait wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(config.getProperty("issue")))).click();

	}

	@When("^clicks on generate documents only$")
	public void clicks_on_generate_documents_only() throws Throwable {

		WebDriverWait wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(config.getProperty("generatedocuments"))))
				.click();

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(config.getProperty("generatedocuments"))));
	}

	@Then("^Status changed to 'ISSUED'$")
	public void status_changed_to_ISSUED() throws Throwable {

		String Account_Name = driver.findElement(By.xpath((config.getProperty("Account_Name")))).getText();

		excel.setCellData(sheetname, "Account_Name", 2, Account_Name);

		String Address_line1 = driver.findElement(By.xpath((config.getProperty("Address_line1")))).getText();

		excel.setCellData(sheetname, "Address_line1", 2, Address_line1);

		String city = driver.findElement(By.xpath((config.getProperty("account_city")))).getText();

		excel.setCellData(sheetname, "city", 2, city);

		String State = driver.findElement(By.xpath((config.getProperty("account_state")))).getText();

		excel.setCellData(sheetname, "State", 2, State);

		String Zip_Code = driver.findElement(By.xpath((config.getProperty("zip_code")))).getText();

		excel.setCellData(sheetname, "Zip_Code", 2, Zip_Code);

		String Policy_Number = driver.findElement(By.xpath((config.getProperty("Policy_Number")))).getText();
		System.out.println(Policy_Number);
		excel.setCellData(sheetname, "Policy_Number", 2, Policy_Number);

		String Policy_Amount = driver.findElement(By.xpath((config.getProperty("Policy_Amount")))).getText();
		System.out.println(Policy_Amount);
		excel.setCellData(sheetname, "Policy_Amount", 2, Policy_Amount);

		String Account_Number = driver.findElement(By.xpath((config.getProperty("Account_Number")))).getText();
		System.out.println(Account_Number);
		excel.setCellData(sheetname, "Account_Number", 2, Account_Number);

		excel.addSheet(Policy_Number);

		excel.addColumn(Policy_Number, "A");
		excel.setCellData(Policy_Number, "A", 2, "Account_Number");
		excel.setCellData(Policy_Number, "A", 3, "Policy_Number");
		excel.setCellData(Policy_Number, "A", 4, "Policy_Amount");

		excel.addColumn(Policy_Number, "B");
		excel.setCellData(Policy_Number, "B", 2, Account_Number);

		excel.setCellData(Policy_Number, "B", 3, Policy_Number);
		excel.setCellData(Policy_Number, "B", 4, Policy_Amount);

		excel.setCellData(Policy_Number, "A", 8, "NB_Checkpoints");

		driver.manage().timeouts().implicitlyWait(3L, TimeUnit.MINUTES);
		WebDriverWait wait = new WebDriverWait(driver, 60);

		driver.findElement(By.xpath("//span[(@class='iceMnuBarItemLabel') and contains (text(),'Vehicles')]")).click();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[text()='Garages (1)']//following::span[5]"))).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Vehicle Coverages']"))).click();

		String Collision1 = driver.findElement(By.xpath("//*[text()='Premium']//following::span[2]")).getText();

		String Comprehensive1 = driver.findElement(By.xpath("//*[text()='Premium']//following::span[5]")).getText();

		excel.addColumn(Policy_Number, "C");

		// ---------------------------------------------------------------
		excel.setCellData(Policy_Number, "A", 9, "Vehicle1");
		excel.setCellData(Policy_Number, "A", 10, "Collision");
		excel.setCellData(Policy_Number, "A", 11, "Comprehensive");
		excel.setCellData(Policy_Number, "B", 10, Collision1);
		excel.setCellData(Policy_Number, "B", 11, Comprehensive1);

		if (Collision1.equals("295.00")) {
			excel.setCellData(Policy_Number, "C", 10, "PASS");
		} else {
			excel.setCellData(Policy_Number, "C", 10, "FAIL");
		}

		if (Comprehensive1.equals("295.00")) {
			excel.setCellData(Policy_Number, "C", 11, "PASS");
		} else {
			excel.setCellData(Policy_Number, "C", 11, "FAIL");
		}
		// -------------------------------------------------------------------

		Thread.sleep(1500);

		driver.findElement(By.xpath("//span[(@class='iceMnuBarItemLabel') and contains (text(),'Vehicles')]")).click();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[text()='Garages (1)']//following::span[6]"))).click();

		Thread.sleep(2000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Vehicle Coverages']"))).click();

		String Collision2 = driver.findElement(By.xpath("//*[text()='Premium']//following::span[2]")).getText();

		String Comprehensive2 = driver.findElement(By.xpath("//*[text()='Premium']//following::span[5]")).getText();

		excel.setCellData(Policy_Number, "A", 12, "Vehicle2");
		excel.setCellData(Policy_Number, "A", 13, "Collision");
		excel.setCellData(Policy_Number, "A", 14, "Comprehensive");
		excel.setCellData(Policy_Number, "B", 13, Collision2);
		excel.setCellData(Policy_Number, "B", 14, Comprehensive2);

		if (Collision2.equals("295.00")) {
			excel.setCellData(Policy_Number, "C", 13, "PASS");
		} else {
			excel.setCellData(Policy_Number, "C", 13, "FAIL");
		}

		if (Comprehensive2.equals("295.00")) {
			excel.setCellData(Policy_Number, "C", 14, "PASS");
		} else {
			excel.setCellData(Policy_Number, "C", 14, "FAIL");
		}
		// -------------------------------------------------------------------

		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[(@class='iceMnuBarItemLabel') and contains (text(),'Vehicles')]")).click();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[text()='Garages (1)']//following::span[7]"))).click();
		Thread.sleep(2000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Vehicle Coverages']"))).click();

		String Collision3 = driver.findElement(By.xpath("//*[text()='Premium']//following::span[2]")).getText();

		String Comprehensive3 = driver.findElement(By.xpath("//*[text()='Premium']//following::span[5]")).getText();

		excel.setCellData(Policy_Number, "A", 15, "Vehicle3");
		excel.setCellData(Policy_Number, "A", 16, "Collision");
		excel.setCellData(Policy_Number, "A", 17, "Comprehensive");
		excel.setCellData(Policy_Number, "B", 16, Collision3);
		excel.setCellData(Policy_Number, "B", 17, Comprehensive3);

		if (Collision3.equals("295.00")) {
			excel.setCellData(Policy_Number, "C", 16, "PASS");
		} else {
			excel.setCellData(Policy_Number, "C", 16, "FAIL");
		}

		if (Comprehensive3.equals("295.00")) {
			excel.setCellData(Policy_Number, "C", 17, "PASS");
		} else {
			excel.setCellData(Policy_Number, "C", 17, "FAIL");
		}
		// -------------------------------------------------------------------

	}

	@When("^User clicks on Logout$")
	public void user_clicks_on_Logout() throws Throwable {

		driver.findElement(By.xpath("//a[@href='/c/portal/logout']")).click();
	}

	@Then("^User is navigated to login page$")
	public void user_is_navigated_to_login_page() throws Throwable {

	}

}
