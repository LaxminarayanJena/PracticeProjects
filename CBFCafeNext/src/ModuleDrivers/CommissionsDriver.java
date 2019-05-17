/******************************************************************************
Created by :  Capgemini Automation team
Created\Updated on : 1/31/2018 5:23:49 AM
Module part of 'Guidewire_BillingCenter'
Module created using Cafenext Selenium Builder
 ******************************************************************************/
package ModuleDrivers;

import static cbf.engine.TestResultLogger.*;
import java.io.IOException;

import org.openqa.selenium.By;

import cbf.engine.TestResult.ResultType;
import cbf.harness.ParameterAccess;
import cbf.utils.DataRow;
import cbf.utils.SleepUtils;
import cbf.utils.SleepUtils.TimeSlab;
import cbfx.selenium.BaseWebModuleDriver;

/**
 * Extends BaseModuleDriver class and performs application specific operations
 */
public class CommissionsDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public CommissionsDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void Policy_Commissions(DataRow input, DataRow output) {

		// 1. Click on Account WebElement
		uiDriver.click("Policy_Commissions.eltAccount");
		SleepUtils.sleep(2);

		// 2. Type $data in Account_Name field
		uiDriver.setValue("Policy_Commissions.txtAccount_Name", input.get("Type@Account_Name"));
		SleepUtils.sleep(2);

		// 3. Click on Search button
		uiDriver.click("Policy_Commissions.btnSearch");
		SleepUtils.sleep(2);

		// 4. Click on Account Link
		uiDriver.click("Policy_Commissions.lnkAccount");
		SleepUtils.sleep(4);

		// 5. Click on Details WebElement
		uiDriver.click("Policy_Commissions.eltDetails");
		SleepUtils.sleep(4);
		uiDriver.click("Policy_Commissions.lnkPolicy_Number");
		uiDriver.sendKey("Pagedown");
		uiDriver.sendKey("Pagedown");
		uiDriver.sendKey("Pagedown");

		// 6. Click on Commissions WebElement
		uiDriver.click("Policy_Commissions.eltCommissions");
		uiDriver.sendKey("Pagedown");
		uiDriver.sendKey("Pagedown");
		SleepUtils.sleep(5);

		// 7. Click on Commission_Plan Link
		uiDriver.click("Policy_Commissions.lnkCommission_Plan");
		uiDriver.sendKey("Pagedown");
		uiDriver.sendKey("Pagedown");
		SleepUtils.sleep(5);

		// 8. Click on Return_to_Commissions Link
		uiDriver.sendKey("Pagedown");
		uiDriver.click("Policy_Commissions.lnkReturn_to_Commissions");
		SleepUtils.sleep(2);

		// 9. Click on Commission_Plan_1 Link
		uiDriver.click("Policy_Commissions.lnkCommission_Plan_1");
		uiDriver.sendKey("Pagedown");
		uiDriver.sendKey("Pagedown");
		SleepUtils.sleep(2);

		// 10. Click on Return_to_Commissions_1 Link
		uiDriver.click("Policy_Commissions.lnkReturn_to_Commissions_1");

		// 11. Click on Commission_Plan_2 Link
		uiDriver.click("Policy_Commissions.lnkCommission_Plan_2");
		uiDriver.sendKey("Pagedown");
		uiDriver.sendKey("Pagedown");
		SleepUtils.sleep(2);

		// 12. Click on Return_to_Commissions_2 Link
		uiDriver.click("Policy_Commissions.lnkReturn_to_Commissions_2");

		// 13. Click on Commission_Plan_3 Link
		uiDriver.click("Policy_Commissions.lnkCommission_Plan_3");
		uiDriver.sendKey("Pagedown");
		uiDriver.sendKey("Pagedown");
		SleepUtils.sleep(2);

		// 14. Click on Return_to_Commissions_3 Link
		uiDriver.click("Policy_Commissions.lnkReturn_to_Commissions_3");

		// 15. Click on Commission_Plan_4 Link
		uiDriver.click("Policy_Commissions.lnkCommission_Plan_4");
		uiDriver.sendKey("Pagedown");
		uiDriver.sendKey("Pagedown");
		SleepUtils.sleep(2);

