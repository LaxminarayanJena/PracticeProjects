/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 3/2/2018 5:01:19 AM
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
public class US999_Transfer_Funds_Producer_LevelDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US999_Transfer_Funds_Producer_LevelDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void VerifyField_ProdLevel(DataRow input, DataRow output) {
		// 1. Click on Actions WebElement
		uiDriver.click("VerifyField_ProdLevel.eltActions");

		// 2. Verify whether the Transfer_Funds element present
		if (!uiDriver.checkElementPresent("VerifyField_ProdLevel.eltTransfer_Funds")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
	}

	public void VerifyField_Desk_AccLevel(DataRow input, DataRow output) {
		// 1. Click on Actions WebElement
		uiDriver.click("VerifyField_Desk_AccLevel.eltActions");

		// 2. Click on New_Transaction WebElement
		uiDriver.mouseOver("VerifyField_Desk_AccLevel.eltNew_Transaction");
		SleepUtils.sleep(2);

		// 3. Verify whether the Transfer element present
		if (!uiDriver.checkElementPresent("VerifyField_Desk_AccLevel.eltTransfer")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 4. Verify whether the Transfer_Funds_Reversal element present
		if (!uiDriver.checkElementPresent("VerifyField_Desk_AccLevel.eltTransfer_Funds_Reversal")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		uiDriver.sendKey("Esc");

		// 5. Click on Desktop WebElement
		uiDriver.click("VerifyField_Desk_AccLevel.eltDesktop");

		// 6. Click on Desk_Actions WebElement
		uiDriver.click("VerifyField_Desk_AccLevel.eltDesk_Actions");

		// 7. Click on Desk_New_Transaction WebElement
		uiDriver.click("VerifyField_Desk_AccLevel.eltDesk_New_Transaction");

		// 8. Verify whether the Transfer element present
		if (!uiDriver.checkElementPresent("VerifyField_Desk_AccLevel.eltTransfer")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 9. Verify whether the Transfer_Funds_Reversal element present
		if (!uiDriver.checkElementPresent("VerifyField_Desk_AccLevel.eltTransfer_Funds_Reversal")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		uiDriver.sendKey("Esc");
	}

	/**
	 * Overriding toString() method of object class to print
	 * US999_Transfer_Funds_Producer_Level format string
	 **/
	public String toString() {
		return "US999_Transfer_Funds_Producer_LevelDriver";
	}
}