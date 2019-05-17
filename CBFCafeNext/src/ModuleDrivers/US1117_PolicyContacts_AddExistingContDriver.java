/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/15/2017 2:47:15 AM
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
public class US1117_PolicyContacts_AddExistingContDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US1117_PolicyContacts_AddExistingContDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void PolicyContacts_AddExistingCont(DataRow input, DataRow output) {

		//1. Click on Search button
		uiDriver.click("PolicyContacts_AddExistingCont.tabpolicy");
		uiDriver.click("PolicyContacts_AddExistingCont.lnpolicy");

		//2. Click on Contacts WebElement
		uiDriver.click("PolicyContacts_AddExistingCont.eltContacts");

		//3. Click on Add_Existing_Contact button
		SleepUtils.sleep(2);
		uiDriver.click("PolicyContacts_AddExistingCont.btnAdd_Existing_Contact");

		//4. Select $data from the Type list
		uiDriver.doubleclick("PolicyContacts_AddExistingCont.lstType");
		SleepUtils.sleep(1);
		uiDriver.sendKey("keysdown");
		uiDriver.sendKey("enter");
		// uiDriver.doubleclick("PolicyContacts_AddExistingCont.eltPerson");

		//5. Type $data in First_Name field
		SleepUtils.sleep(2);
		uiDriver.setValue("PolicyContacts_AddExistingCont.txtFirst_Name", input.get("Type@First_Name"));

		//6. Type $data in Last_Name field
		SleepUtils.sleep(2);
		uiDriver.setValue("PolicyContacts_AddExistingCont.txtLast_Name", input.get("Type@Last_Name"));

		//7. Click on Search_1 button
		uiDriver.click("PolicyContacts_AddExistingCont.btnSearch_1");

		//8. Click on Select button
		uiDriver.click("PolicyContacts_AddExistingCont.btnSelect");

		//9. Click on Add button
		uiDriver.click("PolicyContacts_AddExistingCont.btnAdd");
		SleepUtils.sleep(2);
		
		//10. Double Click on Role in the list
		uiDriver.sendKey("enter");
		SleepUtils.sleep(2);
		uiDriver.sendKey("keysdown");
		uiDriver.sendKey("keysdown");
		SleepUtils.sleep(2);
		uiDriver.sendKey("enter");

		//11. Click on Update button
		uiDriver.click("PolicyContacts_AddExistingCont.btnUpdate");
		SleepUtils.sleep(10);
		
	}

	/**
	 * Overriding toString() method of object class to print
	 * PolicyContacts_AddExistingCont format string
	 **/
	public String toString() {
		return "PolicyContacts_AddExistingContDriver";
	}
}
