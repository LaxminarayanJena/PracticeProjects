/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 3/5/2018 1:55:51 AM
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
public class US1388_NEP_Debit_AdjustmentDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US1388_NEP_Debit_AdjustmentDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void TC01_NEPPaymentreversal(DataRow input, DataRow output) {
		// 1. Click on Account WebElement
		uiDriver.click("TC01_NEPPaymentreversal.eltAccount");

		// 2. Type $data in Account_Name field
		uiDriver.setValue("TC01_NEPPaymentreversal.txtAccount_Name", input.get("Type@Account_Name"));

		// 3. Click on Search button
		uiDriver.click("TC01_NEPPaymentreversal.btnSearch");

		// 4. Verify whether the Account link is present
		if (uiDriver.checkElementPresent("TC01_NEPPaymentreversal.lnkAccount")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 5. Click on Account_ Link
		uiDriver.click("TC01_NEPPaymentreversal.lnkAccount_");

		// 6. Click on Actions button
		uiDriver.click("TC01_NEPPaymentreversal.btnActions");

		// 7. Click on NEP WebElement
		uiDriver.click("TC01_NEPPaymentreversal.eltNEP");

		// 8. Click on Debit_Adjustment WebElement
		uiDriver.click("TC01_NEPPaymentreversal.eltDebit_Adjustment");

		// 9. Click on Payment_Reversal WebElement
		uiDriver.click("TC01_NEPPaymentreversal.eltPayment_Reversal");

		// 10. Click on Button Cancel
		uiDriver.click("TC01_NEPPaymentreversal.btnCancel");
		SleepUtils.sleep(2);
		uiDriver.click("TC01_NEPPaymentreversal.btnOk");
		SleepUtils.sleep(8);
	}

	public void TC02_NEP_Debit_Adjustment(DataRow input, DataRow output) {
		// 1. Click on Account WebElement
		uiDriver.click("TC02_NEP_Debit_Adjustment.eltAccount");
		SleepUtils.sleep(5);

		// 2. Type $data in Account_Name field
		uiDriver.setValue("TC02_NEP_Debit_Adjustment.txtAccount_Name", input.get("Type@Account_Name"));

		// 3. Click on Search button
		uiDriver.click("TC02_NEP_Debit_Adjustment.btnSearch");
		SleepUtils.sleep(6);

		// 4. Verify whether the Account link is present
		if (uiDriver.checkElementPresent("TC02_NEP_Debit_Adjustment.lnkAccount")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 5. Click on Account_ Link
		uiDriver.click("TC02_NEP_Debit_Adjustment.lnkAccount_");
		SleepUtils.sleep(3);

		// 6. Click on Actions button
		uiDriver.click("TC02_NEP_Debit_Adjustment.btnActions");
		SleepUtils.sleep(3);

		// 7. Click on NEP WebElement
		uiDriver.click("TC02_NEP_Debit_Adjustment.eltNEP");
		SleepUtils.sleep(2);

		// 8. Click on Debit_Adjustment WebElement
		uiDriver.click("TC02_NEP_Debit_Adjustment.eltDebit_Adjustment");
		SleepUtils.sleep(2);

		// 9. Click on Payment_Reversal WebElement
		uiDriver.click("TC02_NEP_Debit_Adjustment.eltPayment_Reversal");
		SleepUtils.sleep(4);

	}

	/**
	 * Overriding toString() method of object class to print
	 * US1388_NEP_Debit_Adjustment format string
	 **/
	public String toString() {
		return "US1388_NEP_Debit_AdjustmentDriver";
	}
}
