/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/29/2017 4:19:26 AM
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
public class US1257_ReverseDirectBillPaDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1257_ReverseDirectBillPaDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void US1257TC04_ReverseDirectBillPa(DataRow input, DataRow output) {
		//1. Click on Desktop WebElement
		uiDriver.click("US1257TC04_ReverseDirectBillPa.eltDesktop");
		
		//2. Click on Payment_Batches WebElement
		uiDriver.click("US1257TC04_ReverseDirectBillPa.eltPayment_Batches");
		SleepUtils.sleep(4);
		
		//3. Select $data from the Status list
		uiDriver.setValue("US1257TC04_ReverseDirectBillPa.lstStatus", input.get("Select@Status"));
		SleepUtils.sleep(3);
		
		//4. Click on Search button
		uiDriver.click("US1257TC04_ReverseDirectBillPa.btnSearch");
		SleepUtils.sleep(3);
		
		//5. Click on Checkbox
		uiDriver.click("US1257TC04_ReverseDirectBillPa.chkCheckbox");
		SleepUtils.sleep(3);
		
		//6. Click on Reverse button
		uiDriver.click("US1257TC04_ReverseDirectBillPa.btnReverse");
		SleepUtils.sleep(3);
		
		//7. Click on Ok button
		uiDriver.click("US1257TC04_ReverseDirectBillPa.btnOk");
		SleepUtils.sleep(3);
		
		//8.Click on Reset button
		uiDriver.click("US1257TC04_ReverseDirectBillPa.btnReset");
		SleepUtils.sleep(3);
		
		//9. Select $data from the Status list
		uiDriver.setValue("US1257TC04_ReverseDirectBillPa.lstStatus_1", input.get("Select@Status_1"));
		SleepUtils.sleep(3);
		
		//10. Click on Search button
		uiDriver.click("US1257TC04_ReverseDirectBillPa.btnSearch_1");
		SleepUtils.sleep(6);
		
		//11. Click on Check box
		if (uiDriver.checkElementPresent("US1257TC04_ReverseDirectBillPa.chkCheckbox_1")) {
			uiDriver.click("US1257TC04_ReverseDirectBillPa.chkCheckbox_1");
			SleepUtils.sleep(3);
			
			//12. Click on Delete button
			uiDriver.click("US1257TC04_ReverseDirectBillPa.btnDelete");
			SleepUtils.sleep(3);
			
			//13. Click on OK button
			uiDriver.click("US1257TC04_ReverseDirectBillPa.btnOk");
			SleepUtils.sleep(3);
		}
	}
	

	/**
	*Overriding toString() method of object class to print US1257TC04_ReverseDirectBillPa
	*format string
	**/
	public String toString(){
		return "US1257TC04_ReverseDirectBillPaDriver";
	}
}
