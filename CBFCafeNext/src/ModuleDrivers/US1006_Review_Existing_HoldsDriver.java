/******************************************************************************
Created by : CapGemini Automation Team
Created\Updated on : 3/1/2018 2:09:20 AM
Module part of 'Guidewire_BillingCenter'
Module created using Cafenext Selenium Builder
******************************************************************************/
package ModuleDrivers;

import static cbf.engine.TestResultLogger.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import cbf.engine.TestResult.ResultType;
import cbf.harness.ParameterAccess;
import cbf.utils.DataRow;
import cbf.utils.SleepUtils;
import cbf.utils.SleepUtils.TimeSlab;
import cbfx.selenium.BaseWebModuleDriver;

/**
 * Extends BaseModuleDriver class and performs application specific operations
 */
public class US1006_Review_Existing_HoldsDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US1006_Review_Existing_HoldsDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void Review_Existing_HoldsCharges(DataRow input, DataRow output) {
		// 1. Click on Charges WebElement
		uiDriver.click("Review_Existing_HoldsCharges.eltCharges");
		SleepUtils.sleep(2);

		// 2. Click on Checkbox WebElement
		uiDriver.th.findRelativeCellAndClickSelectedCell("HoldChar_History_AccLevlPoliLe.chkCharges_Tble",
				input.get("Select@Charges_Tble"), 6, input.get("Select@Charges_Tble"), "");
		SleepUtils.sleep(3);

		// 3. Click on Edit_Holds button
		uiDriver.click("Review_Existing_HoldsCharges.btnEdit_Holds");

		// 4. Click on Not_Held WebElement
		uiDriver.click("Review_Existing_HoldsCharges.eltNot_Held");

