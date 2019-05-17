/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 2/21/2018 7:11:35 AM
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
public class Authority_Limits_ProfileDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public Authority_Limits_ProfileDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void Authority_Limits_Profile(DataRow input, DataRow output) {
		//1. Click on Administration WebElement
		uiDriver.click("Adminuser_Addrole.eltAdministration");
		
		//2. Type $data in User_name field
		//input.get("Type@User_name")
		uiDriver.setValue("Adminuser_Addrole.txtUser_name",System.getProperty("user.name"));
		
		//3. Click on Search button
		uiDriver.click("Adminuser_Addrole.btnSearch");
		
		//4. Click on Display_Name Link
		uiDriver.click("Adminuser_Addrole.lnkDisplay_Name");
		
		//5. Click on Edit button
		uiDriver.click("Adminuser_Addrole.btnEdit");
		
		//6. Click on Add_User_Role button
		uiDriver.click("Authority_Limits_Profile.eltAuthorityLimits");
		
		//7. Select authoiry profile
		
		if(input.get("Select@AuthorityLimitProfile").equalsIgnoreCase("Custom")) {
			uiDriver.click("Authority_Limits_Profile.lstAuthorityLimitsProfile");
			SleepUtils.sleep(3);
			uiDriver.setValue("Authority_Limits_Profile.lstAuthorityLimitsProfile", input.get("Select@AuthorityLimitProfile"));
			SleepUtils.sleep(2);
			uiDriver.sendKey("keysdown");
			uiDriver.sendKey("keysdown");
			SleepUtils.sleep(2);
			uiDriver.sendKey("enter");
			SleepUtils.sleep(2);
		}else {
			uiDriver.click("Authority_Limits_Profile.lstAuthorityLimitsProfile");
			SleepUtils.sleep(3);
			uiDriver.setValue("Authority_Limits_Profile.lstAuthorityLimitsProfile", input.get("Select@AuthorityLimitProfile"));	
			SleepUtils.sleep(2);
			uiDriver.sendKey("tab");
			SleepUtils.sleep(2);
		}
				
		//8. Click on Update button
		uiDriver.click("Adminuser_Addrole.btnUpdate");
		SleepUtils.sleep(4);

	}
	

	/**
	*Overriding toString() method of object class to print Adminuser_Addrole
	*format string
	**/
	public String toString(){
		return "Authority_Limits_Profile";
	}
}
