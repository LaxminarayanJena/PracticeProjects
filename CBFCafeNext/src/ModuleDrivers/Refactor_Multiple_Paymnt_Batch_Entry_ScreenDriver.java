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
public class Refactor_Multiple_Paymnt_Batch_Entry_ScreenDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public Refactor_Multiple_Paymnt_Batch_Entry_ScreenDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void TC010203_MultiPle_Paymnt_Wizard(DataRow input, DataRow output) {
		//1. Click on Desktop WebElement
		uiDriver.click("Batchpaymententry.eltDesktop");
		SleepUtils.sleep(4);
		
		//2. Click on Actions button
		uiDriver.click("Batchpaymententry.btnActions");
		SleepUtils.sleep(4);
		
		//3. Click on New_Payment WebElement
		uiDriver.mouseOver("Batchpaymententry.eltNew_Payment");
		SleepUtils.sleep(4);
		
		//4. Click on Batch_Payment_Entry WebElement
		uiDriver.click("Batchpaymententry.eltBatch_Payment_Entry");
		SleepUtils.sleep(4);
		
		//5. Type $data in Batch_Amount field
		uiDriver.setValue("Batchpaymententry.txtBatch_Amount", input.get("Type@Batch_Amount"));
		SleepUtils.sleep(4);
		
		//6. Click Payment_Source
		uiDriver.click("Batchpaymententry.txtPayment_Source");
		SleepUtils.sleep(4);
		boolean verfiyva1l=uiDriver.getElementNameUsingTag("li","PHLY.com");	
		if (!verfiyva1l)
		{
		uiDriver.drawHighlight("Batchpaymententry.txtPayment_Source");
		uiDriver.click("Batchpaymententry.txtPayment_Source");
		}
		SleepUtils.sleep(4);
		uiDriver.checkDropDownOptions("li", input.get("Select@Payment_Source1"));
		SleepUtils.sleep(4);
		
		//7. Select $data from the Payment_Source list
		uiDriver.setValue("Batchpaymententry.txtPayment_Source", input.get("Select@Payment_Source"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("enter");
		SleepUtils.sleep(4);
		
		//8. Click Payment_Instrument
		uiDriver.click("Batchpaymententry.txtPayment_Instrument");
		SleepUtils.sleep(3);
		boolean verfiyva12=uiDriver.getElementNameUsingTag("li","American Express");	
		if (!verfiyva12)
		{
		uiDriver.drawHighlight("Batchpaymententry.txtPayment_Instrument");
		uiDriver.click("Batchpaymententry.txtPayment_Instrument");
		}
		SleepUtils.sleep(4);
		uiDriver.checkDropDownOptions("li", input.get("Select@Payment_Instrument1"));
		SleepUtils.sleep(3);
		uiDriver.setValue("Batchpaymententry.txtPayment_Instrument", input.get("Select@Payment_Instrument"));
		SleepUtils.sleep(3);
		uiDriver.sendKey("enter");
		SleepUtils.sleep(3);
		
		//9. Click on Next button
		uiDriver.click("Batchpaymententry.btnNext");
		SleepUtils.sleep(4);
		
		//10.verify deposit error date
		uiDriver.verifyTextActAndExp("TC02ModifyDistribution.eltErrorMsgPaymentSource", input.get("Verify@ErrMsg"));
		SleepUtils.sleep(4);
		
		//11. Type Deposit_Date
		uiDriver.setValue("Batchpaymententry.eltDeposit_Date", input.get("Type@Deposit_Date"));
		SleepUtils.sleep(4);	
		
		//12. Click Check
		uiDriver.click("TC02_03_Create_Commi_Adjustment.txtCheck");
		SleepUtils.sleep(4);
		
		//13. Type $data in Check field
		uiDriver.setValue("Batchpaymententry.txtCheck_1", input.get("Type@Check"));
		SleepUtils.sleep(4);
		
		//14. Click Amount
		uiDriver.click("TC02_03_Create_Commi_Adjustment.txtAmount");
		SleepUtils.sleep(4);
		
		//15. Type $data in Amount field
		uiDriver.setValue("Batchpaymententry.txtAmount_1", input.get("Type@Amount"));
		SleepUtils.sleep(4);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(4);
		
		//16. Type $data in Account_ field
		SleepUtils.sleep(4);
		uiDriver.setValue("Batchpaymententry.txtAccount_", input.get("Type@Account_"));
		SleepUtils.sleep(4);
		
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
	*Overriding toString() method of object class to print TC010203_MultiPle_Paymnt_Wizard
	*format string
	**/
	public String toString(){
		return "Refactor_Multiple_Paymnt_Batch_Entry_ScreenDriver";
	}
}
