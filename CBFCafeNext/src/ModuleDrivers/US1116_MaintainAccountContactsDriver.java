/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/8/2017 9:22:00 AM
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
public class US1116_MaintainAccountContactsDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US1116_MaintainAccountContactsDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void MaintainAccountContacts(DataRow input, DataRow output) {

		// 1. Click on Contacts WebElement
		uiDriver.click("MaintainAccountContacts.eltContacts");

		// 2. Click on Add button
		uiDriver.click("MaintainAccountContacts.btnAdd");

		// 3. Click on Add_New_Person WebElement
		uiDriver.click("MaintainAccountContacts.eltAdd_New_Person");

		// 4. Type $data in FirstName field
		uiDriver.setValue("MaintainAccountContacts.txtFirstName", input.get("Type@FirstName"));

		// 5. Type $data in LastName field
		uiDriver.setValue("MaintainAccountContacts.txtLastName", input.get("Type@LastName"));

		// 6. Type $data in Address_1 field
		uiDriver.setValue("MaintainAccountContacts.txtAddress_1", input.get("Type@Address_1"));

		// 7. Type $data in City field
		uiDriver.setValue("MaintainAccountContacts.txtCity", input.get("Type@City"));

		// 8. Double Click on State in the list
		uiDriver.doubleclick("MaintainAccountContacts.lstState");

		// 9. Select $data from the State list
		uiDriver.setValue("MaintainAccountContacts.lstState", input.get("Select@State"));
		uiDriver.sendKey("keysdown");
		uiDriver.sendKey("enter");
		SleepUtils.sleep(3);

		// 10. Type $data in ZIP_Code field
		uiDriver.setValue("MaintainAccountContacts.txtZIP_Code", input.get("Type@ZIP_Code"));

		// 11. Type $data in Phone field
		uiDriver.setValue("MaintainAccountContacts.txtPhone", input.get("Type@Phone"));

		// 12. Type $data in Email field
		uiDriver.setValue("MaintainAccountContacts.txtEmail", input.get("Type@Email"));

		// 13. Click on Add button
		SleepUtils.sleep(4);
		uiDriver.click("MaintainAccountContacts.btnAdd_1");

		// 14. Select $data from the Role list
		SleepUtils.sleep(3);
		uiDriver.doubleclick("MaintainAccountContacts.lstRole");
		SleepUtils.sleep(3);
		uiDriver.sendKey("keysdown");
		uiDriver.sendKey("enter"); 
		SleepUtils.sleep(3);

		// 15. Click on Standardize_Address button
		uiDriver.click("MaintainAccountContacts.btnStandardize_Address");
		Boolean bStatus=uiDriver.getControl("CreateNewAcc.btnOverRide").isEnabled();
		if (bStatus==true)
		{
			uiDriver.ElementPrestnclick("CreateNewAcc.btnOverRide");
		}

		// 16. Click on Update button
		SleepUtils.sleep(3);
		uiDriver.click("MaintainAccountContacts.btnUpdate");

	}

	/**
	 * Overriding toString() method of object class to print MaintainAccountContacts
	 * format string
	 **/
	public String toString() {
		return "MaintainAccountContactsDriver";
	}
}