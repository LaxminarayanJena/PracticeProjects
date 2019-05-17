/******************************************************************************
Created by : Capgemini Automation Team 
Created\Updated on : 2/27/2018 4:34:41 AM
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
public class Remove_AdminuserroleDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public Remove_AdminuserroleDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void Remove_Adminuserrole(DataRow input, DataRow output) {
		
		//1. Click on Administration WebElement
		uiDriver.click("Remove_Adminuserrole.eltAdministration");
		SleepUtils.sleep(3);
		
		//2. Type $data in User_name field
		uiDriver.setValue("Remove_Adminuserrole.txtUser_name",System.getProperty("user.name"));
		
		//3. Click on Search button
		uiDriver.click("Remove_Adminuserrole.btnSearch");
		SleepUtils.sleep(3);
		
		//4. Click on Display_Name Link
		uiDriver.click("Remove_Adminuserrole.lnkDisplay_Name");
		
		//5. Click on Edit button
		uiDriver.click("Remove_Adminuserrole.btnEdit");
		SleepUtils.sleep(6);

     	//6. Select the Click?checkbox
		uiDriver.th.findRelativeCellAndClickfirstCell("Remove_Adminuserrole.tblUserDetailPage", input.get("Select@Role"), 1, input.get("Select@Role"));
			
		//7. Click on Remove_Selected_Role button
		uiDriver.click("Remove_Adminuserrole.btnRemove_Selected_Role");
		SleepUtils.sleep(3);
		
		//8. Click on Update button
		uiDriver.click("Remove_Adminuserrole.btnUpdate");
		SleepUtils.sleep(6);
		
	}
	

	/**
	*Overriding toString() method of object class to print Remove_Adminuserrole
	*format string
	**/
	public String toString(){
		return "Remove_AdminuserroleDriver";
	}
}
