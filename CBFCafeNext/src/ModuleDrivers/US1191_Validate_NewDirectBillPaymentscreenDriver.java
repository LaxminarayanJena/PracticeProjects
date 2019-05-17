/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/27/2017 2:59:13 AM
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
public class US1191_Validate_NewDirectBillPaymentscreenDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1191_Validate_NewDirectBillPaymentscreenDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void US1191_TC02_Validate(DataRow input, DataRow output) {
	
		//1. Click on Summary WebElement
		SleepUtils.sleep(10);
		uiDriver.click("US1191_TC02_Validate.eltSummary");
		
		//2. Click on Actions button
		uiDriver.click("US1191_TC02_Validate.btnActions");
		SleepUtils.sleep(5);
		
		//3. Click on New_Payment WebElement
		uiDriver.click("US1191_TC02_Validate.eltNew_Payment");
		SleepUtils.sleep(5);
		
	}
	

	/**
	*Overriding toString() method of object class to print US1191_TC02_Validate
	*format string
	**/
	public String toString(){
		return "US1191_TC02_ValidateDriver";
	}
}
