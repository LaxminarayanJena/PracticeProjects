/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/5/2017 7:11:34 AM
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
public class US104_SearchBCUsersDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US104_SearchBCUsersDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void SearchBCUsers(DataRow input, DataRow output) {
		// 1. Click on Administration WebElement
		uiDriver.click("SearchBCUsers.eltAdministration");
		uiDriver.click("SearchBCUsers.btnReset");

		// 2. Type $data in First_Name field
		uiDriver.setValue("SearchBCUsers.txtFirst_Name", input.get("Type@First_Name"));

		// 3. Type $data in Last_Name field
		uiDriver.setValue("SearchBCUsers.txtLast_Name", input.get("Type@Last_Name"));

		// 4. Click on Search button
		uiDriver.click("SearchBCUsers.btnSearch");

		// 5. Verify whether the Display_Name link is present
		if (uiDriver.checkElementPresent("SearchBCUsers.lnkDisplay_Name")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		uiDriver.click("SearchBCUsers.lnkdisplayname");
		uiDriver.click("SearchBCUsers.tbprofile");
		uiDriver.click("SearchBCUsers.btnedit");
		uiDriver.setValue("SearchBCUsers.txtempno", input.get("Type@empno"));
		uiDriver.setValue("SearchBCUsers.txtemail", input.get("Type@email"));
		uiDriver.click("SearchBCUsers.btnupdate");

		// 7. Click on Administration WebElement
		uiDriver.click("SearchBCUsers.eltAdministration");

		// 8. Type $data in User_Name field
		uiDriver.setValue("SearchBCUsers.txtUser_Name", input.get("Type@User_Name"));

		// 9. Click on Search button
		uiDriver.click("SearchBCUsers.btnSearch");

		// 10. Verify whether the Display_Name link is present
		if (uiDriver.checkElementPresent("SearchBCUsers.lnkDisplay_Name")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 11. Click on Display_Name Link
		uiDriver.click("SearchBCUsers.lnkDisplay_Name");
		SleepUtils.sleep(2);
		
		// 12. Verify whether the Display_web Element is present
		if (uiDriver.checkElementPresent("SearchBCUsers.txtAccount_Name")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
	}

	/**
	 * Overriding toString() method of object class to print SearchBCUsers format
	 * string
	 **/
	public String toString() {
		return "SearchBCUsersDriver";
	}
}
