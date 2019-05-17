/******************************************************************************
Created by : Capgemini Automatin Team
Created\Updated on : 11/29/2017 11:09:58 AM
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
 * Extends BaseModuleDriver class and performs application specific operations
 */
public class US126_NewEmailVerificationDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public US126_NewEmailVerificationDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void NewEmailVerification(DataRow input, DataRow output) {

		// 1. Click on Policies
		SleepUtils.sleep(4);
		uiDriver.click("NewEmailVerification.btnpolicies");

		// 2. Click on Policy_Number Link
		uiDriver.click("NewEmailVerification.lnkPolicy_Number");

		// 3. Click on Actions button
		uiDriver.click("NewEmailVerification.btnActions");

		// 4. Click on New_Email WebElement
		uiDriver.click("NewEmailVerification.eltNew_Email");

		// 5. Click on New_Email_Sub WebElement
		uiDriver.click("NewEmailVerification.eltNew_Email_Sub");

		// 6. Type $data in Name field
		uiDriver.click("NewEmailVerification.txtNamebox");
		uiDriver.setValue("NewEmailVerification.txtName", input.get("Type@Name"));

		// 7. Type $data in Email field
		uiDriver.click("NewEmailVerification.txtEmailbox");
		uiDriver.setValue("NewEmailVerification.txtEmail", input.get("Type@Email"));

		// 8. Type $data in Subject field
		uiDriver.setValue("NewEmailVerification.txtSubject", input.get("Type@Subject"));

		// 9. Type $data in body field
		uiDriver.click("NewEmailVerification.eltbody");
		SleepUtils.sleep(2);

		// 10. Type the body of the email
		uiDriver.setValue("NewEmailVerification.txtbody", input.get("Type@body"));
		SleepUtils.sleep(3);

		// 11. Click on Send_Email button
		uiDriver.click("NewEmailVerification.btnSend_Email");
		SleepUtils.sleep(5);

		// 12. Click on Account_Number Link
		uiDriver.click("NewEmailVerification.lnkAccount_Number");
		SleepUtils.sleep(3);

		// 13. Click on History WebElement
		uiDriver.click("NewEmailVerification.eltHistory");
		SleepUtils.sleep(3);
		
		//14. Filter according to Email Sent for Policy Period
		uiDriver.doubleclick("NewEmailVerification.eltFilterBy");
		uiDriver.setValue("NewEmailVerification.txtFilterBy", input.get("Type@Filter"));
		uiDriver.sendKey("enter");
		SleepUtils.sleep(2);
		
		//15. Verify the Event type for Email
		String actualTextName = uiDriver.th.getCellData("NewEmailVerification.tbName",0,4);
		String expectedTextName = "Email Sent for Policy Period";
		
		if (actualTextName.equalsIgnoreCase(expectedTextName)) {
			passed("verifyText", "verifyText should pass", "verifyText passed");
		} else {
			failed("verifyText", "verifyText should pass", "verifyText failed");
		}	
	}

	/**
	 * Overriding toString() method of object class to print NewEmailVerification
	 * format string
	 **/
	public String toString() {
		return "NewEmailVerificationDriver";
	}
}