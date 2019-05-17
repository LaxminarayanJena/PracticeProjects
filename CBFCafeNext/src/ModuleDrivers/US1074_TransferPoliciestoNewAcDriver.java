/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 2/27/2018 1:28:58 AM
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
public class US1074_TransferPoliciestoNewAcDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US1074_TransferPoliciestoNewAcDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void US1074_TransferPoliciestoNewAc(DataRow input, DataRow output) {
		// 1. Click on Account WebElement
		uiDriver.click("US1074_TransferPoliciestoNewAc.eltAccount");

		// 2. Type $data in Account_Name field
		uiDriver.setValue("US1074_TransferPoliciestoNewAc.txtAccount_Name", input.get("Type@Account_Name"));

		// 3. Click on Search button
		uiDriver.click("US1074_TransferPoliciestoNewAc.btnSearch");

		// 4. Verify whether the Account link is present
		if (uiDriver.checkElementPresent("US1074_TransferPoliciestoNewAc.lnkAccount")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(2);

		// 5. Click on Account Link
		uiDriver.click("US1074_TransferPoliciestoNewAc.lnkAccount_");

		// 6. Click on Actions button
		uiDriver.click("US1074_TransferPoliciestoNewAc.btnActions");
		SleepUtils.sleep(6);

		// 7. Verify whether the Transfer_Policies element present
		if (uiDriver.checkElementPresent("US1074_TransferPoliciestoNewAc.eltTransfer_Policies")) {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed ");
		} else {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		}
	}

	/**
	 * Overriding toString() method of object class to print
	 * US1074_TransferPoliciestoNewAc format string
	 **/
	public String toString() {
		return "US1074_TransferPoliciestoNewAcDriver";
	}
}