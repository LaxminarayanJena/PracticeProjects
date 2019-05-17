/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/14/2017 8:31:05 AM
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
public class US118_ProducerContacts_AddandremoveDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US118_ProducerContacts_AddandremoveDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void ProducerContacts_Addandremove(DataRow input, DataRow output) {
		// 1. Click on Producer WebElement
		uiDriver.click("ProducerContacts_Addandremove.eltProducer");

		// 2. Type $data in Producer_Name field
		uiDriver.setValue("ProducerContacts_Addandremove.txtProducer_Name", input.get("Type@Producer_Name"));

		// 3. Click on Search button
		uiDriver.click("ProducerContacts_Addandremove.btnSearch");

		// 4. Click on Name Link
		uiDriver.click("ProducerContacts_Addandremove.lnkName");

		// 5. Click on Contacts WebElement
		uiDriver.click("ProducerContacts_Addandremove.eltContacts");

		// 6. Click on Add_Existing_Contact button
		uiDriver.click("ProducerContacts_Addandremove.btnAdd_Existing_Contact");

		// 7. Type $data in First_Name field
		uiDriver.setValue("ProducerContacts_Addandremove.txtFirst_Name", input.get("Type@First_Name"));

		// 8. Type $data in last_Name field
		uiDriver.setValue("ProducerContacts_Addandremove.txtlast_Name", input.get("Type@last_Name"));

		// 9. Click on search_1 button
		uiDriver.click("ProducerContacts_Addandremove.btnsearch_1");

		// 10. Click on Select button
		uiDriver.click("ProducerContacts_Addandremove.btnSelect");
		SleepUtils.sleep(3);

		// 11. Click on Add button
		uiDriver.click("ProducerContacts_Addandremove.btnAdd");
		SleepUtils.sleep(2);

		// 12. Double Click on Role in the list
		uiDriver.doubleclick("ProducerContacts_Addandremove.lstRole");

		// 13. Select $data from the Role_Edit list
		SleepUtils.sleep(2);
		uiDriver.setValue("ProducerContacts_Addandremove.lstRole_Edit", input.get("Select@Role_Edit"));

		// 14. Click on Update button
		uiDriver.click("ProducerContacts_Addandremove.btnUpdate");

		// 15. Select the Contacts ?checkbox
		uiDriver.setValue("ProducerContacts_Addandremove.chkContacts", input.get("Select@Contacts"));

		// 16. Click on Remove button
		uiDriver.click("ProducerContacts_Addandremove.btnRemove");

	}

	/**
	 * Overriding toString() method of object class to print
	 * ProducerContacts_Addandremove format string
	 **/
	public String toString() {
		return "ProducerContacts_AddandremoveDriver";
	}
}