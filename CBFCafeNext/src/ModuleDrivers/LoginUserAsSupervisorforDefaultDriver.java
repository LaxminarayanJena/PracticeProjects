/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 3/1/2018 2:09:20 AM
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
public class LoginUserAsSupervisorforDefaultDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public LoginUserAsSupervisorforDefaultDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void LoginUserAsSupervisorforDefault(DataRow input, DataRow output) {
		//1. Click on Administration WebElement
		uiDriver.click("LoginUserASupervisorforDefault.eltAdministration");
		SleepUtils.sleep(3);
		
		//2. Click on Group WebElement
		uiDriver.click("LoginUserASupervisorforDefault.eltGroup");
		SleepUtils.sleep(3);
		
		//3. Type $data in Page field
		uiDriver.setValue("LoginUserASupervisorforDefault.txtPage", input.get("Type@Page"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("enter");
		SleepUtils.sleep(2);
		
		//4. Click on DefaultrootGroup WebElement
		uiDriver.th.findRelativeCellAndClick("LoginUserASupervisorforDefault.eltDefaultrootGroup", "Default Root Group", 0, "Default Root Group");
		SleepUtils.sleep(2);
		
		//5. Click on Edit button
		uiDriver.click("LoginUserASupervisorforDefault.btnEdit");
		SleepUtils.sleep(2);
		
		//6. Click on Supervisor_Image_Icon image
		uiDriver.click("LoginUserASupervisorforDefault.imgSupervisor_Image_Icon");
		SleepUtils.sleep(2);
		
		//7. Click on Search_for_User WebElement
		uiDriver.click("LoginUserASupervisorforDefault.eltSearch_for_User");
		
		//8. Type $data in User_Name field
		uiDriver.setValue("LoginUserASupervisorforDefault.txtUser_Name", System.getProperty("user.name"));
		
		//9. Click on Search button
		uiDriver.click("LoginUserASupervisorforDefault.btnSearch");
		SleepUtils.sleep(2);
		
		//10. Verify whether the Select button is present
		if (uiDriver.checkElementPresent("LoginUserASupervisorforDefault.btnSelect")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//11. Click on Select button
		uiDriver.click("LoginUserASupervisorforDefault.btnSelect");
		SleepUtils.sleep(3);
		
		//12. Click on Update button
		uiDriver.click("LoginUserASupervisorforDefault.btnUpdate");
		
	}
	

	/**
	*Overriding toString() method of object class to print LoginUserAsSupervisorforDefault
	*format string
	**/
	public String toString(){
		return "LoginUserAsSupervisorforDefaultDriver";
	}
}
