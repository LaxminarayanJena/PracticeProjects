/******************************************************************************
Created by : at1
Created\Updated on : 10/3/2017 2:42:35 PM
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
public class loginDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public loginDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void loginBillingCenter(DataRow input, DataRow output) {
		//1. Launch the $data browser and navigate to $URL and wait for few seconds
	//	uiDriver.launchApplication(input.get("LaunchBrowser"));
	//	uiDriver.launchApplication("http://www.google.com");
		uiDriver.launchApplication(input.get("Navigate@Browser"));
		Thread.sleep(15000);
		
		//2. Type $data in UserName field
		uiDriver.setValue("loginBillingCenter.txtUserName", input.get("Type@UserName"));
		
		//3. Type $data in password field
		uiDriver.setValue("loginBillingCenter.txtpassword", input.get("Type@password"));
		
		//4. Click on Login WebElement
		uiDriver.click("loginBillingCenter.eltLogin");
		
	}
	
	public void logOutBillingCenter(DataRow input, DataRow output) {
		//1. Click on logouticon WebElement
		uiDriver.click("logOutBillingCenter.eltlogouticon");
		
		//2. Click on logoutuser WebElement
		uiDriver.click("logOutBillingCenter.eltlogoutuser");
		
	}
	

	/**
	*Overriding toString() method of object class to print login
	*format string
	**/
	public String toString(){
		return "loginDriver";
	}
}
