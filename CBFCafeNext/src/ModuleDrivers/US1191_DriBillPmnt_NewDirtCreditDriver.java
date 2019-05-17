/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 1/4/2018 5:57:06 AM
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
public class US1191_DriBillPmnt_NewDirtCreditDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1191_DriBillPmnt_NewDirtCreditDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void TC05_DirBillPmnt_NewDirtCredit(DataRow input, DataRow output) {
		
		//1. Click on Actions WebElement
		SleepUtils.sleep(3);
		uiDriver.click("TC05_DirBillPmnt_NewDirtCredit.eltActions");
		
		//2. Click on New_Transaction WebElement
		uiDriver.mouseOver("TC05_DirBillPmnt_NewDirtCredit.eltNew_Transaction");
		
		//3. Click on Credit WebElement
		SleepUtils.sleep(2);
		uiDriver.click("TC05_DirBillPmnt_NewDirtCredit.eltCredit");
		
		//4. Select $data from the Credit_Type list
		uiDriver.click("TC05_DirBillPmnt_NewDirtCredit.lstCredit_Type");
		SleepUtils.sleep(2);
		uiDriver.setValue("TC05_DirBillPmnt_NewDirtCredit.lstCredit_Type", input.get("Select@Credit_Type"));
		uiDriver.sendKey("tab");
		
		//5. Type $data in Amount field
		uiDriver.setValue("TC05_DirBillPmnt_NewDirtCredit.txtAmount", input.get("Type@Amount"));
		
		//6. Click on Next button
		uiDriver.click("TC05_DirBillPmnt_NewDirtCredit.btnNext");
		
		//7. Click on Finish button
		uiDriver.click("TC05_DirBillPmnt_NewDirtCredit.btnFinish");
		
		//8. Click on Actions WebElement
		uiDriver.click("TC05_DirBillPmnt_NewDirtCredit.eltActions");
		
		//9. Click on New_Payment WebElement
		SleepUtils.sleep(2);
		uiDriver.mouseOver("TC05_DirBillPmnt_NewDirtCredit.eltNew_Payment");
		
		//10. Click on New_Credit_Distribution WebElement
		SleepUtils.sleep(2);
		uiDriver.click("TC05_DirBillPmnt_NewDirtCredit.eltNew_Credit_Distribution");
		
		//11. Select the Use_Unapplied_Credit_Amount ?checkbox
		SleepUtils.sleep(2);
		uiDriver.click("TC05_DirBillPmnt_NewDirtCredit.chkUse_Unapplied_Credit_Amount");
		
		//12. Click on Override_Distribution button
		uiDriver.click("TC05_DirBillPmnt_NewDirtCredit.btnOverride_Distribution");
		
		//13. Select $data from the Select_Items_where_the list
		uiDriver.click("TC05_DirBillPmnt_NewDirtCredit.lstSelect_Items_where_the");
		SleepUtils.sleep(2);
		uiDriver.setValue("TC05_DirBillPmnt_NewDirtCredit.lstSelect_Items_where_the", input.get("Select@Select_Items_where_the"));
		SleepUtils.sleep(1);
		uiDriver.sendKey("tab");
		
		//14. Type $data in Override_Amount field
		uiDriver.click("TC05_DirBillPmnt_NewDirtCredit.txtOverride_Amount");
		SleepUtils.sleep(2);
		uiDriver.setValue("TC05_DirBillPmnt_NewDirtCredit.txtOverride_Amount1", input.get("Type@Override_Amount"));
		
		//15. Click on Execute button
		uiDriver.click("TC05_DirBillPmnt_NewDirtCredit.btnExecute");
		
		//16. Click on Payment webelement
		SleepUtils.sleep(8);
		uiDriver.click("TC05_DirBillPmnt_NewDirtCredit.eltPayment");
		
		//17. Click on Credit Distribution webelement 
		SleepUtils.sleep(2);
		uiDriver.click("TC05_DirBillPmnt_NewDirtCredit.eltCreditdistribution");
		
		//18. Click on Execute button
		SleepUtils.sleep(10);
		String textTosearch=input.get("Type@Amount1");
		uiDriver.th.verfiygetCellDataOfColumn("TC05_DirBillPmnt_NewDirtCredit.tblAmount_Distributed", textTosearch, 6);
//		String Celldata=uiDriver.th.getCellData("TC05_DirBillPmnt_NewDirtCredit.tblAmount_Distributed", 1, 6);
//		SleepUtils.sleep(15);
//		if(Celldata.equalsIgnoreCase(textTosearch)) 
//			{
//				passed( "verify Actual value",textTosearch+ " Expected value" ,Celldata+ " Bothe values are same");
//			}
//			else
//			{
//				failed( "verify Actual value",textTosearch+ " Expected value" ,Celldata+ " Bothe values are not same");
//			}
		
		//19. Click on Desktop WebElement
		SleepUtils.sleep(5);
		uiDriver.click("TC02ModifyDistribution.eltDesktop");
		
		//20. Click on Actions WebElement
		uiDriver.click("TC02ModifyDistribution.eltActions");
		
		//21. Click on New_Payment WebElement
		uiDriver.mouseOver("TC02ModifyDistribution.eltNew_Payment");
		
		//22. Click on Batch_payment_Entery WebElement
		SleepUtils.sleep(4);
		uiDriver.click("TC02ModifyDistribution.eltBatch_payment_Entery");
		
		//23. Type $data in Batch_Amount field
		uiDriver.setValue("TC02ModifyDistribution.txtBatch_Amount", input.get("Type@Batch_Amount"));
		
