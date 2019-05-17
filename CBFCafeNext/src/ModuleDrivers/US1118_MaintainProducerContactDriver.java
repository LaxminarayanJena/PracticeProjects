/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/13/2017 9:11:03 AM
Module part of 'Guidewire Billing Center'
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
public class US1118_MaintainProducerContactDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US1118_MaintainProducerContactDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void US1118_MaintainProducerContact(DataRow input, DataRow output) {
		// 1. Click on Producer_tab WebElement
		uiDriver.click("US1118_MaintainProducerContact.eltProducer_tab");

		// 2. Type $data in Producer_Code field
		uiDriver.setValue("US1118_MaintainProducerContact.txtProducer_Code", input.get("Type@Producer_Code"));

		// 3. Click on Search button
		uiDriver.click("US1118_MaintainProducerContact.btnSearch");

		// 4. Click on Producer_Name Link
		uiDriver.click("US1118_MaintainProducerContact.lnkProducer_Name");

		// 5. Click on Contacts Link
		uiDriver.click("US1118_MaintainProducerContact.lnkContacts");

		// 6. Click on Add_Button button
		uiDriver.click("US1118_MaintainProducerContact.btnAdd_Button1");

		// 7. Click on Add_New_Person Link
		uiDriver.click("US1118_MaintainProducerContact.lnkAdd_New_Person");

		// 8. Type $data in First_Name field
		uiDriver.setValue("US1118_MaintainProducerContact.txtFirst_Name", input.get("Type@First_Name"));

		// 9. Type $data in Last_Name field
		uiDriver.setValue("US1118_MaintainProducerContact.txtLast_Name", input.get("Type@Last_Name"));

		// 10. Type $data in Address1 field
		uiDriver.setValue("US1118_MaintainProducerContact.txtAddress1", input.get("Type@Address1"));

		// 11. Type $data in City field
		uiDriver.setValue("US1118_MaintainProducerContact.txtCity", input.get("Type@City"));

		// 12. Type $data in Zip_Code field
		uiDriver.setValue("US1118_MaintainProducerContact.txtZip_Code", input.get("Type@Zip_Code"));

		// 13. Type $data in Phone field
		uiDriver.setValue("US1118_MaintainProducerContact.txtPhone", input.get("Type@Phone"));

		// 14. Type $data in Email field
		uiDriver.setValue("US1118_MaintainProducerContact.txtEmail", input.get("Type@Email"));

		// 15. Click on Add_button button
		uiDriver.click("US1118_MaintainProducerContact.btnAdd_button");

		// 16. Type $data in Role field
		uiDriver.click("US1118_MaintainProducerContact.bRole");
		SleepUtils.sleep(3);
		uiDriver.setValue("US1118_MaintainProducerContact.txtRole", input.get("Type@Role"));

		// 17. Type $data in State field
		uiDriver.setValue("US1118_MaintainProducerContact.txtState", input.get("Type@State"));

		// 18. Click on Standardize_Address button
		uiDriver.click("US1118_MaintainProducerContact.btnStandardize_Address");

		// 19. Click on Override button
		SleepUtils.sleep(3);
		uiDriver.click("US1118_MaintainProducerContact.btnOverride");
		SleepUtils.sleep(3);

		// 20. Click on update button
		uiDriver.click("US1118_MaintainProducerContact.btnupdate");
		SleepUtils.sleep(3);
	}

	/**
	 * Overriding toString() method of object class to print
	 * US1118_MaintainProducerContact format string
	 **/
	public String toString() {
		return "US1118_MaintainProducerContactDriver";
	}
}