		// 17. Click on Return_to_Commissions_4 Link
		uiDriver.click("Policy_Commissions.lnkReturn_to_Commissions_4");

		// 18. Click on Account_1 Link
		uiDriver.click("Policy_Commissions.lnkAccount_1");

		// 19. Click on Details_1 WebElement
		uiDriver.click("Policy_Commissions.eltDetails_1");
		uiDriver.sendKey("pagedown");
		uiDriver.sendKey("pagedown");
		SleepUtils.sleep(2);

		// 20. Click on Policy_Number_1 link
		uiDriver.click("Policy_Commissions.lnkPolicy_Number_1");
		SleepUtils.sleep(2);

		// 21. Click on Commissions_1 WebElement
		uiDriver.click("Policy_Commissions.eltCommissions_1");
		SleepUtils.sleep(3);

		// 22. Click on Commission_Plan_5 Link
		uiDriver.click("Policy_Commissions.lnkCommission_Plan");
		SleepUtils.sleep(2);

		// 23. Click on Return_to_Commissions_5 Link
		uiDriver.click("Policy_Commissions.lnkReturn_to_Commissions");
		SleepUtils.sleep(2);
	}

	public void Change_Charge_Commissions(DataRow input, DataRow output) {
		// 1. Click on Administration WebElement
		uiDriver.click("Change_Charge_Commissions.eltAdministration");

		// 2. Type $data in User_name field
		uiDriver.setValue("Change_Charge_Commissions.txtUser_name", System.getProperty("user.name"));

		// 3. Click on Search button
		uiDriver.click("Change_Charge_Commissions.btnSearch");

		// 4. Click on Display_Name Link
		uiDriver.click("Change_Charge_Commissions.lnkDisplay_Name");

		// 5. Click on Account WebElement
		uiDriver.click("Change_Charge_Commissions.eltAccount");

		// 6. Type $data in Account_Name field
		uiDriver.setValue("Change_Charge_Commissions.txtAccount_Name", input.get("Type@Account_Name"));

		// 7. Click on Search_1 button
		uiDriver.click("Change_Charge_Commissions.btnSearch_1");
		uiDriver.click("Change_Charge_Commissions.lnkAccount");

		// 8. Click on Charges WebElement
		uiDriver.click("Change_Charge_Commissions.eltCharges");
		SleepUtils.sleep(4);

		// 9. Click the Checkbox
		uiDriver.click("Change_Charge_Commissions.chkCheckbox");
		SleepUtils.sleep(4);

		// 10. Verify whether the Override_Commission button is present
		if (uiDriver.checkElementPresent("Change_Charge_Commissions.btnOverride_Commission")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(4);

		// 11. Click on Policies WebElement
		uiDriver.click("Change_Charge_Commissions.eltPolicies");
		SleepUtils.sleep(2);

		// 12. Click on Policy Link
		uiDriver.click("Change_Charge_Commissions.lnkPolicy");
		SleepUtils.sleep(2);

		// 13. Click on Charges WebElement
		uiDriver.click("Change_Charge_Commissions.eltCharges_1");
		SleepUtils.sleep(4);

		// 14. Click the Checkbox
		uiDriver.click("Change_Charge_Commissions.chkCheckbox_1");
		SleepUtils.sleep(3);

		// 15. Verify whether the Override_Commission button is present
		if (uiDriver.checkElementPresent("Change_Charge_Commissions.btnOverride_Commission_1")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(4);

		// 16. Click on Commissions WebElement
		uiDriver.click("Change_Charge_Commissions.eltCommissions");
		SleepUtils.sleep(2);

		// 17. Click on Override_Plan button
		uiDriver.click("Change_Charge_Commissions.btnOverride_Plan");
		SleepUtils.sleep(4);

		// 18. Click OverrideCommissionPlan
		uiDriver.click("Change_Charge_Commissions.txtOverrideCommissionPlan");
		SleepUtils.sleep(2);

		// 19. Select $data from the OverrideCommissionPlan list
		uiDriver.setValue("Change_Charge_Commissions.lstOverrideCommissionPlan",
				input.get("Select@OverrideCommissionPlan"));
		uiDriver.sendKey("ENTER");
		SleepUtils.sleep(3);

		// 20. Type $data in Percentage field
		uiDriver.setValue("Change_Charge_Commissions.txtPercentage", input.get("Type@Percentage"));
		SleepUtils.sleep(3);

		// 21. Click on Update button
		uiDriver.click("Change_Charge_Commissions.btnUpdate");
		SleepUtils.sleep(4);

		// 22. Click on History WebElement
		uiDriver.click("Change_Charge_Commissions.eltHistory");
		SleepUtils.sleep(4);

		// 23. Click on Producer Link
		uiDriver.click("Change_Charge_Commissions.lnkProducer");
		SleepUtils.sleep(4);

		// 24. Click on History WebElement
		uiDriver.click("Change_Charge_Commissions.eltHistory_1");
		SleepUtils.sleep(4);

		// 25. Select $data from the Filter_by_Type list
		uiDriver.click("Change_Charge_Commissions.lstFilter_by_Type");
		SleepUtils.sleep(3);
		uiDriver.setValue("Change_Charge_Commissions.lstFilter_by_Type", input.get("Select@Filter_by_Type"));
		uiDriver.sendKey("ENTER");
		SleepUtils.sleep(5);

		// 26. Select $data from the Filter_by_Type list
		uiDriver.click("Change_Charge_Commissions.lstFilter_by_Type_1");
		SleepUtils.sleep(2);
		uiDriver.setValue("Change_Charge_Commissions.lstFilter_by_Type_1", input.get("Select@Filter_by_Type_1"));
		uiDriver.sendKey("ENTER");
		SleepUtils.sleep(8);
	}

	public void New_Commission_Payments(DataRow input, DataRow output) {
//		// 1. Click on Desktop WebElement
//		uiDriver.click("New_Commission_Payments.eltDesktop");
//		SleepUtils.sleep(2);
//
//		// 2. Click on Actions button
//		uiDriver.click("New_Commission_Payments.btnActions");
//		SleepUtils.sleep(2);
//
//		// 3. Click on New_Payment WebElement
//		uiDriver.click("New_Commission_Payments.eltNew_Payment");
//		SleepUtils.sleep(2);
//
//		// 4. Click on Batch_Payment_Entry WebElement
//		uiDriver.click("New_Commission_Payments.eltBatch_Payment_Entry");
//		SleepUtils.sleep(2);
//
//		// 5. Type $data in Batch_Amount field
//		uiDriver.setValue("New_Commission_Payments.txtBatch_Amount", input.get("Type@Batch_Amount"));
//		SleepUtils.sleep(2);
//
//		// 6. Click Payment_Instrument
//		uiDriver.click("New_Commission_Payments.txtPayment_Instrument");
//		SleepUtils.sleep(1);
//
//		// 7. Select $data from the Payment_Instrument list
//		uiDriver.setValue("New_Commission_Payments.lstPayment_Instrument", input.get("Select@Payment_Instrument"));
//		SleepUtils.sleep(1);
//
//		// 8. Click on Deposit_Date WebElement
//		uiDriver.click("New_Commission_Payments.eltDeposit_Date");
//
//		uiDriver.click("New_Commission_Payments.eltDeposit_Date");
//		uiDriver.sendKey("ENTER");
//
//		// 8. Click on Payment_Source WebElement
//		uiDriver.click("New_Commission_Payments.eltPayment_Source");
//		SleepUtils.sleep(3);
//
//		// 9. Select $data from the Payment_Source list
//		uiDriver.setValue("New_Commission_Payments.lstPayment_Source", input.get("Select@Payment_Source"));
//		SleepUtils.sleep(3);
//		uiDriver.sendKey("keysdown");
//		uiDriver.sendKey("Enter");
//		SleepUtils.sleep(3);
//		uiDriver.sendKey("tab");
//		uiDriver.sendKey("tab");
//		uiDriver.sendKey("tab");
//		uiDriver.sendKey("tab");
//		uiDriver.sendKey("tab");
//		uiDriver.sendKey("tab");
//		uiDriver.sendKey("tab");
//		uiDriver.sendKey("tab");
//		uiDriver.sendKey("tab");
//		uiDriver.sendKey("Enter");
//		SleepUtils.sleep(1);
//		
//
//		// 10. Type $data in Check_Ref field
//		uiDriver.setValue("New_Commission_Payments.txtCheck_Ref_", input.get("Type@Check_Ref_"));
//		uiDriver.sendKey("TAB");
//		SleepUtils.sleep(2);
//
//		// 11. Type $data in Amount field
//		uiDriver.setValue("New_Commission_Payments.txtAmount", input.get("Type@Amount#1"));
//		uiDriver.sendKey("TAB");
//		uiDriver.sendKey("TAB");
//		uiDriver.sendKey("TAB");
//		SleepUtils.sleep(2);
//
//		// 12. Type $data in Policy field
//		uiDriver.setValue("New_Commission_Payments.txtPolicy", input.get("Type@Policy#1"));
//		SleepUtils.sleep(2);
//
//		// 12. Click on Next button
//		uiDriver.click("New_Commission_Payments.btnNext");
//		SleepUtils.sleep(3);
//		if(uiDriver.checkElementPresent("Batchpaymententry.txtPayment_Source")) {
//			uiDriver.click("Batchpaymententry.txtPayment_Source");
//			SleepUtils.sleep(3);
//			uiDriver.sendKey("keysdown");
//			SleepUtils.sleep(3);
//			uiDriver.sendKey("Enter");
//			SleepUtils.sleep(3);
//		}
//		
//		//18. Click on Post_Batch button
//				uiDriver.click("Batchpaymententry.btnPost_Batch");
//				SleepUtils.sleep(3);
//				
//
//		// 14. Click on Administration WebElement
//		uiDriver.click("New_Commission_Payments.eltAdministration");
//		SleepUtils.sleep(2);
//
//		// 15. Type $data in User_name field
//		uiDriver.setValue("New_Commission_Payments.txtUser_name", input.get("Type@User_name"));
//		SleepUtils.sleep(2);
//
//		// 16. Click on Search button
//		uiDriver.click("New_Commission_Payments.btnSearch");
//		SleepUtils.sleep(1);
//
//		// 17. Click on Display_name Link
//		uiDriver.click("New_Commission_Payments.lnkDisplay_name");
//
//		// 18. Click on Policy WebElement
//		uiDriver.click("New_Commission_Payments.eltPolicy");
//
//		// 19. Type $data in Policy field
//		uiDriver.setValue("New_Commission_Payments.txtPolicy_1", input.get("Type@Policy#2"));
//
//		// 20. Click on Search button
//		uiDriver.click("New_Commission_Payments.btnSearch_1");
//		SleepUtils.sleep(3);
//
//		// 21. Click on Policy Link
//		uiDriver.click("New_Commission_Payments.lnkPolicy");
//
//		// 22. Click on Producer Link
//		uiDriver.click("New_Commission_Payments.lnkProducer");

		// 23. Click on Actions_1 button
		uiDriver.click("New_Commission_Payments.btnActions_1");
		SleepUtils.sleep(1);

		// 24. Click on New_Comm_Payment WebElement
		uiDriver.click("New_Commission_Payments.eltNew_Comm_Payment");
		SleepUtils.sleep(2);

		// 23. Select $data from the New_Comm_Payment list
		uiDriver.click("New_Commission_Payments.eltBonus");
		uiDriver.sendKey("ENTER");
		SleepUtils.sleep(1);

		// 24. Type $data in Amount field
		uiDriver.setValue("New_Commission_Payments.txtAmount_1", input.get("Type@Amount#2"));
		SleepUtils.sleep(1);

		// 25. Click Producer_Code
		uiDriver.click("New_Commission_Payments.txtProducer_Code");
		SleepUtils.sleep(1);

		// 26. Select $data from the Producer_Code list
		uiDriver.setValue("New_Commission_Payments.lstProducer_Code", input.get("Select@Producer_Code"));
		SleepUtils.sleep(1);

		// 27. Click on Payment Radio Button from the list
		uiDriver.click("New_Commission_Payments.rdgPayment");
		SleepUtils.sleep(1);

		// 28. Click on Next button
		uiDriver.click("New_Commission_Payments.btnNext_1");
		SleepUtils.sleep(1);

		// 29. Click on Finish button
		uiDriver.click("New_Commission_Payments.btnFinish");
		SleepUtils.sleep(1);

		// 30. Click on Actions_1 button
		uiDriver.click("New_Commission_Payments.btnActions_2");
		SleepUtils.sleep(1);

		// 31. Click on New_Comm_Payment_1 WebElement
		uiDriver.click("New_Commission_Payments.eltNew_Comm_Payment_1");
		SleepUtils.sleep(1);

		// 32. Click on eltBonus_1 WebElement
		uiDriver.click("New_Commission_Payments.eltBonus_1");
		SleepUtils.sleep(1);

		// 33. Type $data in Amount_1 field
		uiDriver.setValue("New_Commission_Payments.txtAmount_1", input.get("Type@Amount_1"));
		SleepUtils.sleep(1);

		// 34. Click Producer_Code_1
		uiDriver.click("New_Commission_Payments.txtProducer_Code_1");
		SleepUtils.sleep(1);

		// 35. Select $data from the Producer_Code_1 list
		uiDriver.setValue("New_Commission_Payments.lstProducer_Code_1", input.get("Select@Producer_Code_1"));
		SleepUtils.sleep(1);

		// 36. Click on Payment Radio Button from the list
		uiDriver.click("New_Commission_Payments.rdgPayment_1");
		SleepUtils.sleep(1);

		// 37. Click on Next_1 button
		uiDriver.click("New_Commission_Payments.btnNext_1");
		SleepUtils.sleep(1);

		// 38. Click on Finish_1 button
		uiDriver.click("New_Commission_Payments.btnFinish_1");
		SleepUtils.sleep(1);

		// 39. Click on Actions_2 button
		uiDriver.click("New_Commission_Payments.btnActions_3");
		SleepUtils.sleep(1);

		// 40. Click on New_Comm_Payment_2 WebElement
		uiDriver.click("New_Commission_Payments.eltNew_Comm_Payment_2");
		SleepUtils.sleep(1);

		// 41. Select $data from the New_Comm_Payment_2 list
		uiDriver.click("New_Commission_Payments.eltBonus_2");
		SleepUtils.sleep(3);

		// 42. Type $data in Amount_2 field
		uiDriver.setValue("New_Commission_Payments.txtAmount_2", input.get("Type@Amount_2"));
		SleepUtils.sleep(3);

		// 43. Click Producer_Code_2
		uiDriver.click("New_Commission_Payments.txtProducer_Code_2");
		SleepUtils.sleep(3);

		// 44. Select $data from the Producer_Code_2 list
		uiDriver.setValue("New_Commission_Payments.lstProducer_Code_2", input.get("Select@Producer_Code_2"));
		SleepUtils.sleep(3);

		// 45. Click on Payment Radio Button from the list
		uiDriver.click("New_Commission_Payments.rdgPayment_2");
		SleepUtils.sleep(3);

		// 46. Click Pay_On_Date
		String sDate=uiDriver.getControl("New_Commission_Payments.eltproducerAppDate").getText();
		SleepUtils.sleep(4);
		String appDate=uiDriver.StringToShortdate("MMM dd, yyyy", "MM/dd/yyyy", sDate);
		SleepUtils.sleep(2);
		uiDriver.setValue("New_Commission_Payments.eltPay_On_Date", appDate);
//		SleepUtils.sleep(4);
//		uiDriver.click("New_Commission_Payments.txtPay_On_Date");
//		uiDriver.setValue("New_Commission_Payments.txtPay_On_Date_1", input.get("Type@Pay_On_Date"));
//		uiDriver.sendKey("ENTER");
//		SleepUtils.sleep(3);

		// 47. Click on Next_2 button
		uiDriver.click("New_Commission_Payments.btnNext_2");
		SleepUtils.sleep(2);

		// 48. Click on Finish_2 button
		uiDriver.click("New_Commission_Payments.btnFinish_2");
		SleepUtils.sleep(3);

		// 49. Click on History WebElement
		uiDriver.click("New_Commission_Payments.eltHistory");
		SleepUtils.sleep(3);

		// 50. Click on Transactions WebElement
		uiDriver.click("New_Commission_Payments.eltTransactions");
		SleepUtils.sleep(3);

		// 51. Click on Summary WebElement
		uiDriver.click("New_Commission_Payments.eltSummary");
		SleepUtils.sleep(3);

		// 52. Click on Actions_3 button
		uiDriver.click("New_Commission_Payments.btnActions_4");
		SleepUtils.sleep(2);

		// 53. Click on New_Comm_Payment_3 WebElement
		uiDriver.click("New_Commission_Payments.eltNew_Comm_Payment_3");
		SleepUtils.sleep(2);

		// 54. Click on Manual WebElement
		uiDriver.click("New_Commission_Payments.eltManual");
		SleepUtils.sleep(3);

		// 55. Click on Payment Radio Button from the list
		uiDriver.click("New_Commission_Payments.rdgPayment_Type");
		SleepUtils.sleep(3);

		// 56. Type $data in Other_Amount field
		uiDriver.setValue("New_Commission_Payments.txtOther_Amount", input.get("Type@Other_Amount"));
		SleepUtils.sleep(3);

		// 57. Verify whether the Date element present
		if (uiDriver.checkElementPresent("New_Commission_Payments.eltDate")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);

		// 58. Verify whether the Total_Commission_Payable element present
		if (uiDriver.checkElementPresent("New_Commission_Payments.eltAuthor")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);

		// 59. Click Related_To
		uiDriver.click("New_Commission_Payments.txtRelated_To");
		SleepUtils.sleep(2);

		// 60. Select $data from the Related_To list
		uiDriver.setValue("New_Commission_Payments.lstRelated_To", input.get("Select@Related_To"));
		SleepUtils.sleep(2);

		// 61. Click Topic
		uiDriver.click("New_Commission_Payments.txtTopic");
		SleepUtils.sleep(2);

		// 62. Select $data from the Topic list
		uiDriver.setValue("New_Commission_Payments.lstTopic", input.get("Select@Topic"));
		SleepUtils.sleep(2);

		// 63. Type $data in Subject field
		uiDriver.setValue("New_Commission_Payments.txtSubject", input.get("Type@Subject"));
		uiDriver.sendKey("tab");
		SleepUtils.sleep(2);

		// 64. Type $data in Text field
		uiDriver.setValue("New_Commission_Payments.txtText", input.get("Type@Text"));
		SleepUtils.sleep(2);

		// 65. Click on Execute button
		uiDriver.click("New_Commission_Payments.btnExecute");
		SleepUtils.sleep(2);

		// 66. Verify whether the Total_Commission_Payable element present
		if (uiDriver.checkElementPresent("New_Commission_Payments.eltTotal_Commission_Payable")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		SleepUtils.sleep(3);

		// 67. Click on Notes WebElement
		uiDriver.click("New_Commission_Payments.eltNotes");
		SleepUtils.sleep(5);

		// 68. Click on Reset button
		uiDriver.click("New_Commission_Payments.btnReset");
		SleepUtils.sleep(4);

		// 69. Type $data in Find_Text_ field
		uiDriver.setValue("New_Commission_Payments.txtFind_Text_", input.get("Type@Find_Text_"));
		SleepUtils.sleep(4);

		// 70. Click on Search button
		uiDriver.click("New_Commission_Payments.btnSearch_2");
		SleepUtils.sleep(4);

		// 71. Click on History_1 WebElement
		uiDriver.click("New_Commission_Payments.eltHistory_1");
		SleepUtils.sleep(5);

		// 72. Click Filter_by_Type
		uiDriver.click("New_Commission_Payments.txtFilter_by_Type");
		SleepUtils.sleep(5);

		// 73. Select $data from the Filter_by_Type list
		uiDriver.setValue("New_Commission_Payments.lstFilter_by_Type", input.get("Select@Filter_by_Type"));
		SleepUtils.sleep(4);
	}

	/**
	 * Overriding toString() method of object class to print Commissions format
	 * string
	 **/
	public String toString() {
		return "CommissionsDriver";
	}
}
