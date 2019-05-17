/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 3/9/2018 1:34:42 AM
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
public class US1393_Config_Support_Story_for_BillingDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US1393_Config_Support_Story_for_BillingDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void Change_PolicyPeriod_Activity(DataRow input, DataRow output) {

		// 1. Click on Administration WebElement
		uiDriver.click("Change_PolicyPeriod_Activity.eltAdministration");

		// 2. Click on Utilities WebElement
		uiDriver.click("Change_PolicyPeriod_Activity.eltUtilities");

		// 3. Click on Script_Parameters WebElement
		uiDriver.click("Change_PolicyPeriod_Activity.eltScript_Parameters");

		// 4. Type $data in Page field
		uiDriver.setValue("Change_PolicyPeriod_Activity.txtPage", input.get("Type@Page"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("enter");
		SleepUtils.sleep(2);

		// 5. Click on CommissionRateThreshold WebElement
		uiDriver.th.findRelativeCellAndClickSelectedCell("Change_PolicyPeriod_Activity.eltCommissionRateThreshold",
				"CommissionRateThreshold", 0, "CommissionRateThreshold", "");

		// 6. Click on Policy WebElement
		uiDriver.click("Change_PolicyPeriod_Activity.eltPolicy");

		// 7. Click on Acc_Image image
		uiDriver.click("Change_PolicyPeriod_Activity.imgAcc_Image");
		SleepUtils.sleep(2);

		// 8. Type $data in Account_Name field
		uiDriver.setValue("Change_PolicyPeriod_Activity.txtAccount_Name", input.get("Type@Account_Name"));

		// 9. Click on Search WebElement
		uiDriver.click("Change_PolicyPeriod_Activity.eltSearch");
		SleepUtils.sleep(5);

		// 10. Verify whether the Select #targettype# is present
		if (uiDriver.checkElementPresent("Change_PolicyPeriod_Activity.eltSelect")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 11. Click on Select WebElement
		uiDriver.click("Change_PolicyPeriod_Activity.eltSelect");
		SleepUtils.sleep(2);

		// 12. Click on Pol_Search WebElement
		uiDriver.click("Change_PolicyPeriod_Activity.eltPol_Search");
		SleepUtils.sleep(5);

		// 13. Verify whether the Policy_Num element present
		if (uiDriver.checkElementPresent("Change_PolicyPeriod_Activity.eltPolicy_Num")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 14. Click on Policy_Num WebElement
		uiDriver.click("Change_PolicyPeriod_Activity.eltPolicy_Num");
		SleepUtils.sleep(2);

		// 15. Click on Commissions WebElement
		uiDriver.click("Change_PolicyPeriod_Activity.eltCommissions");
		SleepUtils.sleep(2);

		// 16. Click on Override_Plan button
		uiDriver.click("Change_PolicyPeriod_Activity.btnOverride_Plan");

		// 17. Select $data from the Override_Primary_Unassigned_H_ list
		uiDriver.click("Change_PolicyPeriod_Activity.lstOverride_Primary_Unassigned_H_");
		SleepUtils.sleep(2);
		uiDriver.setValue("Change_PolicyPeriod_Activity.lstOverride_Primary_Unassigned_H_",
				input.get("Select@Override_Primary_Unassigned_H_"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(2);

		// 18. Type $data in Percentage field
		uiDriver.setValue("Change_PolicyPeriod_Activity.txtPercentage", input.get("Type@Percentage"));

		// 19. Click on Update button
		uiDriver.click("Change_PolicyPeriod_Activity.btnUpdate");
		SleepUtils.sleep(2);

		// 20. Click on Activities WebElement
		uiDriver.click("Change_PolicyPeriod_Activity.eltActivities");
		SleepUtils.sleep(2);

	}

	public void Transfer_Policy(DataRow input, DataRow output) {
		// 1. Click on Producer WebElement
		uiDriver.click("TC01_TransferPoliciestoNewpro_.eltProducer");
		SleepUtils.sleep(3);

		// 2. Type $data in Producer_Code field
		uiDriver.setValue("TC01_TransferPoliciestoNewpro_.txtProducer_Code", input.get("Type@Producer_Code"));
		SleepUtils.sleep(3);

		// 3. Click on Search button
		uiDriver.click("TC01_TransferPoliciestoNewpro_.btnSearch");
		SleepUtils.sleep(3);

		// 4. Verify whether the Name link is present
		if (uiDriver.checkElementPresent("TC01_TransferPoliciestoNewpro_.lnkName")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);

		// 5. Click on Name_ Link
		uiDriver.click("TC01_TransferPoliciestoNewpro_.lnkName_");
		SleepUtils.sleep(3);

		// 6. Click on Policies WebElement
		uiDriver.click("TC01_TransferPoliciestoNewpro_.eltPolicies");
		SleepUtils.sleep(3);

		// 7. Click on Transfer_Policy button
		uiDriver.click("TC01_TransferPoliciestoNewpro_.btnTransfer_Policy");
		SleepUtils.sleep(3);

		// 8. Click Code
		uiDriver.click("TC01_TransferPoliciestoNewpro_.txtCode");
		SleepUtils.sleep(3);

		// 9. Select $data from the Code list
		uiDriver.setValue("TC01_TransferPoliciestoNewpro_.lstCode", input.get("Select@Code"));
		SleepUtils.sleep(3);

		// 10. Click on Next button
		uiDriver.click("TC01_TransferPoliciestoNewpro_.btnNext");
		SleepUtils.sleep(3);

		// 11. Select the Checkbox ?checkbox
		uiDriver.click("TC01_TransferPoliciestoNewpro_.chkCheckbox");
		SleepUtils.sleep(3);

		// 12. Verify whether the Policy_ field is present
		if (uiDriver.checkElementPresent("TC01_TransferPoliciestoNewpro_.txtPolicy_")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);

		// 13. Click Product
		uiDriver.click("TC01_TransferPoliciestoNewpro_.txtProduct");
		SleepUtils.sleep(3);

		// 14. Select $data from the Product list
		uiDriver.setValue("TC01_TransferPoliciestoNewpro_.lstProduct", input.get("Select@Product"));
		SleepUtils.sleep(3);

		// 15. Click on Next_1 button
		uiDriver.click("TC01_TransferPoliciestoNewpro_.btnNext_1");
		SleepUtils.sleep(3);

		// 16. Click on Producer_Picker Link
		uiDriver.click("TC01_TransferPoliciestoNewpro_.lnkProducer_Picker");
		SleepUtils.sleep(3);

		// 17. Type $data in Producer_Code_1 field
		uiDriver.setValue("TC01_TransferPoliciestoNewpro_.txtProducer_Code_1", input.get("Type@Producer_Code_1"));
		SleepUtils.sleep(3);

		// 18. Click on Search_1 button
		uiDriver.click("TC01_TransferPoliciestoNewpro_.btnSearch_1");
		SleepUtils.sleep(3);

		// 19. Click on Select button
		uiDriver.click("TC01_TransferPoliciestoNewpro_.btnSelect");
		SleepUtils.sleep(3);

		// 20. Click on Next button
		uiDriver.click("TC01_TransferPoliciestoNewpro_.btnNext");
		SleepUtils.sleep(3);

		// 21. Click on Finish button
		uiDriver.click("TC01_TransferPoliciestoNewpro_.btnFinish");
		SleepUtils.sleep(3);

		// 22. Click on History WebElement
		uiDriver.click("TC01_TransferPoliciestoNewpro_.eltHistory");
		SleepUtils.sleep(3);

		// 23. Click Filter_by_Type
		uiDriver.click("TC01_TransferPoliciestoNewpro_.txtFilter_by_Type");
		SleepUtils.sleep(3);

		// 24. Select $data from the Filter_by_Type list
		uiDriver.setValue("TC01_TransferPoliciestoNewpro_.lstFilter_by_Type", input.get("Select@Filter_by_Type"));
		SleepUtils.sleep(3);
	}

	/**
	 * Overriding toString() method of object class to print
	 * US1393_Config_Support_Story_for_Billing format string
	 **/
	public String toString() {
		return "US1393_Config_Support_Story_for_BillingDriver";
	}
}
