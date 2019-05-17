/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/6/2017 3:51:15 AM
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
public class US86_SearchInvoicesDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US86_SearchInvoicesDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void SearchInvoices(DataRow input, DataRow output) {
		// 1. Click on Search WebElement
		uiDriver.click("SearchInvoices.eltSearch");

		// 2. Click on Inovices WebElement
		uiDriver.click("SearchInvoices.eltInovices");

		// 3. Type $data in Inovices field
		uiDriver.setValue("SearchInvoices.txtInovices", input.get("Type@Inovices"));

		// 4. Click on Search button
		uiDriver.click("SearchInvoices.btnSearch");

		// 5. Verify whether the Invoice link is present
		if (uiDriver.checkElementPresent("SearchInvoices.lnkInvoice")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

//		// 6. Click on Reset button
//		uiDriver.click("SearchInvoices.btnReset");
//
//		// 7. Type $data in First_Name field
//		uiDriver.setValue("SearchInvoices.txtFirst_Name", input.get("Type@First_Name"));
//
//		// 8. Click on Search button
//		uiDriver.click("SearchInvoices.btnSearch");
//
//		// 9. Verify whether the Invoice link is present
//		if (uiDriver.checkElementPresent("SearchInvoices.lnkInvoice")) {
//			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
//		} else {
//			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
//		}
//
//		// 10. Click on Reset button
//		uiDriver.click("SearchInvoices.btnReset");

	}

	/**
	 * Overriding toString() method of object class to print SearchInvoices format
	 * string
	 **/
	public String toString() {
		return "SearchInvoicesDriver";
	}
}
