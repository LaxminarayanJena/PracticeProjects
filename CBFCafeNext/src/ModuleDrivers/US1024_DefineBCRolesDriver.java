/******************************************************************************
Created by : Capemini Automation Team
Created\Updated on : 5/14/2018 6:11:32 AM
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
public class US1024_DefineBCRolesDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US1024_DefineBCRolesDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void TC01_DefineBCRoles(DataRow input, DataRow output) {
		//1. Click on Administration WebElement
		uiDriver.click("TC01_DefineBCRoles.eltAdministration");
		SleepUtils.sleep(4);

		//2. Click on Roles WebElement
		uiDriver.click("TC01_DefineBCRoles.eltRoles");
		SleepUtils.sleep(4);

		//3. Click on New_Role button
		uiDriver.click("TC01_DefineBCRoles.btnNew_Role");
		SleepUtils.sleep(4);

		//4. Type $data in Name field
		uiDriver.setValue("TC01_DefineBCRoles.txtName", input.get("Type@Name"));
		SleepUtils.sleep(4);

		//5. Type $data in Description field
		uiDriver.setValue("TC01_DefineBCRoles.txtDescription", input.get("Type@Description"));
		SleepUtils.sleep(4);

		//6. Click on Add button
		uiDriver.click("TC01_DefineBCRoles.btnAdd");
		SleepUtils.sleep(4);

		//7. Click none
		uiDriver.click("TC01_DefineBCRoles.txtnone");
		SleepUtils.sleep(3);
		uiDriver.sendKey("keysdown");
		uiDriver.sendKey("Enter");
		SleepUtils.sleep(4);

		//8. Click on Update button
		uiDriver.click("TC01_DefineBCRoles.btnUpdate");
		SleepUtils.sleep(4);
	}

	public void TC02_DefineBCRoles(DataRow input, DataRow output) {
		//1. Click on Administration WebElement
		uiDriver.click("TC02_DefineBCRoles.eltAdministration");
		SleepUtils.sleep(4);

		//2. Click on Roles WebElement
		uiDriver.click("TC02_DefineBCRoles.eltRoles");
		SleepUtils.sleep(4);

		//3.Click on the Web element Account_Managment
		if (uiDriver.checkElementPresent("TC02_DefineBCRoles.eltAccount_Management")) {
			uiDriver.click("TC02_DefineBCRoles.eltAccount_Management");
			SleepUtils.sleep(8);

			//4.Click on the Web Link Up to Roles
			uiDriver.click("TC02_DefineBCRoles.lnkUp_to_Roles");
		} 

	}



	/**
	 *Overriding toString() method of object class to print US1024_DefineBCRoles
	 *format string
	 **/
	public String toString(){
		return "US1024_DefineBCRolesDriver";
	}
}
