/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/11/2017 4:59:23 AM
Module part of 'Guidewire_BillingCenter'
Module created using Cafenext Selenium Builder
******************************************************************************/
package ModuleDrivers;

import static cbf.engine.TestResultLogger.*;
import java.io.IOException;

import org.openqa.selenium.Keys;

import cbf.engine.TestResult.ResultType;
import cbf.harness.ParameterAccess;
import cbf.utils.DataRow;
import cbf.utils.SleepUtils;
import cbf.utils.SleepUtils.TimeSlab;
import cbfx.selenium.BaseWebModuleDriver;

/**
 * Extends BaseModuleDriver class and performs application specific operations
 */
public class US1116_MaintainAccount_RecHistoryDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US1116_MaintainAccount_RecHistoryDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void MaintainAccount_RecHistory(DataRow input, DataRow output) {
		// 1. Click on Contacts WebElement
		SleepUtils.sleep(3);
		uiDriver.click("MaintainAccount_RecHistory.eltContacts");

		// 2. Click on Add WebElement
		uiDriver.click("MaintainAccount_RecHistory.btnAdd");

		// 3. Select $data from the Add list
		SleepUtils.sleep(3);
		uiDriver.click("MaintainAccount_RecHistory.eltAdd_New_Person");

		// 4. Type $data in FirstName field
		SleepUtils.sleep(2);
		uiDriver.setValue("MaintainAccount_RecHistory.txtFirstName", input.get("Type@FirstName"));

		// 5. Type $data in lastName field
		uiDriver.setValue("MaintainAccount_RecHistory.txtlastName", input.get("Type@lastName"));

		// 6. Type $data in Address_1 field
		uiDriver.setValue("MaintainAccount_RecHistory.txtAddress_1", input.get("Type@Address_1"));

		// 7. Type $data in City field
		uiDriver.setValue("MaintainAccount_RecHistory.txtCity", input.get("Type@City"));

		// 8. Select $data from the State list
		uiDriver.setValue("MaintainAccount_RecHistory.lstState", input.get("Select@State"));
		uiDriver.sendKey("keydown");
		uiDriver.sendKey("enter");

		// 9. Type $data in ZipCode field
		uiDriver.setValue("MaintainAccount_RecHistory.txtZipCode", input.get("Type@ZipCode"));

		// 10. Type $data in Phone field
		uiDriver.setValue("MaintainAccount_RecHistory.txtPhone", input.get("Type@Phone"));

		// 11. Type $data in Email field
		uiDriver.setValue("MaintainAccount_RecHistory.txtEmail", input.get("Type@Email"));

		// 12. Click on Add button
		SleepUtils.sleep(3);
		uiDriver.click("MaintainAccount_RecHistory.btnAdd_1");

		// 13. Select $data from the Role list
		SleepUtils.sleep(3);
		uiDriver.click("MaintainAccount_RecHistory.lstRole");
		SleepUtils.sleep(3); 
		SleepUtils.sleep(3);
		uiDriver.sendKey("keysdown");
		uiDriver.sendKey("enter");
		SleepUtils.sleep(2);

		// 14. Click on Standardize button
		uiDriver.click("MaintainAccount_RecHistory.btnStandardize");
		SleepUtils.sleep(2);
		
		Boolean bStatus=uiDriver.getControl("CreateNewAcc.btnOverRide").isEnabled();
		if (bStatus==true)
		{
			uiDriver.ElementPrestnclick("CreateNewAcc.btnOverRide");
		
		}
		
		uiDriver.click("MaintainAccountContacts.btnUpdate");
		SleepUtils.sleep(2);

		// 15. Click on History WebElement
		uiDriver.click("MaintainAccount_RecHistory.eltHistory");
		SleepUtils.sleep(2);
	}

	/**
	 * Overriding toString() method of object class to print
	 * MaintainAccount_RecHistory format string
	 **/
	public String toString() {
		return "MaintainAccount_RecHistoryDriver";
	}
}
