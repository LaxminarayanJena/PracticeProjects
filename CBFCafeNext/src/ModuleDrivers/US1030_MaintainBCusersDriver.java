/******************************************************************************
Created by : Capgemini Automation Team 
Created\Updated on : 5/15/2018 12:46:42 AM
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
public class US1030_MaintainBCusersDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1030_MaintainBCusersDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void TC01_MaintainBCusers(DataRow input, DataRow output) {
		//1. Click on Administration WebElement
		uiDriver.click("TC01_MaintainBCusers.eltAdministration");
		SleepUtils.sleep(4);

		//2. Click on Actions button
		uiDriver.click("TC01_MaintainBCusers.btnActions");
		SleepUtils.sleep(4);

		//3. Click on New_User WebElement
		uiDriver.click("TC01_MaintainBCusers.eltNew_User");
		SleepUtils.sleep(4);
		
		//4. Type $data in FirstName field
		uiDriver.setValue("TC01_MaintainBCusers.txtFirst_Name", input.get("Type@First_Name"));
		SleepUtils.sleep(4);
		
		//5. Type $data in LastName field
		uiDriver.setValue("TC01_MaintainBCusers.txtLast_Name", input.get("Type@Last_Name"));
		SleepUtils.sleep(4);
		
		//6. Type $data in UserName field
		uiDriver.setValue("TC01_MaintainBCusers.txtUser_Name", input.get("Type@User_Name"));
		SleepUtils.sleep(4);
	
		//6. Type $data in Password field
		uiDriver.setValue("TC01_MaintainBCusers.txtPassword", input.get("Type@Password"));
		SleepUtils.sleep(4);
		
		//6. Type $data in Confirm Password field
		uiDriver.setValue("TC01_MaintainBCusers.txtConfirm_Password", input.get("Type@Confirm_Password"));
		SleepUtils.sleep(4);
		
		//3. Click on Add_UserRole WebButton
		uiDriver.click("TC01_MaintainBCusers.btnAdd_UserRole");
		SleepUtils.sleep(4);
		
		//7. Click none
		uiDriver.click("TC01_MaintainBCusers.txtnone");
		SleepUtils.sleep(3);
		uiDriver.sendKey("keysdown");
		uiDriver.sendKey("Enter");
		SleepUtils.sleep(4);

		//8.Click on Next Web Button
		uiDriver.click("TC01_MaintainBCusers.btnNext");
		
		//9. Type $data in Employee_ID field
		uiDriver.setValue("TC01_MaintainBCusers.txtEmployee_ID", input.get("Type@Employee_ID"));
		SleepUtils.sleep(4);
		
		//9. Type $data in Job_Title field
		uiDriver.setValue("TC01_MaintainBCusers.txtJob_Title", input.get("Type@Job_Title"));
		SleepUtils.sleep(4);
		
		//10. Type $data in Work_Phone field
		uiDriver.setValue("TC01_MaintainBCusers.txtWork_Phone", input.get("Type@Work_Phone"));
		SleepUtils.sleep(4);
		
		//11. Type $data in Work_Phone field
		uiDriver.setValue("TC01_MaintainBCusers.txtPrimary_Email_Address", input.get("Type@Primary_Email_Address"));
		SleepUtils.sleep(4);
		
		//12.Click on Next_1 Web Button
		uiDriver.click("TC01_MaintainBCusers.btnNext_1");
		SleepUtils.sleep(4);
		
		//13.Click on Finish Web Button
		uiDriver.click("TC01_MaintainBCusers.btnFinish");
		SleepUtils.sleep(4);
		
		//14.Click on Delete User Web Button
		uiDriver.click("TC01_MaintainBCusers.btnDelete_User");
		SleepUtils.sleep(4);
		
		//15.Click on Ok Web Button
		uiDriver.click("TC01_MaintainBCusers.btnOk");
		SleepUtils.sleep(4);
		
		
	}
	
	public void TC02_MaintainBCusers(DataRow input, DataRow output) {
		//1. Click on Administration WebElement
		uiDriver.click("TC01_MaintainBCusers.eltAdministration");
		SleepUtils.sleep(4);
		
		//2. Click on Users WebElement
		uiDriver.click("TC02_DefineBCUsers.eltUsers");
		SleepUtils.sleep(4);

		//3. Click on Search button
		uiDriver.click("TC02_DefineBCUsers.btnSearch");
		SleepUtils.sleep(10);
	}
	

	/**
	*Overriding toString() method of object class to print US1030_MaintainBCusers
	*format string
	**/
	public String toString(){
		return "US1030_MaintainBCusersDriver";
	}
}
