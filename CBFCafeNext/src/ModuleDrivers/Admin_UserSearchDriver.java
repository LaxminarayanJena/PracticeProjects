/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 2/1/2018 2:02:11 AM
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
public class Admin_UserSearchDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public Admin_UserSearchDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void Admin_UserSearch(DataRow input, DataRow output) {
		//1. Click on Administration WebElement
		uiDriver.click("Admin_UserSearch.eltAdministration");
		
		//2. Type $data in User_Name field
		uiDriver.setValue("Admin_UserSearch.txtUser_Name", input.get("Type@User_Name"));
		
		//3. Click on Search button
		uiDriver.click("Admin_UserSearch.btnSearch");
		
		//4. Verify whether the Display_name link is present
		if (uiDriver.checkElementPresent("Admin_UserSearch.lnkDisplay_name")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//5. Click on Display_name Link
		uiDriver.click("Admin_UserSearch.lnkDisplay_name");
		
	}
	

	/**
	*Overriding toString() method of object class to print Admin_UserSearch
	*format string
	**/
	public String toString(){
		return "Admin_UserSearchDriver";
	}
}
