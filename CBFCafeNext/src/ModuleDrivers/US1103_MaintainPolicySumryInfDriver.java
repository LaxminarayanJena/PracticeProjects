/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/12/2017 2:12:00 AM
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
public class US1103_MaintainPolicySumryInfDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US1103_MaintainPolicySumryInfDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void ViewandEditPolicySum(DataRow input, DataRow output) {

		// 1. Click on PolicyLink Link
		uiDriver.click("ViewandEditPolicySum.lnkPolicy");
		SleepUtils.sleep(2);
		uiDriver.click("ViewandEditPolicySum.lnkPolicyLink");
		SleepUtils.sleep(4);
		
		// 7. Click on Edit button
		uiDriver.click("ViewandEditPolicySum.btnEdit");
		SleepUtils.sleep(4);
		
		// 8. Double Click on Billing_Method in the list
		uiDriver.doubleclick("ViewandEditPolicySum.lstBilling_Method");
		uiDriver.sendKey("Enter");
		SleepUtils.sleep(2);
		
		// 9. Select $data from the Billing_Method_List list
		SleepUtils.sleep(3);
		uiDriver.click("ViewandEditPolicySum.btnOk");

		// 10. Select $data from the Delinquency_Plan list
		uiDriver.click("ViewandEditPolicySum.eltDelinquency");
		SleepUtils.sleep(5);
		uiDriver.setValue("ViewandEditPolicySum.lstDelinquency_Plan", input.get("Select@Delinquency_Plan"));
		SleepUtils.sleep(2);
		
		// 11. Click on Policy_Detail_Update button
		uiDriver.click("ViewandEditPolicySum.btnPolicy_Detail_Update");
		SleepUtils.sleep(3);

		// 12. Verify the text ?$data in the Parent_Account_Number field
		uiDriver.click("ViewandEditPolicySum.eltBillingMethod");
		uiDriver.sendKey("Enter");
		uiDriver.click("ViewandEditPolicySum.btnOk_1");
		SleepUtils.sleep(2);

	}

	/**
	 * Overriding toString() method of object class to print MaintainPolicySumryInf
	 * format string
	 **/
	public String toString() {
		return "MaintainPolicySumryInfDriver";
	}
}
