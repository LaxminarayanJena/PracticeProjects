/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/16/2017 3:16:49 AM
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
public class US1094_Assign_payerto_verifthereverseDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US1094_Assign_payerto_verifthereverseDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void Assign_payerto_Verifthereverse(DataRow input, DataRow output) {
		// 1. Click on Actions WebElement
		uiDriver.click("Assign_payerto_Verifthereverse.btnActions");

		// 2. Click on New_Transaction WebElement
		uiDriver.click("Assign_payerto_Verifthereverse.eltNew_Transaction");

		// 3. Click on Charge Reversal WebElement
		uiDriver.click("Assign_payerto_Verifthereverse.eltCharge Reversal");

		// 4. Select $data from the Type list
		uiDriver.setValue("Assign_payerto_Verifthereverse.lstType", input.get("Select@Type"));

		// 5. Type $data in Account field
		uiDriver.setValue("Assign_payerto_Verifthereverse.txtAccount", input.get("Type@Account"));

		// 6. Click on Search button
		uiDriver.click("Assign_payerto_Verifthereverse.btnSearch");

		// 7. Click on Select button
		uiDriver.click("Assign_payerto_Verifthereverse.btnSelect");

		// 8. Select $data from the Reversal_Reason list
		uiDriver.setValue("Assign_payerto_Verifthereverse.lstReversal_Reason", input.get("Select@Reversal_Reason"));

		// 9. Click on Finish button
		uiDriver.click("Assign_payerto_Verifthereverse.btnFinish");
		SleepUtils.sleep(2);
		
		//10. Verify the transaction
		uiDriver.click("Assign_payerto_Verifthereverse.tbaccount");
		uiDriver.setValue("Assign_payerto_Verifthereverse.txtaccountnumber", input.get("Type@Account"));
		uiDriver.click("Assign_payerto_Verifthereverse.btnsearch");
		uiDriver.click("Assign_payerto_Verifthereverse.lnkaccountnumber");
		uiDriver.click("Assign_payerto_Verifthereverse.eltCharges");
		SleepUtils.sleep(2);
		uiDriver.click("Assign_payerto_Verifthereverse.eltHistory");
		SleepUtils.sleep(2);
		uiDriver.click("Assign_payerto_Verifthereverse.btnsort");
		SleepUtils.sleep(2);
		
		// 11. Verify the transaction in the history table
		String actualTextName = uiDriver.th.getCellData("Assign_payerto_Verifthereverse.tbname", 0, 4);
		String expectedTextName = "Charge Reversed";

		if (actualTextName.equalsIgnoreCase(expectedTextName)) {
			passed("verifyText", "verifyText should pass", "verifyText passed");
		} else {
			failed("verifyText", "verifyText should pass", "verifyText failed");
		}
	}

	/**
	 * Overriding toString() method of object class to print
	 * Assign_payerto_verifthereverse format string
	 **/
	public String toString() {
		return "Assign_payerto_verifthereverseDriver";
	}
}
