/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 5/17/2018 2:06:02 AM
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
public class US1570_removeallfundstransferDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US1570_removeallfundstransferDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void TC01_removeallfundstransfer(DataRow input, DataRow output) {
		//1. Click on Collateral WebElement
		uiDriver.click("TC01_removeallfundstransfer.eltCollateral");
        SleepUtils.sleep(5);
        
		//2. Click on Cash_Held WebElement
		uiDriver.click("TC01_removeallfundstransfer.eltCash_Held");
		SleepUtils.sleep(5);
		 
		//3. Click on Disbursement button
		uiDriver.click("TC01_removeallfundstransfer.btnDisbursement");
		SleepUtils.sleep(5);
		
		//4. Click Reason_for_Disbursement
		uiDriver.click("TC01_removeallfundstransfer.txtReason_for_Disbursement");
		SleepUtils.sleep(5);
		 
		//5. Verify whether the Fund_Transfer_1 element present
		if (uiDriver.checkElementPresent("TC01_removeallfundstransfer.eltFund_Transfer_1")) {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(5);
		 
		//6. Click on Cancel button
		uiDriver.click("TC01_removeallfundstransfer.btnCancel");
		SleepUtils.sleep(5);
		 
		//7. Click on Ok button
		uiDriver.click("TC01_removeallfundstransfer.btnOk");
		SleepUtils.sleep(5);
		 
		//8. Click on Actions button
		uiDriver.click("TC01_removeallfundstransfer.btnActions");
		SleepUtils.sleep(5);
		
		//9. Click on New_Transaction WebElement
		uiDriver.click("TC01_removeallfundstransfer.eltNew_Transaction");
		SleepUtils.sleep(5);
		
		//10. Click on Disbursement WebElement
		uiDriver.click("TC01_removeallfundstransfer.eltDisbursement");
		SleepUtils.sleep(5);
		
		//11. Click Reason_for_Disbursement_1
		uiDriver.click("TC01_removeallfundstransfer.txtReason_for_Disbursement_1");
		SleepUtils.sleep(5);
		
		//12. Verify whether the Fund_Transfer_2 element present
		if (uiDriver.checkElementPresent("TC01_removeallfundstransfer.eltFund_Transfer_2")) {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(5);
		
		//13. Click on Cancel_1 button
		uiDriver.click("TC01_removeallfundstransfer.btnCancel_1");
		SleepUtils.sleep(5);
		
		//14. Click on Ok_1 button
		uiDriver.click("TC01_removeallfundstransfer.btnOk_1");
		SleepUtils.sleep(5);
		
		//15. Click on Search WebElement
		uiDriver.click("TC01_removeallfundstransfer.eltSearch");
		SleepUtils.sleep(5);
		
		//16. Click on Disbursements WebElement
		uiDriver.click("TC01_removeallfundstransfer.eltDisbursements");
		SleepUtils.sleep(5);
		
		//17. Click Reason
		uiDriver.click("TC01_removeallfundstransfer.txtReason");
		SleepUtils.sleep(5);
		
		//18. Verify whether the Fund_Transfer element present
		if (uiDriver.checkElementPresent("TC01_removeallfundstransfer.eltFund_Transfer")) {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
        SleepUtils.sleep(6);
        
		//19. Click on Producer WebElement
		uiDriver.click("TC01_removeallfundstransfer.eltProducer");
		SleepUtils.sleep(5);
		uiDriver.click("Validate_Producer_Summ_Screen.btnReset");
		SleepUtils.sleep(5);

	   //20. Type $data in Producer_Code field
		String Producer_Code=input.get("Type@Producer_Code");
		if(!Producer_Code.equals("")) {
			uiDriver.setValue("TC01_removeallfundstransfer.txtProducer_Code", input.get("Type@Producer_Code"));
		}
		String Producer_Name=input.get("Type@Producer_Name");
		if(!Producer_Name.equals("")) {
			uiDriver.setValue("TC01_removeallfundstransfer.txtProducer_Name", input.get("Type@Producer_Name"));
		}
		//21. Click on Search button
		uiDriver.click("TC01_removeallfundstransfer.btnSearch");
		SleepUtils.sleep(5);
		
		//22. Verify whether the Producer_Name element present
		if (uiDriver.checkElementPresent("TC01_removeallfundstransfer.eltProducer_Name")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(5);
		
		//23. Click on Producer_Name Link
		SleepUtils.sleep(3);
		uiDriver.click("TC01_removeallfundstransfer.lnkProducer_Name");
		SleepUtils.sleep(5);
		
		//24. Click on Actions_1 button
		uiDriver.click("TC01_removeallfundstransfer.btnActions_1");
		SleepUtils.sleep(5);
		
		//25. Click on Disbursement_1 button
		uiDriver.click("TC01_removeallfundstransfer.btnDisbursement_1");
		SleepUtils.sleep(5);
		
		//26. Click Reason_for_Disbursement_2
		uiDriver.click("TC01_removeallfundstransfer.txtReason_for_Disbursement_2");
		SleepUtils.sleep(5);
		
		//27. Verify whether the Fund_Transfer_3 element present
		if (uiDriver.checkElementPresent("TC01_removeallfundstransfer.eltFund_Transfer_3")) {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(5);
		
		//28. Click on Cancel_2 button
		uiDriver.click("TC01_removeallfundstransfer.btnCancel_2");
		SleepUtils.sleep(5);
		
		//29. Click on Ok_2 button
		uiDriver.click("TC01_removeallfundstransfer.btnOk_2");
		SleepUtils.sleep(5);
	}


	/**
	 *Overriding toString() method of object class to print US1570_removeallfundstransfer
	 *format string
	 **/
	public String toString(){
		return "US1570_removeallfundstransferDriver";
	}
}
