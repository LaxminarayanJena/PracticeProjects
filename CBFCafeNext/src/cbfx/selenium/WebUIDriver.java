/******************************************************************************
$Id : WebUIDriver.java 3/3/2016 7:07:41 PM
Copyright 2016-2017 IGATE GROUP OF COMPANIES. All rights reserved
(Subject to Limited Distribution and Restricted Disclosure Only.)
THIS SOURCE FILE MAY CONTAIN INFORMATION WHICH IS THE PROPRIETARY
INFORMATION OF IGATE GROUP OF COMPANIES AND IS INTENDED FOR USE
ONLY BY THE ENTITY WHO IS ENTITLED TO AND MAY CONTAIN
INFORMATION THAT IS PRIVILEGED, CONFIDENTIAL, OR EXEMPT FROM
DISCLOSURE UNDER APPLICABLE LAW.
YOUR ACCESS TO THIS SOURCE FILE IS GOVERNED BY THE TERMS AND
CONDITIONS OF AN AGREEMENT BETWEEN YOU AND IGATE GROUP OF COMPANIES.
The USE, DISCLOSURE REPRODUCTION OR TRANSFER OF THIS PROGRAM IS
RESTRICTED AS SET FORTH THEREIN.
 ******************************************************************************/

package cbfx.selenium;

import static cbf.engine.TestResultLogger.failed;
import static cbf.engine.TestResultLogger.passed;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import cbf.engine.TestResult.ResultType;
import cbf.harness.Harness;
import cbf.plugin.PluginManager;
import cbf.utils.DataRow;
import cbf.utils.LogUtils;
import cbf.utils.SleepUtils;
import cbf.utils.SleepUtils.TimeSlab;
import cbf.utils.StringUtils;
import cbfx.selenium.browsers.Browser;

/**
 * 
 * Extends BaseWebAppDriver and handles all the common functionalities for
 * webControls like setting the TextBox,Selecting an option in Dropdown ,etc..
 * 
 */

public class WebUIDriver {

	/**
	 * Overloaded Constructor to initialize webdriver and selenium
	 * 
	 * @param parameters
	 *            webDriver: object of WebDriver selenium: object of
	 *            WebDriverBackedSelenium
	 */
	public WebUIDriver(Map parameters) {
		Map obj = (Map<String, Object>) Harness.GCONFIG.get("ObjectMap");
		objMap = (ObjectMap) PluginManager.getPlugin(
				(String) obj.get("plugin"), null);

		browser = (Browser) PluginManager.getPlugin(
				(String) parameters.get("plugin"),
				(Map<String, Object>) parameters.get("parameters"));
		this.th = new TableHandler(this);
	}

	private void openBrowser() {
		this.webDr = browser.openDriver();
		webDr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		webDr.manage().window().maximize();
	}

	/**
	 * Launches the Application in the Browser
	 * 
	 * @param url
	 *            URL of the page to be opened.
	 */
	public void launchApplication(String url) {
		closeBrowsers();
		openBrowser();

		try {
			webDr.get(url);

			passed("Open " + " " + url, "Should open " + url, url + " "
					+ "opened successfully");

		} catch (Exception e) {

			failed("Open " + " " + url, "Should open " + url, url + " "
					+ "opened unsuccessfully");

			logger.handleError("Error while navigating to url " + url, e);

		}

	}

	/**
	 * Navigates to the specified url in the browser
	 * 
	 * @param url
	 *            URL of the page to be opened.
	 */
	public void navigateToPage(String url) {
		try {
			webDr.get(url);
			passed("Navigate to " + " " + url, "Should navigate to" + url, url
					+ " " + "Navigated successfully");
		} catch (Exception e) {

			failed("Navigate to " + " " + url, "Should navigate to" + url, url
					+ " " + "Navigated unsuccessfully");

			logger.handleError("Error while navigating to url " + url, e);

		}

	}

	/**
	 * Checks whether page title matches or not
	 * 
	 * @param pageTitle
	 *            title of page opened
	 * @return true or false result
	 */
	public boolean checkPage(String pageTitle) {
		try {
			if (pageTitle.equals(webDr.getTitle())) {
				passed("Check page title: " + pageTitle,
						" Page title should be " + pageTitle,
						"Page verified successfully");

				return true;
			}
		} catch (Exception e) {
			failed("Check page title: " + pageTitle, " Page title should be "
					+ pageTitle, "Page verified unsuccessfully");

			logger.handleError(
					"Error in checking the page title: " + pageTitle, e);
		}
		return false;
	}

	/**
	 * Identifies the locator as needed by webDriver object
	 * 
	 * @param elementName
	 *            Name of the element whose locator is required
	 * @return Identified locator as Web Element
	 */

	public Map getLocator(String element) {

		Map<String, String> locatorMap = null;
		List<Map> pageLocators = objMap.ObjectMaps(element.split("\\.")[0]);
		for (Map locator : pageLocators) {
			if (locator.get("elementName").equals(element.split("\\.")[1])) {
				locatorMap = locator;
				break;
			}

		}
		return locatorMap;
	}

	public WebElement getControl(String elementName) {
		WebElement element = null;
		element = getElement(elementName);
		if (element == null) {
			element = autoFind(elementName);
			if (element == null) {
				logger.error("Unable to find the element" + elementName);
			}
		}

		return element;

	}

	public WebElement getElement(String elementName) {
		WebElement element = null;
		Map<String, String> locators = getLocator(elementName);
		for (Map.Entry<String, String> entry : locators.entrySet()) {

			if (element != null)
				break;
			try {
				if (!entry.getValue().isEmpty())
					switch (entry.getKey()) {
					case "id":
						element = webDr.findElement(By.id(locators.get("id")
								.toString()));

						break;
					case "name":
						element = webDr.findElement(By.name(locators
								.get("name").toString()));

						break;


					case "xpath":

						element = webDr.findElement(By.xpath(locators.get(
								"xpath").toString()));

						break;
					case "relativeXpath":

						element = webDr.findElement(By.xpath(locators.get(
								"relativeXpath").toString()));

						break;
					case "absoluteXpath":

						element = webDr.findElement(By.xpath(locators.get(
								"absoluteXpath").toString()));

						break;

					case "className":

						element = webDr.findElement(By.xpath(locators.get(
								"className").toString()));

						break;
					case "css":

						element = webDr.findElement(By.xpath(locators
								.get("css").toString()));

						break;
					case "linkText":

						element = webDr.findElement(By.xpath(locators.get(
								"linkText").toString()));

						break;
					case "tagName":

						element = webDr.findElement(By.xpath(locators.get(
								"tagName").toString()));

						break;
					case "partialLinkText":

						element = webDr.findElement(By.xpath(locators.get(
								"partialLinkText").toString()));

						break;

					}
			} catch (Exception e) {
				continue;

			}
		}
		return element;

	}

