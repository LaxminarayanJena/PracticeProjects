/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/26/2017 8:29:29 AM
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
public class US1188_CreatesuspensepaymentsDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1188_CreatesuspensepaymentsDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void US1188Createsuspensepayments(DataRow input, DataRow output) {
		
		//1. Click on Desktop WebElement
		uiDriver.click("US1188Createsuspensepayments.eltDesktop");
				
		//2. Click on Actions button
		uiDriver.doubleclick("US1188Createsuspensepayments.btnActions");
				
		//3. Click on New_Payment WebElement
		uiDriver.click("US1188Createsuspensepayments.eltNew_Payment");
				
		//4. Click on Batch_Payment_Entry WebElement
		uiDriver.click("US1188Createsuspensepayments.eltBatch_Payment_Entry");
				
		//5. Type $data in Batch_Amount field
		uiDriver.setValue("US1188Createsuspensepayments.txtBatch_Amount", input.get("Type@Batch_Amount"));
				
		//6. Click on Payment_Instrument WebElement
		uiDriver.click("US1188Createsuspensepayments.eltPayment_Instrument");
				
		//7. Select $data from the Payment_Instrument list
		uiDriver.setValue("US1188Createsuspensepayments.lstPayment_Instrument", input.get("Select@Payment_Instrument"));
		SleepUtils.sleep(3);
				
		//8. Click on Deposit_Date WebElement
		String tdy=uiDriver.currentdate("");
		uiDriver.setValue("Batchpaymententry.eltDeposit_Date", tdy);
		SleepUtils.sleep(3);
				
		//9. Click on Payment_Source WebElement
		uiDriver.click("US1188Createsuspensepayments.eltPayment_Source");
		SleepUtils.sleep(3);
		uiDriver.sendKey("keysdown");
		uiDriver.sendKey("Enter");
		SleepUtils.sleep(3);
				
		//10. Select $data from the Payment_Source list
		uiDriver.click("MakePaymentMulAccPoliProd.txtCheck_Ref");
		SleepUtils.sleep(2);
		
		//11. Type $data in Check_Ref_ field
		uiDriver.setValue("US1188Createsuspensepayments.txtCheck_Ref_", input.get("Type@Check_Ref_"));
		uiDriver.sendKey("TAB");
		SleepUtils.sleep(4);
		
		//12. Type $data in Amount field
		uiDriver.setValue("US1188Createsuspensepayments.txtAmount", input.get("Type@Amount"));
		uiDriver.sendKey("TAB");
		SleepUtils.sleep(4);
		
		//13. Type $data in Account_ field
		uiDriver.setValue("Batchpaymententry.txtAccount_", input.get("Type@Account_"));
		SleepUtils.sleep(4);
	
		//14. Click on Next button
	    uiDriver.click("US1188Createsuspensepayments.btnNext");
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
		SleepUtils.sleep(3);
				
		//15. Click on Post_Batch button
		uiDriver.click("US1188Createsuspensepayments.btnPost_Batch");
		SleepUtils.sleep(3);
			
		//16. Click on Unmatched_Suspense_Payments_ WebElement
		uiDriver.click("US1188Createsuspensepayments.eltUnmatched_Suspense_Payments_");
		SleepUtils.sleep(3);
		uiDriver.click("US1188Createsuspensepayments.eltpaymentDate");
		SleepUtils.sleep(14);
		uiDriver.click("US1188Createsuspensepayments.eltpaymentDate");
		SleepUtils.sleep(12);
		
		//17. Click on Edit WebElement
		uiDriver.click("US1188Createsuspensepayments.eltEdit");
	
		//18. Type $data in Account_ field
		uiDriver.setValue("US1188Createsuspensepayments.txtAccount_", input.get("Type@Account_"));
		SleepUtils.sleep(6);
		
		//19. Click on Update button
		uiDriver.click("US1188Createsuspensepayments.btnUpdate");
		SleepUtils.sleep(6);
		
		//20. Click on Apply WebElement
		uiDriver.click("US1188Createsuspensepayments.eltApply");
		SleepUtils.sleep(4);
		
		//21. Type $data in Account_1 field
		uiDriver.setValue("US1188Createsuspensepayments.txtAccount_1", input.get("Type@Account_1"));
		SleepUtils.sleep(5);
		
		//22. Click on Update button
		uiDriver.click("US1188Createsuspensepayments.btnUpdate_1");
		SleepUtils.sleep(5);
		
		//23. Click on Account WebElement
		uiDriver.click("US1188Createsuspensepayments.eltAccount");
		SleepUtils.sleep(5);
		
		//24. Type $data in Account_Name field
		uiDriver.setValue("US1188Createsuspensepayments.txtAccount_Name", input.get("Type@Account_Name"));
		SleepUtils.sleep(5);
		
		//25. Click on Search button
		uiDriver.click("US1188Createsuspensepayments.btnSearch");
		SleepUtils.sleep(5);
		
		//26. Click on Account Link
		uiDriver.click("US1188Createsuspensepayments.lnkAccount");
		SleepUtils.sleep(3);
		
		//27. Click on History WebElement
		uiDriver.click("US1188Createsuspensepayments.eltHistory");
		SleepUtils.sleep(5);
		
		//28. Select $data from the Filter_by_Date list
		uiDriver.click("US1188Createsuspensepayments.lstFilter_by_Date");
		SleepUtils.sleep(4);
		
		//29. Select $data from the Filter_by_Date list
		uiDriver.setValue("US1188Createsuspensepayments.lstFilter_by_Date", input.get("Select@Filter_by_Date"));
		uiDriver.sendKey("enter");
		SleepUtils.sleep(5);
		
		//30. Select $data from the Filter_by_Type list
		uiDriver.click("US1188Createsuspensepayments.lstFilter_by_Type");
		SleepUtils.sleep(3);
		uiDriver.setValue("US1188Createsuspensepayments.lstFilter_by_Type", input.get("Select@Filter_by_Type"));
		uiDriver.sendKey("enter");
		SleepUtils.sleep(4);
		
		//31.verify the history in table
		String Hist="Unmatched suspense payment was applied to this account for";
		uiDriver.th.verfiygetCellDataOfColumn("Verify_Acc_Poli_History.tblDescription", Hist, 1);
		SleepUtils.sleep(4);
		
	}	

	

	/**
	*Overriding toString() method of object class to print US1188Createsuspensepayments
	*format string
	**/
	public String toString(){
		return "US1188CreatesuspensepaymentsDriver";
	}
}
