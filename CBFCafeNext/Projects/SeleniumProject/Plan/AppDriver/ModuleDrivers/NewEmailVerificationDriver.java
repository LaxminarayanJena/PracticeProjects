/******************************************************************************
Created by : Admin
Created\Updated on : 11/29/2017 11:09:58 AM
Module part of 'sample_1'
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
public class NewEmailVerificationDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public NewEmailVerificationDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void NewEmailVerification(DataRow input, DataRow output) {
		//1. Click on Account WebElement
		uiDriver.click("NewEmailVerification.eltAccount");
		
		//2. Type $data in Account field
		uiDriver.setValue("NewEmailVerification.txtAccount", input.get("Type@Account"));
		
		//3. Click on Search button
		uiDriver.click("NewEmailVerification.btnSearch");
		
		//4. Click on Policies WebElement
		uiDriver.click("NewEmailVerification.eltPolicies");
		
		//5. Click on Policy_Number Link
		uiDriver.click("NewEmailVerification.lnkPolicy_Number");
		
		//6. Click on Actions button
		uiDriver.click("NewEmailVerification.btnActions");
		
		//7. Click on New_Email WebElement
		uiDriver.click("NewEmailVerification.eltNew_Email");
		
		//8. Click on New_Email_Sub WebElement
		uiDriver.click("NewEmailVerification.eltNew_Email_Sub");
		
		//9. Type $data in Name field
		uiDriver.setValue("NewEmailVerification.txtName", input.get("Type@Name"));
		
		//10. Type $data in Email field
		uiDriver.setValue("NewEmailVerification.txtEmail", input.get("Type@Email"));
		
		//11. Type $data in Subject field
		uiDriver.setValue("NewEmailVerification.txtSubject", input.get("Type@Subject"));
		
		//12. Type $data in body field
		uiDriver.setValue("NewEmailVerification.txtbody", input.get("Type@body"));
		
		//13. Click on Send_Email button
		uiDriver.click("NewEmailVerification.btnSend_Email");
		
		//14. Click on Account_Number Link
		uiDriver.click("NewEmailVerification.lnkAccount_Number");
		
		//15. Click on History WebElement
		uiDriver.click("NewEmailVerification.eltHistory");
		
	}
	

	/**
	*Overriding toString() method of object class to print NewEmailVerification
	*format string
	**/
	public String toString(){
		return "NewEmailVerificationDriver";
	}
}
