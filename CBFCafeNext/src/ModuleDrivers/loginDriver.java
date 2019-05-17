/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 10/3/2017 2:42:35 PM
Module part of 'Guidewire_BillingCenter'
Module created using Cafenext Selenium Builder
******************************************************************************/
package ModuleDrivers;

import static cbf.engine.TestResultLogger.*;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.security.UserAndPassword;

import cbf.engine.TestResult.ResultType;
import cbf.harness.ParameterAccess;
import cbf.utils.DataRow;
import cbf.utils.SleepUtils;
import cbf.utils.SleepUtils.TimeSlab;
import cbfx.selenium.BaseWebModuleDriver;

/**
 * Extends BaseModuleDriver class and performs application specific operations
 */
public class loginDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public loginDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void loginBillingCenter(DataRow input, DataRow output) {
		// 1. Launch the $data browser and navigate to $URL and wait for few seconds
		uiDriver.launchApplication(input.get("LaunchBrowser"));
		SleepUtils.sleep(4);
//		Alert alert=uiDriver.webDr.switchTo().alert();
//		SleepUtils.sleep(6);
//		alert.authenticateUsing(new UserAndPassword(System.getProperty("user.name"), "Apri@2018"));
//		SleepUtils.sleep(2);
//		alert.accept();
		SleepUtils.sleep(2);
	}

	public void logOutBillingCenter(DataRow input, DataRow output) {
		// 1. Click on logout WebElement
		uiDriver.click("logOutBillingCenter.eltlogouticon");
		SleepUtils.sleep(4);

		// 2. Click on logout user WebElement
		uiDriver.click("logOutBillingCenter.eltlogoutuser");
	}

	/**
	 * Overriding toString() method of object class to print login format string
	 **/
	public String toString() {
		return "loginDriver";
	}
}
