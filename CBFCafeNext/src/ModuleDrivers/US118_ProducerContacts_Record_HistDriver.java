/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/14/2017 3:00:08 AM
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
public class US118_ProducerContacts_Record_HistDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US118_ProducerContacts_Record_HistDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void ProducerContacts_Record_Hist(DataRow input, DataRow output) {
		// 1. Click on Producer WebElement
		uiDriver.click("ProducerContacts_Record_Hist.eltProducer");

		// 2. Type $data in Producer_Name field
		uiDriver.setValue("ProducerContacts_Record_Hist.txtProducer_Name", input.get("Type@Producer_Name"));

		// 3. Click on Search button
		uiDriver.click("ProducerContacts_Record_Hist.btnSearch");

		// 4. Click on Name Link
		uiDriver.click("ProducerContacts_Record_Hist.lnkName");

		// 5. Click on History WebElement
		uiDriver.click("ProducerContacts_Record_Hist.eltHistory");

		// 6. Select $data from the Filter_by_Date list
		uiDriver.setValue("ProducerContacts_Record_Hist.lstFilter_by_Date", input.get("Select@Filter_by_Date"));

		// 7. Click on Contacts WebElement
		uiDriver.doubleclick("ProducerContacts_Record_Hist.eltContacts");
		SleepUtils.sleep(2);
		uiDriver.doubleclick("ProducerContacts_Record_Hist.eltContacts");

		// 8. Click on Add button
		SleepUtils.sleep(2);
		uiDriver.click("ProducerContacts_Record_Hist.btnAdd");

		// 9. Click on Add_New_Person WebElement
		SleepUtils.sleep(3);
		uiDriver.click("ProducerContacts_Record_Hist.eltAdd_New_Person");

		// 10. Type $data in FirstName field
		uiDriver.setValue("ProducerContacts_Record_Hist.txtFirstName", input.get("Type@FirstName"));

		// 11. Type $data in LastName field
		uiDriver.setValue("ProducerContacts_Record_Hist.txtLastName", input.get("Type@LastName"));

		// 12. Type $data in Address_1 field
		uiDriver.setValue("ProducerContacts_Record_Hist.txtAddress_1", input.get("Type@Address_1"));

		// 13. Type $data in City field
		uiDriver.setValue("ProducerContacts_Record_Hist.txtCity", input.get("Type@City"));

		// 14. Select $data from the State list
		uiDriver.setValue("ProducerContacts_Record_Hist.lstState", input.get("Select@State"));
		uiDriver.sendKey("tab");

		// 15. Type $data in ZIP_Code field
		uiDriver.setValue("ProducerContacts_Record_Hist.txtZIP_Code", input.get("Type@ZIP_Code"));

		// 16. Type $data in Phone field
		uiDriver.setValue("ProducerContacts_Record_Hist.txtPhone", input.get("Type@Phone"));

		// 17. Type $data in Email field
		uiDriver.setValue("ProducerContacts_Record_Hist.txtEmail", input.get("Type@Email"));

		// 18. Click on Add_1 button
		uiDriver.click("ProducerContacts_Record_Hist.btnAdd_1");

		// 19. Double Click on Role in the list
		uiDriver.doubleclick("ProducerContacts_Record_Hist.lstRole");

		// 20. Select $data from the Role_Edit list
		SleepUtils.sleep(2);
		uiDriver.setValue("ProducerContacts_Record_Hist.lstRole_Edit", input.get("Select@Role_Edit"));
	
		// 21. Click on Standardize_Address button
		SleepUtils.sleep(2);
		uiDriver.click("ProducerContacts_Record_Hist.btnStandardize_Address");

		// 22. Click on Update button
		SleepUtils.sleep(3);
		uiDriver.click("ProducerContacts_Record_Hist.btnUpdate");

		// 23. Click on History WebElement
		uiDriver.click("ProducerContacts_Record_Hist.eltHistory_1");

		// 24. Select $data from the Filter_by_Date_1 list
		uiDriver.setValue("ProducerContacts_Record_Hist.lstFilter_by_Date_1", input.get("Select@Filter_by_Date_1"));

		// 25. Click on Contacts_1 WebElement
		SleepUtils.sleep(2);
		uiDriver.click("ProducerContacts_Record_Hist.eltContacts_1");
		SleepUtils.sleep(2);
		uiDriver.click("ProducerContacts_Record_Hist.eltContacts_1");

		// 26. Select the Contacts ?checkbox
		uiDriver.th.findRelativeCellAndClickSelectedCell("ProducerContacts_Record_Hist.chkContacts_2", "No", 4, "No", "");
		SleepUtils.sleep(2);
		
		// 27. Click on Remove button
		SleepUtils.sleep(4);
		uiDriver.click("ProducerContacts_Record_Hist.btnRemoveContact");

		// 28. Click on History_1 WebElement
		uiDriver.click("ProducerContacts_Record_Hist.eltHistory_2");

		// 29. Select $data from the Filter_by_Date_2 list
		uiDriver.setValue("ProducerContacts_Record_Hist.lstFilter_by_Date_2", input.get("Select@Filter_by_Date_2"));

	}

	/**
	 * Overriding toString() method of object class to print
	 * ProducerContacts_Record_Hist format string
	 **/
	public String toString() {
		return "ProducerContacts_Record_HistDriver";
	}
}
