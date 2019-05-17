/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 3/1/2018 1:26:07 AM
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
public class US1383_Transfer_Funds_AccountDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US1383_Transfer_Funds_AccountDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void US1383_Transfer_Funds_Account(DataRow input, DataRow output) {
		// 1. Click on Account WebElement
		uiDriver.click("US1383_Transfer_Funds_Account.eltAccount");
		SleepUtils.sleep(2);

		// 2. Type $data in Account_Name field
		uiDriver.setValue("US1383_Transfer_Funds_Account.txtAccount_Name", input.get("Type@Account_Name"));
		SleepUtils.sleep(2);

		// 3. Click on Search button
		uiDriver.click("US1383_Transfer_Funds_Account.btnSearch");
		SleepUtils.sleep(2);

		// 4. Verify whether the Account link is present
		if (uiDriver.checkElementPresent("US1383_Transfer_Funds_Account.lnkAccount")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(2);

		// 5. Click on Account_ Link
		uiDriver.click("US1383_Transfer_Funds_Account.lnkAccount_");
		SleepUtils.sleep(2);

		// 6. Click on Actions button
		uiDriver.click("US1383_Transfer_Funds_Account.btnActions");
		SleepUtils.sleep(2);

		// 7. Click on New_Transaction WebElement
		uiDriver.click("US1383_Transfer_Funds_Account.eltNew_Transaction");
		SleepUtils.sleep(2);

		// 8. Verify whether the Transfer_Funds element present
		if (uiDriver.checkElementPresent("US1383_Transfer_Funds_Account.eltTransfer_Funds")) {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed ");
		} else {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		}

	}

	/**
	 * Overriding toString() method of object class to print
	 * US1383_Transfer_Funds_Account format string
	 **/
	public String toString() {
		return "US1383_Transfer_Funds_AccountDriver";
	}
}