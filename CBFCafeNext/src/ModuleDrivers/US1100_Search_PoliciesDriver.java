/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/7/2017 6:35:21 AM
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
public class US1100_Search_PoliciesDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1100_Search_PoliciesDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	

	public void Search_Policies(DataRow input, DataRow output) {
		//1. Click on Policy WebElement
		uiDriver.click("Search_Policies.eltPolicy");
		
		//2. Type $data in Policy field
		uiDriver.doubleclick("Search_Policies.eltpolicynumber");
		uiDriver.setValue("Search_Policies.txtPolicy", input.get("Type@Policy"));
		
		//3. Click on Search WebElement
		uiDriver.click("Search_Policies.eltSearch");
		SleepUtils.sleep(3);		
	}
	

	/**
	*Overriding toString() method of object class to print Search_Policies
	*format string
	**/
	public String toString(){
		return "Search_PoliciesDriver";
	}
}