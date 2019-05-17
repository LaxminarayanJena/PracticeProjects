/******************************************************************************
Created by : Capgemini Automation Team 
Created\Updated on : 5/15/2018 2:26:07 AM
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
public class US1027_BCGroupStructureDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1027_BCGroupStructureDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	
	public void TC01_BCGroupStructure(DataRow input, DataRow output) {
		//1. Click on Administration WebElement
		uiDriver.click("TC01_BCGroupStructure.eltAdministration");
		SleepUtils.sleep(4);
		
		//2. Click on Groups WebElement
		uiDriver.click("TC01_BCGroupStructure.eltGroups");
		SleepUtils.sleep(4);
		
		//3. Type $data in Paging field
		uiDriver.setValue("TC01_BCGroupStructure.txtPaging", input.get("Type@Paging"));
		uiDriver.sendKey("Enter");
		SleepUtils.sleep(4);
		
		//4. Type $data in Paging_1 field
		uiDriver.setValue("TC01_BCGroupStructure.txtPaging_1", input.get("Type@Paging_1"));
		uiDriver.sendKey("Enter");
		SleepUtils.sleep(4);
	}
	
	public void TC02_BCGroupStructure(DataRow input, DataRow output) {
		//1. Click on Administration WebElement
		uiDriver.click("TC01_BCGroupStructure.eltAdministration");
		SleepUtils.sleep(4);
		
		//2. Click on Groups WebElement
		uiDriver.click("TC01_BCGroupStructure.eltGroups");
		SleepUtils.sleep(4);
		
		//3. Verify whether the Button NEw_Group Is Enabled
		uiDriver.VerifyButtonIsEnabled("TC02_BCGroupStructure.btnNew_Group");
	}
	

	/**
	*Overriding toString() method of object class to print US1027_BCGroupStructure
	*format string
	**/
	public String toString(){
		return "US1027_BCGroupStructureDriver";
	}
}
