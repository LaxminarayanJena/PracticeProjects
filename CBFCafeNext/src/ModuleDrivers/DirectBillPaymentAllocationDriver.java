/******************************************************************************
reated by : Capgemini Automation Team
Created\Updated on : 12/19/2017 6:27:56 AM
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
public class DirectBillPaymentAllocationDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public DirectBillPaymentAllocationDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void DirectBillPaymentAllocation(DataRow input, DataRow output) {
		//1. Click on Account WebElement
		uiDriver.click("DirectBillPaymentAllocation.eltAccount");
		
		//2. Type $data in Account field
		uiDriver.setValue("DirectBillPaymentAllocation.txtAccount", input.get("Type@Account"));
		
		//3. Click on Search button
		uiDriver.click("DirectBillPaymentAllocation.btnSearch");
		SleepUtils.sleep(3);
		
		//4. Click on Actions button
		uiDriver.click("DirectBillPaymentAllocation.btnActions");
		SleepUtils.sleep(3);
		
		//5. Click on New_Account WebElement
		uiDriver.click("DirectBillPaymentAllocation.eltNew_Account");
		SleepUtils.sleep(3);
	}
	

	/**
	*Overriding toString() method of object class to print DirectBillPaymentAllocation
	*format string
	**/
	public String toString(){
		return "DirectBillPaymentAllocationDriver";
	}
}
