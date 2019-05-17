/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 3/5/2018 7:19:59 AM
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
public class US956_TransferPoliciestoNewProducerDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US956_TransferPoliciestoNewProducerDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void TC01_TransferPoliciestoNewpro_(DataRow input, DataRow output) {
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
		uiDriver.sendKey("tab");
		SleepUtils.sleep(5);

		// 10. Click on Next button
		uiDriver.click("TC01_TransferPoliciestoNewpro_.btnNext");
		SleepUtils.sleep(15);
		if (uiDriver.checkElementPresent("TC01_TransferPoliciestoNewpro_.lstCode")) {
			String valCode = uiDriver.getControl("TC01_TransferPoliciestoNewpro_.lstCode").getAttribute("value");
			if (valCode.equalsIgnoreCase("<none>")) {
				uiDriver.click("TC01_TransferPoliciestoNewpro_.lstCode");
				SleepUtils.sleep(3);
				uiDriver.setValue("TC01_TransferPoliciestoNewpro_.lstCode", input.get("Select@Code"));
				SleepUtils.sleep(3);
				uiDriver.sendKey("tab");
				SleepUtils.sleep(3);
				uiDriver.click("TC01_TransferPoliciestoNewpro_.btnNext");
				SleepUtils.sleep(3);
			}
		}
		
		// 11. Select the Check box ?check box
		SleepUtils.sleep(3);
		uiDriver.th.findRelativeCellAndClickfirstCell("TC01_TransferPoliciestoNewpro_.eltPolicies_1", "primary", 3, "primary");
		//uiDriver.click("TC01_TransferPoliciestoNewpro_.chkCheckbox");
		SleepUtils.sleep(3);

		// 12. Verify whether the Policy_ field is present
		if (uiDriver.checkElementPresent("TC01_TransferPoliciestoNewpro_.txtPolicy_")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		
		// 13. Click Product
		SleepUtils.sleep(3);
		uiDriver.click("TC01_TransferPoliciestoNewpro_.txtProduct");
		SleepUtils.sleep(3);

		// 14. Select $data from the Product list
		uiDriver.setValue("TC01_TransferPoliciestoNewpro_.lstProduct", input.get("Select@Product"));
		SleepUtils.sleep(3);
		uiDriver.sendKey("tab");
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
		uiDriver.sendKey("tab");
		SleepUtils.sleep(3);
	}

