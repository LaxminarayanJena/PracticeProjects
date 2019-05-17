/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 1/2/2018 5:12:21 AM
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
Extends BaseModuleDriver class and performs application specific operations
*/
public class US1268_NEPPmntReversalDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1268_NEPPmntReversalDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void TC01_NEPPmntRevviewEditAddNew(DataRow input, DataRow output) {
	
		//1. Click on Actions WebElement
		uiDriver.click("TC01_NEPPmntRevviewEditAddNew.eltActions");
		
		//2. Click on NEP WebElement
		uiDriver.click("TC01_NEPPmntRevviewEditAddNew.eltNEP");
		SleepUtils.sleep(3);
		
		//3. Click on Payment_Reversal WebElement
		uiDriver.mouseOver("TC01_NEPPmntRevviewEditAddNew.eltdebitadjustment");
		SleepUtils.sleep(3);
		uiDriver.click("TC01_NEPPmntRevviewEditAddNew.eltPayment_Reversal");
		SleepUtils.sleep(3);
			
		//4. Click on Pmtn_rever_Clear button
		String PolicyNum=uiDriver.th.getCellData("NEPOtherTransactions.tblPolicy", 0, 1);
		SleepUtils.sleep(3);
		uiDriver.click("NEPOtherTransactions.btnClear");
			
		//5. Type $data in Policy_Starts_With field
		uiDriver.setValue("NEPOtherTransactions.txtPolicyStartsWith", PolicyNum);
		SleepUtils.sleep(3);
		uiDriver.click("NEPOtherTransactions.btnGo");

		//6. Type $data in Payment_Amount field
		uiDriver.setValue("NEPOtherTransactions.txtPaymentAmount", input.get("Type@Payment_Amount#1"));
		SleepUtils.sleep(3);

		
		//7. Click on Payment_Date WebElement
		SleepUtils.sleep(3);
		String tdayDate=uiDriver.currentdate("");
		SleepUtils.sleep(2);
		uiDriver.setValue("NEPOtherTransactions.eltDatePicker",tdayDate);
		SleepUtils.sleep(2);

		//8. Click on Pmnt_Reversal_Next button
		SleepUtils.sleep(2);
		uiDriver.click("TC01_NEPPmntRevviewEditAddNew.btnPmnt_Reversal_Next");
		SleepUtils.sleep(5);

		//9. Verify the text ?$data in the Reversal_Reason_Wrng_Msg field
		if (uiDriver.verifyTextActAndExp("NEPOtherTransactions.eltPaymentReversal", input.get("VerifyText@Reversal_Reason_Wrng_Msg"))) {
			passed("verifyTextActAndExp","verifyTextActAndExp should pass","verifyTextActAndExp passed");
		} else {
			failed("verifyTextActAndExp","verifyTextActAndExp should pass","verifyTextActAndExp failed");
		}
			
		//10. Select $data from the Reversal_Reason list
		SleepUtils.sleep(2);
		uiDriver.click("NEPOtherTransactions.lstReason");
		SleepUtils.sleep(2);
		uiDriver.setValue("NEPOtherTransactions.lstReason", input.get("Select@Reversal_Reason#1"));
		uiDriver.sendKey("tab");
		SleepUtils.sleep(2);
		
		//11. Click on Clear_Payment_Date WebElement
		uiDriver.clear("NEPOtherTransactions.eltDatePicker");
		SleepUtils.sleep(2);
		
		//12. Click on Pmnt_Reversal_Next button
		uiDriver.click("TC01_NEPPmntRevviewEditAddNew.btnPmnt_Reversal_Next");
		SleepUtils.sleep(2);

