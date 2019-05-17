/******************************************************************************
Created by : Capgemini Automation team
Created\Updated on : 3/8/2018 4:05:54 AM
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
public class BatchpaymententryDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public BatchpaymententryDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void Batchpaymententry(DataRow input, DataRow output) {
		
		//1. Click on Desktop WebElement
		uiDriver.click("Batchpaymententry.eltDesktop");
		SleepUtils.sleep(1);
		
		//2. Click on Actions button
		uiDriver.click("Batchpaymententry.btnActions");
		SleepUtils.sleep(1);
		
		//3. Click on New_Payment WebElement
		uiDriver.mouseOver("Batchpaymententry.eltNew_Payment");
		SleepUtils.sleep(1);
		
		//4. Click on Batch_Payment_Entry WebElement
		uiDriver.click("Batchpaymententry.eltBatch_Payment_Entry");
		SleepUtils.sleep(1);
		
		//5. Type $data in Batch_Amount field
		uiDriver.setValue("Batchpaymententry.txtBatch_Amount", input.get("Type@Batch_Amount"));
		SleepUtils.sleep(1);
		
		//6. Click Payment_Instrument
		uiDriver.click("Batchpaymententry.txtPayment_Instrument");
		SleepUtils.sleep(1);
		
		//7. Select $data from the Payment_Instrument list
		uiDriver.setValue("Batchpaymententry.lstPayment_Instrument", input.get("Select@Payment_Instrument"));
		SleepUtils.sleep(1);
		
		//8. Click Deposit_Date
		uiDriver.setValue("Batchpaymententry.eltDeposit_Date", input.get("Type@Deposit_Date"));
		SleepUtils.sleep(1);
		
		//9. Click Payment_Source
		uiDriver.click("Batchpaymententry.txtPayment_Source");
		SleepUtils.sleep(3);
		uiDriver.sendKey("keysdown");
		uiDriver.sendKey("Enter");
		SleepUtils.sleep(3);
		uiDriver.sendKey("tab");
		uiDriver.sendKey("tab");
		uiDriver.sendKey("tab");
		uiDriver.sendKey("tab");
		uiDriver.sendKey("tab");
		uiDriver.sendKey("tab");
		uiDriver.sendKey("tab");
		uiDriver.sendKey("tab");
		uiDriver.sendKey("tab");
		uiDriver.sendKey("Enter");
		SleepUtils.sleep(1);
		
		//11. Click Check
		uiDriver.click("Batchpaymententry.txtCheck");
		SleepUtils.sleep(1);
		
		//12. Type $data in Check field
		uiDriver.setValue("Batchpaymententry.txtCheck_1", input.get("Type@Check"));
		uiDriver.sendKey("tab");
		SleepUtils.sleep(1);
		
		//13. Click Amount
		uiDriver.click("Batchpaymententry.txtAmount");
		SleepUtils.sleep(1);
		
		//14. Type $data in Amount field
		uiDriver.setValue("Batchpaymententry.txtAmount_1", input.get("Type@Amount"));
		uiDriver.sendKey("tab");
		SleepUtils.sleep(1);
		
		//16. Type $data in Account_ field
		uiDriver.setValue("Batchpaymententry.txtAccount_", input.get("Type@Account_"));
		SleepUtils.sleep(1);
		
		//17. Click on Next button
		uiDriver.click("Batchpaymententry.btnNext");
		SleepUtils.sleep(4);
		if(uiDriver.checkElementPresent("Batchpaymententry.txtPayment_Source")) {
			uiDriver.click("Batchpaymententry.txtPayment_Source");
			SleepUtils.sleep(3);
			uiDriver.sendKey("keysdown");
			SleepUtils.sleep(3);
			uiDriver.sendKey("Enter");
			SleepUtils.sleep(3);
		}
		
		//18. Click on Post_Batch button
		uiDriver.click("Batchpaymententry.btnPost_Batch");
		SleepUtils.sleep(3);
		}

	/**
	*Overriding toString() method of object class to print Batchpaymententry
	*format string
	**/
	public String toString(){
		return "BatchpaymententryDriver";
	}
}
