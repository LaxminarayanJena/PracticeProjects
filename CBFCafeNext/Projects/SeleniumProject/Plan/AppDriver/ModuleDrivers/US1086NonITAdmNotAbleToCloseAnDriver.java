/******************************************************************************
Created by : AT1
Created\Updated on : 11/30/2017 7:05:49 AM
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
public class US1086NonITAdmNotAbleToCloseAnDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1086NonITAdmNotAbleToCloseAnDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void US1086NonITAdmNotAbleTocloseAn(DataRow input, DataRow output) {
		//1. Click on Account WebElement
		uiDriver.click("US1086NonITAdmNotAbleTocloseAn.eltAccount");
		
		//2. Type $data in Account field
		uiDriver.setValue("US1086NonITAdmNotAbleTocloseAn.txtAccount", input.get("Type@Account"));
		
		//3. Click on Search button
		uiDriver.click("US1086NonITAdmNotAbleTocloseAn.btnSearch");
		
		//4. Click on Account Link
		uiDriver.click("US1086NonITAdmNotAbleTocloseAn.lnkAccount");
		
		//5. Click on WebElement
		uiDriver.click("US1086NonITAdmNotAbleTocloseAn.eltSummary");
		
		//6. verify button status
		SleepUtils.sleep(5);
		uiDriver.VerifyButtonDisabled("US1086NonITAdmNotAbleTocloseAn.btnClose_Account");
		
	}
	

	/**
	*Overriding toString() method of object class to print US1086NonITAdmNotAbleToCloseAn
	*format string
	**/
	public String toString(){
		return "US1086NonITAdmNotAbleToCloseAnDriver";
	}
}
