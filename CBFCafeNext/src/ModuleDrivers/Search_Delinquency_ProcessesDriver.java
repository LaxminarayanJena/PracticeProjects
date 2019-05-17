/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/26/2017 5:51:54 AM
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
Extends BaseModuleDriver class and performs application specific operations
*/
public class Search_Delinquency_ProcessesDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public Search_Delinquency_ProcessesDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void TC02_Search_Delinquency_proc(DataRow input, DataRow output) {
			
		//1. Click on Search WebElement
		SleepUtils.sleep(4);
		uiDriver.click("SearchAccounts.eltSearch");
			
		//2. Click on Delinquency processes WebElement
		uiDriver.click("TC01_VerifyStateTypelistfield.eltSearch_Delinquency_Processes_");
		SleepUtils.sleep(6);
		
		//3.Verify the validation msg
		uiDriver.verifyTextActAndExp("TC02_Search_Delinquency_proc.eltDelinquency_Msg", input.get("Verify@Delinquency_error"));
		SleepUtils.sleep(4);
		
		//4. Click on Search button
		uiDriver.click("TC02_Search_Delinquency_proc.btnSearch");
		SleepUtils.sleep(4);
		
		//5.Verify the validation warning msg
		uiDriver.verifyTextActAndExp("TC02_Search_Delinquency_proc.eltWarningmessage", input.get("Verify@Warning_msg"));
		SleepUtils.sleep(4);
		
		//6. Click on Reset button
		uiDriver.click("TC02_Search_Delinquency_proc.btnReset");
		SleepUtils.sleep(10);
		
		//7. Set the list value in region
		uiDriver.click("TC02_Search_Delinquency_proc.lstRegion");
		SleepUtils.sleep(4);
		uiDriver.setValue("TC02_Search_Delinquency_proc.lstRegion", input.get("Select@Region"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("enter");
		uiDriver.click("TC02_Search_Delinquency_proc.lstCountray");
		SleepUtils.sleep(4);
		uiDriver.setValue("TC02_Search_Delinquency_proc.lstCountray", "United States");
		SleepUtils.sleep(2);
		uiDriver.click("TC01_VerifyStateTypelistfield.eltSearch_Delinquency_Processes_State");
		SleepUtils.sleep(4);
		uiDriver.setValue("TC01_VerifyStateTypelistfield.eltSearch_Delinquency_Processes_State", "California");
		uiDriver.sendKey("enter");
		SleepUtils.sleep(4);
		
		//8. Click on Search button
		uiDriver.click("TC02_Search_Delinquency_proc.btnSearch");
		SleepUtils.sleep(15);
		
		//9. Verify whether the Select element is present
		if (uiDriver.checkElementPresent("TC02_Search_Delinquency_proc.tblDelinquency")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
		
		//10.get the cell data
		String policyNum=uiDriver.th.getCellData("TC02_Search_Delinquency_proc.tblDelinquency", 0, 2);
		
		//11. Click on Reset button
		uiDriver.click("TC02_Search_Delinquency_proc.btnReset");
		SleepUtils.sleep(10);
		
		//11. Type $data In Polcy edit box
		uiDriver.setValue("TC02_Search_Delinquency_proc.txtPolicy", policyNum);
		SleepUtils.sleep(4);
		
		//12. Set the list value in region
		uiDriver.click("TC02_Search_Delinquency_proc.lstRegion");
		SleepUtils.sleep(4);
		uiDriver.setValue("TC02_Search_Delinquency_proc.lstRegion", input.get("Select@Region"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("enter");
		SleepUtils.sleep(4);
		
		//13. Click on Search button
		uiDriver.click("TC02_Search_Delinquency_proc.btnSearch");
		SleepUtils.sleep(4);
		
		//14. Verify whether the Select element is present
		if (uiDriver.checkElementPresent("TC02_Search_Delinquency_proc.tblDelinquency")) {
			passed("checkElementPresent","checkElementPresent should pass","checkElementPresent passed");
		} else {
			failed("checkElementPresent","checkElementPresent should pass","checkElementPresent failed");
		}
	}
	

	/**
	*Overriding toString() method of object class to print TC02_Search_Delinquency_proc
	*format string
	**/
	public String toString(){
		return "Search_Delinquency_ProcessesDriver";
	}
}
