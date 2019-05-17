/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/15/2017 4:35:21 AM
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
public class US1117_PolicyContacts_ValidateaddressDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US1117_PolicyContacts_ValidateaddressDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void PolicyContacts_Validateaddress(DataRow input, DataRow output) {
		// 1. Click on Policy WebElement
		uiDriver.click("PolicyContacts_Validateaddress.eltPolicy");

		// 2. Type $data in Policy field
		uiDriver.setValue("PolicyContacts_Validateaddress.txtPolicy", input.get("Type@Policy"));

		// 3. Click on Search button
		uiDriver.click("PolicyContacts_Validateaddress.btnSearch");

		// 4. Click on Policy Link
		uiDriver.click("PolicyContacts_Validateaddress.lnkPolicy");

		// 5. Click on Contacts WebElement
		uiDriver.click("PolicyContacts_Validateaddress.eltContacts");

		// 6. Click on Add button
		uiDriver.click("PolicyContacts_Validateaddress.btnAdd");
		SleepUtils.sleep(2);

		// 7. Click on Add_New_Person WebElement
		SleepUtils.sleep(2);
		uiDriver.click("PolicyContacts_Validateaddress.eltAdd_New_Person");
		SleepUtils.sleep(2);

		// 8. Type $data in First_Name field
		uiDriver.setValue("PolicyContacts_Validateaddress.txtFirst_Name", input.get("Type@First_Name"));

		// 9. Type $data in Last_Name field
		uiDriver.setValue("PolicyContacts_Validateaddress.txtLast_Name", input.get("Type@Last_Name"));

		// 10. Type $data in Address_1 field
		uiDriver.setValue("PolicyContacts_Validateaddress.txtAddress_1", input.get("Type@Address_1"));
		SleepUtils.sleep(2);
		uiDriver.click("PolicyContacts_Validateaddress.txtCity");
		
		// 11. Type $data in City field
		uiDriver.setValue("PolicyContacts_Validateaddress.txtCity", input.get("Type@City"));
		SleepUtils.sleep(2);
		uiDriver.click("PolicyContacts_Validateaddress.btnStandardize_Address");
		
		// 12. Click on Standardize_Address button
		uiDriver.click("PolicyContacts_Validateaddress.btnStandardize_Address");
		SleepUtils.sleep(2);
		
		// 13. Type $data in ZIP_Code field
		uiDriver.setValue("PolicyContacts_Validateaddress.txtZIP_Code", input.get("Type@ZIP_Code"));

		// 14. Click on Standardize_Address_1 button
		uiDriver.click("PolicyContacts_Validateaddress.btnStandardize_Address_1");
	}

	/**
	 * Overriding toString() method of object class to print
	 * PolicyContacts_Validateaddress format string
	 **/
	public String toString() {
		return "PolicyContacts_ValidateaddressDriver";
	}
}
