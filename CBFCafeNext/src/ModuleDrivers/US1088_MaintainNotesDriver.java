/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/7/2017 3:36:55 AM
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
public class US1088_MaintainNotesDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US1088_MaintainNotesDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void MaintainNotes(DataRow input, DataRow output) {

		// 1. Click on Actions WebElement
		uiDriver.click("MaintainNotes.eltActions");

		// 2. Click on New_Notes WebElement
		uiDriver.click("MaintainNotes.eltNew_Notes");

		// 3. Click on Cancel button
		uiDriver.click("MaintainNotes.btnCancel");

		// 4. Verify whether the Account_Details element present
		SleepUtils.sleep(5);
		if (uiDriver.checkElementPresent("MaintainNotes.eltAccount_Details")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 5. Click on Actions WebElement
		uiDriver.click("MaintainNotes.eltActions");

		// 6. Click on New_Notes WebElement
		uiDriver.click("MaintainNotes.eltNew_Notes");

		// 7. Double Click on Related_To in the list
		uiDriver.doubleclick("MaintainNotes.lstRelated_To");

		// 8. Select $data from the Related_To list
		uiDriver.setValue("MaintainNotes.lstRelated_To", input.get("Select@Related_To"));

		// 9. Type $data in Subject field
		uiDriver.setValue("MaintainNotes.txtSubject", input.get("Type@Subject"));

		// 10. Type $data in Text field
		uiDriver.setValue("MaintainNotes.txtText", input.get("Type@Text"));

		// 11. Click on Update button
		uiDriver.click("MaintainNotes.btnUpdate");

		// 12. Click on ServiceTickets and Account_Notes WebElement
		SleepUtils.sleep(3);
		uiDriver.click("MaintainNotes.eltServiceTickets");
		SleepUtils.sleep(3);
		uiDriver.click("MaintainNotes.eltAccount_Notes");

		// 13. Click on Search_Account_notes button
		uiDriver.setValue("MaintainNotes.txtFindText", input.get("Type@Subject"));
		SleepUtils.sleep(3);
		uiDriver.click("MaintainNotes.btnSearch_Account_notes");

		// 14. Verify whether the Account_Details_Notes element present
		SleepUtils.sleep(3);
		if (uiDriver.checkElementPresent("MaintainNotes.eltAccount_Details_Notes")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 15. Click on OverView WebElement
		SleepUtils.sleep(3);
		uiDriver.click("MaintainNotes.eltOverView");

		// 16. Verify whether the Notes element present
		if (uiDriver.checkElementPresent("MaintainNotes.eltNotes")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

	}

	/**
	 * Overriding toString() method of object class to print MaintainNotes format
	 * string
	 **/
	public String toString() {
		return "MaintainNotesDriver";
	}
}