		//13. Verify the text ?$data in the Payment_Date_Wrng_Msg field
		if (uiDriver.verifyTextActAndExp("NEPOtherTransactions.eltPaymentReversal", input.get("VerifyText@Payment_Date_Wrng_Msg"))) {
			passed("verifyTextActAndExp","verifyTextActAndExp should pass","verifyTextActAndExp passed");
		} else {
			failed("verifyTextActAndExp","verifyTextActAndExp should pass","verifyTextActAndExp failed");
		}
		SleepUtils.sleep(2);
		
		//14. Click Clear_Pmnt_Amount
		SleepUtils.sleep(3);
		String tdayDate1=uiDriver.currentdate("");
		SleepUtils.sleep(2);
		uiDriver.setValue("NEPOtherTransactions.eltDatePicker",tdayDate1);		
		SleepUtils.sleep(2);
		uiDriver.clear("NEPOtherTransactions.txtPaymentAmount");
		SleepUtils.sleep(2);
		
		//15. Click on Pmnt_Reversal_Next button
		SleepUtils.sleep(2);
		uiDriver.click("TC01_NEPPmntRevviewEditAddNew.btnPmnt_Reversal_Next");
		SleepUtils.sleep(2);

		//16. Verify the text ?$data in the Paymnt_Amount field
		if (uiDriver.verifyTextActAndExp("NEPOtherTransactions.eltPaymentReversal", input.get("VerifyText@Paymnt_Amount"))) {
			passed("verifyTextActAndExp","verifyTextActAndExp should pass","verifyTextActAndExp passed");
		} else {
			failed("verifyTextActAndExp","verifyTextActAndExp should pass","verifyTextActAndExp failed");
		}
		SleepUtils.sleep(2);
		
		//17. Click on Pmnt_Reversal_Next button
		uiDriver.setValue("NEPOtherTransactions.txtPaymentAmount", input.get("Type@Payment_Amount#1"));
		SleepUtils.sleep(2);
		uiDriver.th.findRelativeCellAndClickfirstCell("NEPOtherTransactions.tblPolicy", PolicyNum, 1, PolicyNum);
		SleepUtils.sleep(4);
		uiDriver.click("NEPOtherTransactions.btnSelectPolicies");
		SleepUtils.sleep(4);
		uiDriver.click("TC01_NEPPmntRevviewEditAddNew.btnPmnt_Reversal_Next");
		SleepUtils.sleep(2);
		
		//18. Click on Back button
		SleepUtils.sleep(2);
		uiDriver.click("TC01_NEPPmntRevviewEditAddNew.btnBack");
		SleepUtils.sleep(2);
		
