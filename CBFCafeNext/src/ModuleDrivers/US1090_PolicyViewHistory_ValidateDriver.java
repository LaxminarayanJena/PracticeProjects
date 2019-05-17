/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/12/2017 1:23:54 AM
Module part of 'Guidewire_BillingCenter'
Module created using Cafenext Selenium Builder
******************************************************************************/
package ModuleDrivers;

import static cbf.engine.TestResultLogger.*;
import java.io.IOException;

import org.openqa.selenium.By;

import cbf.engine.TestResult.ResultType;
import cbf.harness.ParameterAccess;
import cbf.utils.DataRow;
import cbf.utils.SleepUtils;
import cbf.utils.SleepUtils.TimeSlab;
import cbfx.selenium.BaseWebModuleDriver;

/**
 * Extends BaseModuleDriver class and performs application specific operations
 */
public class US1090_PolicyViewHistory_ValidateDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US1090_PolicyViewHistory_ValidateDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void PolicyViewHistory_Validate(DataRow input, DataRow output) {
		// 1. Click on Policy WebElement
		uiDriver.click("PolicyViewHistory_Validate.eltPolicy");

		// 2. Click on Policy Link
		uiDriver.click("PolicyViewHistory_Validate.lnkPolicy");

		// 3. Click on History WebElement
		uiDriver.click("PolicyViewHistory_Validate.eltHistory");
		SleepUtils.sleep(2);

		// 4. Click on Print_Export button
		uiDriver.click("PolicyViewHistory_Validate.btnPrint_Export");
		SleepUtils.sleep(3);

		// 5. Click on Print as radio button and click ok button
		uiDriver.doubleclick("PolicyViewHistory_Validate.rdprintas");
		uiDriver.click("PolicyViewHistory_Validate.btnOk");
		SleepUtils.sleep(2);

		// 6. Select Export as radio button and click on Ok button
		uiDriver.doubleclick("PolicyViewHistory_Validate.rdexportas");
		uiDriver.click("PolicyViewHistory_Validate.btnOk");
		SleepUtils.sleep(2);

		// 7. Select custom radio button and clicks on Ok button
		uiDriver.doubleclick("PolicyViewHistory_Validate.rdcustom");
		SleepUtils.sleep(2);

		// 8. Selecting Check boxes for custom reports
		uiDriver.click("PolicyViewHistory_Validate.chDate");
		uiDriver.click("PolicyViewHistory_Validate.chDate");
		SleepUtils.sleep(2);
		uiDriver.click("PolicyViewHistory_Validate.chDescription");
		uiDriver.click("PolicyViewHistory_Validate.chDescription");
		SleepUtils.sleep(2);
		uiDriver.click("PolicyViewHistory_Validate.chRef");
		uiDriver.click("PolicyViewHistory_Validate.chRef");
		SleepUtils.sleep(2);
		uiDriver.click("PolicyViewHistory_Validate.chRelatedPeriod");
		uiDriver.click("PolicyViewHistory_Validate.chRelatedPeriod");
		SleepUtils.sleep(2);
		uiDriver.click("PolicyViewHistory_Validate.chUser");
		uiDriver.click("PolicyViewHistory_Validate.chUser");
		SleepUtils.sleep(2);
		uiDriver.click("PolicyViewHistory_Validate.chEverntType");
		uiDriver.click("PolicyViewHistory_Validate.chEverntType");
		SleepUtils.sleep(2);
		uiDriver.click("PolicyViewHistory_Validate.btnOk");
		SleepUtils.sleep(2);
	}

	/**
	 * Overriding toString() method of object class to print
	 * PolicyViewHistory_Validate format string
	 **/
	public String toString() {
		return "PolicyViewHistory_ValidateDriver";
	}
}