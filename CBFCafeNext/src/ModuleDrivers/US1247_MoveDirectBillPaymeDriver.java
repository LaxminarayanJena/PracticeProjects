/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 1/4/2018 6:04:24 AM
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
public class US1247_MoveDirectBillPaymeDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1247_MoveDirectBillPaymeDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void US1247TC03_MoveDirectBillPayme(DataRow input, DataRow output) {
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
		uiDriver.setValue("Batchpaymententry.txtAccount_", input.get("Type@Account"));
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
		
		//16. Click on Account WebElement
		uiDriver.click("US1247TC03_MoveDirectBillPayme.eltAccount");
		SleepUtils.sleep(3);
		
		//17. Type $data in Account_Name field
		uiDriver.setValue("US1247TC03_MoveDirectBillPayme.txtAccount_Name", input.get("Type@Account_Name"));
		SleepUtils.sleep(3);
		 
		//18. Click on Search button
		uiDriver.click("US1247TC03_MoveDirectBillPayme.btnSearch");
		SleepUtils.sleep(3);
		
		//19. Click on Account Link
		uiDriver.click("US1247TC03_MoveDirectBillPayme.lnkAccount");
		SleepUtils.sleep(3);
		
		//20. Click on Details WebElement
		uiDriver.click("US1247TC03_MoveDirectBillPayme.eltDetails");
		SleepUtils.sleep(3);
		uiDriver.sendKey("Pagedown");
		
		//21. Click on Actions button
		uiDriver.th.findRelativeCellAndClickSelectedCellInSubtext("US1247TC03_MoveDirectBillPayme.tblId", "MasterCard", 3,  "MasterCard", "Actions", "Actions");
		SleepUtils.sleep(3);
		uiDriver.sendKey("Pagedown");
		
		//22. Click on Move_To_Account WebElement
		uiDriver.click("US1247TC03_MoveDirectBillPayme.eltMove_To_Account");
		SleepUtils.sleep(3);
		
		//23. Type $data in Selected_Account_ field
		uiDriver.setValue("US1247TC03_MoveDirectBillPayme.txtSelected_Account_", input.get("Type@Selected_Account_"));
		SleepUtils.sleep(3);
		
		//24. Click on Execute_Without_Distribution button
		uiDriver.click("US1247TC03_MoveDirectBillPayme.btnExecute_Without_Distribution");
		SleepUtils.sleep(3);
		
		//25. Click on History WebElement
		uiDriver.click("US1247TC03_MoveDirectBillPayme.eltHistory");
		SleepUtils.sleep(3);
		
		//26. Click on Filter_by_Type WebElement
		uiDriver.click("US1247TC03_MoveDirectBillPayme.eltFilter_by_Type");
		uiDriver.sendKey("ENTER");
		SleepUtils.sleep(3);
			
		//27. Select $data from the Filter_by_Type list
		uiDriver.setValue("US1247TC03_MoveDirectBillPayme.lstFilter_by_Type", input.get("Select@Filter_by_Type"));
		uiDriver.sendKey("ENTER");
		SleepUtils.sleep(3);
		
	}
	

	/**
	*Overriding toString() method of object class to print US1247TC03_MoveDirectBillPayme
	*format string
	**/
	public String toString(){
		return "US1247TC03_MoveDirectBillPaymeDriver";
	}
}