		// 5. Select $data from the Hold_Status list
		uiDriver.setValue("Review_Existing_HoldsCharges.lstHold_Status", input.get("Select@Hold_Status"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(2);

		// 6. Click on _none_ WebElement
		uiDriver.click("Review_Existing_HoldsCharges.elt_none_");

		// 7. Select $data from the Reason list
		uiDriver.setValue("Review_Existing_HoldsCharges.lstReason", input.get("Select@Reason"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(2);

		// 8. Click on OK button
		uiDriver.click("Review_Existing_HoldsCharges.btnOK");
		SleepUtils.sleep(6);

		// 9. Click on Desktop WebElement
		uiDriver.click("Review_Existing_HoldsCharges.eltDesktop");
		SleepUtils.sleep(6);

		// 10. Click on Held_Charges WebElement
		uiDriver.click("Review_Existing_HoldsCharges.eltHeld_Charges");
		SleepUtils.sleep(6);

		// 11. Verify Log_in_User
		switch (System.getProperty("user.name")) {

		case "rjuwadi":
			uiDriver.verifyTextforWebEdit("Review_Existing_HoldsCharges.eltLog_in_User", "Ranjith Juwadi");
			break;
		case "bgolla":
			uiDriver.verifyTextforWebEdit("Review_Existing_HoldsCharges.eltLog_in_User", "Bhavana golla");
			break;
		case "gankumar":
			uiDriver.verifyTextforWebEdit("Review_Existing_HoldsCharges.eltLog_in_User", "Kumar Gandla");
			break;
		default:
		}

		// 12. Select $data from the Requested_by list
		uiDriver.click("Review_Existing_HoldsCharges.eltLog_in_User");
		SleepUtils.sleep(3);
		uiDriver.setValue("Review_Existing_HoldsCharges.eltLog_in_User", input.get("Select@Requested_by"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(2);

		// 13. Click on Group_Member WebElement
		uiDriver.click("Review_Existing_HoldsCharges.eltGroup_Member");
		SleepUtils.sleep(2);
		uiDriver.sendKey("keysdown");
		uiDriver.sendKey("keysdown");
		uiDriver.sendKey("keysdown");
		SleepUtils.sleep(2);
		uiDriver.sendKey("enter");

		// 14. Verify whether the Print_Export element present
		if (uiDriver.checkElementPresent("Review_Existing_HoldsCharges.eltPrint_Export")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 15. Click on Print_Export button
		uiDriver.click("Review_Existing_HoldsCharges.btnPrint_Export");

		// 16. Click on Cancel button
		uiDriver.click("Review_Existing_HoldsCharges.btnCancel");

		// 17. Select $data from the Login_user list
		uiDriver.click("Review_Existing_HoldsCharges.lstLogin_user");
		SleepUtils.sleep(2);
		switch (System.getProperty("user.name")) {

		case "rjuwadi":
			uiDriver.click("Review_Existing_HoldsCharges.lstLogin_user");
			SleepUtils.sleep(2);
			uiDriver.setValue("Review_Existing_HoldsCharges.lstLogin_user", "Ranjith Juwadi");
			SleepUtils.sleep(2);
			uiDriver.sendKey("enter");
			SleepUtils.sleep(8);
			String LoginUser = uiDriver.getControl("Review_Existing_HoldsCharges.lstLogin_user").getAttribute("value");
			if (!LoginUser.equalsIgnoreCase("ranjith Juwadi")) {
				uiDriver.click("Review_Existing_HoldsCharges.lstLogin_user");
				SleepUtils.sleep(2);
				uiDriver.setValue("Review_Existing_HoldsCharges.lstLogin_user", "Ranjith Juwadi");
				SleepUtils.sleep(2);
				uiDriver.sendKey("enter");
				SleepUtils.sleep(5);
			}
			break;
		case "bgolla":
			uiDriver.setValue("Review_Existing_HoldsCharges.lstLogin_user", "Bhavana golla");
			SleepUtils.sleep(2);
			uiDriver.sendKey("tab");
			SleepUtils.sleep(10);
			String LoginUser1 = uiDriver.getControl("Review_Existing_HoldsCharges.lstLogin_user").getAttribute("value");
			if (!LoginUser1.equalsIgnoreCase("bhavana golla")) {
				uiDriver.click("Review_Existing_HoldsCharges.lstLogin_user");
				SleepUtils.sleep(2);
				uiDriver.setValue("Review_Existing_HoldsCharges.lstLogin_user", "Ranjith Juwadi");
				SleepUtils.sleep(2);
				uiDriver.sendKey("tab");
				SleepUtils.sleep(10);
			}
			break;
		case "gankumar":
			uiDriver.setValue("Review_Existing_HoldsCharges.lstLogin_user", "Kumar Gandla");
			SleepUtils.sleep(2);
			uiDriver.sendKey("tab");
			SleepUtils.sleep(4);
			String LoginUser2 = uiDriver.getControl("Review_Existing_HoldsCharges.lstLogin_user").getAttribute("value");
			if (!LoginUser2.equalsIgnoreCase("ranjith Juwadi")) {
				uiDriver.click("Review_Existing_HoldsCharges.lstLogin_user");
				SleepUtils.sleep(2);
				uiDriver.setValue("Review_Existing_HoldsCharges.lstLogin_user", "Kumar Gandla");
				SleepUtils.sleep(2);
				uiDriver.sendKey("tab");
				SleepUtils.sleep(10);
			}
			break;
		default:
		}
		SleepUtils.sleep(5);

		// 18. Verify Reason
		uiDriver.th.getCellDataOfCol("Review_Existing_HoldsCharges.tblHeldCharges", input.get("Select@Reason"), 7);
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(2);

		// 19. Verify Hold_Effective_Date
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String Search = dateFormat.format(date);
		uiDriver.th.getCellDataOfCol("Review_Existing_HoldsCharges.tblHeldCharges", Search, 12);

		// 20. Verify Requestor
		switch (System.getProperty("user.name")) {

		case "rjuwadi":
			uiDriver.th.getCellDataOfCol("Review_Existing_HoldsCharges.tblHeldCharges", "ranjith Juwadi", 12);
			break;
		case "bgolla":
			uiDriver.th.getCellDataOfCol("Review_Existing_HoldsCharges.tblHeldCharges", "bhavana golla", 12);
			break;
		case "gankumar":
			uiDriver.th.getCellDataOfCol("Review_Existing_HoldsCharges.tblHeldCharges", "Kumar Gandla", 12);
			break;
		default:
		}
	}

	/**
	 * Overriding toString() method of object class to print
	 * US1006_Review_Existing_Holds format string
	 **/
	public String toString() {
		return "US1006_Review_Existing_HoldsDriver";
	}
}