	public WebElement autoFind(String elementName) {
		WebElement element = null;

		Set<String> windowList = webDr.getWindowHandles();
		for (String window : windowList) {
			webDr.switchTo().window(window);

			element = getElement(elementName);
			if (element == null) {
				List<WebElement> listOfFrames = webDr.findElements(By
						.tagName("frame"));
				List<WebElement> listOfIFrames = webDr.findElements(By
						.tagName("iframe"));

				listOfFrames.addAll(listOfIFrames);

				if (listOfFrames.size() > 0) {
					for (WebElement webElement : listOfFrames) {
						webDr.switchTo().frame(webElement);

						element = getElement(elementName);
						if (element == null) {
							webDr.switchTo().defaultContent();
							continue;
						} else {
							break;
						}

					}

				}
				continue;
			}
			break;

		}

		return element;
	}

	public void setAttribute(String elementName, String value) {
		System.out.println("abc");
	}




	/**
	 * Sets the value to the specified UI Element
	 * 
	 * @param elementName
	 *            name of element
	 * @param value
	 *            value to be set on element
	 */
	public void setValue(String elementName, String value) {
		//SleepUtils.sleep(TimeSlab.LOW);
		if (checkElementPresent(elementName)) {
			WebElement element = getControl(elementName);
			try {
				String type = element.getAttribute("type");

				if ((type.equals("text")) || type.equals("password")|| type.equals("email")) {
					element.clear();
					element.sendKeys(value);
					logger.trace("Typed text '" + value
							+ "' in the input element '" + elementName + "'");
					passed("setting the value for" + " " + elementName + " ",
							"value" + " " + value + " " + "should set properly",
							"value" + " " + value + " "
									+ "entered successfully");

					return;
				}

				if (type.equals("select-one")) {
					Select selectOption = new Select(element);
					selectOption.selectByVisibleText(value);
					logger.trace("Selected  " + value + "' in " + elementName
							+ "'");
					passed("setting the value for" + " " + elementName + " ",
							"value" + " " + value + " " + "should set properly",
							"value" + " " + value + " "
									+ "entered successfully");

					return;
				}

				if (type.equalsIgnoreCase("Calendar")) {
					setCalendar(element, value);
					passed("setting the value for" + " " + elementName + " ",
							"value" + " " + value + " " + "should set properly",
							"value" + " " + value + " "
									+ "entered successfully");

					return;
				}
				if (element.getTagName().equalsIgnoreCase("textarea")) {
					element.clear();
					element.sendKeys(value);
					logger.trace("Typed text '" + value
							+ "' in the input element '" + elementName + "'");
					passed("setting the value for" + " " + elementName + " ",
							"value" + " " + value + " " + "should set properly",
							"value" + " " + value + " "
									+ "entered successfully");

					return;
				}
				if ((type.equals("checkbox")) || type.equals("radio")) {
					element.click();
					logger.trace("Clicked on " + elementName);
					passed("setting the value for" + " " + elementName + " ",
							"value" + " " + value + " " + "should set properly",
							"value" + " " + value + " "
									+ "entered successfully");

					return;

				}
			} catch (Exception e) {
				failed("setting the value for" + " " + elementName + " ",
						"value" + " " + value + " " + "should set properly",
						"Failed to set value" + " " + value);

				logger.handleError("Error while setting value ," + value
						+ " on element " + elementName, e);

			}
		} else
			failed("setting the value for" + " " + elementName + " ", "value"
					+ " " + value + " " + "should set properly",
					"Failed to set value" + " " + value);
	}

	/**
	 * Sets the value to the specified UI Element
	 * 
	 * @param elementName
	 *            name of element
	 * @param input
	 *            input datarow with UI properties
	 */
	public void setValue(String elementName, DataRow input) {
		setValue(elementName, input.get("elementName"));
	}

	// TODO:Should be made as a plugin
	private void setCalendar(WebElement element, String value) {
		element.click();
		webDr.findElement(
				By.linkText(value.substring(0, value.indexOf("/")).toString()))
		.click();
	}

	/**
	 * Sets the value to all the locators on the specified page.
	 * 
	 * @param pageName
	 *            name of the page
	 * @param data
	 *            value to be set on page
	 */
	public void setValues(String pageName, Map data) {
		List<Map> resultMap = new ArrayList();
		resultMap = objMap.ObjectMaps(pageName);
		setValues(data, resultMap);
	}

	private void setValues(Map data, List<Map> uiElements) {
		String elementName = "";
		for (Map uiElement : uiElements) {
			elementName = ((String) uiElement.get("elementName"));

			if (data.containsKey(elementName)) {
				setValue(elementName, (String) data.get(elementName));
			}
		}
	}

	/**
	 * Gets the value of the specified element
	 * 
	 * @param elementName
	 *            whose value has to be obtained
	 */
	public String getValue(String elementName) {
		WebElement element = getControl(elementName);
		try {
			String type = element.getAttribute("type");

			if (type.equals("text") || type.equals("password")) {

				if (element.getText().equals(""))
					return getAttribute(elementName, "value");

				return element.getText();

			}
			if (type.equals("select-one")) {

				Select selectOption = new Select(element);
				return selectOption.getFirstSelectedOption().getText();

			}
			if (type.equals("checkbox") || type.equals("radio")) {

				if (element.isSelected()) {
					return "Yes";
				} else {
					return "No";
				}

			}
			if (type.equals(null)) {
				return element.getText();
			}
		} catch (Exception e) {
			failed("getting the value for" + " " + elementName + " ",
					"should get value properly", "Failed to get value");
			logger.handleError("Error while getting value of element "
					+ elementName, e);
		}

		return null;
	}

	/**
	 * Clears the value of specified element
	 * 
	 * @param elementName
	 *            element to be cleared
	 */
	public boolean clear(String elementName) {
		try {
			getControl(elementName).clear();
			passed("Clear the data of " + elementName,
					"Data should be cleared", "Data is cleared successfully");
			return true;
		} catch (Exception e) {
			failed("Clear the data of " + elementName,
					"Data should be cleared", "Failed to clear data for"
							+ elementName);
			logger.handleError("Failed to clear  " + elementName, e);
			return false;
		}

	}

	/**
	 * Navigates to the Menu
	 * 
	 * @param menuList
	 *            list of menu items
	 */
	public void navigateMenu(String menuList) {
		String[] aMenu;
		aMenu = menuList.split(",");
		try {
			for (int i = 0; i < aMenu.length; i++) {
				if (!(aMenu[i].matches(""))) {
					getControl(aMenu[i]).click();
					logger.trace("Clicked on menu: " + aMenu[i] + ".");
					passed("Navigate to menu" + menuList, "Should navigate "
							+ menuList, "Navigated to " + menuList);
					waitForBrowserStability(1000);
				}
			}
		} catch (Exception e) {
			if (menuList.contains(","))
				menuList = menuList.replaceAll(",", "-->");
			failed("Navigate to menu" + menuList,
					"Should navigate " + menuList, "Failed to navigate to "
							+ menuList);
			logger.handleError("Failed while Navigating to  " + menuList);
		}
	}