	public void TC03_TransferPoliciesvalidater(DataRow input, DataRow output) {
		// 1. Click on Account WebElement
		uiDriver.click("TC03_TransferPoliciesvalidater.eltAccount");
		SleepUtils.sleep(4);

		// 2. Type $data in Account_Name field
		uiDriver.setValue("TC03_TransferPoliciesvalidater.txtAccount_Name", input.get("Type@Account_Name"));
		SleepUtils.sleep(4);

		// 3. Click on Search button
		uiDriver.click("TC03_TransferPoliciesvalidater.btnSearch");
		SleepUtils.sleep(4);

		// 4. Verify whether the Account link is present
		if (uiDriver.checkElementPresent("TC03_TransferPoliciesvalidater.lnkAccount")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(4);

		// 5. Click on Account_ Link
		uiDriver.click("TC03_TransferPoliciesvalidater.lnkAccount_");
		SleepUtils.sleep(4);

		// 6. Click on Actions button
		uiDriver.click("TC03_TransferPoliciesvalidater.btnActions");
		SleepUtils.sleep(4);

		// 7. Click on NEP WebElement
		uiDriver.click("TC03_TransferPoliciesvalidater.eltNEP");
		SleepUtils.sleep(4);

		// 8. Click on Credit_Adjustment WebElement
		uiDriver.click("TC03_TransferPoliciesvalidater.eltCredit_Adjustment");
		SleepUtils.sleep(4);

		// 9. Click on Undistribute WebElement
		uiDriver.click("TC03_TransferPoliciesvalidater.eltUndistribute");
		SleepUtils.sleep(4);

		// 10. Type $data in Amount field
		uiDriver.setValue("TC03_TransferPoliciesvalidater.txtAmount", input.get("Type@Amount"));
		SleepUtils.sleep(4);

		// 11. Click Date
		uiDriver.click("TC03_TransferPoliciesvalidater.txtDate");
		SleepUtils.sleep(3);
		uiDriver.sendKey("Enter");
		SleepUtils.sleep(4);

		// 12. Click on Next button
		uiDriver.click("TC03_TransferPoliciesvalidater.btnNext");
		SleepUtils.sleep(4);

		// 13. Click on Finish button
		uiDriver.click("TC03_TransferPoliciesvalidater.btnFinish");
		SleepUtils.sleep(4);

		// 14. Click on Activities WebElement
		uiDriver.click("TC03_TransferPoliciesvalidater.eltActivities");
		SleepUtils.sleep(4);

		uiDriver.click("TC03_TransferPoliciesvalidater.lnkNEP - Commission Review");
		SleepUtils.sleep(15);

		// 15. Click on Cancel button
		if (uiDriver.checkElementPresent("TC03_TransferPoliciesvalidater.btnCancel")) {
			uiDriver.click("TC03_TransferPoliciesvalidater.btnCancel");
		}
		SleepUtils.sleep(10);

		// 16. Click on Actions_1 button
		uiDriver.click("TC03_TransferPoliciesvalidater.btnActions_1");
		SleepUtils.sleep(4);

		// 17. Click on NEP_1 WebElement
		uiDriver.click("TC03_TransferPoliciesvalidater.eltNEP_1");
		SleepUtils.sleep(4);

		// 18. Click on Modify_Distribution WebElement
		uiDriver.click("TC03_TransferPoliciesvalidater.eltModify_Distribution");
		SleepUtils.sleep(4);

		// 19. Click Payment_Amount
		uiDriver.click("TC03_TransferPoliciesvalidater.txtPayment_Amount");
		SleepUtils.sleep(4);

		// 20. Type $data in Payment_Amount field
		uiDriver.setValue("TC03_TransferPoliciesvalidater.txtPayment_Amount", input.get("Type@Payment_Amount#1"));
		SleepUtils.sleep(3);
		uiDriver.sendKey("tab");
		uiDriver.click("TC03_TransferPoliciesvalidater.txtPayment_Date");
		uiDriver.sendKey("Enter");
		SleepUtils.sleep(3);

		// 21. Type $data in Debit field
		uiDriver.click("TC03_TransferPoliciesvalidater.txtDebit");
		SleepUtils.sleep(4);
		uiDriver.setValue("TC03_TransferPoliciesvalidater.txtDebit_Edit", input.get("Type@Debit#1"));
		SleepUtils.sleep(4);

		// 22. Type $data in Credit field
		uiDriver.doubleclick("TC03_TransferPoliciesvalidater.txtCredit");
		SleepUtils.sleep(4);
		uiDriver.doubleclick("TC03_TransferPoliciesvalidater.txtCredit");
		SleepUtils.sleep(4);
		SleepUtils.sleep(4);
		uiDriver.setValue("TC03_TransferPoliciesvalidater.txtCredit_Edit", input.get("Type@Credit#1"));
		SleepUtils.sleep(2);

		// 23. Click on Next_1 button
		uiDriver.click("TC03_TransferPoliciesvalidater.btnNext_1");
		SleepUtils.sleep(4);

		// 24. Click on Finish button
		uiDriver.click("TC03_TransferPoliciesvalidater.btnFinish_1");
		SleepUtils.sleep(4);

		// 25. Click on Activities_1 WebElement
		uiDriver.click("TC03_TransferPoliciesvalidater.eltActivities_1");
		SleepUtils.sleep(10);

		uiDriver.click("TC03_TransferPoliciesvalidater.lnkNEP - Commission Review");
		SleepUtils.sleep(15);

		// 26. Click on Cancel_1 button
		uiDriver.click("TC03_TransferPoliciesvalidater.btnCancel_1");
		SleepUtils.sleep(4);
		if (uiDriver.checkElementPresent("TC03_TransferPoliciesvalidater.btnCancel_1")) {
			uiDriver.click("TC03_TransferPoliciesvalidater.btnCancel_1");
		}
		SleepUtils.sleep(4);

		// 27. Click on Actions_2 button
		uiDriver.click("TC03_TransferPoliciesvalidater.btnActions_2");
		SleepUtils.sleep(4);

		// 28. Click on NEP_2 WebElement
		uiDriver.click("TC03_TransferPoliciesvalidater.eltNEP_2");
		SleepUtils.sleep(4);

		// 29. Click on Debit_Adjustment WebElement
		uiDriver.click("TC03_TransferPoliciesvalidater.eltDebit_Adjustment");
		SleepUtils.sleep(4);

		// 30. Click on Payment_Reversal WebElement
		//uiDriver.click("TC03_TransferPoliciesvalidater.eltPayment_Reversal");
		uiDriver.click("TC01_NEPPmntRevviewEditAddNew.eltPayment_Reversal");
		SleepUtils.sleep(5);
		String PolicyNum=uiDriver.th.getCellData("NEPOtherTransactions.tblPolicy", 0, 1);
		SleepUtils.sleep(4);

		// 31. Type $data in Payment_Amount field
		uiDriver.setValue("NEPOtherTransactions.txtPaymentAmount", input.get("Type@Payment_Amount#2"));
		//uiDriver.sendKey("tab");
		SleepUtils.sleep(4);

		// 32. Click Payment_Date
		SleepUtils.sleep(3);
		String tdayDate2=uiDriver.currentdate("");
		SleepUtils.sleep(2);
		uiDriver.setValue("NEPOtherTransactions.eltDatePicker",tdayDate2);
		SleepUtils.sleep(2);
//		uiDriver.click("TC03_TransferPoliciesvalidater.txtPayment_Date_1");
//		uiDriver.sendKey("Enter");
//		uiDriver.sendKey("tab");
//		SleepUtils.sleep(4);

		// 33. Click Reversal_Reason
		uiDriver.click("NEPOtherTransactions.lstReason");
		SleepUtils.sleep(4);

		// 34. Select $data from the Reversal_Reason list
		uiDriver.setValue("NEPOtherTransactions.lstReason", input.get("Select@Reversal_Reason"));
		SleepUtils.sleep(3);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(3);
		
		//32. Type $data in Policy_Starts_With field
		uiDriver.setValue("NEPOtherTransactions.txtPolicyStartsWith",PolicyNum);
		SleepUtils.sleep(2);
		
		//33. Click on Go_ button
		uiDriver.click("NEPOtherTransactions.btnGo");
		SleepUtils.sleep(2);
		
		
		//34. Click on Pmnt_Reversal_Next button
		SleepUtils.sleep(2);
		uiDriver.th.findRelativeCellAndClickfirstCell("NEPOtherTransactions.tblPolicy", PolicyNum, 1, PolicyNum);
		SleepUtils.sleep(4);
		uiDriver.click("NEPOtherTransactions.btnSelectPolicies");
		SleepUtils.sleep(4);
		uiDriver.click("TC01_NEPPmntRevviewEditAddNew.btnPmnt_Reversal_Next");
		SleepUtils.sleep(2);
		
		//35. Click and Type $data in Debt field
		uiDriver.doubleclick("NEPOtherTransactions.tblDebit");
		SleepUtils.sleep(2);
		uiDriver.doubleclick("NEPOtherTransactions.tblDebit");
		SleepUtils.sleep(2);
		uiDriver.setValue("NEPOtherTransactions.tblDebit_1", input.get("Type@Debit#1"));
		SleepUtils.sleep(6);
		

		//36.Click on Add button
		uiDriver.click("NEPOtherTransactions.btnAdd");
		SleepUtils.sleep(4);
		
		//37. Click and Type $data in Category field
		uiDriver.click("NEPOtherTransactions.tblCategory");
		SleepUtils.sleep(2);
		uiDriver.setValue("NEPOtherTransactions.tblCategory_1", input.get("Select@Category"));
		uiDriver.sendKey("enter");
		SleepUtils.sleep(2);
		
		//38. Click and Type $data in Amount field
		uiDriver.click("NEPOtherTransactions.txtAmount");
		SleepUtils.sleep(2);
		uiDriver.setValue("NEPOtherTransactions.txtAmount_1", input.get("Type@Debit#1"));
		uiDriver.sendKey("enter");
		SleepUtils.sleep(2);
		
		//39. Click on Finish button
		uiDriver.click("TC01_NEPPmntRevviewEditAddNew.btnFinsh");
		SleepUtils.sleep(12);
		uiDriver.mouseOver("US1257TC04_ReverseDirectBillPa.btnOk");
		SleepUtils.sleep(6);
		uiDriver.click("US1257TC04_ReverseDirectBillPa.btnOk");
		SleepUtils.sleep(2);

		//40. Verify whether the NEP_payment_Complete element present
		SleepUtils.sleep(2);
		if (uiDriver.checkElementPresent("NEPOtherTransactions.eltDebitAdjustmentTransa")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}

//		// 35. Type $data in Debit field
//		uiDriver.click("TC03_TransferPoliciesvalidater.txtDebit_1");
//		if (!uiDriver.checkElementPresent("TC03_TransferPoliciesvalidater.txtDebit_Edit_1")) {
//			uiDriver.click("TC03_TransferPoliciesvalidater.txtDebit_1");
//		}
//		SleepUtils.sleep(4);
//		uiDriver.setValue("TC03_TransferPoliciesvalidater.txtDebit_Edit_1", input.get("Type@Debit#2"));
//
//		// 36. Click on Next_2 button
//		uiDriver.click("TC03_TransferPoliciesvalidater.btnNext_2");
//		SleepUtils.sleep(4);
//
//		// 37. Click on Finish button
//		uiDriver.click("TC03_TransferPoliciesvalidater.btnFinish_2");
//		SleepUtils.sleep(4);

		// 38. Click on Activities_2 WebElement
		uiDriver.click("TC03_TransferPoliciesvalidater.eltActivities_2");
		SleepUtils.sleep(3);

		uiDriver.click("TC03_TransferPoliciesvalidater.lnkNEP - Commission Review");
		SleepUtils.sleep(15);

		// 39. Click on Cancel_2 button
		if (uiDriver.checkElementPresent("TC03_TransferPoliciesvalidater.btnCancel_2")) {
			uiDriver.click("TC03_TransferPoliciesvalidater.btnCancel_2");
		}
		
		// 40. Click on Transactions WebElement
		SleepUtils.sleep(4);
		uiDriver.click("TC03_TransferPoliciesvalidater.eltTransactions");
		SleepUtils.sleep(3);
	}

	/**
	 * Overriding toString() method of object class to print
	 * US956_TransferPoliciestoNewProducer format string
	 **/
	public String toString() {
		return "US956_TransferPoliciestoNewProducerDriver";
	}
}
