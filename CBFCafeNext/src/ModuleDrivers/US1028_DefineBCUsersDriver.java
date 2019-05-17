/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 5/14/2018 7:29:28 AM
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
public class US1028_DefineBCUsersDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1028_DefineBCUsersDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void TC01_DefineBCUsers(DataRow input, DataRow output) {
		//1. Click on Administration WebElement
		uiDriver.click("TC01_DefineBCUsers.eltAdministration");
		SleepUtils.sleep(4);
		
		//2. Click on Actions button
		uiDriver.click("TC01_DefineBCUsers.btnActions");
		SleepUtils.sleep(4);
		
		//3. Click on New_User WebElement
		uiDriver.click("TC01_DefineBCUsers.eltNew_User");
		SleepUtils.sleep(4);
		
		//4. Click on Cancel button
		uiDriver.click("TC01_DefineBCUsers.btnCancel");
		SleepUtils.sleep(4);
	}
	
	public void TC02_DefineBCUsers(DataRow input, DataRow output) {
		//1. Click on Administration WebElement
		uiDriver.click("TC02_DefineBCUsers.eltAdministration");
		SleepUtils.sleep(4);
		
		//2. Click on Users WebElement
		uiDriver.click("TC02_DefineBCUsers.eltUsers");
		SleepUtils.sleep(4);
		
		//3. Click on Search button
		uiDriver.click("TC02_DefineBCUsers.btnSearch");
		SleepUtils.sleep(10);
	}
	

	/**
	*Overriding toString() method of object class to print US1028_DefineBCUsers
	*format string
	**/
	public String toString(){
		return "US1028_DefineBCUsersDriver";
	}
}
