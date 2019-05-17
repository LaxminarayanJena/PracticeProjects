/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/15/2017 6:07:52 AM
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
public class US1117_PolicyContacts_Editadd_roleupdDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US1117_PolicyContacts_Editadd_roleupdDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void PolicyContacts_Editadd_roleupd(DataRow input, DataRow output) {
		// 1. Click on Policy WebElement
		uiDriver.click("PolicyContacts_Editadd_roleupd.eltPolicy");

		// 2. Type $data in Policy field
		uiDriver.setValue("PolicyContacts_Editadd_roleupd.txtPolicy", input.get("Type@Policy"));

		// 3. Click on Search button
		uiDriver.click("PolicyContacts_Editadd_roleupd.btnSearch");

		// 4. Click on policy Link
		uiDriver.click("PolicyContacts_Editadd_roleupd.lnkpolicy");

		// 5. Click on Contacts WebElement
		uiDriver.click("PolicyContacts_Editadd_roleupd.eltContacts");

		// 6. Click on Add button
		uiDriver.click("PolicyContacts_Editadd_roleupd.btnAdd");

		// 7. DoubleClick Add_New_Person
		uiDriver.doubleclick("PolicyContacts_Editadd_roleupd.eltAdd_New_Person");

		// 8. Type $data in First_Name field
		uiDriver.setValue("PolicyContacts_Editadd_roleupd.txtFirst_Name", input.get("Type@First_Name"));

		// 9. Type $data in Last_Name field
		uiDriver.setValue("PolicyContacts_Editadd_roleupd.txtLast_Name", input.get("Type@Last_Name"));

		// 10. Type $data in Address_1 field
		uiDriver.setValue("PolicyContacts_Editadd_roleupd.txtAddress_1", input.get("Type@Address_1"));

		// 11. Type City $Parama1
		uiDriver.setValue("PolicyContacts_Editadd_roleupd.eltCity", input.get("Type@City"));

		// 12. Select $data from the State list
		uiDriver.setValue("PolicyContacts_Editadd_roleupd.lstState", input.get("Select@State"));

		// 13. Type $data in ZIP_Code field
		uiDriver.setValue("PolicyContacts_Editadd_roleupd.txtZIP_Code", input.get("Type@ZIP_Code"));

		// 14. Type $data in phone field
		uiDriver.setValue("PolicyContacts_Editadd_roleupd.txtphone", input.get("Type@phone"));

		// 15. Type $data in Email field
		uiDriver.setValue("PolicyContacts_Editadd_roleupd.txtEmail", input.get("Type@Email"));

		uiDriver.click("PolicyContacts_Editadd_roleupd.txtEmail.btnAdd_1");

		// 16. Double Click on Role in the list
		uiDriver.doubleclick("PolicyContacts_Editadd_roleupd.lstRole");

		// 17. Select $data from the Role_Edit list
		SleepUtils.sleep(2);
		uiDriver.setValue("PolicyContacts_Editadd_roleupd.lstRole_Edit", input.get("Type@Role_Edit"));

		// 18. Click on Standardize_Address button
		SleepUtils.sleep(2);
		uiDriver.click("PolicyContacts_Editadd_roleupd.btnStandardize_Address");

		// 19. Click on Update button
		SleepUtils.sleep(2);
		uiDriver.click("PolicyContacts_Editadd_roleupd.btnUpdate");

		// 20. Click on History WebElement
		uiDriver.click("PolicyContacts_Editadd_roleupd.eltHistory");

		SleepUtils.sleep(2);
		// 21. Select $data from the Filter_by_Type list
		uiDriver.setValue("PolicyContacts_Editadd_roleupd.lstFilter_by_Type", input.get("Select@Filter_by_Type"));

		// 22. Click on Contacts_1 WebElement
		uiDriver.click("PolicyContacts_Editadd_roleupd.eltContacts_1");

		// 23. Select the Checkbox ?checkbox
		uiDriver.setValue("PolicyContacts_Editadd_roleupd.chkCheckbox", input.get("Select@Checkbox"));

		// 24. Click on Remove button
		uiDriver.click("PolicyContacts_Editadd_roleupd.btnRemove");

		// 25. Click on History_1 WebElement
		uiDriver.click("PolicyContacts_Editadd_roleupd.eltHistory_1");

		// 26. Select $data from the Filter_by_Type list
		uiDriver.setValue("PolicyContacts_Editadd_roleupd.lstFilter_by_Type", input.get("Select@Filter_by_Type"));

	}

	/**
	 * Overriding toString() method of object class to print
	 * PolicyContacts_Editadd_roleupd format string
	 **/
	public String toString() {
		return "PolicyContacts_Editadd_roleupdDriver";
	}
}