		//24. Select $data from the Payment_Instrument list
		uiDriver.click("MakePaymentMulAccPoliProd.lstPaymentInstrument");
		SleepUtils.sleep(2);
		uiDriver.setValue("TC02ModifyDistribution.lstPayment_Instrument", input.get("Select@Payment_Instrument"));
		
		//25. Click on Deposit_Date WebElement
		SleepUtils.sleep(3);
		uiDriver.click("TC02ModifyDistribution.eltDeposit_Date");
		SleepUtils.sleep(2);
		uiDriver.click("TC02ModifyDistribution.eltDeposit_Date");
		uiDriver.sendKey("enter");
		
		//26. Select $data from the Payment_Source list
		uiDriver.click("TC02ModifyDistribution.lstPayment_Source");
		SleepUtils.sleep(1);
		uiDriver.setValue("TC02ModifyDistribution.lstPayment_Source", input.get("Select@Payment_Source"));
		
		//27. Type $data in Check_Ref_ field
		uiDriver.click("MakePaymentMulAccPoliProd.txtCheck_Ref");
		SleepUtils.sleep(2);
		uiDriver.setValue("TC02ModifyDistribution.txtCheck_Ref_", input.get("Type@Check_Ref_"));
		
		//28. Type $data in Amount field
		uiDriver.click("MakePaymentMulAccPoliProd.txtAmount");
		SleepUtils.sleep(2);
		uiDriver.setValue("TC02ModifyDistribution.txtAmount", input.get("Type@Amount_BP"));
		
		//29. Type $data in Account field
		uiDriver.click("TC02ModifyDistribution.txtAccount");
		uiDriver.click("TC02ModifyDistribution.txtAccount");
		SleepUtils.sleep(2);
		uiDriver.setValue("TC02ModifyDistribution.txtAccount1", input.get("Type@Account"));
		
		//30. Click on Confirm_Payment_Next button
		uiDriver.click("TC02ModifyDistribution.btnConfirm_Payment_Next");
		SleepUtils.sleep(4);
		if(uiDriver.checkElementPresent("Batchpaymententry.txtPayment_Source")) {
			uiDriver.click("Batchpaymententry.txtPayment_Source");
			SleepUtils.sleep(3);
			uiDriver.sendKey("keysdown");
			SleepUtils.sleep(3);
			uiDriver.sendKey("Enter");
			SleepUtils.sleep(3);
			uiDriver.click("US1188Createsuspensepayments.eltPayment_Instrument");
			SleepUtils.sleep(3);
			uiDriver.setValue("US1188Createsuspensepayments.lstPayment_Instrument", input.get("Select@Payment_Instrument"));
			uiDriver.sendKey("Enter");
			SleepUtils.sleep(3);
			uiDriver.click("US1188Createsuspensepayments.btnNext");
			SleepUtils.sleep(3);
		}
		
		//31. Click on Post_Batch button
		uiDriver.click("TC02ModifyDistribution.btnPost_Batch");
		SleepUtils.sleep(8);
		
		//32. Click on Account WebElement
		SleepUtils.sleep(6);
		uiDriver.click("TC05_DirBillPmnt_NewDirtCredit.eltAccount");
		uiDriver.click("TC05_DirBillPmnt_NewDirtCredit.eltAccount");
		
		//33. Type $data in Account_Name field
		uiDriver.setValue("TC05_DirBillPmnt_NewDirtCredit.txtAccount_Name", input.get("Type@Account_Name"));
		
		//34. Click on Search button
		uiDriver.click("TC05_DirBillPmnt_NewDirtCredit.btnSearch");
		
		//35. Verify whether the Account link is present
		if (uiDriver.checkElementPresent("TC05_DirBillPmnt_NewDirtCredit.lnkAccount")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//36. Click on Account Link
		uiDriver.click("TC05_DirBillPmnt_NewDirtCredit.lnkAccount");
		
		//37. Click on New_Payment WebElement
		SleepUtils.sleep(3);
		uiDriver.click("TC05_DirBillPmnt_NewDirtCredit.eltPayment");

		
		//38. Click on New_Payment WebElement
		SleepUtils.sleep(6);
		String tday = uiDriver.currentdate(null);
		uiDriver.th.findRelativeCellAndClickSelectedCellInSubtext("TC05_DirBillPmnt_NewDirtCredit.tblId", tday, 1, tday, "Actions", "Actions");
		
		//39. Click on New_Payment WebElement
		SleepUtils.sleep(5);
		uiDriver.click("TC05_DirBillPmnt_NewDirtCredit.eltMoveToaccount");
		
		
		//40. Verify whether the Select Account is present
		SleepUtils.sleep(5);
		if (uiDriver.checkElementPresent("TC05_DirBillPmnt_NewDirtCredit.txtSelectAccount")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(5);
		
		//41. Type $data in Account_Name field
		uiDriver.setValue("TC05_DirBillPmnt_NewDirtCredit.txtSelectAccount", input.get("Type@Accnumber"));
		//uiDriver.sendKey("tab");
		
		//42. Click on Execute button 
		SleepUtils.sleep(2);
		uiDriver.click("TC05_DirBillPmnt_NewDirtCredit.btnExecutewithoutDis");
		SleepUtils.sleep(15);
		
	}
	

	/**
	*Overriding toString() method of object class to print US1191_TC05_DriBillPmnt_NewDirtCredit
	*format string
	**/
	public String toString(){
		return "US1191_TC05_DriBillPmnt_NewDirtCreditDriver";
	}
}