		//19. Verify whether the Payment_Amount element present
		SleepUtils.sleep(4);
		if (uiDriver.checkElementPresent("TC01_NEPPmntRevviewEditAddNew.btnPmnt_Reversal_Next")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(2);
		
		//20. Click on Pmnt_Reversal_Next button
		uiDriver.click("TC01_NEPPmntRevviewEditAddNew.btnPmnt_Reversal_Next");
		SleepUtils.sleep(2);
		
		//21. Click on Cancel button
		uiDriver.click("TC01_NEPPmntRevviewEditAddNew.btnCancel");
		SleepUtils.sleep(2);
		
		//22. Click on Cancel_Btn_Pop button
		uiDriver.click("TC01_NEPPmntRevviewEditAddNew.btnCancel_Btn_Pop");
		SleepUtils.sleep(2);
		
		//23. Click on Cancel button
		uiDriver.click("TC01_NEPPmntRevviewEditAddNew.btnCancel");
		SleepUtils.sleep(2);
		
		//24. Click on Ok_Btn_Pop button
		uiDriver.click("TC01_NEPPmntRevviewEditAddNew.btnOk_Btn_Pop");
		SleepUtils.sleep(2);
		
		//25. Verify whether the Account_Details element present
		if (uiDriver.checkElementPresent("TC01_NEPPmntRevviewEditAddNew.eltAccount_Details")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//26. Click on Actions WebElement
		uiDriver.click("TC01_NEPPmntRevviewEditAddNew.eltActions");
		SleepUtils.sleep(2);
		
		//27. Click on NEP WebElement
		uiDriver.click("TC01_NEPPmntRevviewEditAddNew.eltNEP");
		SleepUtils.sleep(2);
		
		//28. Click on Payment_Reversal WebElement
		uiDriver.mouseOver("TC01_NEPPmntRevviewEditAddNew.eltdebitadjustment");
		SleepUtils.sleep(2);
		uiDriver.click("TC01_NEPPmntRevviewEditAddNew.eltPayment_Reversal");
		SleepUtils.sleep(2);
		
		//29. Type $data in Payment_Amount field
		uiDriver.setValue("NEPOtherTransactions.txtPaymentAmount", input.get("Type@Payment_Amount#2"));
		SleepUtils.sleep(2);
		
		//30. Click on Payment_date WebElement
		SleepUtils.sleep(3);
		String tdayDate2=uiDriver.currentdate("");
		SleepUtils.sleep(2);
		uiDriver.setValue("NEPOtherTransactions.eltDatePicker",tdayDate2);
		SleepUtils.sleep(2);
		
		//31. Select $data from the Reversal_Reason list
		uiDriver.click("NEPOtherTransactions.lstReason");
		SleepUtils.sleep(2);
		uiDriver.setValue("NEPOtherTransactions.lstReason", input.get("Select@Reversal_Reason#2"));
		uiDriver.sendKey("tab");
		SleepUtils.sleep(2);
		
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
		
		//41. Click on Charges WebElement
		uiDriver.click("TC01_NEPPmntRevviewEditAddNew.eltCharges");
		SleepUtils.sleep(3);
		String Str1=input.get("VerifyText@Category");
		uiDriver.th.findRelativeCellAndClick("US882_NEPModifyDistri.eltNEP_Transaction", Str1, 4, Str1);
		SleepUtils.sleep(2);
		
		//42. Click on Transaction WebElement
		uiDriver.click("TC01_NEPPmntRevviewEditAddNew.eltTransaction");
		uiDriver.click("Verfiy_Producer_History.eltDate");
		SleepUtils.sleep(2);
		uiDriver.click("NEPOtherTransactions.imageDesArrow");
		SleepUtils.sleep(2);
		uiDriver.click("NEPOtherTransactions.eltTransSortDescending");
		SleepUtils.sleep(2);
		String Expectedstr=input.get("VerifyText@Transaction");
		String ItemValu=uiDriver.th.getRelativeCellData("US882_NEPModifyDistri.tblNEP_Transaction_Charged", "NEP Premium Charged", 2);
		if(ItemValu.equalsIgnoreCase(Expectedstr)) {
			passed("Verify ","Actual and expected both string should be equal","both values should equal passed");
		} else {
			failed("Verify ","Actual and expected both string should be equal","both values Not equal failed");
		}
		
		//43. Click on History WebElement
		uiDriver.click("TC01_NEPPmntRevviewEditAddNew.eltHistory");
		SleepUtils.sleep(6);
		
		//44. Select $data from the Filter_by_Type list
		uiDriver.click("TC01_NEPPmntRevviewEditAddNew.lstFilter_by_Type");
		SleepUtils.sleep(2);
		uiDriver.setValue("TC01_NEPPmntRevviewEditAddNew.lstFilter_by_Type", input.get("Select@Filter_by_Type"));
		SleepUtils.sleep(1);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(2);
		
		//45.Verify the transaction history
		String SearchString="NEP Transaction totaling $"+input.get("Type@Debit#1") +"has been debited.";
		uiDriver.th.verfiygetCellDataOfColumn("Verify_Acc_Poli_History.tblDescription", SearchString, 1);
		SleepUtils.sleep(4);
		
		
	}
	

	/**
	*Overriding toString() method of object class to print US1268_NEPPmntReversal
	*format string
	**/
	public String toString(){
		return "US1268_NEPPmntReversalDriver";
	}
}