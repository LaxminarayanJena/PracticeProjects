/******************************************************************************
Created by : Capgemini Automation Team 
Created\Updated on : 3/11/2018 11:37:58 AM
Module part of 'Guidewire_BillingCenter'
Module created using Cafenext Selenium Builder
******************************************************************************/
package ModuleDrivers;

import static cbf.engine.TestResultLogger.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import cbf.engine.TestResult.ResultType;
import cbf.harness.ParameterAccess;
import cbf.utils.DataRow;
import cbf.utils.SleepUtils;
import cbf.utils.SleepUtils.TimeSlab;
import cbfx.selenium.BaseWebModuleDriver;

/**
 * Extends BaseModuleDriver class and performs application specific operations
 */
public class US907_TC_BC_NEPCommissonAdjustmentDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US907_TC_BC_NEPCommissonAdjustmentDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void TC01_NEPCommissionAdjustment(DataRow input, DataRow output) {
		// 1. Click on Producer WebElement
		uiDriver.click("TC01_NEPCommissionAdjustment.eltProducer");
		SleepUtils.sleep(2);

		// 2. Type $data in Producer_Code field
		uiDriver.setValue("TC01_NEPCommissionAdjustment.txtProducer_Code", input.get("Type@Producer_Code"));
		SleepUtils.sleep(2);

		// 3. Click on Search button
		uiDriver.click("TC01_NEPCommissionAdjustment.btnSearch");
		SleepUtils.sleep(2);

		// 4. Verify whether the Name link is present
		if (uiDriver.checkElementPresent("TC01_NEPCommissionAdjustment.lnkName")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		
		// 5. Click on Name Link
		SleepUtils.sleep(2);
		uiDriver.click("TC01_NEPCommissionAdjustment.lnkName_");
		SleepUtils.sleep(2);

		// 6. Click on Actions button
		uiDriver.click("TC01_NEPCommissionAdjustment.btnActions");
		SleepUtils.sleep(8);

		// 7. Click on Commission_Adjustment WebElement
		uiDriver.click("TC01_NEPCommissionAdjustment.eltCommission_Adjustment");
		SleepUtils.sleep(2);

		// 8. Type $data in Amount field
		uiDriver.setValue("TC01_NEPCommissionAdjustment.txtAmount", input.get("Type@Amount"));
		SleepUtils.sleep(2);

		// 9. Click Adjustment_Reason
		uiDriver.click("TC01_NEPCommissionAdjustment.txtAdjustment_Reason");
		SleepUtils.sleep(2);

		// 10. Select $data from the Adjustment_Reason list
		uiDriver.setValue("TC01_NEPCommissionAdjustment.lstAdjustment_Reason", input.get("Select@Adjustment_Reason"));
		SleepUtils.sleep(3);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(3);

		// 11. Click on Next button
		uiDriver.click("TC01_NEPCommissionAdjustment.btnNext");
		uiDriver.sendKey("keysdown");
		SleepUtils.sleep(6);

		// 12. Click Starts_with_Policy_Number
		uiDriver.click("TC01_NEPCommissionAdjustment.txtStarts_with_Policy_Number");
		SleepUtils.sleep(2);
		String Starts_with_Policy_Number=uiDriver.th.getCellData("TC01_NEPCommissionAdjustment.tblCommissionAdjustment", 0, 1);
		SleepUtils.sleep(2);
			

		// 13. Type $data in Starts_with_Policy_Number field
		uiDriver.setValue("TC01_NEPCommissionAdjustment.txtStarts_with_Policy_Number",
				Starts_with_Policy_Number);
		SleepUtils.sleep(4);

		// 14. Click on Go button
		uiDriver.click("TC01_NEPCommissionAdjustment.btnGo");
		SleepUtils.sleep(2);

		// 15. Click on Select Link
		uiDriver.click("TC01_NEPCommissionAdjustment.lnkSelect");
		SleepUtils.sleep(2);

		// 16. Click on Finish button
		uiDriver.click("TC01_NEPCommissionAdjustment.btnFinish");
		SleepUtils.sleep(2);

		// 17. Click on History WebElement
		uiDriver.click("TC01_NEPCommissionAdjustment.eltHistory");
		SleepUtils.sleep(2);

		// 18. Click Filter_by_Type
		uiDriver.click("TC01_NEPCommissionAdjustment.txtFilter_by_Type");
		SleepUtils.sleep(2);

		// 19. Type $data in Filter_by_Type field
		uiDriver.setValue("TC01_NEPCommissionAdjustment.txtFilter_by_Type", input.get("Type@Filter_by_Type"));

	}

