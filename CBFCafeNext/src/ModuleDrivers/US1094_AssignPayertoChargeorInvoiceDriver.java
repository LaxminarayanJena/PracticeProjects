/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/15/2017 8:31:54 AM
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
public class US1094_AssignPayertoChargeorInvoiceDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US1094_AssignPayertoChargeorInvoiceDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void AssignPayertoChargeorInvoice(DataRow input, DataRow output) {
		// 1. Click on Charges WebElement
		SleepUtils.sleep(2);
		uiDriver.click("AssignPayertoChargeorInvoice.eltCharges");

		// 2. Select the Checkbox ?checkbox
		SleepUtils.sleep(2);
		uiDriver.click("AssignPayertoChargeorInvoice.chkCheckbox");
		SleepUtils.sleep(2);
		
		// 3. Click on Assign_Payer button
		SleepUtils.sleep(3);
		uiDriver.click("AssignPayertoChargeorInvoice.btnAssign_Payer");

		// 4. Click on Assign_to_Account WebElement
		uiDriver.sendKey("keysdown");
		uiDriver.sendKey("enter");
		//uiDriver.sendKey("enter");

		// 5. Click New_Payer
		SleepUtils.sleep(2);
		uiDriver.doubleclick("AssignPayertoChargeorInvoice.txtNew_Payer");

		// 6. Type $data in Account field
		uiDriver.setValue("AssignPayertoChargeorInvoice.txtAccount_2", input.get("Type@Account#2"));
		uiDriver.sendKey("tab");

		// 7. Click on Search button
		SleepUtils.sleep(2);
		uiDriver.click("AssignPayertoChargeorInvoice.txtinovicestream");
		uiDriver.sendKey("keysdown");
		uiDriver.sendKey("tab");

		// 8. Click on Select button
		SleepUtils.sleep(2);
		// uiDriver.click("AssignPayertoChargeorInvoice.btnSelect");

		// 9. Click on Execute button
		uiDriver.click("AssignPayertoChargeorInvoice.btnExecute");
		SleepUtils.sleep(5);

	}

	/**
	 * Overriding toString() method of object class to print
	 * AssignPayertoChargeorInvoice format string
	 **/
	public String toString() {
		return "AssignPayertoChargeorInvoiceDriver";
	}
}
