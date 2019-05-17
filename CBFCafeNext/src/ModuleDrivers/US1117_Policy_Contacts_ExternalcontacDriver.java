/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/15/2017 2:01:29 AM
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
public class US1117_Policy_Contacts_ExternalcontacDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US1117_Policy_Contacts_ExternalcontacDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void Policy_Contacts_Externalcontac(DataRow input, DataRow output) {
		// 1. Click on Policy WebElement
		uiDriver.click("Policy_Contacts_Externalcontac.eltPolicy");

		// 2. Click on Policy_ Link
		uiDriver.click("Policy_Contacts_Externalcontac.lnkPolicy");

		// 3. Click on Summary WebElement
		uiDriver.click("Policy_Contacts_Externalcontac.eltSummary");

		// 4. Click on Contacts WebElement
		uiDriver.click("Policy_Contacts_Externalcontac.eltContacts");
	}

	/**
	 * Overriding toString() method of object class to print
	 * Policy_Contacts_Externalcontac format string
	 **/
	public String toString() {
		return "Policy_Contacts_ExternalcontacDriver";
	}
}
