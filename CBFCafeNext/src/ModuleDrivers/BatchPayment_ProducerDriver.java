/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 3/14/2018 3:23:04 AM
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
public class BatchPayment_ProducerDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public BatchPayment_ProducerDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void BatchPayment_Producer(DataRow input, DataRow output) {
		//1. Click on Desktop WebElement
		uiDriver.click("BatchPayment_Producer.eltDesktop");
		SleepUtils.sleep(2);
		
		//2. Click on Actions button
		uiDriver.click("BatchPayment_Producer.btnActions");
		SleepUtils.sleep(2);
		
		//3. Click on New_Payment WebElement
		uiDriver.click("BatchPayment_Producer.eltNew_Payment");
		SleepUtils.sleep(2);
		
		//4. Click on Batch_Payment_Entry WebElement
		uiDriver.click("BatchPayment_Producer.eltBatch_Payment_Entry");
		SleepUtils.sleep(2);
		
		//5. Type $data in Batch_Amount field
		uiDriver.setValue("BatchPayment_Producer.txtBatch_Amount", input.get("Type@Batch_Amount"));
		SleepUtils.sleep(2);
		
		//9. Click Payment_Source
		uiDriver.click("BatchPayment_Producer.txtPayment_Source");
		SleepUtils.sleep(5);
				
		//10. Select $data from the Payment_Source list
		uiDriver.setValue("BatchPayment_Producer.lstPayment_Source", input.get("Select@Payment_Source"));
		uiDriver.sendKey("tab");
		SleepUtils.sleep(3);
		
		//6. Click Payment_Instrument
		uiDriver.click("BatchPayment_Producer.txtPayment_Instrument");
		SleepUtils.sleep(5);

		//7. Select $data from the Payment_Instrument list
		uiDriver.setValue("BatchPayment_Producer.lstPayment_Instrument", input.get("Select@Payment_Instrument"));
		uiDriver.sendKey("tab");
		SleepUtils.sleep(5);
		
		//8. Click Deposit_Date
		uiDriver.setValue("BatchPayment_Producer.txtDeposit_Date", input.get("Type@Deposit_Date"));
		SleepUtils.sleep(3);
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
		uiDriver.click("BatchPayment_Producer.txtCheck");
		SleepUtils.sleep(2);
		
		//12. Type $data in Check field
		uiDriver.setValue("BatchPayment_Producer.txtCheck", input.get("Type@Check"));
		uiDriver.sendKey("tab");
		SleepUtils.sleep(1);
		
		//13. Click Amount
		uiDriver.click("BatchPayment_Producer.txtAmount");
		SleepUtils.sleep(2);
		
		//14. Type $data in Amount field
		uiDriver.setValue("BatchPayment_Producer.txtAmount_1", input.get("Type@Amount"));
		uiDriver.sendKey("tab");
		uiDriver.sendKey("tab");
		uiDriver.sendKey("tab");
		uiDriver.sendKey("tab");
		SleepUtils.sleep(1);
		
		//15. Click Producer
		uiDriver.click("BatchPayment_Producer.txtProducer");
		SleepUtils.sleep(2);
		
		//16. Click on Producer_Search button
		uiDriver.click("BatchPayment_Producer.btnProducer_Search");
		SleepUtils.sleep(2);
		
		//17. Type $data in Producer_Code field
		uiDriver.setValue("BatchPayment_Producer.txtProducer_Name", input.get("Type@Producer_Name"));
		SleepUtils.sleep(2);
		
		//18. Click on Search button
		uiDriver.click("BatchPayment_Producer.btnSearch");
		SleepUtils.sleep(2);
		
		//19. Verify whether the Select button is present
		if (uiDriver.checkElementPresent("BatchPayment_Producer.btnSelect")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(2);
		
		//20. Click on Select button
		uiDriver.click("BatchPayment_Producer.btnSelect_1");
		SleepUtils.sleep(2);
		
		//21. Click on Next button
		uiDriver.click("BatchPayment_Producer.btnNext");
		SleepUtils.sleep(2);
		
		//22. Click on Post_Batch button
		uiDriver.click("BatchPayment_Producer.btnPost_Batch");
		SleepUtils.sleep(5);
	}
	

	/**
	*Overriding toString() method of object class to print BatchPayment_Producer
	*format string
	**/
	public String toString(){
		return "BatchPayment_ProducerDriver";
	}
}
