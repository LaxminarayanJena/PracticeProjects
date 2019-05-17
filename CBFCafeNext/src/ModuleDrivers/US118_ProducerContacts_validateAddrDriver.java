/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/13/2017 1:51:04 AM
Module part of 'Guidewire_BillingCenter'
Module created using Cafenext Selenium Builder
******************************************************************************/
package ModuleDrivers;

import static cbf.engine.TestResultLogger.*;

import java.awt.event.KeyEvent;
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
public class US118_ProducerContacts_validateAddrDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US118_ProducerContacts_validateAddrDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void ProducerContacts_validateAddr(DataRow input, DataRow output) {
		// 1. Click on Producer WebElement
		uiDriver.click("ProducerContacts_validateAddr.eltProducer");

		// 2. Type $data in Producer_Name field
		uiDriver.setValue("ProducerContacts_validateAddr.txtProducer_Name", input.get("Type@Producer_Name"));

		// 3. Click on Search button
		uiDriver.click("ProducerContacts_validateAddr.btnSearch");

		// 4. Click on Name Link
		uiDriver.click("ProducerContacts_validateAddr.lnkName");

		// 5. Click on Contacts button
		uiDriver.click("ProducerContacts_validateAddr.eltContacts");
		SleepUtils.sleep(2);
		
		// 6. Click on Add button
		uiDriver.click("ProducerContacts_validateAddr.btnAdd");

		// 7. Click on Add_New_Person WebElement
		uiDriver.click("ProducerContacts_validateAddr.eltAdd_New_Person");

		// 8. Type $data in First_Name field
		uiDriver.setValue("ProducerContacts_validateAddr.txtFirst_Name", input.get("Type@First_Name"));

		// 9. Type $data in Last_Name field
		uiDriver.setValue("ProducerContacts_validateAddr.txtLast_Name", input.get("Type@Last_Name"));

		// 10. Type $data in Address_1 field
		uiDriver.setValue("ProducerContacts_validateAddr.txtAddress_1", input.get("Type@Address_1"));

		// 11. Type $data in City field
		uiDriver.setValue("ProducerContacts_validateAddr.txtCity", input.get("Type@City"));

		// 12. Double Click on State in the list
		uiDriver.doubleclick("ProducerContacts_validateAddr.lstState");

		// 13. Select $data from the State list
		uiDriver.setValue("ProducerContacts_validateAddr.lstState", input.get("Select@State"));
		uiDriver.sendKey("keysdown");
		uiDriver.sendKey("enter");

		// 14. Type $data in ZIP_Code field
		uiDriver.setValue("ProducerContacts_validateAddr.txtZIP_Code", input.get("Type@ZIP_Code"));

		// 15. Type $data in Phone field
		uiDriver.setValue("ProducerContacts_validateAddr.txtPhone", input.get("Type@Phone"));

		// 16. Type $data in Email field
		uiDriver.setValue("ProducerContacts_validateAddr.txtEmail", input.get("Type@Email"));

		// 17. Click on Add_1 button
		uiDriver.click("ProducerContacts_validateAddr.btnAdd_1");

		// 18. Double Click on Role in the list
		uiDriver.doubleclick("ProducerContacts_validateAddr.lstRole_Edit");

		// 19. Select $data from the Role list
		uiDriver.sendKey("keysdown");
		uiDriver.sendKey("enter");

		// 20. Click on Standardize_Address button
		uiDriver.click("ProducerContacts_validateAddr.btnStandardize_Address");
		SleepUtils.sleep(5);
		
		if (uiDriver.checkElementPresent("ProducerContacts_validateAddr.msgerror")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 21. Click on Update button
		uiDriver.click("ProducerContacts_validateAddr.btnUpdate");
		SleepUtils.sleep(2);

	}

	/**
	 * Overriding toString() method of object class to print
	 * ProducerContacts_validateAddr format string
	 **/
	public String toString() {
		return "ProducerContacts_validateAddrDriver";
	}
}
