/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 11/27/2017 7:13:44 AM
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
import cbfx.selenium.*;

/**
 * Extends BaseModuleDriver class and performs application specific operations
 */
public class US1116_CreateNewAccountDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US1116_CreateNewAccountDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void AddTheContactInAccountLevel(DataRow input, DataRow output) {

		// 1. Click on Contacts WebElement
		SleepUtils.sleep(3);
		uiDriver.click("AddTheContactInAccountLevel.eltContacts");
		SleepUtils.sleep(3);
		
		// 2. Click on Add_ button
		uiDriver.click("AddTheContactInAccountLevel.btnAdd_");
		SleepUtils.sleep(3);
		
		// 3. Click on Add_New_Person WebElement
		uiDriver.click("AddTheContactInAccountLevel.eltAdd_New_Person");
		SleepUtils.sleep(3);
		
		// 5. Type $data in First_Name field
		uiDriver.setValue("AddTheContactInAccountLevel.txtFirst_Name", input.get("Type@First_Name"));
		SleepUtils.sleep(3);
		
		// 6. Type $data in Last_Name field
		uiDriver.setValue("AddTheContactInAccountLevel.txtLast_Name", input.get("Type@Last_Name"));
		SleepUtils.sleep(3);
		
		// 7. Type $data in Address1 field
		uiDriver.setValue("AddTheContactInAccountLevel.txtAddress1", input.get("Type@Address1"));
		SleepUtils.sleep(3);
		
		// 8. Type $data in City field
		uiDriver.setValue("AddTheContactInAccountLevel.txtCity", input.get("Type@City"));
		SleepUtils.sleep(3);
		// 9. Select $data from the State list
		uiDriver.setValue("AddTheContactInAccountLevel.lstState", input.get("Select@State"));
		uiDriver.sendKey("keysdown");
		uiDriver.sendKey("enter");
		SleepUtils.sleep(2);

		// 10. Type $data in Zip_Code field
		uiDriver.setValue("AddTheContactInAccountLevel.txtZip_Code", input.get("Type@Zip_Code"));
		SleepUtils.sleep(3);
		
		// 11. Type $data in Phone field
		uiDriver.setValue("AddTheContactInAccountLevel.txtPhone", input.get("Type@Phone"));
		SleepUtils.sleep(3);
		
		// 12. Type $data in Email field
		uiDriver.setValue("AddTheContactInAccountLevel.txtEmail", input.get("Type@Email"));
		SleepUtils.sleep(3);
		
		// 13. Click on Add button
		SleepUtils.sleep(3);
		uiDriver.click("AddTheContactInAccountLevel.btnAdd");

		// 14. Select $data from the Role list
		SleepUtils.sleep(3);
		uiDriver.doubleclick("AddTheContactInAccountLevel.lstRole");
		SleepUtils.sleep(3);
		uiDriver.sendKey("keysdown");
		uiDriver.sendKey("enter");
		SleepUtils.sleep(3);

		// 15. Click on Standardize_Address button
		uiDriver.click("AddTheContactInAccountLevel.btnStandardize_Address");
		SleepUtils.sleep(3);
		
		// 16. Click on Update button
		uiDriver.click("AddTheContactInAccountLevel.btnUpdate");
		SleepUtils.sleep(3);		
		if (uiDriver.checkElementPresent("US1089_ViewPoliciesAccount.msgerror")) {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		} else {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		}
	}

	/**
	 * Overriding toString() method of object class to print CreateNewAccount format
	 * string
	 **/
	public String toString() {
		return "CreateNewAccountDriver";
	}
}
