/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/27/2017 4:20:13 AM
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
public class US1246_ModifyDistributionDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1246_ModifyDistributionDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void TC02ModifyDistribution(DataRow input, DataRow output) {
		//1. Click on Desktop WebElement
		uiDriver.click("TC02ModifyDistribution.eltDesktop");
		
		//2. Click on Actions WebElement
		uiDriver.click("TC02ModifyDistribution.eltActions");
		
		//3. Click on New_Payment WebElement
		uiDriver.mouseOver("TC02ModifyDistribution.eltNew_Payment");
		
		//4. Click on Batch_payment_Entery WebElement
		SleepUtils.sleep(4);
		uiDriver.click("TC02ModifyDistribution.eltBatch_payment_Entery");
		
		//5. Type $data in Batch_Amount field
		uiDriver.setValue("TC02ModifyDistribution.txtBatch_Amount", input.get("Type@Batch_Amount"));
		
		//6. Select $data from the Payment_Source list
		uiDriver.click("TC02ModifyDistribution.lstPayment_Source");
		SleepUtils.sleep(1);
		uiDriver.setValue("TC02ModifyDistribution.lstPayment_Source", input.get("Select@Payment_Source"));
		uiDriver.sendKey("tab");
		SleepUtils.sleep(3);
	
		//7. Select $data from the Payment_Instrument list
		uiDriver.click("MakePaymentMulAccPoliProd.lstPaymentInstrument");
		SleepUtils.sleep(2);
		uiDriver.setValue("TC02ModifyDistribution.lstPayment_Instrument", input.get("Select@Payment_Instrument"));
		
		//8. Click on Deposit_Date WebElement
		SleepUtils.sleep(3);
		String today=uiDriver.currentdate("");
		uiDriver.setValue("Batchpaymententry.eltDeposit_Date", today);
		SleepUtils.sleep(2);
		
		//9. Type $data in Check_Ref_ field
		uiDriver.click("MakePaymentMulAccPoliProd.txtCheck_Ref");
		SleepUtils.sleep(2);
		uiDriver.setValue("TC02ModifyDistribution.txtCheck_Ref_", input.get("Type@Check_Ref_"));
		uiDriver.sendKey("tab");
		SleepUtils.sleep(3);
		
		//10. Type $data in Amount field
		//uiDriver.click("MakePaymentMulAccPoliProd.txtAmount");
		SleepUtils.sleep(2);
		uiDriver.setValue("TC02ModifyDistribution.txtAmount", input.get("Type@Amount"));
		SleepUtils.sleep(2);
		
		//11. Type $data in Account field
		uiDriver.click("TC02ModifyDistribution.txtAccount");
		uiDriver.click("TC02ModifyDistribution.txtAccount");
		SleepUtils.sleep(2);
		uiDriver.setValue("TC02ModifyDistribution.txtAccount1", input.get("Type@Account"));
		SleepUtils.sleep(2);
		
		//12. Click on Confirm_Payment_Next button
		uiDriver.click("TC02ModifyDistribution.btnConfirm_Payment_Next");
		SleepUtils.sleep(2);
		if (uiDriver.checkElementPresent("TC02ModifyDistribution.eltErrorMsgPaymentSource")) {
			uiDriver.click("TC02ModifyDistribution.lstPayment_Source");
			SleepUtils.sleep(1);
			uiDriver.setValue("TC02ModifyDistribution.lstPayment_Source", input.get("Select@Payment_Source"));
			uiDriver.sendKey("tab");
			SleepUtils.sleep(3);
			uiDriver.click("MakePaymentMulAccPoliProd.lstPaymentInstrument");
			SleepUtils.sleep(2);
			uiDriver.setValue("TC02ModifyDistribution.lstPayment_Instrument", input.get("Select@Payment_Instrument"));
			SleepUtils.sleep(2);
			uiDriver.click("TC02ModifyDistribution.btnConfirm_Payment_Next");
			SleepUtils.sleep(2);
		}
		SleepUtils.sleep(4);
		
