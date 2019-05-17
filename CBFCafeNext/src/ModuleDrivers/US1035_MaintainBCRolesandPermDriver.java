/******************************************************************************
Created by : Capgemini Automation team 
Created\Updated on : 5/10/2018 2:23:32 AM
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
public class US1035_MaintainBCRolesandPermDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1035_MaintainBCRolesandPermDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void TC01_MaintainBCRolesandPerm(DataRow input, DataRow output) {
		//1. Click on Administration WebElement
		uiDriver.click("TC01_MaintainBCRolesandPerm.eltAdministration");
		SleepUtils.sleep(4);
		
		//2. Click on Roles WebElement
		uiDriver.click("TC01_MaintainBCRolesandPerm.eltRoles");
		SleepUtils.sleep(4);
		
		//3. Click on New_Role button
		uiDriver.click("TC01_MaintainBCRolesandPerm.btnNew_Role");
		SleepUtils.sleep(4);
		
		//4. Type $data in Name field
		uiDriver.setValue("TC01_MaintainBCRolesandPerm.txtName", input.get("Type@Name"));
		SleepUtils.sleep(4);
		
		//5. Click on Add button
		uiDriver.click("TC01_MaintainBCRolesandPerm.btnAdd");
		SleepUtils.sleep(4);
		
		//6. Click on none WebElement
		uiDriver.click("TC01_MaintainBCRolesandPerm.txtnone");
		uiDriver.sendKey("keysdown");
		uiDriver.sendKey("Enter");
		SleepUtils.sleep(4);
				
		//7. Click on Update button
		uiDriver.click("TC01_MaintainBCRolesandPerm.btnUpdate");
		SleepUtils.sleep(4);
		
		//8.Click on the Specific Role 
		uiDriver.th.findRelativeCellAndClickSelectedCellInSubtext("TC01_MaintainBCRolesandPerm.tblRoles", "Automation_Test", 1, "Automation_Test", "Automation_Test", "Automation_Test");
		SleepUtils.sleep(4);
		
		//9. Click on Edit button
		uiDriver.click("TC01_MaintainBCRolesandPerm.btnEdit");
		SleepUtils.sleep(4);
		
		//10. Type $data in Description field
		uiDriver.setValue("TC01_MaintainBCRolesandPerm.txtDescription", input.get("Type@Description"));
		SleepUtils.sleep(4);
		
		//11. Click on Update button
		uiDriver.click("TC01_MaintainBCRolesandPerm.btnUpdate_1");
		SleepUtils.sleep(4);
		
		//12. Click on Up_to_Roles Link
		uiDriver.click("TC01_MaintainBCRolesandPerm.lnkUp_to_Roles");
		SleepUtils.sleep(4);
	}
	
	public void TC01_MaintainBCRoles_CSOPS(DataRow input, DataRow output) {
		//1. Click on Administration WebElement
		uiDriver.click("TC01_MaintainBCRoles_CSOPS.eltAdministration");
		SleepUtils.sleep(4);
		
		//2. Click on Roles WebElement
		uiDriver.click("TC01_MaintainBCRoles_CSOPS.eltRoles");
		SleepUtils.sleep(4);
		
		//3.click on the specific Role 
		uiDriver.th.findRelativeCellAndClickSelectedCellInSubtext("TC01_MaintainBCRoles_CSOPS.tblRoles", "Automation_Test", 1, "Automation_Test", "Automation_Test", "Automation_Test");
		SleepUtils.sleep(4);
				
		//4. Click on Edit button
		uiDriver.click("TC01_MaintainBCRoles_CSOPS.btnEdit");
		SleepUtils.sleep(4);
		
		//5. Type $data in Description field
		uiDriver.setValue("TC01_MaintainBCRoles_CSOPS.txtDescription", input.get("Type@Description"));
		SleepUtils.sleep(4);
		
		//6. Click on Update button
		uiDriver.click("TC01_MaintainBCRoles_CSOPS.btnUpdate");
		SleepUtils.sleep(4);
		
		//7. Click on Up_to_Roles Link
		uiDriver.click("TC01_MaintainBCRoles_CSOPS.lnkUp_to_Roles");
		SleepUtils.sleep(4);
		
		//8.Click on the Specific Role 
		uiDriver.th.findRelativeCellAndClickfirstCell("TC01_MaintainBCRoles_CSOPS.tblRoles", "Automation_Test", 1, "Automation_Test");
		SleepUtils.sleep(4);
		
		//9.click on the Web Button Delete 
		uiDriver.click("TC01_MaintainBCRoles_CSOPS.btnDelete");
		SleepUtils.sleep(4);
		
		
	}
	

	/**
	*Overriding toString() method of object class to print US1035_MaintainBCRolesandPerm
	*format string
	**/
	public String toString(){
		return "US1035_MaintainBCRolesandPermDriver";
	}
}
