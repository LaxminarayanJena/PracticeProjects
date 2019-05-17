/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/1/2017 4:24:22 AM
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
public class US1089_ViewPoliciesAccountDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US1089_ViewPoliciesAccountDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void US1089_ViewPoliciesAccount(DataRow input, DataRow output) {

		// 1. Verify whether the Product element present
		uiDriver.click("US1089_ViewPoliciesAccount.eltProduct");
		SleepUtils.sleep(2);
		if (uiDriver.checkElementPresent("US1089_ViewPoliciesAccount.eltProduct")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 2. Click on Policies WebElement
		uiDriver.click("US1089_ViewPoliciesAccount.eltPolicies");

		// 3. Verify whether the Product element present
		if (uiDriver.checkElementPresent("US1089_ViewPoliciesAccount.eltProductPolicies")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

	}

	/**
	 * Overriding toString() method of object class to print
	 * US1089_ViewPoliciesAccount format string
	 **/
	public String toString() {
		return "US1089_ViewPoliciesAccountDriver";
	}
}