	/**
	 * Checks the presence of element till timeout
	 * 
	 * @param elementName
	 *            name of the element
	 * @param timeInSec
	 *            time limit
	 * @return boolean result
	 */
	public boolean checkElementPresent(final String elementName) {
		//SleepUtils.sleep(TimeSlab.YIELD);
		boolean result = false;
		String time = "10";
		int timeInSec = Integer.parseInt(time);

		try {
			ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver webDriver) {
					WebElement element = getControl(elementName);
					if (element != null) {
						return true;

					} else {
						return false;

					}
				}
			};

			Wait<WebDriver> wait = new WebDriverWait(webDr, timeInSec);
			try {
				result = wait.until(expectation);
			} catch (Exception e) {

			}
		} catch (Exception e) {

		}
		return result;
	}
	/**
	 * Checks the Not presence of element 
	 * 
	 * @param elementName
	 *            name of the element
	 * @param timeInSec
	 *            time limit
	 * @return boolean result
	 */
	public boolean checkElementNotPresent(final String elementName) {
		//SleepUtils.sleep(TimeSlab.YIELD);
		boolean result = false;
		String time = "10";
		int timeInSec = Integer.parseInt(time);

		try {
			ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver webDriver) {
					WebElement element = getControl(elementName);
					if (element == null) {
						return true;

					} else {
						return false;

					}
				}
			};

			Wait<WebDriver> wait = new WebDriverWait(webDr, timeInSec);
			try {
				result = wait.until(expectation);
			} catch (Exception e) {

			}
		} catch (Exception e) {

		}
		return result;
	}


	/**
	 * Check for the presence of the specified text on page till timeout
	 * 
	 * @param text
	 *            text to be verified
	 * @param timeInSec
	 *            time-limit(in seconds)
	 * @return boolean Result
	 */
	public boolean checkTextOnPage(String text, int timeInSec) {
		boolean result = false;
		WebDriverWait waitForPage = new WebDriverWait(webDr,
				TimeUnit.MILLISECONDS.toSeconds(500));

		try {
			for (int second = 0;; second++) {
				if (second >= timeInSec * 10) {
					logger.trace("TimeOut for " + second);
					break;
				}
				if (webDr.findElement(By.tagName("body")).getText()
						.contains(text)) {
					result = true;
					passed("Check " + text + " on page", text
							+ " Should present on page ", text
							+ " not present on page ");
					break;
				}
				waitForPage.until(ExpectedConditions.visibilityOf(webDr
						.findElement(By.tagName("body"))));
			}
		} catch (Exception e) {
			failed("Check " + text + " on page", text
					+ " Should present on page ", text
					+ " not present on page ");
			logger.handleError(
					"Error: Caused while Verifying the Presence of Text \" "
							+ text + " \"", e);
		}
		return result;
	}

	/**
	 * Clicks on the specified element
	 * 
	 * @param elementName
	 *            element to be clicked
	 */

	public void click(String elementName) {
		try {
			//SleepUtils.sleep(TimeSlab.LOW);
			getControl(elementName).click();
			passed("click on element" + " " + elementName, " " + "element"
					+ " " + elementName + " " + "should be clicked", "element"
							+ " " + elementName + " " + "clicked successfully");

		} catch (Exception e) {
			failed("click on element", " " + elementName + " " + "element"
					+ " " + elementName + " " + "should be clicked",
					"Failed to click on element" + " " + elementName);

			logger.handleError("Failed to click on the element ", elementName,
					" ", e);
		}

	}
	/**
	 * Get the Current System Date
	 * 
	 * @param elementName
	 *                 today 
	 * @return String
	 */

	public String currentdate(String tday) {

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

		try {

			tday = dateFormat.format(calendar.getTime());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return tday;
	}
	/**
	 * Clicks on the specified element
	 * 
	 * @param elementName
	 *            element to be clicked
	 */

	public void ElementPrestnclick(String elementName) {
		try {
			//SleepUtils.sleep(TimeSlab.LOW);
			if(getControl(elementName).isEnabled())
			{
				getControl(elementName).click();
				passed("click on element" + " " + elementName, " " + "element"
						+ " " + elementName + " " + "should be clicked", "element"
								+ " " + elementName + " " + "clicked successfully");
			}
		} catch (Exception e) {
			//			failed("click on element", " " + elementName + " " + "element"
			//					+ " " + elementName + " " + "should be clicked",
			//					"Failed to click on element" + " " + elementName);
			//
			//			logger.handleError("Failed to click on the element ", elementName,
			//					" ", e);
		}

	}
	/**
	 * Get the Web button Status
	 * 
	 * @param elementName
	 *            element to be clicked
	 * @return boolean Result           
	 */
	public void VerifyButtonDisabled(String elementName) {
		try {
			//SleepUtils.sleep(TimeSlab.LOW);
			Boolean ButtonStatus=getControl(elementName).isDisplayed();
			if(ButtonStatus==true)
			{
				passed("Verify element" + " " + elementName, " " + "element"
						+ " " + elementName + " " + "should be Disabled", "element"
								+ " " + elementName + " " + "in Disabled Status");
			}
		} catch (Exception e) {
			//			failed("click on element", " " + elementName + " " + "element"
			//					+ " " + elementName + " " + "should be clicked",
			//					"Failed to click on element" + " " + elementName);
			//
			//			logger.handleError("Failed to click on the element ", elementName,
			//					" ", e);
		}

	}
	/**
	 * verify the Button is enabled 
	 * 
	 * @param elementName
	 *            element to be clicked
	 * @return boolean Result           
	 */
	public void VerifyButtonIsEnabled(String elementName) {
		try {
			//SleepUtils.sleep(TimeSlab.LOW);
			Boolean ButtonStatus=getControl(elementName).isEnabled();
			if(ButtonStatus==true)
			{
				passed("Verify element" + " " + elementName, " " + "element"
						+ " " + elementName + " " + "should be Enabled", "element"
								+ " " + elementName + " " + "in Enabled Status");
			}
		} catch (Exception e) {
			//			failed("click on element", " " + elementName + " " + "element"
			//					+ " " + elementName + " " + "should be clicked",
			//					"Failed to click on element" + " " + elementName);
			//
			//			logger.handleError("Failed to click on the element ", elementName,
			//					" ", e);
		}

	}
	/**
	 * Mouse overs on the specified menu and clicks on the sub menu.
	 * 
	 * @param menu
	 *            menu of the elements
	 * @param subMenu
	 *            element to be clicked
	 */

	public void mouseOverAndClick(String menu, String subMenu) {
		try {
			Mouse mouse;
			mouseOver(menu);
			Locatable hoverSubItem = (Locatable) getControl(subMenu);
			mouse = ((HasInputDevices) webDr).getMouse();
			mouse.click(hoverSubItem.getCoordinates());
			passed("Mouse over menu " + menu + " and click subMenu " + subMenu,
					"Should mouse over menu " + menu + " and click subMenu "
							+ subMenu, "mouse over menu " + menu
							+ " and click subMenu " + subMenu
							+ "done successfully");
		} catch (Exception e) {
			failed("Mouse over menu " + menu + " and click subMenu " + subMenu,
					"Should mouse over menu " + menu + " and click subMenu "
							+ subMenu, "failed to mouse over menu " + menu
							+ " and click subMenu " + subMenu);
			logger.handleError("Falied to click ", subMenu, " on", menu, " ", e);
		}
	}

	/**
	 * Mouse overs on the specified element
	 * 
	 * @param elementName
	 *            name of element
	 */

	public void mouseOver(String elementName) {
		try {

			if (elementName.contains("->")) {
				clickFromData(elementName);
			} else {

			}

			Robot robo = new Robot();
			robo.mouseMove(0, 0);
			SleepUtils.sleep(TimeSlab.YIELD);
			Actions actions = new Actions(webDr);
			WebElement mainMenu = getControl(elementName);
			actions.moveToElement(mainMenu).build().perform();

		} catch (Exception e) {
			failed("Mouse over " + elementName, "Should mouse over "
					+ elementName, "Failed to mouse over  " + elementName);
			logger.handleError("Falied to hover on ", elementName, e);
			// return null;
		}

	}

	public void clickFromData(String sValue) {

		Map result = null;
		String[] parts = null;
		String valueForMouseHOver = null, valueForClick = null;
		// Checks for the underscore in the sValue String.

		if (sValue.contains("->")) {
			parts = sValue.split("->");
			valueForClick = parts[parts.length - 1];
			for (int i = 0; i < parts.length; i++) {
				valueForMouseHOver = parts[i];
				try {
					if (valueForMouseHOver.matches(valueForClick)
							|| valueForMouseHOver.equals(valueForClick)) {
						getControl(valueForClick).click();
					} else {
						mouseOver(valueForMouseHOver);
						SleepUtils.sleep(TimeSlab.YIELD);
					}
				} catch (Exception e) {
				}
			}

		}
	}

	/**
	 * Performs the drag and drop operation
	 * 
	 * @param fromLocator
	 *            Contains the locator of source element
	 * @param toLocator
	 *            Contains the locator of destination element
	 */
	public void dragAndDrop(String fromLocator, String toLocator) {
		try {
			WebElement from = getControl(fromLocator);
			WebElement to = getControl(toLocator);
			Actions builder = new Actions(webDr);
			Action dragAndDrop = builder.clickAndHold(from).moveToElement(to)
					.release(to).build();
			dragAndDrop.perform();
			passed("Drag and drop from " + fromLocator + " to " + toLocator,
					"Drag and drop from " + fromLocator + " to " + toLocator,
					"Drag and drop from " + fromLocator + " to " + toLocator
					+ "is done successfully");

		} catch (Exception e) {
			failed("Drag and drop from " + fromLocator + " to " + toLocator,
					"Drag and drop from " + fromLocator + " to " + toLocator,
					"Failed to drag and drop from " + fromLocator + " to "
							+ toLocator);
			logger.handleError("Failed to drag drop elements ", fromLocator,
					" , ", toLocator, " ", e);
		}
	}

	/**
	 * Switch to another window
	 * 
	 * @param title
	 *            Contains title of the new window
	 * @return true or false
	 */
	public boolean switchToWindow(String title) {
		Set<String> availableWindows = webDr.getWindowHandles();
		if (availableWindows.size() > 1) {
			try {
				for (String windowId : availableWindows) {
					if (webDr.switchTo().window(windowId).getTitle()
							.equals(title))
						passed("Switch to window with title: " + title,
								"Shuold switch to window with title: " + title,
								"Switched to window with title: " + title);
					return true;
				}
			} catch (Exception e) {
				failed("Switch to window with title: " + title,
						"Should switch to window with title: " + title,
						"Failed to Switch to window with title: " + title);
				logger.handleError("No child window is available to switch ", e);
			}
		}

		return false;
	}

	/**
	 * Uploads a file
	 * 
	 * @param filePath
	 *            Contains path of the file to be uploaded
	 * @param browse
	 *            Contains locator of the browse button
	 * @param upload
	 *            locator of the upload button
	 */
	public void fileUpload(String filePath, String browse, String upload) {
		WebElement element = getControl(browse);
		try {
			element.sendKeys(filePath);
			if (upload != null) {
				click("upload");
				passed("Upload file " + browse + " on filepath " + filePath,
						"Should upload file " + browse + " on filepath "
								+ filePath, "Uploaded file " + browse
								+ " on filepath " + filePath + " successfully");
			}
		} catch (Exception e) {
			failed("Upload file " + browse + " on filepath " + filePath,
					"Should upload file " + browse + " on filepath " + filePath,
					"Failed to upload file " + browse + " on filepath "
							+ filePath);
			logger.handleError("Invalid File Path: ", filePath, e);
		}

	}

	/**
	 * Invokes enter/tab/F5 key
	 * 
	 * @param keyEvent
	 *            key to be invoked
	 * 
	 */
	// TODO:Check for other useful key events
	public void sendKey(String keyEvent) {
		try {
			Robot key = new Robot();
			if (keyEvent.equalsIgnoreCase("enter")) {
				key.keyPress(KeyEvent.VK_ENTER);
				key.keyRelease(KeyEvent.VK_ENTER);
				waitForBrowserStability(1000);
				passed("Press " + keyEvent, "Should press " + keyEvent,
						keyEvent + "pressed successfully");
				return;
			}
			if (keyEvent.equalsIgnoreCase("tab")) {
				key.keyPress(KeyEvent.VK_TAB);
				key.keyRelease(KeyEvent.VK_TAB);
				waitForBrowserStability(5000);
				passed("Press " + keyEvent, "Should press " + keyEvent,
						keyEvent + "pressed successfully");
				return;
			}
			if (keyEvent.equalsIgnoreCase("F5")) {
				key.keyPress(KeyEvent.VK_F5);
				key.keyRelease(KeyEvent.VK_F5);
				waitForBrowserStability(1000);
				passed("Press " + keyEvent, "Should press " + keyEvent,
						keyEvent + "pressed successfully");
				return;
			}

			if (keyEvent.equalsIgnoreCase("keysdown")) {
				key.keyPress(KeyEvent.VK_DOWN);
				key.keyRelease(KeyEvent.VK_DOWN);
				waitForBrowserStability(1000);
				passed("Press " + keyEvent, "Should press " + keyEvent,
						keyEvent + "pressed successfully");
				return;
			}
			if (keyEvent.equalsIgnoreCase("Pagedown")) {
				key.keyPress(KeyEvent.VK_PAGE_DOWN);
				key.keyRelease(KeyEvent.VK_PAGE_DOWN);
				waitForBrowserStability(1000);
				passed("Press " + keyEvent, "Should press " + keyEvent,
						keyEvent + "pressed successfully");
				return;
			}
			if (keyEvent.equalsIgnoreCase("Esc")) {
				key.keyPress(KeyEvent.VK_ESCAPE);
				key.keyRelease(KeyEvent.VK_ESCAPE);
				waitForBrowserStability(1000);
				passed("Press " + keyEvent, "Should press " + keyEvent,
						keyEvent + "pressed successfully");
				return;
			}
		} catch (AWTException e) {
			failed("Press " + keyEvent, "Should press " + keyEvent, keyEvent
					+ "is not pressed");
			logger.handleError("Error caused while clicking on '", keyEvent, e);
		}
	}

	/**
	 * Compares actual and expected text from the application
	 * 
	 * @param elementName
	 *            element for which text is to be checked
	 * @param expectedText
	 *            expected text
	 * @return boolean result
	 */
	public boolean verifyText(String elementName, String expectedText) {
		String actualText = getValue(elementName); 
		if (actualText.equalsIgnoreCase(expectedText)) {

			passed("Verify text on " + " " + elementName + " with text"
					+ expectedText + "", "Text" + expectedText
					+ " should be verified", "verified successfully");

			return true;
		}
		failed("Verify text on " + " " + elementName + " with text"
				+ expectedText + "", "Text" + expectedText
				+ " should be verified", "verified unsuccessfully");
		return false;
	}

	/**
	 * Verify Tooltip's text
	 * 
	 * @param elementName
	 *            Give element for which tooltip is visible
	 * @param expected
	 *            expected tooltip text
	 */

	public void verifyTooltip(String elementName, String expected) {
		WebElement element = getControl(elementName);
		String str = null;
		try {
			if (!element.getAttribute("title").isEmpty()) {
				str = element.getAttribute("title");
				if (str.contains(expected)) {
					passed("verify tooltip: " + str + "for " + element,
							"Tooltip's text should match with " + str + "for "
									+ element, "Tooltip's text matches with "
											+ str + "for " + element);
				} else {
					failed("verify tooltip: " + str,
							"Tooltip's text should match with " + str,
							"Tooltip's text doesn't match with " + str);
				}
			} else {
				failed("verify tooltip: " + str + "for " + element, str
						+ " not Visible", "Tooltip" + str
						+ " is not visible for " + element);
			}
		} catch (Exception e) {
			logger.handleError("Error while verifying tool tip", e);
		}

	}

	/**
	 * Verifies text in alert and clicks on either OK or cancel.
	 * 
	 * @param text
	 *            expected text
	 * @param button
	 *            "OK" or "Cancel" button
	 */

	public void handleAlert(String text, String button) {
		try {
			Alert alert = webDr.switchTo().alert();
			if (!text.equals("")) {
				String alerttext = alert.getText();
				if (alerttext.matches(text)) {
					passed("verify " + text + " in alert", text
							+ " should present in alert", text
							+ " is present in  alert");
				} else {
					failed("verify " + text + " in alert", text
							+ " should present in alert", text
							+ " is not present in  alert");
				}
			}
			if (button.equalsIgnoreCase("yes") || button.equalsIgnoreCase("ok")) {
				alert.accept();
			} else {
				alert.dismiss();
			}
		} catch (Exception e) {
			logger.handleError("Error while verifying text:" + text
					+ " in alert with button", button, e);
		}

	}

	/**
	 * Sets the text in the alert box
	 * 
	 * @param value
	 *            text to be set in alert box
	 */

	public void setTextInAlert(String value) {
		try {
			Alert alt = webDr.switchTo().alert();
			alt.sendKeys(value);
			alt.accept();
			passed("Send text in alert " + value, "Should send text in alert "
					+ value, "Send text in alert " + value
					+ " done successfully");

		} catch (Exception e) {
			failed("Send text in alert " + value, "Should send text in alert "
					+ value, "Failed to send text in alert " + value);
			logger.handleError("Failed to set text:" + value + " in alert", e);
		}

	}

	/**
	 * Gets the text from the alert box
	 * 
	 * @return String
	 */

	public String getAlertText() {
		try {
			Alert alt = webDr.switchTo().alert();
			String value = alt.getText();
			passed("Get text from alert ", "Should get text from alert ",
					"Retrieve " + value + " done successfully");
			return value;

		} catch (Exception e) {
			failed("Get text from alert ", "Should get text from alert ",
					"Failed to get value from alert");
			logger.handleError("Failed to get text from alert box", e);
			return null;
		}
	}

	/**
	 * Verify the presence of alert till timeout
	 * 
	 * @param TimeOutinSeconds
	 *            Give max time limit
	 * @return boolean
	 */

	public boolean isAlertPresent(int TimeOutinSeconds) {
		for (int i = 0; i < TimeOutinSeconds; i++) {
			try {
				Thread.sleep(500);
				webDr.switchTo().alert();
				passed("Check the presence of Alert",
						"Alert should be present ", "Alert is present");
				return true;
			} catch (Exception e) {
				failed("Check the presence of Alert",
						"Alert should be present ", "Alert is not present");
				logger.handleError("Failed to verify presence of alert", e);
			}
		}
		return false;
	}

	/**
	 * For highlighting an element
	 * 
	 * @param elementName
	 *            Locator
	 */

	public void drawHighlight(String elementName) {
		WebElement element = getControl(elementName);
		try {
			JavascriptExecutor js = ((JavascriptExecutor) webDr);
			js.executeScript("arguments[0].style.border='2px groove red'",
					element);
			passed("Draw highlight on " + elementName, elementName
					+ " should be highlighted", elementName
					+ " is highlighted successfully");
		} catch (Exception e) {
			failed("Draw highlight on " + elementName, elementName
					+ " should be highlighted", elementName
					+ " is not highlighted");
			logger.handleError("Failed to highlight element", elementName, " ",
					e);
		}

	}

	/**
	 * Retrieve drop down options
	 * 
	 * @param elementName
	 *            name of dropdown
	 * 
	 */
	public List<String> getDropDownOptions(String TagName) {
		List<String> optionsStr = new ArrayList<String>();
		try {
			List<WebElement> options = webDr.findElements(By
					.tagName(TagName));
			for (WebElement option : options) {
				optionsStr.add(option.getText());

			}
			passed("Get options from drop down " + TagName,
					"Should get options from drop down " + TagName,
					"Retrieved options from drop down " + TagName
					+ "successfully");
		} catch (Exception e) {
			failed("Get options from drop down " + TagName,
					"Should get options from drop down " + TagName,
					"Failed to get dropdown list for: " + TagName);
			logger.handleError("Failed to get dropdown list for: ",
					TagName, " ", e);
		}

		return optionsStr;
	}
	/**
	 * Retrieve drop down options
	 * 
	 * @param elementName
	 *            name of dropdown
	 * @return boolean results
	 */

	public boolean  getElementNameUsingTag(String TagName,String VerifyOption) {
		boolean tagExist = false;
		List<String> optionsStr = new ArrayList<String>();

		try {
			List<WebElement> options = webDr.findElements(By
					.tagName(TagName));
			for (WebElement option : options) {
				if (option.getText().toUpperCase().equals(VerifyOption.toUpperCase()))
				{

					tagExist = true;
				}
				if (tagExist)
				{
					break;
				}

			}
			passed("Get options from drop down " + TagName,
					"Should get options from drop down " + TagName,
					"Retrieved options from drop down " + TagName
					+ "successfully");
		} catch (Exception e) {
			failed("Get options from drop down " + TagName,
					"Should get options from drop down " + TagName,
					"Failed to get dropdown list for: " + TagName);

		}

		return tagExist;
	}



	/**
	 * checks the presence of specified options in the dropdown
	 * 
	 * @param elementName
	 *            name of element
	 * @param optionsStr
	 *            options to be checked with comma separated values
	 * 
	 * 
	 */
	public boolean checkDropDownOptions(String TagName, String optionsStr) {
		List<Object> flag = new ArrayList<Object>();
		List<String> dropDownOptions = getDropDownOptions(TagName);
		List<String> dropDownOptionsLowerCase = new ArrayList<String>();
		for (String temp : dropDownOptions) {
			dropDownOptionsLowerCase.add(temp.trim().toLowerCase());
		}
		String[] dropDownOptionsActList = optionsStr.split(",");
		try {
			for (int i = 0; i < dropDownOptionsActList.length; i++) {
				if (dropDownOptionsLowerCase.contains(dropDownOptionsActList[i]
						.trim().toLowerCase())) {
					flag.add(true);
				} else {
					flag.add(false);
				}
			}

		} catch (Exception e) {
			failed("Check options " + optionsStr + " in drop down "
					+ TagName, "Options " + optionsStr + " in drop down "
							+ TagName + " should be present",
							"Failed to verify option: " + optionsStr + " for "
									+ TagName);
			logger.handleError("Failed to verify option: ", optionsStr, "for ",
					TagName, " ", e);
		}
		if (flag.contains(false)) {
			failed("Check options " + optionsStr + " in drop down "
					+ TagName, "Options " + optionsStr + " in drop down "
							+ TagName + " should be present",
							"Failed to verify option: " + optionsStr + " for "
									+ TagName);
			return false;
		} else {
			passed("Check options " + optionsStr + " in drop down "
					+ TagName, "Options " + optionsStr + " in drop down "
							+ TagName + " should be present",
							"Checked the presence of options " + optionsStr
							+ " in drop down " + TagName + "successfully");
			return true;
		}
	}

	/**
	 * Checks the attribute value
	 * 
	 * @param elementName
	 *            name of element
	 * 
	 * @param attribute
	 *            attribute to be set
	 * @param value
	 *            value of the attribute
	 */

	public boolean checkAtttribute(String elementName, String attribute,
			String value) {

		String actualValue = getAttribute(elementName, attribute);
		if (value.equals(actualValue)) {
			passed("Check attribute " + attribute + " on element "
					+ elementName, " Should Check attribute " + attribute
					+ " on element " + elementName, "Check attribute "
							+ attribute + " on element " + elementName
							+ " is  done successfully");

			return true;
		}
		failed("Check attribute " + attribute + " on element " + elementName,
				" Should Check attribute " + attribute + " on element "
						+ elementName, "Failed to Check attribute " + attribute
						+ " on element ");
		return false;
	}

	/**
	 * Sets the attribute value
	 * 
	 * @param elementName
	 *            name of element
	 * 
	 * @param attribute
	 *            attribute to be set
	 * @param value
	 *            value of the attribute
	 */
	public void setAttribute(String elementName, String attribute, String value) {
		try {
			WebElement element = getControl(elementName);
			JavascriptExecutor js = (JavascriptExecutor) webDr;
			js.executeScript(
					"arguments[0].setAttribute(arguments[1], arguments[2])",
					element, attribute, value);
			passed("Set attribute " + attribute + " on element " + elementName,
					" Should Set attribute " + attribute + " on element "
							+ elementName, "Set attribute " + attribute
							+ " on element " + elementName
							+ " is  done successfully");
		} catch (Exception e) {
			failed("Set attribute " + attribute + " on element " + elementName,
					" Should Set attribute " + attribute + " on element "
							+ elementName, "Failed to Set attribute "
									+ attribute + " on element " + elementName);
			logger.handleError("Failed to set ", value, " for attribute ",
					attribute, " for the element ", elementName, " ", e);
		}
	}

	/**
	 * Gets the attribute value
	 * 
	 * @param elementName
	 *            name of element
	 * 
	 * @param attribute
	 *            attribute name
	 * */
	public String getAttribute(String elementName, String attribute) {
		WebElement element = getControl(elementName);
		try {
			String value = element.getAttribute(attribute);
			passed("get attribute " + attribute + "from element " + elementName,
					" Should get attribute " + attribute + " from element "
							+ elementName, "get attribute " + attribute
							+ " from element " + elementName
							+ " is  done successfully");
			return value;
		} catch (Exception e) {
			failed("get attribute " + attribute + " from element "
					+ elementName, " Should get attribute " + attribute
					+ " from element " + elementName,
					"Failed to get attribute " + attribute + " from element "
							+ elementName);
			logger.handleError("Failed to get value for attribute ", attribute,
					" for the element ", elementName, " ", e);
			return null;
		}
	}

	/**
	 * Executes Javascript
	 * 
	 * @param script
	 *            script to be executed
	 **/
	public void executeJavaScript(String script) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) webDr;
			js.executeScript(script);
			passed("Execute javascript " + script, script
					+ " should be executed", script + " executed successfully");
		} catch (Exception e) {
			failed("Execute javascript " + script, script
					+ " should be executed", "Falied to execute " + script);
			logger.handleError("Falied to execute ", script);
		}
	}

	/**
	 * For Double clicking on any element
	 * 
	 * @param elementName
	 *            name of element
	 */

	public void doubleclick(String elementName) {
		Actions axn = new Actions(webDr);
		try {
			axn.doubleClick(getControl(elementName)).build().perform();
			passed("double click on element" + " " + elementName, " "
					+ "element" + " " + elementName + " "
					+ "should be double clicked", "element" + " " + elementName
					+ " " + "double clicked successfully");
		} catch (Exception e) {

			failed("double click on element", " " + elementName + " "
					+ "element" + " " + elementName + " "
					+ "should be double clicked",
					"Failed to double click on element" + " " + elementName);
			logger.handleError("Failed to double click on " + elementName, e);

		}
	}

	/**
	 * For right clicking on any element
	 * 
	 * @param elementName
	 *            name of element
	 */

	public void rightClick(String elementName, int option) {
		Actions action = new Actions(webDr);
		Actions act = null;
		try {
			for (int i = 0; i < option - 1; i++) {
				act = action.contextClick(getControl(elementName)).sendKeys(
						Keys.ARROW_DOWN);
				act.build().perform();

			}
			act.sendKeys(Keys.ENTER).build().perform();
			passed("right click on element" + " " + elementName, " "
					+ "element" + " " + elementName + " "
					+ "should be right clicked", "element" + " " + elementName
					+ " " + "Right clicked successfully");
		} catch (Exception e) {
			failed("Right click on element" + " " + elementName, " "
					+ "element" + " " + elementName + " "
					+ "should be Right clicked", "element" + " " + elementName
					+ " " + "Right clicked successfully");

		}
	}

	/**
	 * Shut downs the webdriver
	 */
	public void closeBrowsers() {
		if (webDr != null)
			browser.closeDriver();
	}

	/**
	 * Takes screenshot
	 */
	public File takescreenshot() {
		try {
			File scrFile = ((TakesScreenshot) webDr)
					.getScreenshotAs(OutputType.FILE);

			return scrFile;
		} catch (Exception e) {
			logger.handleError("Failed to take screenshots", e);
			return null;
		}
	}

	/**
	 * Clear cookies
	 */
	public void clearCookies() {
		try {
			webDr.manage().deleteAllCookies();
		} catch (Exception e) {

			logger.handleError("Failed to clear cookies", e);
		}
	}

	/**
	 * Check the running process and kill it
	 * 
	 * @param serviceName
	 *            Give name of the process that you want to kill
	 * @return Boolean
	 * @throws IOException
	 */

	public void killProcess(String serviceName) throws IOException {
		String line;
		Process p = Runtime.getRuntime().exec(
				System.getenv("windir") + "\\system32\\" + "tasklist.exe");
		BufferedReader input = new BufferedReader(new InputStreamReader(
				p.getInputStream()));
		try {
			while ((line = input.readLine()) != null) {
				if (line.contains(serviceName)) {
					Runtime.getRuntime().exec("taskkill /f /IM " + serviceName);
				}
			}
			input.close();
		} catch (Exception e) {
			logger.handleError("Failed to kill ", serviceName, e);

		}
	}

	/**
	 * Checks whether the page is loaded or not
	 * 
	 * @param maxTimeInSec
	 *            time to wait(In seconds)
	 * @return boolean result
	 */
	public boolean waitForBrowserStability(int timeout) {
		boolean bResult = false;
		int secsWaited = 0;
		try {
			do {
				Thread.sleep(100);
				secsWaited++;
				if (isBrowserLoaded()) {
					bResult = true;
					break;
				}
			} while (secsWaited < (timeout * 10));
			Thread.sleep(100);

		} catch (Exception e) {
			logger.handleError("Error while waiting for the page to load ", e);
			bResult = false;
		}
		return bResult;
	}

	/**
	 * Checks if body of the page is loaded or not
	 * 
	 * @return Boolean Result
	 */
	public boolean isBrowserLoaded() {
		boolean isBrowserLoaded = false;
		try {
			long timeOut = 5000;
			long end = System.currentTimeMillis() + timeOut;

			while (System.currentTimeMillis() < end) {

				if (String.valueOf(
						((JavascriptExecutor) webDr)
						.executeScript("return document.readyState"))
						.equals("complete")) {
					isBrowserLoaded = true;
					break;
				}
			}
		} catch (Exception e) {
			logger.handleError("Failed to check for the browser to load", e);
		}
		return isBrowserLoaded;
	}

	public void wait(int mS) {
		try {
			Thread.sleep(mS);

		} catch (Exception e) {
			logger.handleError("Error in synchronization", e);
		}

	}

	/**
	 * Checks the presence of element
	 * 
	 * @param elementName
	 *            name of the element
	 * @return Boolean Result
	 */
	public boolean checkVisible(String elementName) {

		boolean result = false;
		try {
			if (getControl(elementName).isDisplayed()) {
				result = true;
			}
		}

		catch (Exception e) {
			logger.trace("Error: Caused while Verifying the Presence of Element \" "
					+ elementName + " \"");
		}

		return result;
	}

	/**
	 * Sets the focus to given frame
	 * 
	 * @param frame
	 *            Locator
	 * 
	 */
	public void setFrame(String frame) {
		try {
			if (checkVisible(frame)) {
				webDr.switchTo().frame(getControl(frame));
				passed("Switch to frame" + frame, "Should switch to frame",
						"Switched to frame " + frame);
				logger.trace("Navigated to frame with element name" + frame);
			}
		} catch (NoSuchFrameException e) {
			failed("Switch to frame" + frame, "Should switch to frame",
					"Failed to Switch to frame " + frame);
			logger.trace("Unable to locate frame with element name " + frame);
		} catch (Exception e) {
			failed("Switch to frame" + frame, "Should switch to frame",
					"Failed to switch to frame " + frame);
			logger.trace("Unable to navigate to frame with element name "
					+ frame);
		}

	}

	/**
	 * Return the focus to the parent frame
	 * 
	 */

	public void resetFrame() {
		try {
			webDr.switchTo().defaultContent();
			passed("Switch to parent frame", "Should switch to parent frame",
					"Switched to parent frame ");
			logger.trace("Navigated back to webpage from frame");
		} catch (Exception e) {
			failed("Switch to parent frame", "Should switch to parent frame",
					"Failed to Switch to parent frame ");
			logger.trace("Unable to navigate back to main webpage from frame"
					+ e.getStackTrace());
		}

	}

	/**
	 * Method to send SOAP Request and
	 * @param string
	 * @param string2
	 * @param string3
	 * @param string4
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 */

	public void fetchSoapRequest(String _filePath, String _interfaceName, String _operationName,
			String _requestName) throws ParserConfigurationException, SAXException, IOException {

		DocumentBuilderFactory _dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder _dBuilder = _dbFactory.newDocumentBuilder();


		File _xmlFilePath = new File(_filePath);
		Document _docXML = _dBuilder.parse(_xmlFilePath);

		_docXML.getDocumentElement().normalize();
		for(int i = 0 ; i <_docXML.getElementsByTagName("con:interface").getLength();i++)
		{
			Element _interfaceNodeElement = (Element) _docXML.getElementsByTagName("con:interface").item(i);
			if(_interfaceNodeElement.getAttribute("name").equals(_interfaceName))
			{
				for(int j = 0 ; j <_docXML.getElementsByTagName("con:operation").getLength();j++)
				{
					Element _operationNodeElement = (Element) _docXML.getElementsByTagName("con:operation").item(j);
					if(_operationNodeElement.getAttribute("name").equals(_operationName))
					{
						for(int k = 0 ; k <_docXML.getElementsByTagName("con:call").getLength();k++)
						{
							Element _requestNodeElement = (Element) _docXML.getElementsByTagName("con:call").item(k);
							if(_requestNodeElement.getAttribute("name").equals(_requestName))
							{
								_xmlSoapRequest = _docXML.getElementsByTagName("con:request").item(k).getTextContent();
								_xmlSoapRequest = _xmlSoapRequest.trim();
								System.out.println(_xmlSoapRequest);
								break;

							}

						}

					}

				}
			}
		}

	}
	/**
	 * 
	 * @param _url
	 * @param _acceptEncoding
	 * @param _contentType
	 * @param _userAgent
	 * @param _proxyConnection
	 * @param _host
	 */
	public void sendSoapRequest(String _url, String _acceptEncoding, String _contentType,
			String _userAgent, String _proxyConnection, String _host,String _sysProxy) {
		try {
			String _requestXML = _xmlSoapRequest.toString();

			System.setProperty("java.net.useSystemProxies",_sysProxy);

			// Provide the url to send request
			URL url = new URL(_url);
			java.net.URLConnection conn = url.openConnection();

			// Set the necessary header fields
			conn.setRequestProperty("Accept-Encoding", _acceptEncoding);
			conn.setRequestProperty("Content-Type",_contentType);
			conn.setRequestProperty("User-Agent",_userAgent);
			conn.setRequestProperty("Proxy-Connection",_proxyConnection);
			conn.setRequestProperty("Host", _host);
			// conn.setRequestProperty("SOAPAction","http://www.webserviceX.NET/ConvertTemp");
			conn.setDoOutput(true);

			// Send the request
			java.io.OutputStreamWriter wr = new java.io.OutputStreamWriter(
					conn.getOutputStream());
			wr.write(_requestXML);
			wr.flush();

			// Read the response
			java.io.BufferedReader rd = new java.io.BufferedReader(
					new java.io.InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = rd.readLine()) != null) {
				System.out.println(line); // jEdit: print(line);
				_xmlSoapResponse = line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public String fetchSoapResponse(String reqTagName) throws SAXException, IOException, ParserConfigurationException {

		String fetchedData = null;
		try {

			DocumentBuilderFactory _dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder _dBuilder = _dbFactory.newDocumentBuilder();

			Document _rdocXML = _dBuilder.parse(new InputSource(
					new StringReader(_xmlSoapResponse)));
			_rdocXML.getDocumentElement().normalize();

			for (int i = 0; i < _rdocXML.getElementsByTagName(reqTagName)
					.getLength(); i++) {
				Element _interfaceNodeElement = (Element) _rdocXML
						.getElementsByTagName(reqTagName).item(i);
				fetchedData = _interfaceNodeElement.getTextContent();
				System.out.println(_interfaceNodeElement.getTextContent());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return fetchedData;

	}

	public void sendKey(Keys down){

	}


	/**
	 * For HotKeys clicking 
	 * 
	 * @param KeyLetter
	 *            name of element
	 */

	public void HotKeys(String KeyLetter) {
		Actions axn = new Actions(webDr);
		try {
			axn.keyDown(Keys.SHIFT).keyDown(Keys.ALT).sendKeys(KeyLetter).keyUp(Keys.SHIFT).keyUp(Keys.ALT).perform();
			//axn.doubleClick(getControl(elementName)).build().perform();
			passed("double click on element" + " " + KeyLetter, " "
					+ "element" + " " + KeyLetter + " "
					+ "should be double clicked", "element" + " " + KeyLetter
					+ " " + "double clicked successfully");
		} catch (Exception e) {

			failed("double click on element", " " + KeyLetter + " "
					+ "element" + " " + KeyLetter + " "
					+ "should be double clicked",
					"Failed to double click on element" + " " + KeyLetter);
			logger.handleError("Failed to double click on " + KeyLetter, e);

		}
	}
	/**
	 *Verify Actual and expected value of web Elment
	 * 
	 * @param KeyLetter
	 *            name of element
	 * @return boolean results
	 */

	public boolean verifyTextActAndExp(String elementName, String expectedText) {
		String actualText =getControl(elementName).getText(); 
		if (actualText.equalsIgnoreCase(expectedText)) {

			passed("Verify text on " + " " + elementName + " with text"
					+ expectedText + "", "Text" + expectedText
					+ " should be verified", "verified successfully");

			return true;
		}
		failed("Verify text on " + " " + elementName + " with text"
				+ expectedText + "", "Text" + expectedText
				+ " should be verified", "verified unsuccessfully");
		return false;
	}

	/**
	 *Verify Actual and expected value of Web Edit
	 * 
	 * @param KeyLetter
	 *            name of element
	 * @return boolean results
	 */
	public boolean verifyTextforWebEdit(String elementName, String expectedText) {
		String actualText =getControl(elementName).getAttribute("value"); 
		if (actualText.equalsIgnoreCase(expectedText)) {

			passed("Verify text on " + " " + elementName + " with text"
					+ expectedText + "", "Text" + expectedText
					+ " should be verified", "verified successfully");

			return true;
		}
		failed("Verify text on " + " " + elementName + " with text"
				+ expectedText + "", "Text" + expectedText
				+ " should be verified", "verified unsuccessfully");
		return false;
	}
	/**
	 *Convert sring to Integer
	 * 
	 * @param KeyLetter
	 *            name of element
	 * @return Integer results
	 */

	public String ConvertStringToInteger(String value,String Splchar) {
		int i;
		String Rep=null;
		String Rep1 = null;
		String[] splCnt=Splchar.split("|");
		for(i=0; i < splCnt.length ; i++) {
			switch (splCnt[i]) {
			case "$":
				Rep=value.replace(splCnt[i], "");
				break;
			case ",":
				return  Rep1=Rep.replace(splCnt[i], "");

			}
		}
		return Rep1;

	}
	/**
     * changing the String date to short date 
      * 
      * @param elementName
     *                 Original and Target actual date  
      * @return String
     */

     public String StringToShortdate(String Orginal,String target,String Actualdate) {

            DateFormat originalFormat = new SimpleDateFormat(Orginal);
            DateFormat targetFormat = new SimpleDateFormat(target);
            java.util.Date date = null;
            try {
                   date = originalFormat.parse(Actualdate);
            } catch (ParseException e) {
                   e.printStackTrace();
            }
            String formattedDate = targetFormat.format(date);

            return formattedDate;
     }


	
	/**
	 * Overriding toString() method to return WebUIDriver format string
	 */
	public String toString() {
		return StringUtils.mapString(this);
	}

	public static WebDriver webDr;
	private static ObjectMap objMap;
	private Browser browser;
	public TableHandler th;
	public String _xmlSoapRequest ; 
	public String _xmlSoapResponse ;
	private LogUtils logger = new LogUtils(this);
	private BaseWebModuleDriver basewebmoddr;



}
