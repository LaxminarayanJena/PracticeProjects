/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/28/2017 8:51:27 AM
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
public class US1191_Direct_Bill_PaymentDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1191_Direct_Bill_PaymentDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void US1191TC06_Direct_Bill_Payment(DataRow input, DataRow output) {
		
		/*//1. Click on Account WebElement
		uiDriver.click("US1191TC06_Direct_Bill_Payment.eltAccount");
		
		//2. Type $data in Account_Name field
		uiDriver.setValue("US1191TC06_Direct_Bill_Payment.txtAccount_Name", input.get("Type@Account_Name"));
		
		//3. Click on Search button
		uiDriver.click("US1191TC06_Direct_Bill_Payment.btnSearch");
		
		//4. Click on Account Link
		uiDriver.click("US1191TC06_Direct_Bill_Payment.lnkAccount");*/
		
		//5. Click on History WebElement
		uiDriver.click("US1191TC06_Direct_Bill_Payment.eltHistory");
		SleepUtils.sleep(5);
		
		//6. Click on Payments WebElement
		uiDriver.click("US1191TC06_Direct_Bill_Payment.eltPayments");
		SleepUtils.sleep(3);
		
		//7. Click on Credit_Distributions WebElement
		uiDriver.click("US1191TC06_Direct_Bill_Payment.eltCredit_Distributions");
		SleepUtils.sleep(3);
		
		//8. Click on Check_Ref WebElement
		uiDriver.click("US1191TC06_Direct_Bill_Payment.eltCheck_Ref");
		SleepUtils.sleep(3);
	}
	

	/**
	*Overriding toString() method of object class to print US1191TC06_Direct_Bill_Payment
	*format string
	**/
	public String toString(){
		return "US1191TC06_Direct_Bill_PaymentDriver";
	}
}
