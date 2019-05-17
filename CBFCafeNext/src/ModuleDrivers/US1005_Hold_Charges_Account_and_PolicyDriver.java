/******************************************************************************
Created by :CapGemini Automation Team
Created\Updated on : 2/27/2018 3:55:53 AM
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
public class US1005_Hold_Charges_Account_and_PolicyDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US1005_Hold_Charges_Account_and_PolicyDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void HoldChar_History_AccLevlPoliLe(DataRow input, DataRow output) {
		// 1. Click on Charges WebElement
		uiDriver.click("HoldChar_History_AccLevlPoliLe.eltCharges");

		// 2. Select the Charges_Tble ?checkbox
		uiDriver.th.findRelativeCellAndClickSelectedCell("HoldChar_History_AccLevlPoliLe.chkCharges_Tble",
				input.get("Select@Charges_Tble"), 6, input.get("Select@Charges_Tble"), "");
		SleepUtils.sleep(3);

		// 3. Click on Edit_Holds button
		uiDriver.click("HoldChar_History_AccLevlPoliLe.btnEdit_Holds");
		SleepUtils.sleep(3);

		// 4. Select $data from the Hold_Status list
		uiDriver.click("HoldChar_History_AccLevlPoliLe.eltReason_nonEdit");
		SleepUtils.sleep(2);
		uiDriver.click("HoldChar_History_AccLevlPoliLe.lstHold_Status1");
		SleepUtils.sleep(2);
		uiDriver.setValue("HoldChar_History_AccLevlPoliLe.lstHold_Status", input.get("Select@Hold_Status"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");

		// 5. Click on _none_ WebElement
		uiDriver.click("HoldChar_History_AccLevlPoliLe.elt_none_");
		SleepUtils.sleep(2);

		// 6. Select $data from the Reason list
		uiDriver.setValue("HoldChar_History_AccLevlPoliLe.lstReason", input.get("Select@Reason#1"));
		uiDriver.sendKey("enter");
		SleepUtils.sleep(2);
		//uiDriver.sendKey("tab");

		// 7. Click on OK button
		uiDriver.click("HoldChar_History_AccLevlPoliLe.btnOK");
		SleepUtils.sleep(5);
		String cellvalue = uiDriver.th.getCellDataOfRelatedColumn("HoldChar_History_AccLevlPoliLe.chkCharges_Tble",
				"Held", 6, 8);
		if (!cellvalue.equals("")) {
			passed("Reason", "ReasonPresent should pass", "ReasonPresent passed");
		} else {
			failed("Reason", "ReasonPresent should pass", "ReasonPresent failed");
		}

		// 8. Click on History WebElement
		uiDriver.click("HoldChar_History_AccLevlPoliLe.eltHistory");
		SleepUtils.sleep(2);

		// 9. Select $data from the Filter_by_Date list
		uiDriver.click("HoldChar_History_AccLevlPoliLe.lstFilter_by_Date");
		SleepUtils.sleep(2);
		uiDriver.setValue("HoldChar_History_AccLevlPoliLe.lstFilter_by_Date", input.get("Select@Filter_by_Date#1"));
		SleepUtils.sleep(3);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(4);

		// 10. Select $data from the Filter_by_Type list
		uiDriver.click("HoldChar_History_AccLevlPoliLe.lstFilter_by_Type");
		SleepUtils.sleep(2);
		uiDriver.setValue("HoldChar_History_AccLevlPoliLe.lstFilter_by_Type", input.get("Select@Filter_by_Type#1"));
		uiDriver.sendKey("enter");
		SleepUtils.sleep(4);

		// 11. Verify the text ?$data in the Description field
		uiDriver.th.getCellDataOfCol("HoldChar_History_AccLevlPoliLe.eltDescription",
				input.get("VerifyText@Description#1"), 1);
		SleepUtils.sleep(5);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(5);

		// 12. Click on Charges WebElement
		uiDriver.click("HoldChar_History_AccLevlPoliLe.eltCharges");
		SleepUtils.sleep(5);

		// 13. Select the Held ?checkbox
		uiDriver.th.findRelativeCellAndClickSelectedCell("HoldChar_History_AccLevlPoliLe.chkHeld",
				input.get("Select@Held#1"), 6, input.get("Select@Held#1"), "");
		SleepUtils.sleep(3);

		// 14. Click on Edit_Holds button
		uiDriver.click("HoldChar_History_AccLevlPoliLe.btnEdit_Holds");
		SleepUtils.sleep(4);

		// 15. Click on Held WebElement
		uiDriver.click("HoldChar_History_AccLevlPoliLe.eltHeld");
		SleepUtils.sleep(2);

		// 16. Select $data from the Held_Status list
		uiDriver.setValue("HoldChar_History_AccLevlPoliLe.lstHeld_Status", input.get("Select@Held_Status"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(4);

		// 17. Click on OK button
		uiDriver.click("HoldChar_History_AccLevlPoliLe.btnOK");
		SleepUtils.sleep(6);

		// 18. Click on History WebElement
		uiDriver.click("HoldChar_History_AccLevlPoliLe.eltHistory");
		SleepUtils.sleep(4);

		// 19. Select $data from the Filter_by_Date list
		uiDriver.click("HoldChar_History_AccLevlPoliLe.lstFilter_by_Date");
		SleepUtils.sleep(2);
		uiDriver.setValue("HoldChar_History_AccLevlPoliLe.lstFilter_by_Date", input.get("Select@Filter_by_Date#1"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(4);

		// 20. Select $data from the Filter_by_Type list
		uiDriver.click("HoldChar_History_AccLevlPoliLe.lstFilter_by_Type");
		SleepUtils.sleep(2);
		uiDriver.setValue("HoldChar_History_AccLevlPoliLe.lstFilter_by_Type", input.get("Select@Filter_by_Type#2"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(4);

		// 21. Verify the text ?$data in the Description field
		uiDriver.th.getCellDataOfCol("HoldChar_History_AccLevlPoliLe.eltDescription",
				input.get("VerifyText@Description#2"), 1);
		SleepUtils.sleep(4);

		// 22. Click on Policies WebElement
		uiDriver.click("HoldChar_History_AccLevlPoliLe.eltPolicies");
		SleepUtils.sleep(3);

		// 23. Verify whether the Policy_ element present
		if (uiDriver.checkElementPresent("HoldChar_History_AccLevlPoliLe.eltPolicy_")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(4);

		// 24. Click on Policy_ WebElement
		uiDriver.th.findRelativeCellWithMultipulTextAndClickfirstCell("Reinstated_Policies_New_InvNum.eltActivi_Policy",
				"Active|Reinstated", 5);
		SleepUtils.sleep(4);

		// 25. Click on Charges_Poli WebElement
		uiDriver.click("HoldChar_History_AccLevlPoliLe.eltCharges_Poli");
		SleepUtils.sleep(8);

		// 26. Select the Not_Held ?check box
		uiDriver.th.findRelativeCellAndClickfirstCell("HoldChar_History_AccLevlPoliLe.chkNot_Held",
				input.get("Select@Not_Held"), 7, input.get("Select@Not_Held"));
		SleepUtils.sleep(6);

		// 27. Click on Edit_Holds_Policy button
		uiDriver.click("HoldChar_History_AccLevlPoliLe.btnEdit_Holds_Policy");
		SleepUtils.sleep(10);

		// 28. Click on Not_Held_Policy WebElement
		uiDriver.click("HoldChar_History_AccLevlPoliLe.eltNot_Held_Policy");
		SleepUtils.sleep(6);

		// 29. Select $data from the Hold_Status_Poli list
		uiDriver.setValue("HoldChar_History_AccLevlPoliLe.lstHold_Status_Policy", input.get("Select@Hold_Status_Poli"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(4);

		// 30. Click on _none_ WebElement
		uiDriver.click("HoldChar_History_AccLevlPoliLe.elt_none_");

		// 31. Select $data from the Reason list
		uiDriver.setValue("HoldChar_History_AccLevlPoliLe.lstReason", input.get("Select@Reason#2"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(4);

		// 32. Click on OK button
		uiDriver.click("HoldChar_History_AccLevlPoliLe.btnOK");
		SleepUtils.sleep(2);
		String cellvalue1 = uiDriver.th.getCellDataOfRelatedColumn("HoldChar_History_AccLevlPoliLe.chkNot_Held", "Held",
				7, 9);
		if (!cellvalue1.equals("")) {
			passed("Reason", "ReasonPresent should pass", "ReasonPresent passed");
		} else {
			failed("Reason", "ReasonPresent should pass", "ReasonPresent failed");
		}

		// 33. Click on History_Policy WebElement
		uiDriver.click("HoldChar_History_AccLevlPoliLe.eltHistory_Policy");

		// 34. Select $data from the Filter_by_Type_Policy list
		uiDriver.click("HoldChar_History_AccLevlPoliLe.lstFilter_by_Type_Policy");
		SleepUtils.sleep(2);
		uiDriver.setValue("HoldChar_History_AccLevlPoliLe.lstFilter_by_Type_Policy",
				input.get("Select@Filter_by_Type_Policy#1"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(4);

		// 35. Verify the text ?$data in the Descrilption_Poli field
		uiDriver.th.getCellDataOfCol("HoldChar_History_AccLevlPoliLe.eltDescrilption_Poli",
				input.get("VerifyText@Descrilption_Poli#1"), 1);
		SleepUtils.sleep(2);

		// 36. Click on Charges WebElement
		uiDriver.click("HoldChar_History_AccLevlPoliLe.eltCharges_Poli");
		uiDriver.click("HoldChar_History_AccLevlPoliLe.eltCharges_Poli");
		SleepUtils.sleep(6);

		// 37. Select the Held ?checkbox
		uiDriver.th.findRelativeCellAndClickSelectedCell("HoldChar_History_AccLevlPoliLe.chkNot_Held",
				input.get("Select@Held#2"), 7, input.get("Select@Held#2"), "");
		SleepUtils.sleep(2);

		// 38. Click on Edit_Holds_Policy WebElement
		uiDriver.click("HoldChar_History_AccLevlPoliLe.btnEdit_Holds_Policy");

		// 39. Click on Held_Policy WebElement
		uiDriver.click("HoldChar_History_AccLevlPoliLe.eltHeld_Policy");
		SleepUtils.sleep(2);

		// 40. Select $data from the Hold_Status_Policy list
		uiDriver.setValue("HoldChar_History_AccLevlPoliLe.lstHold_Status_Policy",
				input.get("Select@Hold_Status_Policy"));
		SleepUtils.sleep(3);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(4);

		// 41. Click on OK button
		uiDriver.click("HoldChar_History_AccLevlPoliLe.btnOK");
		SleepUtils.sleep(6);

		// 42. Click on History_Policy WebElement
		uiDriver.click("HoldChar_History_AccLevlPoliLe.eltHistory_Policy");
		SleepUtils.sleep(2);

		// 43. Select $data from the Filter_by_Type_Policy list
		uiDriver.click("HoldChar_History_AccLevlPoliLe.lstFilter_by_Type_Policy");
		SleepUtils.sleep(2);
		uiDriver.setValue("HoldChar_History_AccLevlPoliLe.lstFilter_by_Type_Policy",
				input.get("Select@Filter_by_Type_Policy#2"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(4);

		// 44. Verify the text ?$data in the Descrilption_Poli field
		uiDriver.th.getCellDataOfCol("HoldChar_History_AccLevlPoliLe.eltDescrilption_Poli",
				input.get("VerifyText@Descrilption_Poli#2"), 1);
		SleepUtils.sleep(5);
	}

	public void Validate_UserRoles(DataRow input, DataRow output) {
		// 1. Click on Charges WebElement
		uiDriver.click("Validate_UserRoles.eltCharges");
		SleepUtils.sleep(3);

		// 2. Select the Acc_charges ?checkbox
		uiDriver.th.findRelativeCellAndClickSelectedCell("HoldChar_History_AccLevlPoliLe.chkCharges_Tble",
				input.get("Select@Acc_charges"), 6, input.get("Select@Acc_charges"), "");
		SleepUtils.sleep(3);

	}

	public void Validate_TypeList(DataRow input, DataRow output) {
		// 1. Click on Policies WebElement
		uiDriver.click("HoldChar_History_AccLevlPoliLe.eltPolicies");
		SleepUtils.sleep(3);

		// 2. Verify whether the Policy_ element present
		if (uiDriver.checkElementPresent("HoldChar_History_AccLevlPoliLe.eltPolicy_")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(4);

		// 3. Click on Policy_ WebElement
		uiDriver.th.findRelativeCellWithMultipulTextAndClickfirstCell("Reinstated_Policies_New_InvNum.eltActivi_Policy",
				"Active|Reinstated", 5);
		// uiDriver.click("HoldChar_History_AccLevlPoliLe.eltPolicy_");
		SleepUtils.sleep(4);

		// 4. Click on Charges WebElement
		uiDriver.click("Validate_TypeList.eltCharges");
		SleepUtils.sleep(3);

		// 5. Select the Policy Charges ?checkbox
		uiDriver.th.findRelativeCellAndClickSelectedCell("HoldChar_History_AccLevlPoliLe.chkNot_Held",
				input.get("Select@Not_Held"), 7, input.get("Select@Not_Held"), "");
		SleepUtils.sleep(3);

		// 6. Click on Edit_Holds button
		uiDriver.click("Validate_TypeList.btnEdit_Holds");
		SleepUtils.sleep(3);

		// 7. Click on Not_Held WebElement
		uiDriver.click("Validate_TypeList.eltNot_Held");

		// 8. Select $data from the Hold_Status list
		uiDriver.setValue("Validate_TypeList.lstHold_Status", input.get("Select@Hold_Status"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");

		// 9. Click on _none_ WebElement
		uiDriver.click("Validate_TypeList.elt_none_");
		SleepUtils.sleep(3);
		boolean verfiyva1l = uiDriver.getElementNameUsingTag("li", "Reconciliation");
		if (!verfiyva1l) {
			uiDriver.sendKey("Esc");
			SleepUtils.sleep(3);
			uiDriver.click("Validate_TypeList.elt_none_");
			SleepUtils.sleep(2);
		}

		// 10. Select $data from the Reason list
		uiDriver.checkDropDownOptions("li", input.get("Select@Reason"));

	}

	/**
	 * Overriding toString() method of object class to print
	 * US1005_Hold_Charges_Account_and_Policy format string
	 **/
	public String toString() {
		return "US1005_Hold_Charges_Account_and_PolicyDriver";
	}
}