	public void TC02_NEP_Roles_and_Permission(DataRow input, DataRow output) {
		// 1. Click on Producer WebElement
		uiDriver.click("TC02_NEP_Roles_and_Permission.eltProducer");

		// 2. Type $data in Producer_Code field
		uiDriver.setValue("TC02_NEP_Roles_and_Permission.txtProducer_Code", input.get("Type@Producer_Code"));

		// 3. Click on Search button
		uiDriver.click("TC02_NEP_Roles_and_Permission.btnSearch");

		// 4. Verify whether the Name link is present
		if (uiDriver.checkElementPresent("TC02_NEP_Roles_and_Permission.lnkName")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 5. Click on Name Link
		uiDriver.click("TC02_NEP_Roles_and_Permission.lnkName_");
		SleepUtils.sleep(8);

		// 6. Click on Actions button
		uiDriver.click("TC02_NEP_Roles_and_Permission.btnActions");
		SleepUtils.sleep(3);

		// 7. Verify whether the Commission_Adjustment element present
		if (uiDriver.checkElementPresent("TC02_NEP_Roles_and_Permission.eltCommission_Adjustment")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 8. Click on Commission_Adjustment WebElement
		uiDriver.click("TC02_NEP_Roles_and_Permission.eltCommission_Adjustment");
		SleepUtils.sleep(3);

		// 9. Click Adjustment_Reason
		uiDriver.click("TC02_NEP_Roles_and_Permission.txtAdjustment_Reason");
		SleepUtils.sleep(3);

		// 10. Verify whether the NEP element present
		if (uiDriver.checkElementPresent("TC02_NEP_Roles_and_Permission.eltNEP")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 11. Click on Cancel button
		uiDriver.click("TC02_NEP_Roles_and_Permission.btnCancel");

	}

	public void TC03_NEPCommission_Activities(DataRow input, DataRow output) {
		// 1. Click on Account WebElement
		uiDriver.click("TC03_NEPCommission_Activities.eltAccount");

		// 2. Type $data in Account_Name field
		uiDriver.setValue("TC03_NEPCommission_Activities.txtAccount_Name", input.get("Type@Account_Name"));

		// 3. Click on Search button
		uiDriver.click("TC03_NEPCommission_Activities.btnSearch");

		// 4. Verify whether the Account link is present
		if (uiDriver.checkElementPresent("TC03_NEPCommission_Activities.lnkAccount")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 5. Click on Account_ Link
		uiDriver.click("TC03_NEPCommission_Activities.lnkAccount_");

		// 6. Click on Actions button
		uiDriver.click("TC03_NEPCommission_Activities.btnActions");

		// 7. Click on NEP WebElement
		uiDriver.click("TC03_NEPCommission_Activities.eltNEP");
		SleepUtils.sleep(5);

		// 8. Click on Debit_Adjustment WebElement
		uiDriver.mouseOver("TC03_NEPCommission_Activities.eltDebit_Adjustment");
		SleepUtils.sleep(5);

		// 9. Click on Payment_Reversal WebElement
		uiDriver.click("TC01_NEPPmntRevviewEditAddNew.eltPayment_Reversal");
		SleepUtils.sleep(5);	

		// 10. Type $data in Payment_Amount field
		uiDriver.setValue("NEPOtherTransactions.txtPaymentAmount", input.get("Type@Payment_Amount"));
		SleepUtils.sleep(5);

		// 11. Click Payment_Date
		String tday=uiDriver.currentdate("");
		SleepUtils.sleep(2);
		uiDriver.setValue("NEPOtherTransactions.eltDatePicker", tday);
		SleepUtils.sleep(4);

		// 12. Click on Reversal_Reason WebElement
		uiDriver.click("NEPOtherTransactions.lstReason");

		// 13. Select $data from the Reversal_Reason list
		uiDriver.setValue("NEPOtherTransactions.lstReason", input.get("Select@Reversal_Reason"));
		//uiDriver.sendKey("enter");
		SleepUtils.sleep(3);
	
		// 14. Type $data in Debt field
		String PolicyNum=uiDriver.th.getCellData("NEPOtherTransactions.tblPolicy", 0, 1);
		SleepUtils.sleep(4);
	

		//15.Type $data in Policy field
		uiDriver.setValue("NEPOtherTransactions.txtPolicyStartsWith", PolicyNum);
		SleepUtils.sleep(4);
		
		//16.Click on Go Button
		uiDriver.click("NEPOtherTransactions.btnGo");
		
		//17.Select check box Related policy in table
		uiDriver.th.findRelativeCellAndClickfirstCell("NEPOtherTransactions.tblPolicy", PolicyNum, 1, PolicyNum);
		SleepUtils.sleep(4);
		uiDriver.click("NEPOtherTransactions.btnSelectPolicies");
		SleepUtils.sleep(3);
		
		// 18. Click on Next button
		uiDriver.click("TC01_NEPPmntRevviewEditAddNew.btnPmnt_Reversal_Next");
		SleepUtils.sleep(4);
		if (uiDriver.checkElementPresent("NEPOtherTransactions.eltPaymentReversal")) {
			uiDriver.click("NEPOtherTransactions.lstReason");
			SleepUtils.sleep(3);
			uiDriver.setValue("NEPOtherTransactions.lstReason", input.get("Select@Reversal_Reason"));
			uiDriver.sendKey("enter");
			SleepUtils.sleep(3);
			uiDriver.click("TC01_NEPPmntRevviewEditAddNew.btnPmnt_Reversal_Next");
		}
		SleepUtils.sleep(4);
		
		//19. Click and Type $data in Debt field
		uiDriver.doubleclick("NEPOtherTransactions.tblDebit");
		SleepUtils.sleep(2);
		uiDriver.doubleclick("NEPOtherTransactions.tblDebit");
		SleepUtils.sleep(2);
		uiDriver.setValue("NEPOtherTransactions.tblDebit_1", input.get("Type@Payment_Amount"));
		SleepUtils.sleep(6);
		
		//20.Click on Add button
		uiDriver.click("NEPOtherTransactions.btnAdd");
		SleepUtils.sleep(4);
		
		//21. Verify the list values 
		uiDriver.click("NEPOtherTransactions.tblCategory");
		SleepUtils.sleep(2);
		
		//22. Click and Type $data in Category field
		uiDriver.setValue("NEPOtherTransactions.tblCategory_1", input.get("Select@Category"));
		SleepUtils.sleep(4);

		//23. Click and Type $data in Amount field
		uiDriver.click("NEPOtherTransactions.txtAmount");
		SleepUtils.sleep(2);
		uiDriver.setValue("NEPOtherTransactions.txtAmount_1", input.get("Type@Payment_Amount"));
		SleepUtils.sleep(4);
		
		// 24. Click on Finish button
		uiDriver.click("TC02_NEP_Debit_Adjustment.btnFinish");
		SleepUtils.sleep(10);
		
		// 25.Click on OK button
		uiDriver.mouseOver("TC01_Validate_Newly_Added_Feat.btnOK");
		SleepUtils.sleep(2);
		uiDriver.click("TC01_Validate_Newly_Added_Feat.btnOK");
		SleepUtils.sleep(8);

		// 26. Click on Activities WebElement
		uiDriver.click("TC03_NEPCommission_Activities.eltActivities");

		// 27. Click on NEP_Commission_Review Link
		uiDriver.click("TC03_NEPCommission_Activities.lnkNEP_Commission_Review");
		SleepUtils.sleep(3);

		// 28. Click on Cancel button
		uiDriver.click("TC03_NEPCommission_Activities.btnCancel");

		// 29. Click on Actions_1 button
		uiDriver.click("TC03_NEPCommission_Activities.btnActions_1");

		// 30. Click on NEP_1 WebElement
		uiDriver.click("TC03_NEPCommission_Activities.eltNEP_1");

		// 31. Click on Modify_Distribution WebElement
		uiDriver.click("TC03_NEPCommission_Activities.eltModify_Distribution");

		// 32. Type $data in Payment_Amount_1 field
		uiDriver.setValue("TC03_NEPCommission_Activities.txtPayment_Amount_1", input.get("Type@Payment_Amount_1"));
		uiDriver.sendKey("tab");

		// 33. Click Payment_Date_1
		uiDriver.click("TC03_NEPCommission_Activities.txtPayment_Mod_Date_1");
		SleepUtils.sleep(3);
		uiDriver.setValue("TC03_NEPCommission_Activities.txtPayment_Mod_Date_1", input.get("Type@Payment_Date"));
		SleepUtils.sleep(3);
		
		// 34. Click Debit_1
		uiDriver.click("TC03_NEPCommission_Activities.txtDebit_2");
		SleepUtils.sleep(5);
		uiDriver.click("TC03_NEPCommission_Activities.txtDebit_2");

		// 35. Type $data in Debit_1 field
		uiDriver.setValue("TC03_NEPCommission_Activities.txtDebit_3", input.get("Type@Debit_1"));
		SleepUtils.sleep(5);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(5);

		// 36. Click Credit_1
		uiDriver.click("TC03_NEPCommission_Activities.txtCredit_1");
		SleepUtils.sleep(3);
		if (uiDriver.checkElementPresent("TC03_NEPCommission_Activities.txtCredit_2")) {
			uiDriver.doubleclick("TC03_NEPCommission_Activities.txtCredit_1");
		}
		
		// 37. Type $data in Credit_1 field
		SleepUtils.sleep(3);
		uiDriver.setValue("TC03_NEPCommission_Activities.txtCredit_2", input.get("Type@Credit_1"));
		SleepUtils.sleep(5);

		// 38. Click on Next_1 button
		uiDriver.click("TC03_NEPCommission_Activities.btnNext_1");
		SleepUtils.sleep(5);

		// 39. Click on Finish_1 button
		uiDriver.click("TC03_NEPCommission_Activities.btnFinish_1");
		SleepUtils.sleep(4);

		// 40. Click on Activities_1 WebElement
		uiDriver.click("TC03_NEPCommission_Activities.eltActivities_1");

		// 41. Click on NEP_Commission_Review_1 Link
		uiDriver.click("TC03_NEPCommission_Activities.lnkNEP_Commission_Review_1");
		SleepUtils.sleep(4);

		// 42. Click on Cancel_1 button
		uiDriver.click("TC03_NEPCommission_Activities.btnCancel_1");
		SleepUtils.sleep(4);

		// 43. Click on Actions_2 button
		uiDriver.click("TC03_NEPCommission_Activities.btnActions_2");

		// 44. Click on NEP_2 WebElement
		uiDriver.click("TC03_NEPCommission_Activities.eltNEP_2");
		SleepUtils.sleep(4);

		// 45. Click on Credit_Adjustment WebElement
		uiDriver.click("TC03_NEPCommission_Activities.eltCredit_Adjustment");

		SleepUtils.sleep(2);
		// 46. Click on Undistribute WebElement
		uiDriver.click("TC03_NEPCommission_Activities.eltUndistribute");

		// 47. Type $data in Amount field
		uiDriver.setValue("TC03_NEPCommission_Activities.txtAmount", input.get("Type@Amount"));

		// 48. Click Date
		uiDriver.click("TC03_NEPCommission_Activities.txtDate");
		SleepUtils.sleep(4);
		uiDriver.sendKey("Enter");
		SleepUtils.sleep(4);

		// 49. Click on Next_3 button
		uiDriver.click("TC03_NEPCommission_Activities.btnNext_3");

		// 50. Click on Finish button
		uiDriver.click("TC03_NEPCommission_Activities.btnFinish_2");

		// 51. Click on Activities_2 WebElement
		uiDriver.click("TC03_NEPCommission_Activities.eltActivities_2");
		SleepUtils.sleep(5);
		
		// 52. Click on NEP_Commission_Review_2 Link
		uiDriver.click("TC03_NEPCommission_Activities.lnkNEP_Commission_Review_2");
		SleepUtils.sleep(10);
		
		// 53. Click on Cancel_2 button
		uiDriver.click("TC03_NEPCommission_Activities.btnCancel_3");
		SleepUtils.sleep(10);

		// 54. Click on Transactions WebElement
		uiDriver.click("TC03_NEPCommission_Activities.eltTransactions");
		SleepUtils.sleep(8);
	}

	public void TC02_NEPRoles_ITAdmin(DataRow input, DataRow output) {
		// 1. Click on Producer WebElement
		uiDriver.click("TC02_NEPRoles_ITAdmin.eltProducer");

		// 2. Type $data in Producer_Code field
		uiDriver.setValue("TC02_NEPRoles_ITAdmin.txtProducer_Code", input.get("Type@Producer_Code"));

		// 3. Click on Search button
		uiDriver.click("TC02_NEPRoles_ITAdmin.btnSearch");

		// 4. Verify whether the Name link is present
		if (uiDriver.checkElementPresent("TC02_NEPRoles_ITAdmin.lnkName")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}

		// 5. Click on Name Link
		uiDriver.click("TC02_NEPRoles_ITAdmin.lnkName");

		// 6. Click on Actions button
		uiDriver.click("TC02_NEPRoles_ITAdmin.btnActions");

		// 7. Verify whether the Commission_Adjustment element present
		if (uiDriver.checkElementPresent("TC02_NEPRoles_ITAdmin.eltCommission_Adjustment")) {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		} else {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		}

	}

	/**
	 * Overriding toString() method of object class to print
	 * US907_TC_BC_NEPCommissonAdjustment format string
	 **/
	public String toString() {
		return "US907_TC_BC_NEPCommissonAdjustmentDriver";
	}
}