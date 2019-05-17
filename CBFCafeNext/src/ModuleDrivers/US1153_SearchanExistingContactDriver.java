/******************************************************************************
Created by : Capgemini Automation Team
Created\Updated on : 12/21/2017 8:36:58 AM
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
public class US1153_SearchanExistingContactDriver extends BaseWebModuleDriver {
	private ParameterAccess paramAccess;
	
	public US1153_SearchanExistingContactDriver(ParameterAccess paramAccess) {
		this.paramAccess = paramAccess;
	}
	
	public void US1153SearchanExistingContact(DataRow input, DataRow output) {
		//1. Click on Account WebElement
		uiDriver.click("US1153SearchanExistingContact.eltAccount");
		
		//2. Click on Search button
		uiDriver.click("US1153SearchanExistingContact.btnSearch");
		
		//3. Type $data in First_Name field
		uiDriver.setValue("US1153SearchanExistingContact.txtFirst_Name", input.get("Type@First_Name"));
		SleepUtils.sleep(3);
		
		//4. Click on Search_1 button
		uiDriver.click("US1153SearchanExistingContact.btnSearch_1");
		SleepUtils.sleep(3);
		
		//5. Type $data in Last_Name_ field
		uiDriver.setValue("US1153SearchanExistingContact.txtLast_Name_", input.get("Type@Last_Name_"));
		
		//6. Click on Search_2 button
		uiDriver.click("US1153SearchanExistingContact.btnSearch_2");
		SleepUtils.sleep(3);
		
		//7. Select $data from the Country list
		uiDriver.setValue("US1153SearchanExistingContact.lstCountry", input.get("Select@Country"));
		SleepUtils.sleep(3);
		
		//8. Type $data in City field
		uiDriver.setValue("US1153SearchanExistingContact.txtCity", input.get("Type@City"));
		SleepUtils.sleep(3);
		
		//9. Select $data from the State list
		uiDriver.setValue("US1153SearchanExistingContact.lstState", input.get("Select@State"));
		SleepUtils.sleep(3);
		
		//10. Type $data in ZIP_Code field
		uiDriver.setValue("US1153SearchanExistingContact.txtZIP_Code", input.get("Type@ZIP_Code"));
		
		//11. Click on Search_3 button
		uiDriver.click("US1153SearchanExistingContact.btnSearch_3");
		
	}
	

	/**
	*Overriding toString() method of object class to print US1153SearchanExistingContact
	*format string
	**/
	public String toString(){
		return "US1153SearchanExistingContactDriver";
	}
}