		//13. Click on Post_Batch button
		uiDriver.click("TC02ModifyDistribution.btnPost_Batch");
		SleepUtils.sleep(4);
		
		//14. Click on Account WebElement
		SleepUtils.sleep(3);
		uiDriver.click("TC02ModifyDistribution.eltAccount");
		
		//15. Type $data in Account_Name field
		//uiDriver.setValue("TC02ModifyDistribution.txtAccount_Name", input.get("Type@Account_Name"));
		uiDriver.setValue("Account_Search.txtAccount", input.get("Type@Account"));
		
		//16. Click on Search button
		uiDriver.click("TC02ModifyDistribution.btnSearch");
		SleepUtils.sleep(3);
			
		//17. Verify whether the Account  is present
		if (uiDriver.checkElementPresent("US882_NEPModifyDistri.lnkAccount_")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//18. Click on Account Link
		uiDriver.click("US882_NEPModifyDistri.lnkAccount_");
		SleepUtils.sleep(3);
		
		//19. Click on Payment WebElement
		uiDriver.click("TC02ModifyDistribution.eltPayment");
		SleepUtils.sleep(3);
		
		//20. Verify whether the Payment Received web element is present
		if (uiDriver.checkElementPresent("TC02ModifyDistribution.eltPaymentReceived")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//21. Verify the text ?$data in the Select_Items_where_the list
		uiDriver.click("TC02ModifyDistribution.lstPaymentReceived");
		SleepUtils.sleep(2);
		String Expectedpmntvalu=input.get("VerifyText@List_Payment_Received");
		
		boolean verfiylstval=uiDriver.getElementNameUsingTag("li",Expectedpmntvalu);	
		if (verfiylstval)
		{
			passed( "verify option from the Payment Instrument list",Expectedpmntvalu+ " option should be exist on Payment Instrument" ,Expectedpmntvalu+ " Option has been exist on Payment Instrument");
		}
		else
		{
			failed( "verify option from the Payment Instrument list",Expectedpmntvalu+ " option should be exist on Payment Instrument" ,Expectedpmntvalu+ " Option has been exist on Payment Instrument");
		}
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");
			
		
		//22. Click on Actions button
		uiDriver.th.findRelativeCellAndClickSelectedCellInSubtext("TC05_DirBillPmnt_NewDirtCredit.tblId", "ACH", 3,  "ACH", "Actions", "Actions");
		
		//23. Click on Modify_Distribution WebElement
		SleepUtils.sleep(6);
		uiDriver.click("TC02ModifyDistribution.eltModify_Distribution");
		
		
		//24. Verify whether the Override_Distribution button is present
		if (uiDriver.checkElementPresent("TC02ModifyDistribution.btnOverride_Distribution")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//25. Click on Override_Distribution button
		uiDriver.click("TC02ModifyDistribution.btnOverride_Distribution");
		
		
		//26. Verify the text ?$data in the Select_Items_where_the list
		uiDriver.click("TC02ModifyDistribution.lstSelect_Items_where_the");
		SleepUtils.sleep(2);
		String Expectedlstvalu=input.get("VerifyText@Select_Items_where_the");
		
		boolean verfiyval=uiDriver.getElementNameUsingTag("li",Expectedlstvalu);	
		if (verfiyval)
		{
			passed( "verify option from the Payment Instrument list",Expectedlstvalu+ " option should be exist on Payment Instrument" ,Expectedlstvalu+ " Option has been exist on Payment Instrument");
		}
		else
		{
			failed( "verify option from the Payment Instrument list",Expectedlstvalu+ " option should be exist on Payment Instrument" ,Expectedlstvalu+ " Option has been exist on Payment Instrument");
		}
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");
		
		//27. Select $data from the Select_Items_where_the list
		uiDriver.click("TC02ModifyDistribution.lstSelect_Items_where_the");
		SleepUtils.sleep(2);
		uiDriver.setValue("TC02ModifyDistribution.lstSelect_Items_where_the", input.get("Select@Select_Items_where_the"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");
		
		//28. Type $data in Override_Amount field
		uiDriver.click("TC02ModifyDistribution.txtOverride_Amount");
		//uiDriver.click("TC02ModifyDistribution.txtOverride_Amount");
		SleepUtils.sleep(2);
		uiDriver.setValue("TC02ModifyDistribution.txtOverride_Amount1", input.get("Type@Override_Amount"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("tab");
		
		//29. Click on Suspense Items field
		uiDriver.click("TC02ModifyDistribution.eltSuspenseItems");
		SleepUtils.sleep(2);
		if (!uiDriver.checkElementPresent("TC02ModifyDistribution.tblSupenseitems")) {
		
			//30. Click on Add button
			uiDriver.click("TC02ModifyDistribution.btnAdd_Suspense");
			
			//31. Click on Reason
			uiDriver.click("TC02ModifyDistribution.eltReason");
			
			//32. Select $data from the Filter_by_Type list
			SleepUtils.sleep(3);
			uiDriver.setValue("TC02ModifyDistribution.eltReason1", input.get("Select@Reason"));
			
			//33. Click on Reason
			uiDriver.click("TC02ModifyDistribution.txtSupAmount");
			SleepUtils.sleep(2);
			uiDriver.click("TC02ModifyDistribution.txtSupAmount");
			
			//34. Type $data in Amount field
			uiDriver.setValue("TC02ModifyDistribution.txtSupAmount1", input.get("Type@SupAmount"));
			uiDriver.sendKey("enter");
			SleepUtils.sleep(4);
		}
		
		//35. Click on Suspense Items field
		uiDriver.click("TC02ModifyDistribution.eltCollateralItem");
		SleepUtils.sleep(4);
		if (!uiDriver.checkElementPresent("TC02ModifyDistribution.tblCollateral")) {
			
			//36. Click on Collateral Add button
			uiDriver.click("TC02ModifyDistribution.btnAdd_Collateral");
			SleepUtils.sleep(4);
			
			//37. Click on Collateral Amount
			uiDriver.click("TC02ModifyDistribution.txtColAmount");
			SleepUtils.sleep(4);
			
			//38. Type $data in Collateral Amount field
			uiDriver.setValue("TC02ModifyDistribution.txtColAmount1", input.get("Type@ColAmount"));
			SleepUtils.sleep(3);
			uiDriver.sendKey("tab");
			SleepUtils.sleep(2);
		}
		
		//39. Click on Distribution
		uiDriver.click("TC02ModifyDistribution.eltDistribution");
		SleepUtils.sleep(6);
		
		//40. Verify whether the Execute button is present
		SleepUtils.sleep(1);
		if (uiDriver.checkElementPresent("TC02ModifyDistribution.btnExecute")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//41. Verify whether the Cancel button is present
		if (uiDriver.checkElementPresent("TC02ModifyDistribution.btnCancel")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//42. Click on Execute button
		uiDriver.click("TC02ModifyDistribution.btnExecute");
		
		//43. Click on History WebElement
		SleepUtils.sleep(3);
		uiDriver.click("TC02ModifyDistribution.eltHistory");
		
		//44. Select $data from the Filter_by_Type list
		SleepUtils.sleep(3);
		uiDriver.setValue("TC02ModifyDistribution.lstFilter_by_Type", input.get("Select@Filter_by_Type"));
		SleepUtils.sleep(1);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(4);
		
		//45. Verify the text ?$data in the Event_Type field
		SleepUtils.sleep(3);
		if (uiDriver.verifyTextActAndExp("TC02ModifyDistribution.eltEvent_Type", input.get("VerifyText@Event_Type"))) {
			passed("verifyText","verifyText should pass","verifyText passed");
		} else {
			failed("verifyText","verifyText should pass","verifyText failed");
		}
		
		//46. Verify the text ?$data in the Description field
		SleepUtils.sleep(6);
		if (uiDriver.verifyTextActAndExp("TC02ModifyDistribution.eltDescription", input.get("VerifyText@Description"))) {
			passed("verifyText","verifyText should pass","verifyText passed");
		} else {
			failed("verifyText","verifyText should pass","verifyText failed");
		}
		
		//47. Click on Overview field
		uiDriver.click("MaintainNotes.eltOverView");
		SleepUtils.sleep(10);
		if (!uiDriver.checkElementPresent("TC02ModifyDistribution.eltDetails")) {
			uiDriver.click("MaintainNotes.eltOverView");
			SleepUtils.sleep(5);
		}
		
		//47. Click on Details
		uiDriver.click("TC02ModifyDistribution.eltDetails");
		SleepUtils.sleep(6);
		
		//48. Click on Details
		int clicks=18;
		
		for(int i=0;i<clicks;i++) {
		uiDriver.getControl("TC02ModifyDistribution.scrollbar").click();;
		}
		
		//49. Click on Payment WebElement
		uiDriver.click("TC02ModifyDistribution.eltPayment");
		SleepUtils.sleep(5);
		
		//50. Click on Actions button
		//uiDriver.click("TC02ModifyDistribution.btnActions");
		uiDriver.th.findRelativeCellAndClickSelectedCellInSubtext("TC05_DirBillPmnt_NewDirtCredit.tblId", "ACH", 3,  "ACH", "Actions", "Actions");
		SleepUtils.sleep(3);
		
		//51. Click on Reverse element
		uiDriver.click("TC02ModifyDistribution.eltReverse");
		
		//52. Click on reversal reason and select bank error reason
		SleepUtils.sleep(3);
		uiDriver.click("TC02ModifyDistribution.lstPaymentReversalReason");
		SleepUtils.sleep(2);
		uiDriver.setValue("TC02ModifyDistribution.lstPaymentReversalReason", input.get("Select@Reason1"));
		SleepUtils.sleep(4);
		
		//53. Click on Ok button
		SleepUtils.sleep(2);
		uiDriver.click("TC02ModifyDistribution.btnPaymentReversal");
		SleepUtils.sleep(4);
		
		//54. Verify whether the check/Ref is present
		uiDriver.click("TC02ModifyDistribution.eltCheck/Ref");
		SleepUtils.sleep(2);
		if (uiDriver.checkElementPresent("TC02ModifyDistribution.eltCheck/Ref")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//55. Verify whether the Unapplied Amount is present
		if (uiDriver.checkElementPresent("TC02ModifyDistribution.eltUnappliedAmount")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//56. Verify whether the Payment Amount is present
		uiDriver.click("TC02ModifyDistribution.eltPaymentAmnt");
		SleepUtils.sleep(2);
		if (uiDriver.checkElementPresent("TC02ModifyDistribution.eltPaymentAmnt")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//57.Click on Suspense Items
		uiDriver.click("TC02ModifyDistribution.eltSupItems");
		SleepUtils.sleep(4);
		
		//58. Verify whether the Reason is present
		SleepUtils.sleep(4);

		
		//57.Click on Suspense Items
		uiDriver.click("TC02ModifyDistribution.eltTitlpaymnt");
		SleepUtils.sleep(4);
		
		//60 Verifying the cell data
		String Expectedstr="Reversed - Bank Error";
		SleepUtils.sleep(8);
		String ActualCellValue=uiDriver.th.getCellData("TC02ModifyDistribution.tblPayment", 0, 0);
		SleepUtils.sleep(8);
		if(ActualCellValue.equalsIgnoreCase(Expectedstr)) {
			passed("Verify ","Actual and expected both string should be equal","both string should equal passed");
		} else {
			failed("Verify ","Actual and expected both string should be equal","both string should equal failed");
		}
		
	}
	

	/**
	*Overriding toString() method of object class to print US1246ModifyDistribution
	*format string
	**/
	public String toString(){
		return "US1246ModifyDistributionDriver";
	}
}
