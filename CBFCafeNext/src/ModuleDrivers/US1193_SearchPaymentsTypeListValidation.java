/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/21/2017 1:48:52 AM
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
public class US1193_SearchPaymentsTypeListValidation extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1193_SearchPaymentsTypeListValidation(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void Searchpayments_TypelistValidat(DataRow input, DataRow output) {
		//1. Click on Search WebElement
		uiDriver.click("Searchpayments_TypelistValidat.eltSearch");
		SleepUtils.sleep(3);
		
		//2. Click on Payments WebElement
		uiDriver.click("Searchpayments_TypelistValidat.eltPayments");
		SleepUtils.sleep(3);
		
		//3. Verify Payment_Type
		uiDriver.click("Searchpayments_TypelistValidat.lstPayment_Type");
		SleepUtils.sleep(3);
	}
	

	/**
	*Overriding toString() method of object class to print Searchpayments_TypelistValidat
	*format string
	**/
	public String toString(){
		return "Searchpayments_TypelistValidatDriver";
	}
}
