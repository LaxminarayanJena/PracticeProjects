/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 3/2/2018 1:23:42 AM
Module part of 'Guidewire_BillingCenter'
Module created using Cafenext Selenium Builder
 ******************************************************************************/
package ModuleDrivers;

import static cbf.engine.TestResultLogger.*;
import java.io.IOException;
import cbf.engine.TestResult.ResultType;
import cbf.harness.ParameterAccess;
import cbf.utils.DataRow;
import cbf.utils.SleepUtils;
import cbf.utils.SleepUtils.TimeSlab;
import cbfx.selenium.BaseWebModuleDriver;

/**
 * Extends BaseModuleDriver class and performs application specific operations
 */
public class US1389_PolicySummaryScreenDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US1389_PolicySummaryScreenDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void TC01_ValidatePolicySummary(DataRow input, DataRow output) {
		// 1. Click on Account WebElement
		uiDriver.click("TC01_ValidatePolicySummary.eltAccount");
		SleepUtils.sleep(2);

		// 2. Type $data in Account_Name field
		uiDriver.setValue("TC01_ValidatePolicySummary.txtAccount_Name", input.get("Type@Account_Name"));
		SleepUtils.sleep(2);

		// 3. Click on Search button
		uiDriver.click("TC01_ValidatePolicySummary.btnSearch");
		SleepUtils.sleep(2);

		// 4. Verify whether the Account link is present
		if (uiDriver.checkElementPresent("TC01_ValidatePolicySummary.lnkAccount")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		
		// 5. Click on Account_ Link
		SleepUtils.sleep(2);
		uiDriver.click("TC01_ValidatePolicySummary.lnkAccount_");
		SleepUtils.sleep(2);

		// 6. Click on Summary WebElement
		uiDriver.click("TC01_ValidatePolicySummary.eltSummary");
		SleepUtils.sleep(2);

		// 7. Click on Policy_ WebElement
		uiDriver.click("TC01_ValidatePolicySummary.eltPolicy_");
		SleepUtils.sleep(2);

		// 8. Verify whether the Policy_Lifetime_field element present
		if (uiDriver.checkElementPresent("TC01_ValidatePolicySummary.eltPolicy_Lifetime_field")) {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		} else {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		}
		SleepUtils.sleep(2);

		// 9. Verify whether the Planned element present
		if (uiDriver.checkElementPresent("TC01_ValidatePolicySummary.eltPlanned")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		
		// 10. Verify whether the Current_Status_Breakdown element present
		SleepUtils.sleep(2);
		if (uiDriver.checkElementPresent("TC01_ValidatePolicySummary.eltCurrent_Status_Breakdown")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(2);

		// 11. Verify whether the rounded_number element present
		if (uiDriver.checkElementPresent("TC01_ValidatePolicySummary.eltrounded_number")) {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		} else {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		}

	}

	/**
	 * Overriding toString() method of object class to print
	 * US1389_PolicySummaryScreen format string
	 **/
	public String toString() {
		return "US1389_PolicySummaryScreenDriver";
	}
}
