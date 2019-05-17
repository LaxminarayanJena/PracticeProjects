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
public class DefineBCAuthorityLimitsDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;

	public DefineBCAuthorityLimitsDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}

	public void TC01_ITAdmin_Add_ALP_VIA_UI(DataRow input, DataRow output) {
			
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
	}
	
	public void TC03_ALP_Valid_Dataloader(DataRow input, DataRow output) {
			
		// 1. Click on Action WebElement
		uiDriver.click("US1086_CloseAccount.eltAdministration");
		SleepUtils.sleep(4);
		
		// 2. Click on Action WebElement
		uiDriver.click("MaintainDelinquencyPlans.eltAuthorityLimitProfile");
		SleepUtils.sleep(4);
		
		// 3.get the element data
		String PageEnd=uiDriver.getControl("DefineBCAuthorityLimits.eltAuthorityLimitProfiles").getText();
		String num=PageEnd.substring(2).trim();
		int PageLenth=Integer.parseInt(num);
		int i;
		for(i=0;i<=PageLenth-1;i++) {
			uiDriver.click("DefineBCAuthorityLimits.btnArrowforward");
			if (uiDriver.checkElementPresent("DefineBCAuthorityLimits.eltTraining")) {
				uiDriver.click("DefineBCAuthorityLimits.eltTraining");
				SleepUtils.sleep(8);
				break;
			}
			SleepUtils.sleep(4);
			if (uiDriver.checkElementPresent("DefineBCAuthorityLimits.eltTraining")) {
				uiDriver.click("DefineBCAuthorityLimits.eltTraining");
				SleepUtils.sleep(8);
				break;
			}
		}
		
		//4.Verify the name element present
		if (uiDriver.checkElementPresent("DefineBCAuthorityLimits.eltName")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		
		//5.Verify the Description element present
		if (uiDriver.checkElementPresent("DefineBCAuthorityLimits.eltDescription")) {
			passed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent passed");
		} else {
			failed("checkElementPresent", "checkElementPresent should pass", "checkElementPresent failed");
		}
		
	}
	

	/**
	 * Overriding toString() method of object class to print Create_Activities
	 * format string
	 **/
	public String toString() {
		return "DefineBCAuthorityLimits";
	}
}
