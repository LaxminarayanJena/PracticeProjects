/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/29/2017 5:50:21 AM
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
public class US1257_ReverseDirectBillPayDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1257_ReverseDirectBillPayDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void US1257TC11_ReverseDirectBillPa(DataRow input, DataRow output) {
		//1. Click on Account WebElement
		uiDriver.click("US1257TC11_ReverseDirectBillPa.eltAccount");
		
		//2. Type $data in Account_Name field
		uiDriver.setValue("US1257TC11_ReverseDirectBillPa.txtAccount_Name", input.get("Type@Account_Name"));
		
		//3. Click on Search button
		uiDriver.click("US1257TC11_ReverseDirectBillPa.btnSearch");
		
		//4. Click on Account Link
		uiDriver.click("US1257TC11_ReverseDirectBillPa.lnkAccount");
		SleepUtils.sleep(3);
		
		//5. Click on History WebElement
		uiDriver.click("US1257TC11_ReverseDirectBillPa.eltHistory");
		SleepUtils.sleep(3);
		
		//6. Select $data from the Filter_by_Type list
		uiDriver.click("US1257TC11_ReverseDirectBillPa.lstFilter_by_Type");
		SleepUtils.sleep(3);
		uiDriver.setValue("US1257TC11_ReverseDirectBillPa.lstFilter_by_Type", input.get("Select@Filter_by_Type"));
	    uiDriver.sendKey("ENTER");
	    SleepUtils.sleep(3);
	    
       
	}	

	/**
	*Overriding toString() method of object class to print US1257TC11_ReverseDirectBillPa
	*format string
	**/
	public String toString(){
		return "US1257TC11_ReverseDirectBillPaDriver";
	}
}
