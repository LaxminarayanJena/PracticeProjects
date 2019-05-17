/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/21/2017 2:29:33 AM
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
public class US1193_Searchpayments_validlistDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1193_Searchpayments_validlistDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void TC10_Searchpayments_validlist(DataRow input, DataRow output) {
		//1. Click on Search WebElement
		uiDriver.click("TC10_Searchpayments_validlist.eltSearch");
		
		//2. Click on Payments WebElement
		uiDriver.click("TC10_Searchpayments_validlist.eltPayments");
		SleepUtils.sleep(3);
		
		//3. Select $data from the Payment_Type list
		uiDriver.setValue("TC10_Searchpayments_validlist.lstPayment_Type", input.get("Select@Payment_Type"));
		SleepUtils.sleep(2);
		
		//4. Type $data in Account field
		uiDriver.setValue("TC10_Searchpayments_validlist.txtAccount", input.get("Type@Account"));
		SleepUtils.sleep(3);
		
		//5. Click on Payment_Instrument WebElement
		uiDriver.click("TC10_Searchpayments_validlist.eltPayment_Instrument");
		SleepUtils.sleep(3);
		
	}
	

	/**
	*Overriding toString() method of object class to print TC10_Searchpayments_validlist
	*format string
	**/
	public String toString(){
		return "TC10_Searchpayments_validlistDriver";
	}
}
