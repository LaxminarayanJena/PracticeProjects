/******************************************************************************
Created by : AT1
Created\Updated on : 11/30/2017 4:12:04 AM
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
public class US1086_CloseAccountDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1086_CloseAccountDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void US1086_CloseAccount(DataRow input, DataRow output) {
		//1. Click on Administration WebElement
		uiDriver.click("US1086_CloseAccount.eltAdministration");
		
		//2. Click on User WebElement
		uiDriver.click("US1086_CloseAccount.eltUser");
		
		//3. Type $data in User_Name field
		uiDriver.setValue("US1086_CloseAccount.txtUser_Name", input.get("Type@User_Name"));
		
		//4. Click on Search button
		uiDriver.click("US1086_CloseAccount.btnSearch");
		
		//5. Click on Display_Name Link
		uiDriver.click("US1086_CloseAccount.lnkDisplay_Name");
		SleepUtils.sleep(3);
		//6. Click on Account WebElement
		uiDriver.click("US1086_CloseAccount.eltAccount");
		SleepUtils.sleep(3);
		
		//7. Type $data in Account field
		uiDriver.setValue("US1086_CloseAccount.txtAccount", input.get("Type@Account"));
		
		//8. Click on Search_ button
		uiDriver.click("US1086_CloseAccount.btnSearch_");
		
		//9. Click on Account Link
		uiDriver.click("US1086_CloseAccount.lnkAccount");
		
		//10. Click on Close_Account button
		uiDriver.click("US1086_CloseAccount.btnClose_Account");
		
		//11. Verify whether the Close element present
		SleepUtils.sleep(5);
		if (uiDriver.checkElementPresent("US1086_CloseAccount.eltClose")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
	}
	

	/**
	*Overriding toString() method of object class to print US1086_CloseAccount
	*format string
	**/
	public String toString(){
		return "US1086_CloseAccountDriver";
	}
}
