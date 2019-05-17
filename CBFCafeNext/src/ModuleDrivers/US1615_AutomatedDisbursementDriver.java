/******************************************************************************
Created by : Capgemini Automation team
Created\Updated on : 5/16/2018 6:36:23 AM
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
public class US1615_AutomatedDisbursementDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1615_AutomatedDisbursementDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void TC01_AutomatedDisbursement(DataRow input, DataRow output) {
		//1. Click on Disbursements WebElement
		uiDriver.click("TC01_AutomatedDisbursement.eltDisbursements");
		SleepUtils.sleep(4);
		
		//2. Click on History WebElement
		uiDriver.click("TC01_AutomatedDisbursement.eltHistory");
		SleepUtils.sleep(4);
		
		//3. Click Filter_by_Type
		uiDriver.click("TC01_AutomatedDisbursement.txtFilter_by_Type");
		SleepUtils.sleep(4);
		
		//4. Select $data from the Filter_by_Type list
		uiDriver.setValue("TC01_AutomatedDisbursement.lstFilter_by_Type", input.get("Select@Filter_by_Type"));
		SleepUtils.sleep(6);
	}
	
	public void TC06_AutomatedDisbursement(DataRow input, DataRow output) {
		//1. Click on Administration WebElement
		uiDriver.click("TC06_AutomatedDisbursement.eltAdministration");
		SleepUtils.sleep(4);
		
		//2. Click on Business_Settings WebElement
		uiDriver.click("TC06_AutomatedDisbursement.eltBusiness_Settings");
		SleepUtils.sleep(4);
		
		//3. Click on Billing_Plans WebElement
		uiDriver.click("TC06_AutomatedDisbursement.eltBilling_Plans");
		SleepUtils.sleep(4);
		
		//4. Verify whether the Direct_Billing_Plan link is present
		if (uiDriver.checkElementPresent("TC06_AutomatedDisbursement.lnkDirect_Billing_Plan")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		SleepUtils.sleep(4);
		
		//5. Click on Direct_Billing_Plan Link
		uiDriver.click("TC06_AutomatedDisbursement.lnkDirect_Billing_Plan");
		SleepUtils.sleep(8);
		
	}
	

	/**
	*Overriding toString() method of object class to print US1615_AutomatedDisbursement
	*format string
	**/
	public String toString(){
		return "US1615_AutomatedDisbursementDriver";
	}
}
