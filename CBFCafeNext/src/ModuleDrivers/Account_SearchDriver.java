/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/20/2017 5:58:21 PM
Module part of 'GW Billing Center'
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
public class Account_SearchDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public Account_SearchDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void Account_Search(DataRow input, DataRow output) {
		//1. Click on Account_tab WebElement
		uiDriver.click("Account_Search.eltAccount");
		
		uiDriver.click("Account_Search.btnReset");
		
		//2. Click on Account_tab WebElement
		uiDriver.click("Account_Search.txtAccount");
				
		//3. Type Account_Name $Parama1
		String AccounName=input.get("Type@Account_Name");
		if(!AccounName.equals("")) {
		 uiDriver.setValue("Account_Search.txtAccountName", input.get("Type@Account_Name"));
		}
		String AccountNumber=input.get("Type@Account_Number");
		if(!AccountNumber.equals("")) {
			uiDriver.setValue("Account_Search.txtAccount", input.get("Type@Account_Number"));
		}
		
		//4. Click on Search button
		uiDriver.click("Account_Search.btnSearch");
				
		//5. Select the account
		SleepUtils.sleep(5);
		uiDriver.click("Account_Search.lnkAccount");
		SleepUtils.sleep(2);
	}

	/**
	*Overriding toString() method of object class to print Account_Search
	*format string
	**/
	public String toString(){
		return "Account_SearchDriver";
	}
}
