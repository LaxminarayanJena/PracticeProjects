/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/5/2017 1:30:15 PM
Module part of 'Guidewire_BillingCenter'
Module created using Cafenext Selenium Builder
******************************************************************************/
package ModuleDrivers;

import static cbf.engine.TestResultLogger.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cbf.engine.TestResult.ResultType;
import cbf.harness.ParameterAccess;
import cbf.utils.DataRow;
import cbf.utils.SleepUtils;
import cbf.utils.SleepUtils.TimeSlab;
import cbfx.selenium.BaseWebModuleDriver;
import cbfx.selenium.WebUIDriver;

/**
 * Extends BaseModuleDriver class and performs application specific operations
 */
public class US723_126_PolicyLevelHistoryDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US723_126_PolicyLevelHistoryDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void PolicyLevelHistory(DataRow input, DataRow output) {

		// 1. Click on Policy WebElement
		uiDriver.click("PolicyLevelHistory.eltPolicy");

		// 2. Click on Policy WebElement
		uiDriver.click("PolicyLevelHistory.lnkPolicy");

		// 3. Click on Actions WebElement
		uiDriver.click("PolicyLevelHistory.eltActions");

		// 4. Click on Create_New_Document_from_Template WebElement
		uiDriver.click("PolicyLevelHistory.eltCreate_New_Document_from_Template");

		// 5. Click on Document_Template WebElement
		uiDriver.click("PolicyLevelHistory.eltDocument_Template");

		// 6. Type $data in Document_Template field
		uiDriver.setValue("PolicyLevelHistory.txtDocument_Template", input.get("Type@Document_Template"));

		// 7. Click on Create_Document button
		uiDriver.click("PolicyLevelHistory.btnCreate_Document");

		// 8. Click on History_tab WebElement
		SleepUtils.sleep(5);
		uiDriver.click("PolicyLevelHistory.eltHistory_tab");
		SleepUtils.sleep(2);

		// 9. Filter according to Email Sent for Policy Period
		uiDriver.doubleclick("PolicyLevelHistory.eltFilterBy");
		uiDriver.setValue("PolicyLevelHistory.txtFilterBy", input.get("Type@Filter"));
		uiDriver.sendKey("enter");
		SleepUtils.sleep(2);

		// 10. Verification of Audit Info Request Sent in the History
		uiDriver.click("PolicyLevelHistory.btnsort");
		SleepUtils.sleep(2);
		String actualTextName = uiDriver.th.getCellData("PolicyLevelHistory.tbname1", 0, 5);
		SleepUtils.sleep(5);
		String expectedTextName = "Audit Info Request Sent";

		if (actualTextName.equalsIgnoreCase(expectedTextName)) {
			passed("verifyText", "verifyText should pass", "verifyText passed");
		} else {
			failed("verifyText", "verifyText should pass", "verifyText failed");
		}

		// Create and sending email with document attachment

		// 1. Click on Actions button
		uiDriver.click("PolicyLevelHistory.btnActions");

		// 2. Click on New_Email WebElement
		uiDriver.click("PolicyLevelHistory.eltNew_Email");

		// 3. Click on New_Email_Sub WebElement
		uiDriver.click("PolicyLevelHistory.eltNew_Email_Sub");
		SleepUtils.sleep(3);

		// 4. Type $data in Name field
		uiDriver.sendKey("enter");
		uiDriver.setValue("PolicyLevelHistory.txtName", input.get("Type@Name"));
		SleepUtils.sleep(1);

		// 5. Type $data in Email field
		uiDriver.click("PolicyLevelHistory.txtEmailbox");
		uiDriver.setValue("PolicyLevelHistory.txtEmail", input.get("Type@Email"));

		// 6. Type $data in Subject field
		uiDriver.setValue("PolicyLevelHistory.txtSubject", input.get("Type@Subject"));

		// 7. Type $data in body field and set the value
		uiDriver.click("PolicyLevelHistory.eltbody");
		uiDriver.setValue("PolicyLevelHistory.txtbody", input.get("Type@body"));
		SleepUtils.sleep(2);

		// 8. Click on add button
		uiDriver.click("PolicyLevelHistory.btnAdd");
		SleepUtils.sleep(15);

		// 9. Click on search button for the attachment
		uiDriver.click("PolicyLevelHistory.btnsearch");
		SleepUtils.sleep(2);

		// 10. Select the document for attachment
		uiDriver.click("PolicyLevelHistory.btnselect");

		// 11. Click on Send_Email button
		uiDriver.click("PolicyLevelHistory.btnSend_Email");
		SleepUtils.sleep(3);
	}

	/**
	 * Overriding toString() method of object class to print PolicyLevelHistory
	 * format string
	 **/
	public String toString() {
		return "PolicyLevelHistoryDriver";
	}
}
