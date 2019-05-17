/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 1/18/2018 1:27:32 AM
Module part of 'Guidewire_BillingCenter'
Module created using Cafenext Selenium Builder
 ******************************************************************************/
package ModuleDrivers;

import static cbf.engine.TestResultLogger.*;
import java.io.IOException;

import org.openqa.selenium.By;

import cbf.engine.TestResult.ResultType;
import cbf.harness.ParameterAccess;
import cbf.utils.DataRow;
import cbf.utils.SleepUtils;
import cbf.utils.SleepUtils.TimeSlab;
import cbfx.selenium.BaseWebModuleDriver;

/**
 * Extends BaseModuleDriver class and performs application specific operations
 */
public class MaintainBCAuthorityLimitsDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public MaintainBCAuthorityLimitsDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void TC01_Edit_Delete_View_ALP(DataRow input, DataRow output) {
		
		// 1. Click on Action WebElement
		uiDriver.click("DefineBCAuthorityLimits.eltAdminAction");
		SleepUtils.sleep(4);
			
		// 2. Click on New Authority Limit Profile WebElement
		uiDriver.click("DefineBCAuthorityLimits.eltNewALP");
		SleepUtils.sleep(4);
			
		// 3. Type $data in User_name field
		uiDriver.setValue("DefineBCAuthorityLimits.txtNewALPName", input.get("Type@Name"));
		SleepUtils.sleep(4);
			
		// 4.Click on Add button
		uiDriver.click("DefineBCAuthorityLimits.btnAdd");
		SleepUtils.sleep(6);
			
		// 5.  Click on none element and select the value in list
		uiDriver.click("DefineBCAuthorityLimits.eltNone");
		SleepUtils.sleep(3);
		uiDriver.setValue("DefineBCAuthorityLimits.eltLimitType", input.get("Select@LimitType"));
		SleepUtils.sleep(3);
		uiDriver.sendKey("tab");
		SleepUtils.sleep(3);
		
		// 6. Type $data in Limit value in field
		uiDriver.setValue("DefineBCAuthorityLimits.eltLimitAmount", input.get("Type@LimitAmount"));
		uiDriver.sendKey("enter");
		SleepUtils.sleep(2);
		
		// 7. Click on Update  button
		uiDriver.click("DefineBCAuthorityLimits.btnUpdate");
		SleepUtils.sleep(2);
			
		// 8. Verify data presented in table
		uiDriver.th.verfiygetCellDataOfColumn("DefineBCAuthorityLimits.tblALP", input.get("Type@Name"), 1);
		SleepUtils.sleep(4);
				
		// 9. Click on Plan link
		SleepUtils.sleep(2);
		uiDriver.webDr.findElement(By.xpath("//*[text()='"+input.get("Type@Name")+"']")).click();
		SleepUtils.sleep(8);
			
		// 10.  Click on Edit  button
		uiDriver.click("DefineBCAuthorityLimits.btnEdit");
		SleepUtils.sleep(2);
			
		// 11. Type $data in User_name field
		uiDriver.setValue("DefineBCAuthorityLimits.eltName", input.get("Type@Name1"));
		SleepUtils.sleep(5);
			
		// 12. Click on Update  button
		uiDriver.click("MaintainBCAuthorityLimits.btnUpdate");
		SleepUtils.sleep(4);
	
		// 13. Click on up to Delinquency plans link
		uiDriver.click("MaintainBCAuthorityLimits.lnkUptoDelinquencyPlans");
		SleepUtils.sleep(5);	

		// 14. Verify data presented in table
		uiDriver.th.verfiygetCellDataOfColumn("DefineBCAuthorityLimits.tblALP", input.get("Type@Name1"), 1);
		SleepUtils.sleep(4);

		// 15. Click on Plan link
		uiDriver.th.findRelativeCellAndClickfirstCell("DefineBCAuthorityLimits.tblALP",input.get("Type@Name1"), 1, input.get("Type@Name1"));
		SleepUtils.sleep(4);
		
		// 16. Click on Update  button
		uiDriver.click("MaintainBCAuthorityLimits.btnDelete");
		SleepUtils.sleep(2);
	}
		


	/**
	 * Overriding toString() method of object class to print Create_Activities
	 * format string
	 **/
	public String toString() {
		return "MaintainBCAuthorityLimits";
	}
}
