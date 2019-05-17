/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 3/26/2018 8:51:50 AM
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
public class Update_Agency_Bill_Saved_PromisesDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public Update_Agency_Bill_Saved_PromisesDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void TC02_Update_AgeBill_Saved_Prom(DataRow input, DataRow output) {
		
		//1. Click on Agency_Bill_Promises WebElement
		SleepUtils.sleep(4);
		uiDriver.click("TC02_Update_AgeBill_Saved_Prom.eltAgency_Bill_Promises");
		SleepUtils.sleep(4);
		
		//2. Click on Saved_Promises WebElement
		uiDriver.click("TC02_Update_AgeBill_Saved_Prom.eltSaved_Promises");
		SleepUtils.sleep(4);
		
		//3. Select $data from the Promise_Saved list
		uiDriver.click("TC02_Update_AgeBill_Saved_Prom.lstPromise_Saved");
		SleepUtils.sleep(4);
		uiDriver.setValue("TC02_Update_AgeBill_Saved_Prom.lstPromise_Saved", input.get("Select@Promise_Saved"));
		SleepUtils.sleep(2);
		uiDriver.sendKey("enter");
		SleepUtils.sleep(2);
		
		//4. Select the checkbox ?checkbox		
		uiDriver.click("TC02_Update_AgeBill_Saved_Prom.btnMenu");
		SleepUtils.sleep(2);
		String uName=uiDriver.getControl("TC02_Update_AgeBill_Saved_Prom.eltUsername").getText();
		SleepUtils.sleep(2);
		uiDriver.sendKey("Esc");
		SleepUtils.sleep(2);
		uiDriver.th.findRelativeCellAndClickfirstCell("TC02_Update_AgeBill_Saved_Prom.chkcheckbox", uName.substring(7).trim(), 3, uName.substring(7).trim());
		SleepUtils.sleep(8);
		
		//5. Verify Edit_Continue_with_Saved_Promise
		boolean sFlag=uiDriver.getControl("TC02_Update_AgeBill_Saved_Prom.txtEdit_Continue_with_Saved_Promise").isEnabled();
		if(sFlag) {
			passed("Saved Promise", "Button is enable status should pass", "Button is enable status passed");
		} else {
			failed("Saved Promise", "Button is enable status should pass", "Button is enable status failed");
		}
	}
	
	public void TC02_Updat_AgeBill_Saved_Prom_1(DataRow input, DataRow output) {
		SleepUtils.sleep(8);
		//1. Click on Actions WebElement
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.eltActions");
		SleepUtils.sleep(4);
		
		//2. Click on New_Agency_Bill_Promise WebElement
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.eltNew_Agency_Bill_Promise");
		SleepUtils.sleep(4);
		
		//3. Type $data in Promise_Amount field
		uiDriver.setValue("TC_02_AGency_Bill_Exe_Promises.txtPromise_Amount", input.get("Type@Promise_Amount"));
		SleepUtils.sleep(4);
		
		//4. Click on Add_Statements WebElement
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.eltAdd_Statements");
		SleepUtils.sleep(4);
		
		//5. Click on Search WebElement
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.eltSearch");
		SleepUtils.sleep(8);
		
		//6. Select the Planned ?checkbox
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.chkPlanned1");
		SleepUtils.sleep(4);
		
		//7. Click on Add_Statements_1 button
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.btnAdd_Statements_1");
		SleepUtils.sleep(4);
		
		//8. Click on Next button
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.btnNext");
		SleepUtils.sleep(4);
		
		//9. Click on Save button
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.btnSave");
		SleepUtils.sleep(4);
		
		//10. Click on OK button
		uiDriver.click("TC_02_AGency_Bill_Exe_Promises.btnOk");
		SleepUtils.sleep(4);
		
	}
	

	/**
	*Overriding toString() method of object class to print Update_Agency_Bill_Saved_Promises
	*format string
	**/
	public String toString(){
		return "Update_Agency_Bill_Saved_PromisesDriver";
	}
}
